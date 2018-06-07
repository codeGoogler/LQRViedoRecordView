package com.lqr.example.takevideo.record.landscapevideocamera;

import java.io.File;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.lqr.R;


public class PlayVideo extends Activity implements OnClickListener{
	VideoView vv;
	
	String path;
	
	
	static ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.video_play);
    	vv=(VideoView) findViewById(R.id.vv);
    	
    	 show(PlayVideo.this,"加载中...");
         dialog.setOnKeyListener(onKeyListener);
    		vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {  
    	         @Override  
    	         public void onPrepared(MediaPlayer mediaPlayer) {  
    	             //Called when the video is ready to play  
    	        	 hide();
    	         }  
    	     });  
    	 vv.setMediaController(new MediaController(this));  
    	try {
			path=getIntent().getStringExtra("path");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path="";
					
		}
    	if(path!=null){
    		if(path.startsWith("http")){
    			 Uri uri = Uri.parse(path);
    			 vv.setVideoURI(uri);  
    		}else{
    			File videoFile = new File(path);
				if (videoFile.exists()) {
    			vv.setVideoPath(path);
    			}else{
    				Toast.makeText(this, "视频文件不存在,请录制视频", Toast.LENGTH_LONG).show();
    			}
    		}
    	}
    	// Uri uri = Uri.parse("http://video.cztv.com/video/rzx/201208/15/1345010952759.mp4");  
    	
    	/* RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
 				RelativeLayout.LayoutParams.FILL_PARENT,
 				RelativeLayout.LayoutParams.FILL_PARENT);
 		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
 		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
 		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
 		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
 		vv.setLayoutParams(layoutParams);*/
        vv.start();  
    	 vv.requestFocus();  
    }
 private static  OnKeyListener onKeyListener = new OnKeyListener() {
		
		@Override
		public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
		           hide();
	      }
        return false;
		}
	};
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
	}
	public static void show(Context context, String msg){
        if(dialog == null || !dialog.isShowing()){
        	String titlename ="视频加载中...";
            (dialog = new ProgressDialog(context)).setTitle(titlename);
            dialog.setMessage(msg);
            dialog.setCancelable(false);
            dialog.show();
        }
        dialog.setOnKeyListener(onKeyListener);
    }
	 public static  void hide(){
	        if(dialog != null){
	            dialog.dismiss();
	            dialog = null;
	        }
	    }
    
}
