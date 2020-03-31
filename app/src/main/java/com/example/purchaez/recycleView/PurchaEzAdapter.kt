package com.example.purchaez.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.purchaez.R
import kotlinx.android.synthetic.main.card_view.view.*

class PurchaEzAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var item: List<Items> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context!!).inflate(R.layout.card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                holder.bind(item.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun submitList(answerList: List<Items>){
        item = answerList
    }

    fun getItem(): List<Items> {
        return item
    }

    class ItemViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.listItem
        var cost = itemView.listCost

        fun bind(item: Items){
            name.setText(item.name)
            cost.setText(item.cost.toString())
        }

    }

}