package com.example.bledar.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Button startBtn;
    Intent quizzIntent;

    EditText teksti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                quizzIntent=new Intent(getApplicationContext(), QuizzActivity.class);
                startActivity(quizzIntent);
            }
        });
    }
}
