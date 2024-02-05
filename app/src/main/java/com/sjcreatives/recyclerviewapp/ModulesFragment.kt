package com.sjcreatives.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.recyclerviewapp.databinding.FragmentModulesBinding


class ModulesFragment : Fragment() {

    private lateinit var binding: FragmentModulesBinding
    private lateinit var adapter: ModulesAdapter
    private lateinit var viewModel: ModulesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentModulesBinding.inflate(layoutInflater, container, false)

        adapter = ModulesAdapter()

//        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this)[ModulesViewModel::class.java]
        binding.modulesRecyclerView.adapter = adapter
        binding.modulesRecyclerView.layoutManager = LinearLayoutManager(context)

        adapter.submitList(viewModel.getListOfModules())

        return binding.root
    }

}