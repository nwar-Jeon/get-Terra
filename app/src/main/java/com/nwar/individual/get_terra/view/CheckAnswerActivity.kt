package com.nwar.individual.get_terra.view

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton

class CheckAnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_answer)
        val isAnswerTrue = intent.getBooleanExtra("answer",false)
        val top = findViewById<View>(R.id.check_top_v)
        if(!isAnswerTrue){
            findViewById<ConstraintLayout>(R.id.check_background).setBackgroundColor(ContextCompat.getColor(this,R.color.blue))
            findViewById<TextView>(R.id.check_answer_tv).text = "오답"
        }
        findViewById<CustomButton>(R.id.check_gomain_btn).setOnColor(ContextCompat.getColor(this,R.color.main),Color.WHITE).setOnClickListener {
            top.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showout_anim))
            finish()
        }
    }
}
