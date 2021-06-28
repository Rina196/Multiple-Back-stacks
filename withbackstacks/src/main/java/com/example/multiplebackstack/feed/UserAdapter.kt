package com.example.multiplebackstack.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplebackstack.R
import kotlinx.android.synthetic.main.item_main.view.*

class UserAdapter(
    private val context: Context,
    private val files: ArrayList<UserData>,
    private val onCLick: (userData : UserData) -> Unit
) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return files.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val file = files[position]
        holder.itemView.tvName.text = file.title
        holder.itemView.tvMobile.text = file.message
        holder.itemView.setOnClickListener {
            onCLick.invoke(file)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}