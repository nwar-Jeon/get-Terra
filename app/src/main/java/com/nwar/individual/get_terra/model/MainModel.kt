package com.nwar.individual.get_terra.model

class MainModel {
    val user : HashMap<String, String> = hashMapOf()
    init {
        user.put("id","password")
    }
    fun tryLogin(id : String?, pw : String?) : Boolean{
        if(user.contains(id)){
            if(pw == user.get(id)){
                return true
            }
        }
        return false
    }
    fun trySignUp(id : String?, pw : String?){
        if(id!=null && pw != null){
            user.put(id,pw)
        }
    }
}