package test.jw.mvvm.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import test.jw.mvvm.BR
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: LoginViewModel
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class LoginViewModel:BaseObservable(){

    private var user:User = User("","")

    @Bindable
    var toastMessage:String = ""

    val successMessage:String = "Login was successful"
    val errorMessage :String = "Email or Password not valid"


    fun gettingToastMessage():String{
        return toastMessage
    }

    fun settingToastMessage(toastMessage: String){
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    fun afterEmailTextChanged(s:CharSequence){
        user.email = s.toString()
    }
    fun afterPasswordTextChanged(s:CharSequence){
        user.password = s.toString()
    }

    fun onLoginClicked(){
        if(user.isInputDataValid()) settingToastMessage(successMessage)
        else settingToastMessage(errorMessage)
    }

}