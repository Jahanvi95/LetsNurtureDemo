package com.example.demoapplication;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.demoapplication.databinding.ActivityMainBindingImpl;
import com.example.demoapplication.databinding.LayoutNoDataFoundBindingImpl;
import com.example.demoapplication.databinding.RowLocationBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_LAYOUTNODATAFOUND = 2;

  private static final int LAYOUT_ROWLOCATION = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.demoapplication.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.demoapplication.R.layout.layout_no_data_found, LAYOUT_LAYOUTNODATAFOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.demoapplication.R.layout.row_location, LAYOUT_ROWLOCATION);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNODATAFOUND: {
          if ("layout/layout_no_data_found_0".equals(tag)) {
            return new LayoutNoDataFoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_no_data_found is invalid. Received: " + tag);
        }
        case  LAYOUT_ROWLOCATION: {
          if ("layout/row_location_0".equals(tag)) {
            return new RowLocationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for row_location is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "isNoDataVisible");
      sKeys.put(2, "mainActivity");
      sKeys.put(3, "mainViewModel");
      sKeys.put(4, "noDataValue");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_main_0", com.example.demoapplication.R.layout.activity_main);
      sKeys.put("layout/layout_no_data_found_0", com.example.demoapplication.R.layout.layout_no_data_found);
      sKeys.put("layout/row_location_0", com.example.demoapplication.R.layout.row_location);
    }
  }
}
