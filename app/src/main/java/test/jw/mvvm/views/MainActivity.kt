package test.jw.mvvm.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import test.jw.mvvm.R
import test.jw.mvvm.databinding.MainLayoutBinding
import test.jw.mvvm.viewmodels.LoginViewModel

/**
 * MVVM_Test
 * Class: MainActivity
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class MainActivity: AppCompatActivity() {

    lateinit var mainLayoutBinding:MainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)

        mainLayoutBinding.viewModel = LoginViewModel()
        mainLayoutBinding.executePendingBindings()

    }

}

 @BindingAdapter("toastMessage")
fun runMe(view:View, message:String){
    Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
}