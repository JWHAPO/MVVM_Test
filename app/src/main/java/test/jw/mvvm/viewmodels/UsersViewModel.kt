package test.jw.mvvm.viewmodels

import android.app.Application
import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import test.jw.mvvm.BR
import test.jw.mvvm.common.db.AppDatabase
import test.jw.mvvm.model.User
import test.jw.mvvm.views.AddActivity

/**
 * MVVM_Test
 * Class: UsersViewModel
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */

class UsersViewModel(var application:Application) : BaseObservable(){

    private var appDatabase: AppDatabase = AppDatabase.getInstance(application)!!
    private var mCompositeDisposable : CompositeDisposable = CompositeDisposable()


    @Bindable
    var users: List<User> = emptyList()
    set(value) {
        field = value
        notifyPropertyChanged(BR.users)
    }

    fun updateList(){
        mCompositeDisposable.add(appDatabase.userDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateUserList, this::searchError)
        )
    }

    fun searchError(error: Throwable){
        Toast.makeText(application.applicationContext,"${error}!",Toast.LENGTH_LONG).show()
    }

    fun updateUserList(users:List<User>){
        this.users = users
    }

    fun clearCompositeDisposable() {
        mCompositeDisposable.clear()
    }

    fun onAddClicked(){
        val intent = Intent(application as Context,AddActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        application.startActivity(intent)
    }

}