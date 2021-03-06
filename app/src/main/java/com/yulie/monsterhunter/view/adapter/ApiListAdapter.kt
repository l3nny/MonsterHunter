package com.yulie.monsterhunter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.yulie.monsterhunter.databinding.ListItemBinding
import com.yulie.monsterhunter.service.model.Armor
import java.util.*
import kotlin.collections.ArrayList


class ApiListAdapter() : RecyclerView.Adapter<ApiListViewHolder>(), Filterable {
    var apiList: ArrayList<Armor> = arrayListOf()
    var backUpList: ArrayList<Armor> = arrayListOf()
    var pro = 0;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ListItemBinding.inflate(inflater, parent, false)
        return ApiListViewHolder(dataBinding)
    }

    override fun getItemCount() = apiList.size

    override fun onBindViewHolder(holder: ApiListViewHolder, position: Int) {
        holder.setIsRecyclable(false);
        holder.setup(apiList[position])
    }

    fun updateApiList(apiList: ArrayList<Armor>) {
        this.apiList = apiList
        notifyDataSetChanged()
    }


    override fun getFilter(): Filter {

        return object : Filter() {
            private val filterResults = FilterResults()

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterPattern = constraint.toString().toLowerCase(Locale.ROOT).trim()

                if (pro == 0 && apiList.isNotEmpty()) {
                    backUpList.addAll(apiList)
                    pro++
                }

                filterResults.values = if (constraint.isNullOrBlank()) {
                    apiList.clear()
                    apiList.addAll(backUpList)
                } else {
                    apiList.filter {
                        it.name.toLowerCase(Locale.ROOT).contains(filterPattern)
                    }
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.values = if (constraint.isNullOrBlank()) {
                    updateApiList(apiList)
                } else {
                    @Suppress("UNCHECKED_CAST")
                    updateApiList(filterResults.values as ArrayList<Armor>)
                }
            }
        }
    }


}