package com.nwar.individual.get_terra.presenter

import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.model.BoothListModel

class BoothListPresenter (val view : Presenter.BoothListView) : Presenter.BoothListPresenter {
    val model = BoothListModel()
    override fun getBoothList() {
        view.setBoothList(model.getBoothList())
    }
}