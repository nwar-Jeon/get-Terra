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

    val backGroundTop by lazy { findViewById<View>(R.id.selteam_top_v) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_team)
        findViewById<CustomButton>(R.id.selteam_blue_btn)
            .init(R.color.blue)
        findViewById<CustomButton>(R.id.selteam_green_btn)
            .init(R.color.green)
        findViewById<CustomButton>(R.id.selteam_violet_btn)
            .init(R.color.violet)
        findViewById<CustomButton>(R.id.selteam_yellow_btn)
            .init(R.color.yellow)
        backGroundTop.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showin_anim))
    }
    fun onClick(color : Int){
        backGroundTop.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showout_anim))

        val intent = Intent(this, ApplySelectTeamActivity::class.java)
        intent.putExtra("teamColor", ContextCompat.getColor(this,color))
        startActivity(intent)

    }

    fun CustomButton.init(backColor : Int){
        this.setOnColor(Color.WHITE, ContextCompat.getColor(this@SelectTeamActivity, backColor))
        this.setOnClickListener {
            onClick(backColor)
        }
    }
}
