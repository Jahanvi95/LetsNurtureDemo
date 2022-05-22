package com.example.demoapplication.utills

import android.widget.AbsListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demoapplication.utills.scroll.RecyclerViewUtil
import com.glowdubai_staff.utils.scroll.LayoutManagerType


class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener {
    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private var visibleThreshold = 5
    // The current offset index of data you have loaded
    private var currentPage = 1
    // The total number of items in the dataset after the last load
    private var previousTotalItemCount = 0
    // True if we are still waiting for the last set of data to load.
    private var loading = true
    // Sets the starting page index
    private val startingPageIndex = 0

    private var userScrolled: Boolean = false
    internal var mLayoutManager: RecyclerView.LayoutManager
    private var scrolledDistance = 0
    private var controlsVisible = true

    constructor(layoutManager: RecyclerView.LayoutManager) {
        this.mLayoutManager = layoutManager
    }

    constructor(layoutManager: GridLayoutManager) {
        this.mLayoutManager = layoutManager
        visibleThreshold *= layoutManager.spanCount
    }

    constructor(layoutManager: StaggeredGridLayoutManager) {
        this.mLayoutManager = layoutManager
        visibleThreshold *= layoutManager.spanCount
    }

    fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPositions.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i]
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i]
            }
        }
        return maxSize
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
            userScrolled = true

        }
//        if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//            //                menuRegister.showMenuButton(true);
//        }
    }

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount
        //            if (dy > 0 || dy < 0 && menuRegister.isShown()) {
        ////                menuRegister.hideMenuButton(true);
        //            }


        when (mLayoutManager) {
            is StaggeredGridLayoutManager -> {
                val lastVisibleItemPositions =
                    (mLayoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(null)
                // get maximum element within the list
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
            }
            is GridLayoutManager -> lastVisibleItemPosition =
                (mLayoutManager as GridLayoutManager).findLastVisibleItemPosition()
            is LinearLayoutManager -> lastVisibleItemPosition =
                (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        }

        // If the total item count is zero and the previous isn't, assume the
        // list is invalidated and should be reset back to initial state

        // If it’s still loading, we check to see if the dataset count has
        // changed, if so we conclude it has finished loading and update the current page
        // number and total item count.

        // If it isn’t currently loading, we check to see if we have breached
        // the visibleThreshold and need to reload more data.
        // If we do need to reload some more data, we execute onLoadMore to fetch the data.
        // threshold should reflect how many total columns there are too

        // If the total item count is zero and the previous isn't, assume the
        // list is invalidated and should be reset back to initial state
        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex
            this.previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }

        // If it’s still loading, we check to see if the dataset count has
        // changed, if so we conclude it has finished loading and update the current page
        // number and total item count.
        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        // If it isn’t currently loading, we check to see if we have breached
        // the visibleThreshold and need to reload more data.
        // If we do need to reload some more data, we execute onLoadMore to fetch the data.
        // threshold should reflect how many total columns there are too
        if (userScrolled && !loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
            currentPage += 1
            userScrolled = false
            onScrolledListener.onLoadMore(currentPage, totalItemCount, view)
            loading = true
        }

        if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
            controlsVisible = false
            scrolledDistance = 0
        } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
            controlsVisible = true
            scrolledDistance = 0
        }

        if (controlsVisible && dy > 0 || !controlsVisible && dy < 0) {
            scrolledDistance += dy
        }

    }

    // Call this method whenever performing new searches
    fun resetState() {
        this.currentPage = this.startingPageIndex
        this.previousTotalItemCount = 0
        this.loading = true
    }

     // Defines the process for actually loading more data based on page

     interface OnScrolledListener {
          fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)
     }

     class Builder(internal val layoutManager: RecyclerView.LayoutManager) {
         internal var visibleThreshold = 7
         internal var layoutManagerType = LayoutManagerType.LINEAR
         internal lateinit var onScrolledListener: OnScrolledListener
         internal var resetLoadingState: Boolean = false

         fun visibleThreshold(value: Int): Builder {
             visibleThreshold = value
             return this
         }

         fun onScrolledListener(value: OnScrolledListener): Builder {
             onScrolledListener = value
             return this
         }


         fun build(): EndlessRecyclerViewScrollListener {
             layoutManagerType = RecyclerViewUtil.computeLayoutManagerType(layoutManager)
             visibleThreshold = RecyclerViewUtil.computeVisibleThreshold(
                 layoutManager, layoutManagerType, visibleThreshold
             )
             return EndlessRecyclerViewScrollListener(this)
         }
     }

    lateinit var layoutManagerType: LayoutManagerType
    lateinit var onScrolledListener: OnScrolledListener

    constructor(builder: Builder) : this(builder.layoutManager) {
        this.layoutManagerType = builder.layoutManagerType
        this.onScrolledListener = builder.onScrolledListener
        if (builder.resetLoadingState) {
            resetState()
        }
    }



     companion object {

        private const val HIDE_THRESHOLD = 20
    }

}