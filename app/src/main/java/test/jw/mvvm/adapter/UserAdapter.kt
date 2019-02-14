package test.jw.mvvm.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import test.jw.mvvm.BR
import test.jw.mvvm.databinding.ListRowBinding
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: UserAdapter
 * Created by JEONGWOOKIM on 2019-02-13.
 * Description:
 */

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>(){

    var users = emptyList<User>()

    fun setData(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater  = LayoutInflater.from(parent.context)
        val binding = ListRowBinding.inflate(layoutInflater)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(users.get(position))
    }

    inner class Holder(val binding: ListRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj:User){
            binding.setVariable(BR.user, obj)
            binding.executePendingBindings()
        }
    }
}