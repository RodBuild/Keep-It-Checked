package com.example.keepitchecked.ui.dashboard

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.keepitchecked.R
import kotlinx.android.synthetic.main.list_design.view.*

class ListAdapter(private val shopList: MutableList<Shopitem>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder (
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_design,
                parent,
                false
            )
        )
    }

    fun addItem(item: Shopitem) {
        shopList.add(item)
        notifyItemInserted(shopList.size - 1)
    }

    fun deleteItem() {
        shopList.removeAll { item ->
            item.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(itemName: TextView, isChecked: Boolean) {
        if (isChecked) {
            itemName.paintFlags = itemName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            itemName.paintFlags = itemName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val curItem = shopList[position]
        holder.itemView.apply {
            itemName.text = curItem.title
            box_done.isChecked = curItem.isChecked
            toggleStrikeThrough(itemName, curItem.isChecked)
            box_done.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(itemName, isChecked)
                curItem.isChecked = !curItem.isChecked
            }
        }

    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}