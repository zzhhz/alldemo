package com.zzh.listview;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;
import com.zzh.listview.adapter.ListViewAdapter;
import com.zzh.listview.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListViewActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private List<Person> dataList;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
    }

    @Override
    protected void initView() {
        listView = (ListView)findViewById(R.id.listView);
    }

    @Override
    protected void initData() {
        dataList = new ArrayList<>();
        for (int i=0; i< 30; i++) {
            Person person = new Person(UUID.randomUUID().toString(), "NAME + "+ i, "");
            dataList.add(person);
        }

        mAdapter = new ListViewAdapter(mContext, R.layout.item_list_view, R.id.text_data, dataList);

        listView.setAdapter(mAdapter);

    }

    @Override
    protected void setViewListener() {
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * listview的点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showMessage(dataList.get(position).getUserName());
    }
}
