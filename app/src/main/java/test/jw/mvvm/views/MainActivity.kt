package test.jw.mvvm.views

import android.content.Context
import android.content.Intent
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
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usersViewModel = UsersViewModel(application)
        initDatabinding()
        initRecyclerView()
        usersViewModel.updateList()

    }

    private fun initRecyclerView(){
        val adapter = UserAdapter{
            launchNoteDetailActivity(this@MainActivity,it.id)
        }
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
        usersViewModel.clearCompositeDisposable()
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.updateList()
    }

    private fun launchNoteDetailActivity(context: Context, userId: Long? = null) {
        val intent = Intent(context, AddActivity::class.java)
        userId?.let {
        }
        context.startActivity(intent)
    }
}
