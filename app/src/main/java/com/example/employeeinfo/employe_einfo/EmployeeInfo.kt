package com.example.employeeinfo.employe_einfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeeinfo.R
import com.example.employeeinfo.Utils.EmployeeItem
import com.example.employeeinfo.employe_einfo.adapter.EmplyoeeAdapter
import com.example.employeeinfo.employe_einfo.model.EmployeeViewModel
import com.example.employeeinfo.employe_einfo.model.EmployeeViewModelFactory

class EmployeeInfo : Fragment() {
    lateinit var emplyoeeList : Array<EmployeeItem>
    lateinit var emplyoeeAdapter : EmplyoeeAdapter
    lateinit var employeeViewModel: EmployeeViewModel
    lateinit var rv : RecyclerView
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_employee_info, container, false)


        employeeViewModel = ViewModelProvider(requireActivity(),EmployeeViewModelFactory(requireContext())).get(EmployeeViewModel::class.java)

        rv = view.findViewById(R.id.view_recycler)
        searchView = view.findViewById(R.id.searchView)

        emplyoeeAdapter = EmplyoeeAdapter(emptyArray())

       emplyoeeList = employeeViewModel.getEmplyoees()

        if(emplyoeeList.isNotEmpty())
        {
            emplyoeeAdapter = EmplyoeeAdapter(emplyoeeList)
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = emplyoeeAdapter

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    emplyoeeAdapter.filter(newText.orEmpty())
                    return true
                }
            })


        }




        return view
    }


}