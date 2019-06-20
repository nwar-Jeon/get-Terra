package com.nwar.individual.get_terra.view

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton
import com.nwar.individual.get_terra.presenter.ApplySelectTeamPresenter

class ApplySelectTeamActivity : AppCompatActivity(), Presenter.ApplySelectTeamView {
    val presenter: Presenter.ApplySelectTeamPresenter = ApplySelectTeamPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_select_team)
        var drawableHead = ContextCompat.getDrawable(this,R.drawable.back_teamcolor_main)
        var drawableBody = ContextCompat.getDrawable(this,R.drawable.style_borderline_rectangle_apply_team)
        val teamColor = intent.getIntExtra("teamColor", 0)


        drawableHead?.setColorFilter(teamColor, PorterDuff.Mode.SRC_ATOP)
        drawableBody?.setColorFilter(teamColor, PorterDuff.Mode.SRC_ATOP)


        findViewById<ConstraintLayout>(R.id.applyteam_backbody_layout).startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.applyteam_body_anim
            )
        )
        findViewById<View>(R.id.applyteam_top_v).let {
            it.background = drawableHead
            it.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showin_anim))
        }
        findViewById<TextView>(R.id.applyteam_body_v).let {
            it.background = drawableBody
            it.setTextColor(Color.WHITE)
        }
        findViewById<CustomButton>(R.id.applyteam_apply_btn)
            .setOnColor(teamColor, Color.WHITE)
            .setOnClickListener {
                val intent = Intent(this, BoothListActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.putExtra("teamColor",teamColor)
                startActivity(intent)
            }
        presenter.getText(teamColor)
    }

    override fun getContext() = this

    override fun setTeamText(text: String) {
        findViewById<TextView>(R.id.applyteam_body_v).setText(text)
    }
}
