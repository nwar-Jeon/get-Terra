package com.nwar.individual.get_terra.presenter

import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.model.ApplySelectTeamModel

class ApplySelectTeamPresenter(val view : Presenter.ApplySelectTeamView) : Presenter.ApplySelectTeamPresenter {
    val model = ApplySelectTeamModel()
    override fun getText(id : Int){
        view.setTeamText(model.getText(id, view.getContext()))
    }
}