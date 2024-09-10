package com.example.pract11;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonToSecondActivity;
    private Button buttonToThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonToSecondActivity = findViewById(R.id.buttonToSecondActivity);
        buttonToThirdActivity = findViewById(R.id.buttonToThirdActivity);

        // Анимация при запуске Activity
        Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        buttonToSecondActivity.startAnimation(animFadeIn);
        buttonToThirdActivity.startAnimation(animFadeIn);

        // Переход на вторую Activity
        buttonToSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Переход на третью Activity
        buttonToThirdActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
        });
    }
}
