package com.example.crystal.contact.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crystal.contact.R;
import com.example.crystal.contact.adapter.MessageAdapter;
import com.example.crystal.contact.model.MessageL;

import java.util.concurrent.atomic.AtomicReference;

import android.content.Context;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.crystal.contact.R;

/**
 * A simple {@link Fragment} subclass.
 */




public class Message extends Fragment {

    private List<MessageL> mData = null;
    private Context mContext;
    private MessageAdapter mAdapter = null;
    private ListView list_message;

    private static final String TAG = "message";



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView() " + savedInstanceState);
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.messagelist, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(): " + savedInstanceState);

        super.onViewCreated(view, savedInstanceState);

        mContext = this.getActivity();
        list_message = (ListView) view.findViewById(R.id.messagelist);
        mData = new LinkedList<MessageL>();
        mData.add(new MessageL("Krystal Jung", "好哒", R.mipmap.head_icon1));
        mData.add(new MessageL("戴老师", "OK" , R.mipmap.head_icon2));
        mData.add(new MessageL("财务主管", "包裹已收到", R.mipmap.head_icon3));
        mData.add(new MessageL("Candy", "谢谢了", R.mipmap.head_icon4));
        mData.add(new MessageL("Bobby", "好", R.mipmap.people));
        mAdapter = new MessageAdapter((LinkedList<MessageL>) mData, mContext);
        list_message.setAdapter(mAdapter);
    }

}
/*public class MessageList extends AppCompatActivity {

    private String[] names = new String[]{"AA", "BB", "CC","DD"};
    private String[] says = new String[]{"好哒", "谢谢了", "包裹已收到","OK"};
    private int[] imgIds = new int[]{R.mipmap.head_icon1, R.mipmap.head_icon2, R.mipmap.head_icon3,R.mipmap.head_icon4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messagelist);

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("says", says[i]);
            listitem.add(showitem);
        }

        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem, R.layout.item, new String[]{"touxiang", "name", "says"}, new int[]{R.id.imgtou, R.id.name, R.id.says});
        ListView listView = (ListView) findViewById(R.id.messagelist);
        listView.setAdapter(myAdapter);
    }
}*/
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MessageList extends Activity implements OnItemClickListener,OnScrollListener{

    private ListView listView;
    private ArrayAdapter<String>arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>>dataList;//SimpleAdapter的data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messagelist);

        listView=(ListView) findViewById(R.id.messagelist);
        //1.新建一个数据适配器
        //ArrayAdapter（上下文，当前listView加载的每一个列表项所对应的布局文件，数据源）
        //2.适配器加载数据源
        String[]arr_data={"苹果","香蕉","橙子","猕猴桃"};
        arr_adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        */
/*SimpleAdapter——
         * 1.context：上下文
         * 5.data：数据源List<? extends Map<String,?>> data 一个Map所组成的List集合，
         * 每一个Map都会去对应ListView列表中的一行，
         * 每一个Map（键-值对）中的键必须包含所在from中所指定的键
         * 2.resource：列表项的布局文件ID
         * 4.from：Map中的键名
         * 3.to：绑定数据视图中的ID，与from对应关系
         * *//*

        dataList=new ArrayList<Map<String,Object>>();
        simp_adapter=new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","text"}, new int[]{R.id.pic,R.id.text});
        //3.视图加载适配器
        //listView.setAdapter(arr_adapter);
        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }
    private List<Map<String, Object>> getData() {
        for(int i=0;i<20;i++){
            Map<String, Object>map=new HashMap<String, Object>();
            map.put("pic", R.mipmap.ic_launcher);
            map.put("text", "苹果"+i);
            dataList.add(map);
        }
        return dataList;
    }
    @Override
    public void onScroll(AbsListView view, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub
        switch (scrollState) {
            case SCROLL_STATE_FLING:
                Log.i("Main","用户在手指离开屏幕之前，由于用力划了一下，试图仍依靠惯性继续滑动");
                Map<String, Object>map=new HashMap<String, Object>();//下拉刷新
                map.put("pic", R.mipmap.ic_launcher);//下拉刷新
                map.put("text", "增加项");//下拉刷新
                dataList.add(map);//下拉刷新
                simp_adapter.notifyDataSetChanged();//下拉刷新，动态更新视图中所包含的数据
                break;
            case SCROLL_STATE_IDLE:
                Log.i("Main","视图已经停止滑动");
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("Main","手指没有离开屏幕，视图正在滑动");
                break;
            default:
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        String text=listView.getItemAtPosition(position)+"";
        Toast.makeText(this, "position="+position+" text="+text, Toast.LENGTH_SHORT).show();
    }
}
*/
