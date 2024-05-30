package com.example.inglih;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView etText;
    Button buttonStart;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        etText = findViewById(R.id.et_text);
        buttonStart = findViewById(R.id.buttonStart);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            int result = arguments.getInt("res");
            // Выводим на экран данные
            etText.setText("верных ответов " + result);


        }


        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на другую активность
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent); // Запускаем другую активность
            }
        });
    }
}