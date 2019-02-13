package test.jw.mvvm.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import test.jw.mvvm.BR
import test.jw.mvvm.databinding.ListRowBinding
import test.jw.mvvm.model.User
import test.jw.mvvm.viewmodels.UserViewModel

/**
 * MVVM_Test
 * Class: UserAdapter
 * Created by JEONGWOOKIM on 2019-02-13.
 * Description:
 */

class UserAdapter(val viewModel:UserViewModel, val users:List<User>) : RecyclerView.Adapter<UserAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater:LayoutInflater  = LayoutInflater.from(parent.context)
        val binding = ListRowBinding.inflate(layoutInflater)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(users.get(position),viewModel)
    }

    inner class Holder(val binding: ListRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj:User, vm: UserViewModel){
            binding.setVariable(BR.obj, obj)
            binding.setVariable(BR.vm,vm)

            binding.executePendingBindings()
        }
    }
}