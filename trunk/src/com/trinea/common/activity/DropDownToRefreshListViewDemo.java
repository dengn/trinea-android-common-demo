package com.trinea.common.activity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.trinea.common.R;
import com.trinea.common.view.DropDownToRefreshListView;
import com.trinea.common.view.DropDownToRefreshListView.OnRefreshListener;

/**
 * 下拉刷新ListView的Demo
 * 
 * @author Trinea 2012-6-15 上午10:34:34
 */
public class DropDownToRefreshListViewDemo extends Activity {

    private LinkedList<String>        listItems = null;
    private DropDownToRefreshListView listView  = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_down_to_refresh_listview_demo);

        listView = (DropDownToRefreshListView)findViewById(R.id.statusListView);
        // 设置listView的refresh listener
        listView.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh() {
                new GetDataTask().execute();
            }
        });

        listItems = new LinkedList<String>();
        listItems.addAll(Arrays.asList(mStrings));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                ;
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {

            listItems.addFirst("Added after refresh...");

            // 刷新结束时需手动调用listView的onRefreshComplete函数
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
            listView.onRefreshComplete("updated at: " + dateFormat.format(new Date()));

            super.onPostExecute(result);
        }
    }

    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};
}
