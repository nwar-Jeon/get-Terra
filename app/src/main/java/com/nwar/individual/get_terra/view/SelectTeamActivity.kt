package com.nwar.individual.get_terra.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.animation.AnimationUtils
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton

class SelectTeamActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_team)
        findViewById<CustomButton>(R.id.selteam_blue_btn)
            .setOnColor(Color.WHITE, ContextCompat.getColor(this,R.color.blue))
            .setOnClickListener {
                onClick(R.color.blue)
            }
        findViewById<CustomButton>(R.id.selteam_green_btn)
            .setOnColor(Color.WHITE, ContextCompat.getColor(this,R.color.green))
            .setOnClickListener {
                onClick(R.color.green)
            }
        findViewById<CustomButton>(R.id.selteam_violet_btn)
            .setOnColor(Color.WHITE, ContextCompat.getColor(this,R.color.violet))
            .setOnClickListener {
                onClick(R.color.violet)
            }
        findViewById<CustomButton>(R.id.selteam_yellow_btn)
            .setOnColor(Color.WHITE, ContextCompat.getColor(this,R.color.yellow))
            .setOnClickListener {
                onClick(R.color.yellow)
            }
        findViewById<View>(R.id.selteam_top_v).startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showin_anim))
    }
    fun onClick(color : Int){
        val intent = Intent(this, ApplySelectTeamActivity::class.java)
        intent.putExtra("teamColor", ContextCompat.getColor(this,color))
        findViewById<View>(R.id.selteam_top_v).startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showout_anim))
        startActivity(intent)
    }
}
