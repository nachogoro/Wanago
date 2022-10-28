package com.architectcoders.wanago

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.architectcoders.wanago.databinding.FragmentEventsListBinding

class FragmentEventsList : Fragment() {

    private var _binding:FragmentEventsListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : EventsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventList : List<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventsListBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerEventsList)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = EventsAdapter(eventList)
        recyclerView.adapter = adapter

    }

    private fun bind() {
        eventList = listOf(
            Event("https://loremflickr.com/320/240?lock=1", "Drake","Sevilla"),
            Event("https://loremflickr.com/320/240?lock=", "Drake","Madrid"),
            Event("https://loremflickr.com/320/240?lock=3", "Drake","Barcelona"),
            Event("https://loremflickr.com/320/240?lock=4", "Drake","Oviedo"),
            Event("https://loremflickr.com/320/240?lock=5", "Drake","Valencia")
        )
    }

}