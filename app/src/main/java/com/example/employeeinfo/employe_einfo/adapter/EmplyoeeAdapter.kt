package com.example.employeeinfo.employe_einfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.employeeinfo.R
import com.example.employeeinfo.Utils.EmployeeItem

class EmplyoeeAdapter(var emps : Array<EmployeeItem>) : RecyclerView.Adapter<MyViewHolder>() {

    var emplyoees : Array<EmployeeItem> = emps

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_employee,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return emplyoees.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val emp = emplyoees[position]

        holder.id.text = emp.EMP_Id.toString()
        holder.name.text = emp.Name
        holder.dob.text = emp.DOB
        holder.role.text = emp.Role
        holder.index.text = emp.EMP_Id.toString()

    }

    fun filter(query : String)
    {
        emplyoees = if (query.isEmpty()) { emps }
        else{
            emps.filter { employeeItem ->
                employeeItem.Name.contains(query, ignoreCase = true)
            }.toTypedArray()
        }
        notifyDataSetChanged()
    }

    fun updateIssues(newEmp : Array<EmployeeItem>) {
        emps = newEmp
        filter("")
    }
}

class MyViewHolder(itemView: View) : ViewHolder(itemView)
{
    var id = itemView.findViewById<TextView>(R.id.tv_id)
    var name = itemView.findViewById<TextView>(R.id.tv_name)
    var dob = itemView.findViewById<TextView>(R.id.tv_dob)
    var role = itemView.findViewById<TextView>(R.id.tv_role)
    var index = itemView.findViewById<TextView>(R.id.tv_index)

}