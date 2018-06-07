package com.lqr.example.takevideo.record.landscapevideocamera;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.lqr.R;


public class RecodePAlerMainActivity extends Activity implements OnClickListener{
String videopath="";//视频地址
ImageView iv_radio;//视频截图显示窗口
ImageView iv_play;//已经录制好视频，播放标识
ImageView iv_radiodel;//删除当前视频
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		iv_radio=(ImageView) findViewById(R.id.iv_radio);
		iv_play=(ImageView) findViewById(R.id.iv_play);
		iv_radiodel=(ImageView) findViewById(R.id.iv_radiodel);
		iv_radio.setOnClickListener(this);
		
		iv_radiodel.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_radio://播放或者录制视频
			if (videopath.trim().isEmpty()) {
				Intent intents = new Intent(this, VideoCaptureActivity.class);
				intents.putExtra(VideoCaptureActivity.EXTRA_OUTPUT_FILENAME,"");
				startActivityForResult(intents, 101);
			} else {
				try {
					Intent it2 = new Intent(RecodePAlerMainActivity.this, PlayVideo.class);
					it2.putExtra("path",videopath);
					startActivity(it2);
				} catch (ActivityNotFoundException e) {
				}

			}
			break;
		case R.id.iv_radiodel://删除视频
			videopath="";
			iv_radio.setImageResource(R.drawable.djb_addpic);
			iv_radiodel.setVisibility(View.GONE);
			iv_play.setVisibility(View.GONE);		
			break;
		default:
			break;
		}
	}
@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
			videopath = data.getStringExtra(VideoCaptureActivity.EXTRA_OUTPUT_FILENAME);
			iv_radiodel.setVisibility(View.VISIBLE);
			iv_play.setVisibility(View.VISIBLE);
			iv_radio.setImageBitmap(getVideoThumbnail(videopath));
		} else if (resultCode == Activity.RESULT_CANCELED) {
			String filename = null;
			String statusMessage = getString(R.string.status_capturecancelled);
		} else if (resultCode == VideoCaptureActivity.RESULT_ERROR) {
			String filename = null;
			String statusMessage = getString(R.string.status_capturefailed);
		}	
	}
public static Bitmap getVideoThumbnail(String filePath) {  
    Bitmap bitmap = null;  
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();  
    try {  
        retriever.setDataSource(filePath);  
        bitmap = retriever.getFrameAtTime(); 
        int w = bitmap.getWidth();

		int h = bitmap.getHeight();

		Matrix matrix = new Matrix();

		float scaleWidth = 1;

		float scaleHeight =2;

		matrix.postScale(scaleWidth, scaleHeight);// 利用矩阵进行缩放不会造成内存溢出

		Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);

		return newbmp;
        
        
        
        
    }   
    catch(IllegalArgumentException e) {  
        e.printStackTrace();  
    }   
    catch (RuntimeException e) {  
        e.printStackTrace();  
    }   
    finally {  
        try {  
            retriever.release();  
        }   
        catch (RuntimeException e) {  
            e.printStackTrace();  
        }  
    }  
    return bitmap;  
}  
}
