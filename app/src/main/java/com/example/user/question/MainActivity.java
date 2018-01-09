package com.example.user.question;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView year;
    private final static int REQUEST_ANSWER = 105;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = (ListView) findViewById(R.id.list);
        String[] question = {"year?", "last year?", "next year?"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, question);
        year.setAdapter(adapter);
        year.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("EXTRA_QUESTION", position);
        startActivityForResult(intent, REQUEST_ANSWER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String answers = data.getStringExtra("EXTRA_ANSWER");
            Toast.makeText(this, answers, Toast.LENGTH_LONG).show();
        }
    }
}
