package test.jw.mvvm.viewmodels

import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import android.widget.Toast
import test.jw.mvvm.BR
import test.jw.mvvm.R
import test.jw.mvvm.adapter.UserAdapter
import test.jw.mvvm.model.User
import test.jw.mvvm.views.AddActivity
import java.util.*

/**
 * MVVM_Test
 * Class: UserViewModel
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class UserViewModel(var user:User) : Observer, BaseObservable(){

    private var users = listOf<User>()
    private var userAdapter:UserAdapter? = null

    init {
        user.addObserver(this)
        userAdapter = UserAdapter(this,users)
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
        return user.gender
    }

    fun getAdapter():UserAdapter?{
        return userAdapter
    }

    fun onButtonClick(view: View){
        val intent:Intent = Intent(view.context,AddActivity::class.java)
        view.context.startActivity(intent)
    }
    fun onItemClick(user:User){
        this.user = user
    }


}