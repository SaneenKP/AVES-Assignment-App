package com.saneen.avesassignmentapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saneen.avesassignmentapp.databinding.ItemViewHomeViewBinding
import com.saneen.avesassignmentapp.models.Result

class HomePageAdapter(
    private val list : List<Result>?
) : RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        val binding = ItemViewHomeViewBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HomePageViewHolder(context = parent.context , binding = binding)
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        list?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class HomePageViewHolder(private val context : Context,
                                   private val binding: ItemViewHomeViewBinding)
        : RecyclerView.ViewHolder(binding.root){

            fun bind(result : Result){
                binding.data = result
            }
    }
}