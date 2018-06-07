package com.lqr.example.takevideo.record.landscapevideocamera;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	/** 设置录音的名称 **/
	public static String setRecordFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd_HHmmss");
		return dateFormat.format(date)+".wav";
	}

	//设置录像文件的名称
	public static String setRecordVideoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd_HHmmss");
		return dateFormat.format(date)+".mp4";
	}

}
