package com.example.keepitchecked.ui.dashboard

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.keepitchecked.R
import com.example.keepitchecked.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.list_design.view.*
import java.io.IOException

class DashboardFragment : Fragment() {
    private lateinit var listAdapter: ListAdapter
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /* METHODS FOR SHOPPING LIST */
        listAdapter = ListAdapter(mutableListOf())

        root.rv_listItems.adapter = listAdapter
        root.rv_listItems.layoutManager = LinearLayoutManager(activity)

        root.btn_shop_add.setOnClickListener {
            val newItem = shop_item.text.toString()
            if (newItem.isNotEmpty()) {
                val item = Shopitem(newItem)
                listAdapter.addItem(item)
                shop_item.text.clear()
            }
        }
        root.btn_shop_delete.setOnClickListener {
            listAdapter.deleteItem()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}