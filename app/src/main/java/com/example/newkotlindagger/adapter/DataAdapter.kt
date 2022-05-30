package com.example.newkotlindagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 import com.example.newkotlindagger.R
import com.example.newkotlindagger.pojo.NewsModel
import com.squareup.picasso.Picasso

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    var listModel: List<NewsModel> = emptyList()
    var onListItemClick: OnClickListner? = null

    fun setList(listModel: List<NewsModel>) {
        this.listModel = listModel
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.textTitle)
        var source: TextView = itemView.findViewById(R.id.source)
        var newsImage: ImageView = itemView.findViewById(R.id.coverImage)

        fun bind(Model: NewsModel) {
            txtTitle.text = Model.title
            source.text = Model.source.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        var Model: NewsModel = listModel.get(position)
        holder.itemView.setOnClickListener(View.OnClickListener {
            onListItemClick?.onClick(position)
        })
        holder.bind(Model)

        Picasso.get()
            .load(Model.url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

}