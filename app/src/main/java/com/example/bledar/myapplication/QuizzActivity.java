package com.example.bledar.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.MedinPiranej.MPNetAPI.BaseActivity;
import com.MedinPiranej.MPNetAPI.Interfaces.RestRequestCompletedDelegate;
import com.MedinPiranej.MPNetAPI.Models.RestResponseModel;
import com.MedinPiranej.MPNetAPI.RestApi;
import com.example.bledar.myapplication.com.example.bledar.myapplication.Models.QuestionModel;
import com.google.gson.Gson;

/**
 * Created by Bledar on 23/08/2016.
 */
public class QuizzActivity extends BaseActivity implements RestRequestCompletedDelegate {
    TextView pyetja;
    TextView piket;
    Button alt1;
    Button alt2;
    Button alt3;
    Button alt4;
    static int AltS=0;
    static int piketNr=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz);
        RestApi.getAsynchronous("/get.php", this,(RestRequestCompletedDelegate) QuizzActivity.this);
        pyetja = (TextView) findViewById(R.id.Pyetja);
        piket = (TextView) findViewById(R.id.Piket);
        alt1 = (Button) findViewById(R.id.buttonAlt1);
        alt2 = (Button) findViewById(R.id.buttonAlt2);
        alt3 = (Button) findViewById(R.id.buttonAlt3);
        alt4 = (Button) findViewById(R.id.buttonAlt4);
        alt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alt1.setEnabled(false);
                alt2.setEnabled(false);
                alt3.setEnabled(false);
                alt4.setEnabled(false);
                if (AltS==1){
                    piketNr++;
                    piket.setText(" "+piketNr);
                    Toast.makeText(getApplicationContext(),"Pergjigje e Sakte",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Pergjigje e Gabuar",Toast.LENGTH_SHORT).show();
                }
                RestApi.getAsynchronous("/get.php",QuizzActivity.this,(RestRequestCompletedDelegate) QuizzActivity.this);
            }
        });

        alt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alt1.setEnabled(false);
                alt2.setEnabled(false);
                alt3.setEnabled(false);
                alt4.setEnabled(false);
                if (AltS==2){
                    piketNr++;
                    piket.setText(" "+piketNr);
                    Toast.makeText(getApplicationContext(),"Pergjigje e Sakte",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Pergjigje e Gabuar",Toast.LENGTH_SHORT).show();
                }
                RestApi.getAsynchronous("/get.php",QuizzActivity.this,(RestRequestCompletedDelegate) QuizzActivity.this);
            }
        });
        alt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alt1.setEnabled(false);
                alt2.setEnabled(false);
                alt3.setEnabled(false);
                alt4.setEnabled(false);
                if (AltS==3){
                    piketNr++;
                    piket.setText(" "+piketNr);
                    Toast.makeText(getApplicationContext(),"Pergjigje e Sakte",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Pergjigje e Gabuar",Toast.LENGTH_SHORT).show();
                }
                RestApi.getAsynchronous("/get.php",QuizzActivity.this,(RestRequestCompletedDelegate) QuizzActivity.this);
            }
        });
        alt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                alt1.setEnabled(false);
                alt2.setEnabled(false);
                alt3.setEnabled(false);
                alt4.setEnabled(false);
                if (AltS==4){
                    piketNr++;
                    piket.setText(" "+piketNr);
                    Toast.makeText(getApplicationContext(),"Pergjigje e Sakte",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Pergjigje e Gabuar",Toast.LENGTH_SHORT).show();
                }
                RestApi.getAsynchronous("/get.php",QuizzActivity.this,(RestRequestCompletedDelegate) QuizzActivity.this);
            }
        });
    }

    @Override
    public void requestFinishedWithResponse(RestResponseModel response) {
        if(response.getHttpStatusCode() == 200){
            QuestionModel [] questions = new Gson().fromJson(response.getResponseContent(),QuestionModel[].class);
            if(questions != null && questions.length > 0) {
                pyetja.setText(questions[0].getPyetja().toString());
                this.AltS=questions[0].getAlts();

                alt1.setText(questions[0].getAlt1().toString());
                alt1.setEnabled(true);

                alt2.setText(questions[0].getAlt2().toString());
                alt2.setEnabled(true);

                alt3.setText(questions[0].getAlt3().toString());
                alt3.setEnabled(true);

                alt4.setText(questions[0].getAlt4().toString());
                alt4.setEnabled(true);
            }
        }
    }



}


