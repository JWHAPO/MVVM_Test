package test.jw.mvvm.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR
import test.jw.mvvm.R
import test.jw.mvvm.adapter.UserAdapter
import test.jw.mvvm.databinding.MainLayoutBinding
import test.jw.mvvm.model.User
import test.jw.mvvm.viewmodels.UsersViewModel

/**
 * MVVM_Test
 * Class: MainActivity
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class MainActivity: AppCompatActivity() {

    private lateinit var mainLayoutBinding:MainLayoutBinding
    lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usersViewModel = UsersViewModel()
        initDatabinding()
        initRecyclerView()

        usersViewModel.startUpdates()

    }

    private fun initRecyclerView(){
        val adapter = UserAdapter()
        mainLayoutBinding.mainRv.adapter = adapter
        mainLayoutBinding.mainRv.layoutManager = LinearLayoutManager(applicationContext)
        mainLayoutBinding.mainRv.setHasFixedSize(true)
    }

    /**
     * initial Databinding
     */
    private fun initDatabinding(){
        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        mainLayoutBinding.setVariable(BR.usersViewModel, usersViewModel)
        mainLayoutBinding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        usersViewModel.stopUpdates()
    }
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, users: List<User>) {

    val adapter = recyclerView.adapter as UserAdapter?
    adapter?.setData(users)
}