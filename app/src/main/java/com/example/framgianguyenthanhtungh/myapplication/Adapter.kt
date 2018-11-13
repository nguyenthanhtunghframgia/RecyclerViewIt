package com.example.framgianguyenthanhtungh.myapplication

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.framgianguyenthanhtungh.myapplication.databinding.ItemBinding

class Adapter(val list: ArrayList<Item>, val onItemClick: (Item) -> Unit)
    : RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(p0.context),
            R.layout.item, p0, false
        )
        binding.apply {
            root.setOnClickListener {
                if (this is ItemBinding) this.item?.let { onItemClick.invoke(it) }
            }
        }
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        if (p0.binding is ItemBinding) p0.binding.item = list[p1]
        val textView: TextView = p0.binding.root.findViewById(R.id.text)
        textView.text = list[p1].string
        p0.binding.executePendingBindings()
    }


    class Holder(val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
//        val view = LayoutInflater.from(p0.getContext())
//            .inflate(R.layout.item, p0, false)
//        return Holder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(p0: Holder, p1: Int) {
//        p0.bindData(list[p1])
//    }
//
//    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val text: TextView = itemView.findViewById(R.id.text)
//        fun bindData(item: Item) {
//            text.setText(item.string)
//        }
//    }
}
