package com.yulie.monsterhunter.view.adapter

import android.widget.LinearLayout
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yulie.monsterhunter.BR
import com.yulie.monsterhunter.R
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.view.dynamicContent.DynamicUiContent
import kotlinx.android.synthetic.main.list_item.view.*

class ApiListViewHolder constructor(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {

    private val img = itemView.item_icon
    private val tex = itemView.item_decor_layout

    fun setup(itemData: Armor) {

        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        when (itemData.type) {
            ("head") -> {
                Picasso.get().load(R.drawable.ic_head).fit().placeholder(R.drawable.ic_head).into(img);
            }
            ("waist") -> {
                Picasso.get().load(R.drawable.ic_waist).fit().placeholder(R.drawable.ic_waist)
                    .into(img);
            }
            ("chest") -> {
                Picasso.get().load(R.drawable.ic_chest).fit().placeholder(R.drawable.ic_chest)
                    .into(img);
            }
            ("gloves") -> {
                Picasso.get().load(R.drawable.ic_gloves).fit().placeholder(R.drawable.ic_gloves)
                    .into(img);
            }
            ("legs") -> {
                Picasso.get().load(R.drawable.ic_legs).fit().placeholder(R.drawable.ic_legs).into(img);
            }
        }

        for (item in 0 until itemData.slots.size) {
            val linearLayout: LinearLayout? = DynamicUiContent(dataBinding.root.context).getLinearLayout()
            linearLayout?.addView(DynamicUiContent(dataBinding.root.context).getTextView(itemData.slots[item].rank.toString()))
            tex.addView(linearLayout)
        }
    }
}

