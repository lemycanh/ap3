package com.uni.geoquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uni.geoquiz.models.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String CUR_QUESTION_IDX = "CUR_QUESTION_IDX";
    private List<Question> questionList;
    private int curQuestionIdx = 0;
    TextView tvQuestionContent;
    final static String TAG = "GEOQUIZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        generateQuestions();

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_main,null);

        tvQuestionContent = view.findViewById(R.id.tvQuestionContent);

        if(savedInstanceState != null) {
            curQuestionIdx = savedInstanceState.getInt(CUR_QUESTION_IDX, 0);
            Log.d(TAG, "onCreate " + curQuestionIdx);
        }

        showCurQuestion();

        setContentView(view);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState " + curQuestionIdx);
        outState.putInt(CUR_QUESTION_IDX, curQuestionIdx);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void showCurQuestion() {
        Question question = questionList.get(curQuestionIdx);
        tvQuestionContent.setText(question.getContent());
    }

    private void generateQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question(getString(R.string.questionA), true));
        questionList.add(new Question(getString(R.string.questionB), true));
        questionList.add(new Question(getString(R.string.questionC), false));
        questionList.add(new Question(getString(R.string.questionD), true));
        questionList.add(new Question(getString(R.string.questionE), true));
        questionList.add(new Question(getString(R.string.questionF), true));
    }

    public void btTrue_OnClick(View view) {
        checkAnswerAndNextQuestion(true);
    }

    private void checkAnswerAndNextQuestion(boolean userAnswer) {
        Question question = questionList.get(curQuestionIdx);
        Boolean answer = question.getAnswer();
        if(answer == userAnswer) {
            Toast.makeText(this, "Bạn đã trả lời ĐÚNG", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bạn đã trả lời SAI", Toast.LENGTH_SHORT).show();
        }
        showNextQuestion();
    }

    private void showNextQuestion() {
        curQuestionIdx++;
        if(curQuestionIdx >= questionList.size()) curQuestionIdx = 0;
        showCurQuestion();
    }

    public void btFalse_OnClick(View view) {
        checkAnswerAndNextQuestion(false);
    }
}
