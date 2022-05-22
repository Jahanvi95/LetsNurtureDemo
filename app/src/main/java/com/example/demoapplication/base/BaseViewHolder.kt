package com.example.demoapplication.base


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R
import com.example.demoapplication.model.Test
import com.example.demoapplication.model.locationResponse.response.Data
import com.example.demoapplication.utills.DataBindingInflate
import com.example.demoapplication.utills.setImage
import com.glowdubai_staff.BaseData
import com.glowdubai_staff.base.BaseViewModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_location.view.*
import java.util.*


abstract class BaseViewHolder<T : BaseData>(val view: ViewDataBinding) :
    RecyclerView.ViewHolder(view.root),
    LayoutContainer {

    override val containerView: View?
        get() = itemView

    abstract fun bind(
        data: T,
        listener: RecyclerAdapter.OnItemClickListener? = null,
        viewModel: BaseViewModel,
        position: Int
    )


    class TestHolder(parent: ViewGroup, val context: Context) :
        BaseViewHolder<Test>(
            parent.DataBindingInflate(
                R.layout.layout_custom
            )
        ) {

        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        override fun bind(
            data: Test,
            listener: RecyclerAdapter.OnItemClickListener?,
            viewModel: BaseViewModel,
            position: Int
        ) {
            try {

                containerView?.setOnClickListener {
                    listener?.onItemClick(it, adapterPosition, data)

                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    class LocationHolder(parent: ViewGroup, val context: Context) :
        BaseViewHolder<Data>(
            parent.DataBindingInflate(
                R.layout.row_location
            )
        ) {

        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        override fun bind(
            data: Data,
            listener: RecyclerAdapter.OnItemClickListener?,
            viewModel: BaseViewModel,
            position: Int
        ) {
            try {

                itemView.imgRestautrant.setImage(data.image)
                itemView.txtOpen.text = context.getString(R.string.str_opens,data.open_hour.start_time)
                itemView.txtClose.text = context.getString(R.string.str_close,data.open_hour.end_time)
                itemView.txtAddress.text = data.address
                itemView.txtResturantName.text = data.name
                itemView.txtStatus.text = if(data.is_restaurant_open) context.getString(R.string.str_status_open) else context.getString(R.string.str_status_close)

                itemView.txtNavigate!!.setOnClickListener {
                    listener?.onItemClick(it, adapterPosition, data)

                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}



