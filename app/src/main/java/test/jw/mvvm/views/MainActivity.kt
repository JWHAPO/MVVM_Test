package test.jw.mvvm.views

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import test.jw.mvvm.R
import test.jw.mvvm.adapter.UserAdapter
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDatabinding()

    }

    /**
     * initial Databinding
     */
    private fun initDatabinding(){

        var user = User()
        user.lastName = "1"
        user.age = 33

        mainLayoutBinding = DataBindingUtil.setContentView(this, R.layout.main_layout)
        mainLayoutBinding.setVariable(BR.vm, UserViewModel(user))
        mainLayoutBinding.executePendingBindings()
    }
}


@BindingAdapter("setAdapter")
fun bindRecyclerViewAdapter( recyclerView:RecyclerView, adapter:RecyclerView.Adapter<RecyclerView.ViewHolder> ) {
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.setHasFixedSize(true)
}