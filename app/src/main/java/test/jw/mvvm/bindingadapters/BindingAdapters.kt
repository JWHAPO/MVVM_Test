package test.jw.mvvm.bindingadapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.add_layout.view.*
import test.jw.mvvm.adapter.UserAdapter
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: BindingAdapters
 * Created by JEONGWOOKIM on 2019-02-15.
 * Description:
 */


@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, users: List<User>) {
    val adapter = recyclerView.adapter as UserAdapter?
    adapter?.setData(users)
}

@BindingAdapter("email_valid")
fun checkEmailValid(view:View, isValid:Boolean){
    view.add_email_valid_tv.let { if(isValid) it.text = "Your Email is Correct!!" else it.text = "Failed. Try to sucess" }
}