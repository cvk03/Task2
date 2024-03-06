package com.example.employeeinfo.employe_einfo.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmployeeViewModelFactory(val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(context) as T
    }
}