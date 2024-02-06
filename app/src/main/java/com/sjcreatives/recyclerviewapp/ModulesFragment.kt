package com.sjcreatives.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
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

        adapter = ModulesAdapter(ModuleClickListener { module ->
            viewModel.onModuleClicked(module)
        })

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = ViewModelProvider(this)[ModulesViewModel::class.java]
        binding.modulesRecyclerView.adapter = adapter
        binding.modulesRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        viewModel.listOfModules.observe(viewLifecycleOwner){ listOfModules ->
            listOfModules?.let {
                adapter.submitList(listOfModules)
            }
        }

        viewModel.navigateToDetails.observe(viewLifecycleOwner){ module ->
            module?.let {
                Toast.makeText(context,"You clicked $it", Toast.LENGTH_SHORT).show()
            }

        }


        return binding.root
    }

}