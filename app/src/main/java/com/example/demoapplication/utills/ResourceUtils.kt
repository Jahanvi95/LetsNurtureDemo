package com.example.demoapplication.utills

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.demoapplication.service.MyApplication


object ResourceUtils {

    fun getString(@StringRes stringId: Int): String {
        return MyApplication.instance.getString(stringId)
    }

    fun getString(@StringRes stringId: Int,vararg data :String): String {
        return MyApplication.instance.getString(stringId,*data)
    }

    fun emptyString(): String {
        return ""
    }
    fun getDrawable(@DrawableRes drawableId: Int): Drawable? {
        return ContextCompat.getDrawable(MyApplication.context, drawableId)
    }

    fun getColor(@ColorRes colorId: Int): Int {
        return ContextCompat.getColor(MyApplication.context, colorId)
    }

    fun getDimen(@DimenRes dimenId: Int): Float {
        return MyApplication.instance.resources.getDimension(dimenId)
    }


    fun changeResourceColor(color: Int, iconResId: Int): Drawable {
        val icon = getDrawable(iconResId)
        icon!!.setColorFilter(getColor(color), PorterDuff.Mode.SRC_ATOP)
        return icon
    }

    /**
     *
     */
    fun changeResourceColor(color: Int, iconResId: Drawable): Drawable {
//        final Drawable icon = getDrawable(context, iconResId);
        iconResId.setColorFilter(getColor(color), PorterDuff.Mode.SRC_ATOP)
        return iconResId
    }
}