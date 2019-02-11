package test.jw.mvvm.model

import android.text.TextUtils
import android.util.Patterns

/**
 * MVVM_Test
 * Class: User
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */
data class User(var email:String, var password:String){

    fun isInputDataValid():Boolean{
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 5;

    }
}

