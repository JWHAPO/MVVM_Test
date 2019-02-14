package test.jw.mvvm.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: UserViewModel
 * Created by JEONGWOOKIM on 2019-02-14.
 * Description:
 */
class UserViewModel : BaseObservable(){

    @Bindable
    var user: User = User()

    fun afterNameTextChanged(s:CharSequence){
        user.lastName = s.toString()
    }

    fun afterAgeTextChanged(s:CharSequence){
        user.age = s.toString().toInt()
    }

    fun afterGenderTextChanged(s:CharSequence){
        user.gender = s.toString()
    }

    fun onNextClicked(){
        //ADD
        println(user.toString())
    }
}