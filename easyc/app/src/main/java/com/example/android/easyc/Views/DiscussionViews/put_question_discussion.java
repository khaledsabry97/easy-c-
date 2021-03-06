package com.example.android.easyc.Views.DiscussionViews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.easyc.Controllers.DiscussionController;
import com.example.android.easyc.Interfaces.OnTaskListeners;
import com.example.android.easyc.R;

public class put_question_discussion extends AppCompatActivity {

    EditText title;
    EditText description;
    Button putOpinion;
    DiscussionController discussionController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_question_discussion);

        discussionController = new DiscussionController();
        title = findViewById(R.id.titlequestion);
        description = findViewById(R.id.descriptionquestion);
        putOpinion = findViewById(R.id.insertquestion);

        putOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertQuestion();
            }
        });


    }


    //put question in discussion room
    void insertQuestion() {
        if (check()) {
            discussionController.insertQuestion(title.getText().toString(), description.getText().toString(), new OnTaskListeners.Bool() {
                @Override
                public void onSuccess(Boolean result) {
                    if (result) {
                        discussionController.toast("successfully added", getApplicationContext());
                        finish();
                      /*  title.setText("");
                        description.setText("");
                        goToMenu();*/
                    } else
                        discussionController.toast("unsuccessfully added", getApplicationContext());
                }
            });
        }


    }

    //before you enter a question first check if the data is alright
    boolean check() {
        if (title.getText().toString().matches("")) {
            discussionController.toast("there is no name for the title of question", getApplicationContext());
            return false;
        }
        if (description.getText().toString().matches("")) {
            discussionController.toast("please add your question", getApplicationContext());
            return false;
        }
        return true;
    }

/*
    //go back to menu after you put the question successfully
    void goToMenu() {

        Intent intent = new Intent(getApplicationContext(), student_menu.class);
        startActivity(intent);
    }*/
}
