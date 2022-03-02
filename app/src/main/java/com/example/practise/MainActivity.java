package com.example.practise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   private Button truebutton;
    private Button falsebutton;
    private ImageButton nextbutton;
    private ImageButton previousbutton;
    private TextView questiontextview;

    private int currentquestionindex= 0;

    Questions [] questionbank = new  Questions[]{

      new Questions(R.string.question_amendments,false),
            new Questions(R.string.question_constitution,true),
            new Questions(R.string.question_declaration,true),
            new Questions(R.string.question_independence_rights,true),
            new Questions(R.string.question_religion,true),
            new Questions(R.string.question_government,false),
            new Questions(R.string.question_government_feds,false),
            new Questions(R.string.question_government_senators,true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        truebutton= findViewById(R.id.truebutton);
        falsebutton= findViewById(R.id.falsebutton);
        questiontextview=findViewById(R.id.textquestions);
        nextbutton=findViewById(R.id.next);
        previousbutton= findViewById(R.id.previous);


        truebutton.setOnClickListener(this);
        falsebutton.setOnClickListener(this);
        nextbutton.setOnClickListener(this);
        previousbutton.setOnClickListener(this);




    }


   @Override

    public void onClick(View view){

        switch (view.getId()){

            case R.id.truebutton:

                checkAnswer(true);

                break;

            case R.id.falsebutton:

                   checkAnswer(false);
                break;

            case R.id.next:
                currentquestionindex = (currentquestionindex + 1)  % questionbank.length;

                questiontextview.setText(questionbank[currentquestionindex].getAnswerid());

                break;

            case R.id.previous:

                if (currentquestionindex > 0){
                    currentquestionindex = (currentquestionindex - 1) % questionbank.length;
                    questiontextview.setText(questionbank[currentquestionindex].getAnswerid());
                    break;

                }
                




        }


    }


    private void checkAnswer(boolean userChooseCorrect){

        boolean answeristrue = questionbank[currentquestionindex].isAnswertrue();
        int toastmessageid;

        if (userChooseCorrect == answeristrue){

            toastmessageid = R.string.correct_answer;

        }
        else {

            toastmessageid= R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this,toastmessageid,Toast.LENGTH_LONG).show();


    }







}