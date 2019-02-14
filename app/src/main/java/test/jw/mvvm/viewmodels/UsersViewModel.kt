package test.jw.mvvm.viewmodels

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Handler
import test.jw.mvvm.BR
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: UsersViewModel
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class UsersViewModel : BaseObservable(){

    @Bindable
    var users: List<User> = emptyList()
    set(value) {
        field = value
        notifyPropertyChanged(BR.users)
    }

    private val updateInterval = 1000L
    private val updateHandler = Handler()

    private var updateRunnable:Runnable = object: Runnable{
        override fun run() {
            updateList()
        }
    }


    private fun updateList(){
        val user1 = User()
        user1.id = 1
        user1.lastName = "Jee"
        user1.age = 33
        val user2 = User()
        user2.id = 2
        user2.lastName = "Jee111"
        user2.age = 444

        users = listOf(user1,user2)
    }

    fun startUpdates(){
        updateHandler.postDelayed(updateRunnable, updateInterval)
    }
    fun stopUpdates(){
        updateHandler.removeCallbacks(updateRunnable)
    }

    fun onAddClicked(){
    }

}