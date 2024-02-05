package com.sjcreatives.recyclerviewapp

import androidx.lifecycle.ViewModel

class ModulesViewModel : ViewModel() {

    private var listOfModules = mutableListOf<Module>()

    fun getListOfModules(): MutableList<Module>{
        if (listOfModules.isEmpty()) {
            for (i in 1..100) {
                listOfModules.add(Module(i, "Module $i"))
            }
        }

        return listOfModules
    }
}

