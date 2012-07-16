package com.trinea.android.common.activity;

import java.util.Arrays;
import java.util.LinkedList;

import com.trinea.android.common.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * demo list 列表
 * 
 * @author Trinea 2012-6-17 下午06:14:57
 */
public class DemoListDemo extends Activity {

    private String[] mStrings = {"Go To DropDownToRefreshListView Demo", "Go To CompoundDrawablesTextView Demo"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_list);

        LinkedList<String> mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListItems);

        ListView demoListView = (ListView)findViewById(R.id.demoListView);
        demoListView.setAdapter(adapter);
        demoListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(DemoListDemo.this, DropDownToRefreshListViewDemo.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(DemoListDemo.this, CompoundDrawablesTextViewDemo.class);
                    startActivity(intent);
                }
            }
        });
    }
}
