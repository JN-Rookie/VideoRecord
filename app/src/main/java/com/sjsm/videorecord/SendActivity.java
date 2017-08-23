package com.sjsm.videorecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SendActivity extends AppCompatActivity {

    private ImageView iv_video;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        path=getIntent().getStringExtra("path");

        iv_video= (ImageView) findViewById(R.id.iv_video);

        if(path!=null){
            Glide.with(this).load(path).into(iv_video);
        }

        iv_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SendActivity.this,PlayActivity.class);
                intent.putExtra("path",path);
                startActivity(intent);
            }
        });
    }
}
