package com.uni.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.uni.geoquiz.models.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questionList;
    private int curQuestionIdx = 0;
    TextView tvQuestionContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        generateQuestions();

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_main,null);

        tvQuestionContent = view.findViewById(R.id.tvQuestionContent);
        showCurQuestion();

        setContentView(view);
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
