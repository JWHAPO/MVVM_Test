package test.jw.mvvm.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import test.jw.mvvm.BR
import test.jw.mvvm.model.User
import java.util.*

/**
 * MVVM_Test
 * Class: UserViewModel
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class UserViewModel(private val user: User) : Observer, BaseObservable(){

    init {
        user.addObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 is String){
            if(p1 == "age"){
                notifyPropertyChanged(BR.age)
            }else if(p1 == "firstName" || p1 == "lastName"){
                notifyPropertyChanged(BR.name)
            }else if(p1 == "female"){
                notifyPropertyChanged(BR.gender)
            }
        }
    }

    val name: String
    @Bindable get() {
        return user.firstName+" "+user.lastName
    }


    val age: String
    @Bindable get() {
        return if(user.age<=0) return ""
                else String.format(Locale.ENGLISH, "%d years old", user.age)
    }

    val gender: String
    @Bindable get() {
        return if(user.female) return "Female" else "Male"
    }

    fun onButtonClick(view: View){
        this.user.age = 35
    }


}