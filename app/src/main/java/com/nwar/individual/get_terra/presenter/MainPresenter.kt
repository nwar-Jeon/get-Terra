package com.nwar.individual.get_terra.presenter

import com.nwar.individual.get_terra.Presenter
import com.nwar.individual.get_terra.model.MainModel

class MainPresenter(val view : Presenter.MainView) : Presenter.MainPresenter{
    final val model = MainModel()
    override fun tryLogin(id: String?, pw: String?) {
        view.loginResult(model.tryLogin(id, pw))
    }

    override fun trySignUp(id: String?, pw: String?) {
        model.trySignUp(id,pw)
    }
}