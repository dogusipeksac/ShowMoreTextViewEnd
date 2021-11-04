package com.example.slideranddetailview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aghajari.zoomhelper.ZoomHelper;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;

public class MainActivity extends AppCompatActivity implements SliderAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Model> listItems;
    public static final String urlImage="imageUrl";
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dialog=new Dialog(this);
        listItems=new ArrayList<>();
        addList();
        adapter=new ModelAdapter(listItems,this);
        recyclerView.setAdapter(adapter);


    }

    List<Model> addList(){


        for(int i=0;i<10;i++){
            String[] urlArr;
            Model listItem=new Model("Heading"+i,
                    "Description"+i,
                    " Android powers hundreds of millions of mobile devices in more than 190 countries around the world. It\\'s the largest installed base of any mobile platform and growing fast—every day another million users power up their Android devices for the first time" +
                    " Android powers hundreds of millions of mobile devices in more than 190 countries around the world. It\\'s the largest installed base of any mobile platform and growing fast—every day another million users power up their Android devices for the first time and start looking for apps, games, and other digital content. " +
                    " Android powers hundreds of millions of mobile devices in more than 190 countries around the world. It\\'s the largest installed base of any mobile platform and growing fast—every day another million users power up their Android devices for the first time and start looking for apps, games, and other digital content." +
                    " Android powers hundreds of " +
                            "millions of mobile devices" +
                            " in more than 190 countries " +
                            "around the world. It\\'s the largest installed base of any mobile platform and growing fast—every day another million users power up their Android devices for the first time and start looking for apps, games, and other digital content. and start looking for apps, games, and other digital content."
                    ,createSliderArray());
            listItems.add(listItem);
        }
        return listItems;
    }
    private  String[] createSliderArray(){
        String[] imagesSlider=new String[5];

        for (int i=0;i<5;i++){

            Random r=new Random(); //random sınıfı
            int a=r.nextInt(100);
            imagesSlider[i]="https://picsum.photos/1000?random"+a;
        }
        return imagesSlider;
    }

    @Override
    public void onItemClick(int position) {

        Model model=listItems.get(position);
        String url=model.getUrlArr()[position];
        Toast.makeText(this, "url:"+ url, Toast.LENGTH_SHORT).show();
        showDetailImageView(url);
    }


    public void showDetailImageView(String url){

       /* dialog.setContentView(R.layout.show_image_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/

        Intent intent=new Intent(this,ImageDetailActivity.class);
        intent.putExtra(urlImage,url);
        startActivity(intent);

       /* ImageView close=dialog.findViewById(R.id.closeImageView);
        ImageView imageView=dialog.findViewById(R.id.dialogImageView);
        ZoomHelper.Companion.skipLayout(imageView,true);
        Glide.with(this).load(url).into(imageView);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();*/

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return ZoomHelper.Companion.getInstance().dispatchTouchEvent(ev,this)
                || super.dispatchTouchEvent(ev);
    }



}
