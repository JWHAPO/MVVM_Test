package test.jw.mvvm.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import test.jw.mvvm.R
import test.jw.mvvm.databinding.AddLayoutBinding
import test.jw.mvvm.viewmodels.UserViewModel
import com.android.databinding.library.baseAdapters.BR

/**
 * MVVM_Test
 * Class: AddActivity
 * Created by JEONGWOOKIM on 2019-02-13.
 * Description:
 */
class AddActivity:AppCompatActivity(){

    lateinit var addLayoutBinding: AddLayoutBinding
    lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = UserViewModel()
        initDatabinding()
    }


    /**
     * initial Databinding
     */
    private fun initDatabinding(){
        addLayoutBinding = DataBindingUtil.setContentView(this, R.layout.add_layout)
        addLayoutBinding.setVariable(BR.userViewModel, userViewModel)
        addLayoutBinding.executePendingBindings()
    }
}