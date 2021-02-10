package com.wsr.katanarecorder.main.list

import androidx.lifecycle.ViewModel
import com.wsr.katanarecorder.db.SampleDB

class ListViewModel : ViewModel(){
    val sampleModel = SampleDB.getDatabase().getAll()
}