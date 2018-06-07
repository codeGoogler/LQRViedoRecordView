# LQRViedoRecordView
安卓视频录制控件，可以用来仿微信小视频


## 一、使用
### 1、引入依赖

	compile 'com.lqr.videorecordview:library:1.0.0'

### 2、布局中引用

	<com.lqr.videorecordview.LQRVideoRecordView
        android:id="@+id/vrvVideo"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="20dp"
        app:vrv_out_format="of_mp4"
        app:vrv_record_max_time="10"
        app:vrv_video_encoding_bit_rate="1048576"
        app:vrv_video_frame_rate="10"
        app:vrv_x_px="320"
        app:vrv_y_px="240"/>

### 3、代码中控制

	mVrvVideo = (LQRVideoRecordView) findViewById(R.id.vrvVideo);

    mVrvVideo.openCamera();//打开相机
    mVrvVideo.record(MainActivity.this);//开始录制
    mVrvVideo.stop();//停止录制并释放相机
	mVrvVideo.stopRecord();//停止录制(如果处理不好容易出问题,一般用stop)
	mVrvVideo.getVecordFile();//得到录制好的视频文件
	mVrvVideo.setOutputDirPath();//设置视频输出目录路径


### 4、自定义属性解释

	app:vrv_is_open_camera:是否控件加载完成就打开相机（默认是true）
	app:vrv_out_format:视频输出格式（分mp4和3gp）
    app:vrv_record_max_time:视频录制最大时长（默认10秒）
    app:vrv_video_encoding_bit_rate:声音的编码位率（默认1 * 1024 * 1024）
    app:vrv_video_frame_rate:录制的视频帧率（默认10）
    app:vrv_x_px:视频分辨率宽度（默认320）
    app:vrv_y_px:视频分辨率高度（默认240）

	以上所有属性均有对应的setter和getter方法，可在代码中动态修改。

## 二、效果

![image](screenshots/1.gif)

图中的仿微信进度条使用的是：[LQRRecordProgress](https://github.com/GitLqr/LQRRecordProgress "仿微信小视频进度条")


#### 相信自己，没有做不到的，只有想不到的
 如果你觉得此文对您有所帮助，欢迎入群 QQ交流群 ：644196190
微信公众号：终端研发部

公众号：「终端研发部」谈的是技术，产品，更是我们的人生，做一个最有味道的互联网开发者，每天八点准时推送，替您从海量同类文章中筛选出高质量文章。

6年Android开发大神，决心做更有成就感的事情，于是有这个公众号，愿景打造个人的Python第一公众号。让小白也能成为Python大神! 涵盖Python基础，爬虫，数据分析，大数据，人工智能！ 关注公众号即可获得5T的学习资料！

一条执着于技术+职场经验之路，从人工智能，Android，FFmpeg音视频解码，前端开发及微信小程序，同时覆盖涵盖Python基础，爬虫。公众号：「终端研发部」谈的是技术，是产品，更是我们的人生！




![技术+职场](http://upload-images.jianshu.io/upload_images/4614633-8af7afbca8ae9de9.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
