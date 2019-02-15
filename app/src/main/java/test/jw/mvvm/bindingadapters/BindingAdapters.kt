package test.jw.mvvm.bindingadapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
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

@BindingAdapter("change_name")
fun setChangeName(view: View, user:User){
    Toast.makeText(view.context,"Text: ${user.lastName} !!",Toast.LENGTH_SHORT).show()
}