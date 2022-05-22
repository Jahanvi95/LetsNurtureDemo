package com.example.demoapplication.base

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.demoapplication.model.Test
import com.example.demoapplication.model.locationResponse.response.Data
import com.glowdubai_staff.BaseData
import com.glowdubai_staff.base.BaseViewModel


class RecyclerAdapter<T : BaseData>(
    private var context: Context,
    private var dataSet: List<T>,
    private var viewModel: BaseViewModel,
    var listener: OnItemClickListener? = null,

    ) : androidx.recyclerview.widget.RecyclerView.Adapter<BaseViewHolder<T>>() {


    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return when (viewType) {
            0 -> BaseViewHolder.TestHolder(parent, context) as BaseViewHolder<T>
            1 -> BaseViewHolder.LocationHolder(parent, context) as BaseViewHolder<T>
            else -> BaseViewHolder.TestHolder(parent, context) as BaseViewHolder<T>
        }
    }

    // notifyDataSetChanged() only works with this method
    fun setData(dataSet: List<T>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
        Log.e("data", "setData: " + this.dataSet.size)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNotifyData(dataSet: ArrayList<T>, dataSets: T, position: Int) {
        dataSet[position] = dataSets
        this.dataSet = dataSet
        notifyDataSetChanged()
        Log.e("data", "setData: " + this.dataSet)
    }

    override fun getItemCount() = this.dataSet.size


    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, T: BaseData, string: String = "")
    }

    override fun getItemViewType(position: Int): Int {
        val type = dataSet[0].javaClass
        return when (type) {
            Test::class.java -> 0
            Data::class.java->1
            else -> 0
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) =
        holder.bind(dataSet[position], listener, viewModel, position)
}