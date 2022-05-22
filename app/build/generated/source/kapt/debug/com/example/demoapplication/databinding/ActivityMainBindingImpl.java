package com.example.demoapplication.databinding;
import com.example.demoapplication.R;
import com.example.demoapplication.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(15);
        sIncludes.setIncludes(1, 
            new String[] {"layout_no_data_found"},
            new int[] {5},
            new int[] {com.example.demoapplication.R.layout.layout_no_data_found});
        sIncludes.setIncludes(2, 
            new String[] {"row_location"},
            new int[] {4},
            new int[] {com.example.demoapplication.R.layout.row_location});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline_start, 6);
        sViewsWithIds.put(R.id.guideline_end, 7);
        sViewsWithIds.put(R.id.shimmerLayout, 8);
        sViewsWithIds.put(R.id.scalingLayout, 9);
        sViewsWithIds.put(R.id.searchLayout, 10);
        sViewsWithIds.put(R.id.ivBack, 11);
        sViewsWithIds.put(R.id.edtSearch, 12);
        sViewsWithIds.put(R.id.ivSearch, 13);
        sViewsWithIds.put(R.id.textViewSearch, 14);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @Nullable
    private final com.example.demoapplication.databinding.RowLocationBinding mboundView21;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (androidx.appcompat.widget.AppCompatEditText) bindings[12]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[11]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[13]
            , (com.example.demoapplication.databinding.LayoutNoDataFoundBinding) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (iammert.com.view.scalinglib.ScalingLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[10]
            , (com.facebook.shimmer.ShimmerFrameLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[14]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView21 = (com.example.demoapplication.databinding.RowLocationBinding) bindings[4];
        setContainedBinding(this.mboundView21);
        setContainedBinding(this.noAppoiment);
        this.rvLocation.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        mboundView21.invalidateAll();
        noAppoiment.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView21.hasPendingBindings()) {
            return true;
        }
        if (noAppoiment.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mainViewModel == variableId) {
            setMainViewModel((com.example.demoapplication.ui.main.viewmodel.MainViewModel) variable);
        }
        else if (BR.mainActivity == variableId) {
            setMainActivity((com.example.demoapplication.ui.main.activity.MainActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainViewModel(@Nullable com.example.demoapplication.ui.main.viewmodel.MainViewModel MainViewModel) {
        this.mMainViewModel = MainViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.mainViewModel);
        super.requestRebind();
    }
    public void setMainActivity(@Nullable com.example.demoapplication.ui.main.activity.MainActivity MainActivity) {
        this.mMainActivity = MainActivity;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.mainActivity);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView21.setLifecycleOwner(lifecycleOwner);
        noAppoiment.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeNoAppoiment((com.example.demoapplication.databinding.LayoutNoDataFoundBinding) object, fieldId);
            case 1 :
                return onChangeMainViewModelIsNoDataVisible((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeMainViewModelIsRecyclerViewVisible((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNoAppoiment(com.example.demoapplication.databinding.LayoutNoDataFoundBinding NoAppoiment, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMainViewModelIsNoDataVisible(androidx.lifecycle.MutableLiveData<java.lang.Boolean> MainViewModelIsNoDataVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMainViewModelIsRecyclerViewVisible(androidx.lifecycle.MutableLiveData<java.lang.Boolean> MainViewModelIsRecyclerViewVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.demoapplication.ui.main.viewmodel.MainViewModel mainViewModel = mMainViewModel;
        boolean androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsNoDataVisibleGetValue = false;
        java.lang.Boolean mainViewModelIsRecyclerViewVisibleGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> mainViewModelIsNoDataVisible = null;
        java.lang.Boolean mainViewModelIsNoDataVisibleGetValue = null;
        com.example.demoapplication.ui.main.activity.MainActivity mainActivity = mMainActivity;
        com.example.demoapplication.base.RecyclerAdapter<com.example.demoapplication.model.locationResponse.response.Data> mainActivitySetLocationAdapter = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> mainViewModelIsRecyclerViewVisible = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsRecyclerViewVisibleGetValue = false;

        if ((dirtyFlags & 0x2eL) != 0) {


            if ((dirtyFlags & 0x2aL) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.isNoDataVisible()
                        mainViewModelIsNoDataVisible = mainViewModel.isNoDataVisible();
                    }
                    updateLiveDataRegistration(1, mainViewModelIsNoDataVisible);


                    if (mainViewModelIsNoDataVisible != null) {
                        // read mainViewModel.isNoDataVisible().getValue()
                        mainViewModelIsNoDataVisibleGetValue = mainViewModelIsNoDataVisible.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(mainViewModel.isNoDataVisible().getValue())
                    androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsNoDataVisibleGetValue = androidx.databinding.ViewDataBinding.safeUnbox(mainViewModelIsNoDataVisibleGetValue);
            }
            if ((dirtyFlags & 0x2cL) != 0) {

                    if (mainViewModel != null) {
                        // read mainViewModel.isRecyclerViewVisible()
                        mainViewModelIsRecyclerViewVisible = mainViewModel.isRecyclerViewVisible();
                    }
                    updateLiveDataRegistration(2, mainViewModelIsRecyclerViewVisible);


                    if (mainViewModelIsRecyclerViewVisible != null) {
                        // read mainViewModel.isRecyclerViewVisible().getValue()
                        mainViewModelIsRecyclerViewVisibleGetValue = mainViewModelIsRecyclerViewVisible.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(mainViewModel.isRecyclerViewVisible().getValue())
                    androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsRecyclerViewVisibleGetValue = androidx.databinding.ViewDataBinding.safeUnbox(mainViewModelIsRecyclerViewVisibleGetValue);
            }
        }
        if ((dirtyFlags & 0x30L) != 0) {



                if (mainActivity != null) {
                    // read mainActivity.setLocationAdapter()
                    mainActivitySetLocationAdapter = mainActivity.setLocationAdapter();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2aL) != 0) {
            // api target 1

            this.noAppoiment.setIsNoDataVisible(androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsNoDataVisibleGetValue);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.noAppoiment.setNoDataValue(getRoot().getResources().getString(R.string.str_no_data));
        }
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            com.example.demoapplication.utills.CommonBindingAdapter.bindRecyclerViewAdapter(this.rvLocation, mainActivitySetLocationAdapter);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            com.example.demoapplication.utills.CommonBindingAdapter.showHideMainView(this.rvLocation, androidxDatabindingViewDataBindingSafeUnboxMainViewModelIsRecyclerViewVisibleGetValue);
        }
        executeBindingsOn(mboundView21);
        executeBindingsOn(noAppoiment);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): noAppoiment
        flag 1 (0x2L): mainViewModel.isNoDataVisible()
        flag 2 (0x3L): mainViewModel.isRecyclerViewVisible()
        flag 3 (0x4L): mainViewModel
        flag 4 (0x5L): mainActivity
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}