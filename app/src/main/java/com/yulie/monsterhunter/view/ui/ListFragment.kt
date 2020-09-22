package com.yulie.monsterhunter.view.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yulie.monsterhunter.R
import com.yulie.monsterhunter.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import com.yulie.monsterhunter.databinding.FragmentListBinding
import com.yulie.monsterhunter.view.adapter.ApiListAdapter
import androidx.lifecycle.ViewModelProvider



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentListBinding
    private lateinit var adapter: ApiListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewDataBinding = FragmentListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProvider(this@ListFragment).get(ListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)



            filterArmor.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                }
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                  adapter.filter.filter(charSequence.toString())

                }

                override fun afterTextChanged(editable: Editable) {
                    adapter.filter.filter(editable.toString())
                }
            })


        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchList()

        setupAdapter()
        setupObservers()

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }


    private fun setupObservers() {
         viewDataBinding.viewmodel?.listLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateApiList(it)
        })

       /* viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.Toast(it)
        })*/
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = ApiListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            repo_list_rv.adapter = adapter





        }
    }
}