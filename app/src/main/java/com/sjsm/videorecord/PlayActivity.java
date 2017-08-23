package com.sjsm.videorecord;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class PlayActivity extends AppCompatActivity {

    private VideoView mView;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mView= (VideoView) findViewById(R.id.videoView);
        path=getIntent().getStringExtra("path");

        Uri uri = Uri.parse( path );

        //设置视频控制器
        mView.setMediaController(new MediaController(this));

        //播放完成回调
        mView.setOnCompletionListener( new MyPlayerOnCompletionListener());

        //设置视频路径
        mView.setVideoURI(uri);

        //开始播放视频
        mView.start();
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( PlayActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
