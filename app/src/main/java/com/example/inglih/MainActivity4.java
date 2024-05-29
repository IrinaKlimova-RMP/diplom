package com.example.inglih;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView etText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        etText = findViewById(R.id.et_text);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null){
            int result = arguments.getInt("res");

            // Выводим на экран данные
            etText.setText("верных ответов " + result);
        }




    }

}