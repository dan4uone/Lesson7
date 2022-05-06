package com.example.lesson8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson8.databinding.FragmentLessonBinding

class LessonFragment : Fragment() {
    private lateinit var binding : FragmentLessonBinding
    private lateinit var adapter: LessonAdapter
    private val data = arrayListOf<Lessons>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLessonBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = LessonAdapter(data,{
            requireContext().showToast(it.toString())
        })
        binding.recycle.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recycle.adapter = adapter
    }

    private fun loadData() {
        data.add(Lessons("Math","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNIEfmjGzOXrMW1prnoe2MAPnxdeKWVRio1g&usqp=CAU",R.color.dark_blue,R.color.dark_blue_two))
        data.add(Lessons("History","https://thumbnail.imgbin.com/8/24/10/history-icon-cultures-icon-KqyVjhWy_t.jpg",R.color.red,R.color.red_two))
        data.add(Lessons("Informatica","https://w7.pngwing.com/pngs/761/575/png-transparent-brand-used-car-sales-informatica-logo-vehicle-informatica.png",R.color.pink,R.color.pink_two))
        data.add(Lessons("Biology","https://w7.pngwing.com/pngs/576/80/png-transparent-biology.png",R.color.green,R.color.green_two))
        data.add(Lessons("Chemistry","https://e7.pngegg.com/pngimages/597/197/png-clipart-atom-computer-icons-others-miscellaneous-chemistry.png",R.color.blue,R.color.blue_two))
        data.add(Lessons("Geography","https://cdn-icons-png.flaticon.com/512/2784/2784487.png",R.color.purple,R.color.purple_two))
        data.add(Lessons("Literature","https://w7.pngwing.com/pngs/304/827/png-transparent-computer-icons-writer-writing-author-others-logo-author-literature.png",R.color.orange,R.color.orange_two))
        if (arguments != null){
            val lesson :Lessons = arguments?.getSerializable("lesson") as Lessons
            data.add(lesson)
        }
    }
}
