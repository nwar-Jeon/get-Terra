package com.nwar.individual.get_terra.view

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.google.zxing.integration.android.IntentIntegrator
import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.R
import com.nwar.individual.get_terra.customView.CustomButton
import com.nwar.individual.get_terra.presenter.BoothListPresenter
import java.util.*

class BoothListActivity : AppCompatActivity(), Presenter.BoothListView {
    val presenter : Presenter.BoothListPresenter = BoothListPresenter(this)
    lateinit var linkedList : List<BoothInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booth_list)
        presenter.getBoothList()
        val teamColor = intent.getIntExtra("teamColor",0)
        val topDrawable = ContextCompat.getDrawable(this, R.drawable.back_teamcolor_main)

        topDrawable?.setColorFilter(teamColor, PorterDuff.Mode.SRC_ATOP)

        findViewById<View>(R.id.boothlist_top_v).background = topDrawable
        findViewById<CustomButton>(R.id.boothlist_qrcode_btn).setOnColor(teamColor,Color.WHITE)
            .setOnClickListener {
                IntentIntegrator(this).initiateScan()
            }

        val recyclerView = findViewById<RecyclerView>(R.id.boothlist_recyclerview)
        recyclerView.adapter = BoothListAdapter(this, linkedList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun setBoothList(list : List<BoothInfo>) {
        linkedList = list
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==IntentIntegrator.REQUEST_CODE){
            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)
        }
    }
}

data class BoothInfo(val boothName : String, val takeTeam : Int?){

}