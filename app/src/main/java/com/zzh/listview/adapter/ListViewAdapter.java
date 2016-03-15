package com.zzh.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zzh.alldemo.R;
import com.zzh.listview.model.Person;

import java.util.List;

/**
 * Created by zzh on 2016/3/3.
 */
public class ListViewAdapter extends ArrayAdapter<Person>{
    private LayoutInflater mInflater;
    private int resId;
    private int textId;
    public ListViewAdapter(Context context, int resource, int textId, List<Person> objects) {
        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        resId = resource;
        this.textId = textId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(resId, null);
            holder.textView = (TextView) convertView.findViewById(textId);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Person person = getItem(position);
        holder.textView.setText(person.getUserName());
        return convertView;
    }

    private class ViewHolder{
        TextView textView;
    }
}
