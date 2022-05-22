package com.example.demoapplication.base

import com.example.demoapplication.model.Test


interface UpdateDataListenerList {
    fun onUpdateList(data: ArrayList<Test>, position: Int = 0)
}