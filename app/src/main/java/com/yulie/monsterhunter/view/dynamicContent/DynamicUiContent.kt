package com.yulie.monsterhunter.view.dynamicContent

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginStart
import com.yulie.monsterhunter.R


class DynamicUiContent constructor(private val context: Context) {

    private var textView: TextView? = null
    private var linearLayout: LinearLayout? = null

    fun getTextView(rank: String): TextView? {
        textView = TextView(context)
        textView!!.text = rank
        return textView
    }

    fun getLinearLayout(): LinearLayout? {
        linearLayout = LinearLayout(context)
        linearLayout?.setBackgroundResource(R.drawable.ic_deco)
        linearLayout?.layoutParams = LinearLayout.LayoutParams(50, 50);
        linearLayout?.gravity = Gravity.CENTER

        return linearLayout

    }
}