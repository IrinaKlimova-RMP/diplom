package com.example.inglih;
import androidx.appcompat.app.AppCompatActivity;

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
    private Button buttonSubmit;
    int result;


    private String[] questions = {
            "Как переводится слово 'apple'?", "Как переводится слово 'cat'?", "Как переводится слово 'book'?",
            "Как переводится слово 'hand'?", "Как переводится слово 'good'?", "Как переводится слово 'red'?",
            "Как переводится слово 'home'?", "Как переводится слово 'light'?", "Как переводится слово 'water'?"};
    private String[] correctAnswers = {"яблоко", "кот", "книга", "рука", "хорошо", "красный", "дом", "свет", "вода"};
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Показываем первый вопрос
        showQuestion();


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             result = checkAnswer();

            }
        });

    }

    public void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            String currentQuestion = questions[currentQuestionIndex];
            textViewQuestion.setText(currentQuestion);
        } else {
            // Все вопросы пройдены
            Toast.makeText(this, "Тест завершен, верных ответов "+ result, Toast.LENGTH_SHORT).show();

            // Создаем Intent для перехода на другую активность
            Intent intent = new Intent(this, MainActivity4.class);
            intent.putExtra("res", result);
            startActivity(intent); // Запускаем другую активность

        }
    }
    int counter = 0;
    public int checkAnswer() {
        String userAnswer = editTextAnswer.getText().toString().trim();
        String correctAnswer = correctAnswers[currentQuestionIndex];




        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            Toast.makeText(this, "Верно!", Toast.LENGTH_SHORT).show();
            counter++;
        } else {
            Toast.makeText(this, "Неверно. Правильный ответ: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        // Переходим к следующему вопросу
        currentQuestionIndex++;
        editTextAnswer.setText(""); // Очищаем поле ввода
        showQuestion();
        return counter;
    }
}
