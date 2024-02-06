package com.sjcreatives.recyclerviewapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ModulesViewModel : ViewModel() {

    private val _listOfModules = MutableLiveData<List<Module>>()
    val listOfModules: LiveData<List<Module>> = _listOfModules

    init {
        loadModules()
    }

    private fun loadModules(){
        val modules = mutableListOf<Module>()
        for (i in 1 ..100){
            modules.add(Module(i,"Module $i"))
        }
        _listOfModules.value = modules
    }

    private val _navigateToDetails = MutableLiveData<Module>()
    val navigateToDetails: LiveData<Module> = _navigateToDetails

    fun onModuleClicked (module: Module){
        _navigateToDetails.value = module
    }

}

