package com.yulie.monsterhunter.view.adapter

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.ViewModel

import androidx.recyclerview.widget.RecyclerView
import com.yulie.monsterhunter.databinding.ListItemBinding
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.viewmodel.ListViewModel


class ApiListAdapter(private val apiListViewModel: ListViewModel) :
    RecyclerView.Adapter<ApiListViewHolder>(), Filterable {
    var apiList: List<Armor> = emptyList()
    var searchableList: List<Armor> = emptyList()

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


    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
              //  ListViewModel.getInstance().listLive.value
                if (constraint.isNullOrBlank()) {
                    searchableList.toMutableList().addAll(apiList)
                } else {
                    val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                     for (item in 0..apiList.size) {
                         if (apiList[item].name!!.toLowerCase().contains(filterPattern)) {
                             searchableList.toMutableList().add(apiList[item])
                         }
                     }
                }
                return filterResults.also {
                       it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                //  if (searchableList.isNullOrEmpty())
                //     onNothingFound?.invoke()
                notifyDataSetChanged()

            }
        }
    }


}