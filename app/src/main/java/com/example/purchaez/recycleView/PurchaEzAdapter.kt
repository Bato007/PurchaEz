package com.example.purchaez.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.purchaez.R
import kotlinx.android.synthetic.main.card_view.view.*

class PurchaEzAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var item: ArrayList<Items> = ArrayList()
    private var xPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context!!).inflate(R.layout.card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                holder.bind(item.get(position))

                holder.itemView.setOnClickListener{
                    xPosition = position
                    item.removeAt(position)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun submitList(answerList: ArrayList<Items>){
        item = answerList
    }

    fun getItem(): ArrayList<Items> {
        return item
    }

    fun getDeleted():Int{
        return xPosition
    }

    class ItemViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.listItem
        var cost = itemView.listCost
        var number = itemView.itemNumber

        fun bind(item: Items){
            name.setText(item.name)
            cost.setText(item.cost.toString())
            number.setText(item.number.toString())
        }

    }

}