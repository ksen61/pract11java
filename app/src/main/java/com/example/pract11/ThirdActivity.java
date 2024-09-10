package com.example.pract11;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Анимация Tween Animation
        ImageView imageView = findViewById(R.id.image_tween);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(rotate);

        // Анимация появления элементов
        Button btnBack = findViewById(R.id.btnBack);
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        btnBack.startAnimation(zoomIn);

        // Переход назад на MainActivity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
            }
        });
    }
}
