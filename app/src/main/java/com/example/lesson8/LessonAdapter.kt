package com.example.lesson8

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson8.databinding.ItemBinding


class LessonAdapter(private val data: ArrayList<Lessons>, private val onClick: ((pos: Int) -> Unit)? = null) :
    RecyclerView.Adapter<LessonAdapter.LessonHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        return LessonHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onClick?.let { it1 -> it1(position) }
        }
    }


    override fun getItemCount(): Int = data.size


    inner  class LessonHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.M)
       fun bind(lessons: Lessons) {
            binding.textView.text = lessons.lessonName
            Glide.with(binding.imageView).load(lessons.lessonImage).into(binding.imageView)
            lessons.color?.let {
                if (it != null){
                    binding.mainLayout.setBackgroundColor(itemView.context.getColor(it))
                }
            }
            lessons.textColor?.let {
                if (it != null) {
                    binding.textView.setBackgroundColor(itemView.context.getColor(it))
                }
            }
        }
    }
}