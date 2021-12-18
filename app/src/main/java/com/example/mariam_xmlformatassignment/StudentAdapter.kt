package com.example.mariam_xmlformatassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mariam_xmlformatassignment.databinding.ItemRowBinding

class StudentAdapter (private var students: List<Student>): RecyclerView.Adapter<StudentAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = students[position]

        holder.binding.apply {
            name.text = student.name
           marks.text = student.grade.toString()
        }
    }

    override fun getItemCount() = students.size

    fun update(students: List<Student>){
        this.students = students
        notifyDataSetChanged()
    }
}