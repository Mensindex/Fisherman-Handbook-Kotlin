package com.example.fishermanhandbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var listArrayR: ArrayList<ListItem>, var contextR: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivImage = view.findViewById<ImageView>(R.id.ivFish)
        val tvTitle = view.findViewById<TextView>(R.id.tvItemTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvItemShortDescription)

        fun bind(listItem: ListItem, context: Context) {
            ivImage.setImageResource(listItem.image_id)
            tvTitle.text = listItem.item_title_text
            //Урезаем полный текст описания для элементов списка
            var shortDescription: String
            if (listItem.item_description_text.length > 100) {
                shortDescription = listItem.item_description_text.substring(0, 100) + "..."
            } else shortDescription = listItem.item_description_text
            tvDescription.text = shortDescription

            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed: ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                //Передаем инфу на следующий экран
                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", listItem.item_title_text)
                    putExtra("content", listItem.item_description_text)
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(i)
            }
        }
    }
}