package com.sjcreatives.recyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.recyclerviewapp.databinding.ModuleItemBinding

class ModulesAdapter : ListAdapter<Module, ModulesAdapter.ViewHolder>(
    ModulesDiffCallBack()
) {
    class ViewHolder(val binding: ModuleItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind (module: Module){
            binding.module = module
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ModuleItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

}

class ModulesDiffCallBack : DiffUtil.ItemCallback<Module>(){
    override fun areItemsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem == newItem
    }

}
