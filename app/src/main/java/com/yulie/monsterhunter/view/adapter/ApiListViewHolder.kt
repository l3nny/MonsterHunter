package com.yulie.monsterhunter.view.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yulie.monsterhunter.BR
import com.yulie.monsterhunter.R
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class ApiListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val apiListViewModel: ListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val img = itemView.item_icon
    fun setup(itemData: Armor) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()


        if (itemData.type.equals("head")) {
            Picasso.get().load(R.drawable.ic_head).fit().placeholder(R.drawable.ic_head).into(img);
        } else if (itemData.type.equals("waist")) {
            Picasso.get().load(R.drawable.ic_waist).fit().placeholder(R.drawable.ic_waist).into(img);
        } else if (itemData.type.equals("chest")) {
            Picasso.get().load(R.drawable.ic_chest).fit().placeholder(R.drawable.ic_chest).into(img);
        } else if (itemData.type.equals("gloves")) {
            Picasso.get().load(R.drawable.ic_gloves).fit().placeholder(R.drawable.ic_gloves).into(img);
        } else if (itemData.type.equals("legs")) {
            Picasso.get().load(R.drawable.ic_legs).fit().placeholder(R.drawable.ic_legs).into(img);
        }



    }

}
