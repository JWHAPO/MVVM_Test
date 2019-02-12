package test.jw.mvvm.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import test.jw.mvvm.R
import test.jw.mvvm.databinding.MainLayoutBinding
import test.jw.mvvm.model.User
import test.jw.mvvm.viewmodels.UserViewModel

/**
 * MVVM_Test
 * Class: MainActivity
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class MainActivity: AppCompatActivity() {

    private lateinit var mainLayoutBinding:MainLayoutBinding
    private lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUserData()
        initDatabinding()

    }

    /**
     * initial User data
     */
    private fun initUserData(){
        user = User()
        user.age=15
        user.female = false
        user.lastName = "Kim"
        user.firstName = "JeongWoo"
    }

    /**
     * initial Databinding
     */
    private fun initDatabinding(){
        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        mainLayoutBinding.setVariable(BR.user, UserViewModel(user))
        mainLayoutBinding.executePendingBindings()
    }
}

@BindingAdapter("age")
fun changeAge(view: View, age: String) {
    Toast.makeText(view.context,"changed "+age+" age",Toast.LENGTH_LONG).show()
}