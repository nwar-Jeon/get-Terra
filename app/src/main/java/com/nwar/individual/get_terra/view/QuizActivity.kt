package com.nwar.individual.get_terra.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.EditText
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val quiz = QuizInfo(0,"퀴즈 내용 입니다", "정답")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val answer = findViewById<EditText>(R.id.quiz_inputanswer_et)
        val intent = Intent(this,CheckAnswerActivity::class.java)
        findViewById<CustomButton>(R.id.quiz_submit_btn).setOnColor(ContextCompat.getColor(this,R.color.main), Color.WHITE)
            .setOnClickListener {
                if(quiz.isAnswerTrue(answer.text)){
                    intent.putExtra("answer", true)
                } else{
                    intent.putExtra("answer", false)
                }
                startActivity(intent)
                finish()
            }
    }
}

data class QuizInfo(val quizId : Int, val quizContent : String, val quizAnswer : String){
    fun isAnswerTrue(other: Any?): Boolean {
        if(other is String){
            return other.equals(quizContent)
        }
        return false
    }
}