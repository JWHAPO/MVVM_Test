package test.jw.mvvm.viewmodels

import android.app.Activity
import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import test.jw.mvvm.common.db.AppDatabase
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: UserViewModel
 * Created by JEONGWOOKIM on 2019-02-14.
 * Description:
 */
class UserViewModel(val application: Application) : BaseObservable(){

    private var appDatabase: AppDatabase = AppDatabase.getInstance(application)!!

    @Bindable
    var user: User = User()

    fun afterNameTextChanged(s:CharSequence){
        user.lastName = s.toString()
        notifyPropertyChanged(BR.user)
    }

    fun afterAgeTextChanged(s:CharSequence){
        user.age = s.toString().toInt()
    }

    fun afterGenderTextChanged(s:CharSequence){
        user.gender = s.toString()
    }

    private fun addList() {
        Completable.fromAction(run { Action { appDatabase.userDao().insert(user) } })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successAdd,this::failAdd)
    }

    fun successAdd(){
        println("Success")
    }

    fun failAdd(error: Throwable){
        println("Fail${error}")
    }

    fun onNextClicked(){
        addList()
    }
}