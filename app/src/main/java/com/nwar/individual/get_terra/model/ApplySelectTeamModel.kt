package com.nwar.individual.get_terra.model

import android.content.Context
import android.support.v4.content.ContextCompat
import com.nwar.individual.get_terra.R

class ApplySelectTeamModel {
    fun getText(id : Int, context : Context) : String{
        var text = "Team_"
        when(id){
            ContextCompat.getColor(context,R.color.blue) -> text += "Blue"
            ContextCompat.getColor(context,R.color.yellow) -> text += "Yellow"
            ContextCompat.getColor(context,R.color.violet) -> text += "Violet"
            ContextCompat.getColor(context,R.color.green) -> text += "Green"
        }
        return text
    }
}