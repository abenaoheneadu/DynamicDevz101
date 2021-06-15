package com.dynamicdevz.dynamicdevz101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button followButton;
    private TextView userNameTextView;
    private ImageView imageView;

    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTextView = findViewById(R.id.username_textview);
        followButton= findViewById(R.id.follow_button);
        imageView = findViewById(R.id.profile_imageview);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count <= 6){
                    imageView.setImageResource(R.drawable.baby);
                } else if (count >= 7 && count <= 13 ) {
                    imageView.setImageResource(R.drawable.images);
                }
                else if (count >= 14 && count <= 21 ) {
                    imageView.setImageResource(R.drawable.teenager);
                } else {
                    imageView.setImageResource(R.drawable.man);
                }


               setCountText();
            }
        });
//        if(savedInstanceState != null){
//            count = savedInstanceState.getInt("COUNT_KEY");
//            setCountText();
//        }

    }

    private void setCountText() {
        userNameTextView.setText("Age : " + count);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("COUNT_KEY");
       setCountText();
    }
}