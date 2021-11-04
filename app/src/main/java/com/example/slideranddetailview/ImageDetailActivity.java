package com.example.slideranddetailview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.aghajari.zoomhelper.ZoomHelper;
import com.bumptech.glide.Glide;

public class ImageDetailActivity extends AppCompatActivity {


    ImageView detailImageView;
    ImageView closeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_activity);
        getSupportActionBar().hide();

        detailImageView=findViewById(R.id.ImageViewDetail);
        closeImageView=findViewById(R.id.closeImageViewDetail);
        Intent intent=getIntent();
        String imgUrl=intent.getStringExtra("imageUrl");

        Glide.with(this).load(imgUrl).into(detailImageView);

        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return ZoomHelper.Companion.getInstance().dispatchTouchEvent(ev,this)
                || super.dispatchTouchEvent(ev);
    }
}