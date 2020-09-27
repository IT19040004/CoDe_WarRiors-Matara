package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

public class FirstPage extends AppCompatActivity {

    TextView txtvw;
    ImageView imgVw,ivbeat;

    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        imgVw = (ImageView)findViewById(R.id.imageViewFront);
        ivbeat = (ImageView)findViewById(R.id.iv_beat);
        txtvw = (TextView)findViewById(R.id.txtVwMedCare);

        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
        ,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initialize object animator
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                imgVw,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );

        //set duration
        objectAnimator.setDuration(500);

        //set repeat
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);

        //set repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        //start animator
        objectAnimator.start();

        //set animated text
        animatedText("MED CARE");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FirstPage.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();

            }
        },4000);


    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //when runnable is run set text
            txtvw.setText(charSequence.subSequence(0,index++));
            //chek condition
            if(index <= charSequence.length()){
                //when index equals to text length, then run handler
                handler.postDelayed(runnable,delay);
            }
        }
    };

    //create animated method text method
    public void animatedText(CharSequence cs){
        //set text
        charSequence = cs;
        index = 0;
        txtvw.setText("");

        //remove call back
        handler.removeCallbacks(runnable);
        //run handler
        handler.postDelayed(runnable,delay);
    }


}