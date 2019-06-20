package com.nwar.individual.get_terra

import android.content.Context
import com.nwar.individual.get_terra.view.BoothInfo

interface Presenter {
    interface MainView{
        fun loginResult(bool : Boolean)
    }
    interface MainPresenter{
        fun tryLogin(id : String?, pw : String?)
        fun trySignUp(id : String?, pw : String?)
    }

    interface ApplySelectTeamView{
        fun getContext() : Context
        fun setTeamText(text : String)
    }
    interface ApplySelectTeamPresenter{
        fun getText(id : Int)
    }

    interface BoothListPresenter{
        fun getBoothList()
    }
    interface BoothListView{
        fun setBoothList(list : List<BoothInfo>)
    }
}