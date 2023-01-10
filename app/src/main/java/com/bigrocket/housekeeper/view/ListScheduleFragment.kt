package com.bigrocket.housekeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.resources.DataSourceSchedules
import com.bigrocket.housekeeper.resources.ListScheduleAdapter
import kotlinx.android.synthetic.main.fragment_list_schedule.*

class ListScheduleFragment : Fragment(R.layout.fragment_list_schedule) {

    private lateinit var listScheduleAdapter: ListScheduleAdapter
    private val args: ListScheduleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        populateArrayList()
    }

    private fun initAdapter() {
        listScheduleAdapter = ListScheduleAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listScheduleAdapter
        }
    }

    private fun populateArrayList() {
        DataSourceSchedules.createSchedules(args.schedule) {
            listScheduleAdapter.setDataSet(it)
        }
    }
}