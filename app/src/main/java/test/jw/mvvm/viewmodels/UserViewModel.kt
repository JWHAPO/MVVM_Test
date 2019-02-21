package test.jw.mvvm.viewmodels

import android.app.Application
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
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
    private var mCompositeDisposable : CompositeDisposable = CompositeDisposable()

    @Bindable
    var emailValue:Boolean = false;

    @Bindable
    var user: User = User()
        set(value) {
            field = value
            notifyPropertyChanged(BR.user)
        }

    fun afterNameTextChanged(s:CharSequence){
        user.lastName = s.toString()
    }
    fun afterEmailTextChanged(s:CharSequence){
        user.email = s.toString()
        emailValue = user.isEmailValid()
        notifyPropertyChanged(BR.emailValue)
    }

    fun afterAgeTextChanged(s:CharSequence){
        if(s=="") user.age = 0
        else user.age = s.toString().toInt()
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

    fun updateDetail(userId:Long) {
        if(userId!=0L){
            mCompositeDisposable.add(appDatabase.userDao().getUserById(userId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::updateUser, this::searchError)
            )
        }
    }

    private fun updateUser(user:User){
        emailValue = true
        this.user = user
    }

    private fun searchError(error: Throwable){
        Toast.makeText(application.applicationContext,"${error}!", Toast.LENGTH_LONG).show()
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