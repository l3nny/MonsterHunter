package com.yulie.monsterhunter.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable


import androidx.recyclerview.widget.RecyclerView
import com.yulie.monsterhunter.databinding.ListItemBinding
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.viewmodel.ListViewModel


class ApiListAdapter(private val apiListViewModel: ListViewModel) :
    RecyclerView.Adapter<ApiListViewHolder>(), Filterable {
    var apiList: ArrayList<Armor> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ListItemBinding.inflate(inflater, parent, false)
        return ApiListViewHolder(dataBinding, apiListViewModel)
    }

    override fun getItemCount() = apiList.size

    override fun onBindViewHolder(holder: ApiListViewHolder, position: Int) {
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
                val filterPattern = constraint.toString().toLowerCase().trim()

                filterResults.values = if (constraint.isNullOrBlank()) {
                    apiList
                } else {
                    apiList.filter {
                        it.name.toLowerCase().contains(filterPattern)
                    }
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                apiList = filterResults.values as ArrayList<Armor>
                notifyDataSetChanged()
            }
        }
    }


}