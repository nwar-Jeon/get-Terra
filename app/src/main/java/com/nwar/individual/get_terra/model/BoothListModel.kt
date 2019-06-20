package com.nwar.individual.get_terra.model

import com.nwar.individual.get_terra.view.BoothInfo
import java.util.*

class BoothListModel {
    fun getBoothList() : List<BoothInfo>{
        val list = LinkedList<BoothInfo>()
        for(i in 0 .. 10){
            list.add(BoothInfo(i.toString() + "번째 부스", null))
        }
        return list
    }
}