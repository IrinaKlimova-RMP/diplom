package com.example.inglih;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private TextView textViewQuestion;
    private EditText editTextAnswer;
    private Button buttonSubmit, buttonLogOut;
    int result, counter;

    private String[] questions = {
            "Как переводится слово 'apple'?", "Как переводится слово 'cat'?", "Как переводится слово 'book'?",
            "Как переводится слово 'hand'?", "Как переводится слово 'good'?", "Как переводится слово 'red'?",
            "Как переводится слово 'home'?", "Как переводится слово 'light'?", "Как переводится слово 'water'?"};
    private String[] correctAnswers = {"яблоко", "кот", "книга", "рука", "хорошо", "красный", "дом", "свет", "вода"};
    int currentQuestionIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonLogOut = findViewById(R.id.buttonLogOut);



        buttonSubmit.setOnClickListener(v -> checkAnswer());

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на другую активность
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent); // Запускаем другую активность
            }
        });

    }

    public void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            String currentQuestion = questions[currentQuestionIndex];
            textViewQuestion.setText(currentQuestion);
        } else {
            // Все вопросы пройдены
            result = counter;
            Toast.makeText(this, "Тест завершен, верных ответов "+ result, Toast.LENGTH_SHORT).show();

            // Создаем Intent для перехода на другую активность
            Intent intent = new Intent(this, MainActivity4.class);
            intent.putExtra("res", result);
            intent.putExtra("index",currentQuestionIndex);
            startActivity(intent); // Запускаем другую активность

        }
    }

    public void checkAnswer() {
        String userAnswer = editTextAnswer.getText().toString().trim();
        String correctAnswer = correctAnswers[currentQuestionIndex];

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            counter++;
            Toast.makeText(this, "Верно!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Неверно. Правильный ответ: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        // Переходим к следующему вопросу
        currentQuestionIndex++;
        editTextAnswer.setText(""); // Очищаем поле ввода
        showQuestion();

    }
}
