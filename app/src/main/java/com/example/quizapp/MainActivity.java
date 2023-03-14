package com.example.quizapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView qustionTV,qustionNumberTV;
    Button optionBtn1,optionBtn2,optionBtn3,optionBtn4;
    Random random;
    int Current_score=0,questionAttempted=-1,currentPos;
    private ArrayList<QuizModel> quizModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qustionTV=findViewById(R.id.tv_question);
        qustionNumberTV=findViewById(R.id.tv_number);
        optionBtn1=findViewById(R.id.btn_obtion);
        optionBtn2=findViewById(R.id.btn_obtion2);
        optionBtn3=findViewById(R.id.btn_obtion3);
        optionBtn4=findViewById(R.id.btn_obtion4);
        quizModelArrayList=new ArrayList<>();
        random=new Random();
        getQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDataToView(currentPos);
        optionBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).
                        getAnswer().trim().toLowerCase().equals(optionBtn1.getText().toString().toLowerCase())){
                    Current_score++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);

            }
        });
        optionBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).
                        getAnswer().trim().toLowerCase().equals(optionBtn2.getText().toString().toLowerCase())){
                    Current_score++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);

            }
        });
        optionBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).
                        getAnswer().trim().toLowerCase().equals(optionBtn3.getText().toString().toLowerCase())){
                    Current_score++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);

            }
        });
        optionBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).
                        getAnswer().trim().toLowerCase().equals(optionBtn4.getText().toString().toLowerCase())){
                    Current_score++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);

            }
        });




    }
    @SuppressLint("SetTextI18n")
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheat,(LinearLayout)findViewById(R.id.Score));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView scoreTv=bottomSheetView.findViewById(R.id.idTvScore);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button RestartQuizBtn=bottomSheetView.findViewById(R.id.RestartBtn);
        scoreTv.setText("Your Score is : /n" +Current_score+"/10");
        RestartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
                questionAttempted=-1;
                Current_score=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    @SuppressLint("SetTextI18n")
    private void setDataToView(int currentPos) {
        if (questionAttempted == 10){
            showBottomSheet();

        }
        else {
            qustionNumberTV.setText("Question Attempted :"+questionAttempted+"/10");
            qustionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            optionBtn1.setText(quizModelArrayList.get(currentPos).getOption1());
            optionBtn2.setText(quizModelArrayList.get(currentPos).getOption2());
            optionBtn3.setText(quizModelArrayList.get(currentPos).getOption3());
            optionBtn4.setText(quizModelArrayList.get(currentPos).getOption4());

        }

    }

    private void getQuestion(ArrayList <QuizModel>quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("How GFG is used?","To solve DSA problems","To learn new languages","To learn Android","All of th above","All of th above"));
        quizModelArrayList.add(new QuizModel("What is GCM in Android?","Google Cloud Messaging","Google Message Pack","Google Cloud Manger","All of th above","Google Cloud Messaging"));
        quizModelArrayList.add(new QuizModel("What is ADB in Android?","Android Debug Bridge","Android data Bridge","Android database bridge","All of th above","Android Debug Bridge"));
        quizModelArrayList.add(new QuizModel("Where are colors present in Android?","color.xml","AndroidManifest.xml","string.xml","All of th above","color.xml"));

    }
}