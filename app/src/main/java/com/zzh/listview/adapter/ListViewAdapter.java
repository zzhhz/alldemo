package com.zzh.listview.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.zzh.listview.model.Person;

/**
 * Created by zzh on 2016/3/3.
 */
public class ListViewAdapter extends ArrayAdapter<Person>{
    public ListViewAdapter(Context context, int resource) {
        super(context, resource);
    }
}
