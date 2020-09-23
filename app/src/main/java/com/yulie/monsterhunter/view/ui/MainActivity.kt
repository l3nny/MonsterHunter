package com.yulie.monsterhunter.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yulie.monsterhunter.R
import com.yulie.monsterhunter.viewmodel.ListViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        ListViewModel.getInstance().fetchList();
    }
}