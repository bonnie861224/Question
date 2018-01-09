package com.example.user.question;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView edquestion;
    private EditText edanswer;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        edquestion = (TextView) findViewById(R.id.question);
        edanswer = (EditText) findViewById(R.id.answer);
        button = (Button) findViewById(R.id.button);
        int question = getIntent().getIntExtra("EXTRA_QUESTION", 0);
        switch (question){
            case 0:
                edquestion.setText("year?");
                break;
            case 1:
                edquestion.setText("last year?");
                break;
            case 2:
                edquestion.setText("next year?");
                break;
        }

    }
}
