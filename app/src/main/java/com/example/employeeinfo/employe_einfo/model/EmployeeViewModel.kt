package com.example.employeeinfo.employe_einfo.model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.employeeinfo.Utils.EmployeeItem
import com.google.gson.Gson

class EmployeeViewModel(val context: Context) : ViewModel() {

    var employeeList : Array<EmployeeItem> = emptyArray()

    init {
        employeeList = loadEmployeeList()
    }

    private fun loadEmployeeList() : Array<EmployeeItem>
    {
        val inputStream = context.assets.open("employee_data.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()

       return gson.fromJson(json, Array<EmployeeItem>::class.java)
    }

    fun getEmplyoees() : Array<EmployeeItem>
    {
        return employeeList
    }

}