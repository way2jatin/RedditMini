package com.sample.redditmini.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.redditmini.databinding.ItemTopicBinding
import com.sample.redditmini.model.Topic

class TopicAdapter(private var listener:TopicAdapterListener) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    var topics: List<Topic> = mutableListOf()

    class TopicViewHolder(private val binding: ItemTopicBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: Topic,
            listener: TopicAdapterListener
        ) {
            binding.topic = item

            binding.ibDownvote.setOnClickListener {
                listener.onDownVote(item)
            }

            binding.ibUpvote.setOnClickListener {
                listener.onUpVote(item)
            }

            binding.root.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    fun setData(topic: List<Topic>){
        this.topics = topic
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder =
        TopicViewHolder(ItemTopicBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) = holder.bind(topics[position],listener)

    interface TopicAdapterListener {
        fun onItemClick(item:Topic)
        fun onUpVote(item: Topic)
        fun onDownVote(item: Topic)
    }
}