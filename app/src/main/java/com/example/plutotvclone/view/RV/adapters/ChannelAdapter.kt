package com.example.plutotvclone.view.RV.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plutotvclone.R
import com.example.plutotvclone.model.Channel


class ChannelAdapter(private var channels: List<Channel>,
                     private val onImageButtonClick: (Int) -> Unit) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val channelName: TextView = itemView.findViewById(R.id.channelName)
        val channelImageButton: ImageButton = itemView.findViewById(R.id.channelImageButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel, parent, false)
        return ChannelViewHolder(view)
    }


    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channels[position]
        holder.channelName.text = holder.itemView.context.getString(channel.nameResId)
        holder.channelImageButton.setImageResource(channel.imageResId)

        holder.channelImageButton.setOnClickListener {
            onImageButtonClick(channel.contentImageResId)
        }
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    fun updateChannels(newChannels: List<Channel>) {
        this.channels = newChannels
        notifyDataSetChanged()
    }



}