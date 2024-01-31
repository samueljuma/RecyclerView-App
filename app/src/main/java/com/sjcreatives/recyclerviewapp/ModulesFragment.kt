package com.sjcreatives.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.recyclerviewapp.databinding.FragmentModulesBinding


class ModulesFragment : Fragment() {

    private lateinit var binding: FragmentModulesBinding
    private lateinit var adapter: ModulesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentModulesBinding.inflate(layoutInflater, container, false)

        adapter = ModulesAdapter()

        binding.lifecycleOwner = viewLifecycleOwner

        //Data
        var listOfModules = mutableListOf<Module>()

        for (i in 1..100) { // This will iterate 11 times
            listOfModules.add(Module(i, "Module $i"))
        }

        binding.modulesRecyclerView.adapter = adapter
        binding.modulesRecyclerView.layoutManager = LinearLayoutManager(context)

        adapter.submitList(listOfModules)

        return binding.root
    }

}