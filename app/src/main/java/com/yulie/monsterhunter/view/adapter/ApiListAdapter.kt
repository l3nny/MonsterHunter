package com.yulie.monsterhunter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yulie.monsterhunter.databinding.ListItemBinding
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.viewmodel.ListViewModel

class ApiListAdapter (private val apiListViewModel: ListViewModel) : RecyclerView.Adapter<ApiListViewHolder>() {
    var apiList: List<Armor> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ListItemBinding.inflate(inflater, parent, false)
        return ApiListViewHolder(dataBinding, apiListViewModel)
    }

    override fun getItemCount() = apiList.size

    override fun onBindViewHolder(holder: ApiListViewHolder, position: Int) {
        holder.setup(apiList[position])
    }

    fun updateApiList(apiList: List<Armor>) {
        this.apiList = apiList
        notifyDataSetChanged()
    }
}