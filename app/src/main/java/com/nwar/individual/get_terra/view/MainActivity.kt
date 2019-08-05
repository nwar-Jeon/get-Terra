package com.nwar.individual.get_terra.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.Toast
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton
import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.presenter.MainPresenter

class MainActivity : AppCompatActivity(), Presenter.MainView {

    val presenter = MainPresenter(this)
    val backGroundTop by lazy { findViewById<View>(R.id.main_top_v) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = findViewById<EditText>(R.id.login_id_et)
        val pw = findViewById<EditText>(R.id.login_pw_et)
        val signUpButton = findViewById<CustomButton>(R.id.login_signUp_btn)
        val loginButton = findViewById<CustomButton>(R.id.login_login_btn)

        signUpButton.let {
            it.setOnColor(ContextCompat.getColor(this,R.color.main), ContextCompat.getColor(this,R.color.orange))
            it.setOnClickListener {
                presenter.trySignUp(id.text?.toString(),pw.text?.toString())
            }
        }

        loginButton.let {
            it.setOnColor(ContextCompat.getColor(this,R.color.main), Color.WHITE)
            it.setOnClickListener {
                presenter.tryLogin(id.text?.toString(),pw.text?.toString())
            }
        }

        backGroundTop.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showin_anim))
    }

    override fun loginResult(bool: Boolean) {
        if(bool){
            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SelectTeamActivity::class.java)
            backGroundTop.startAnimation(AnimationUtils.loadAnimation(this,R.anim.head_showout_anim))
            startActivity(intent)
            finish()
        } else{
            Toast.makeText(this, "로그인 실패!", Toast.LENGTH_SHORT).show()
        }
    }
}
