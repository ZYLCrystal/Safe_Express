package com.example.crystal.contact.activity;

/**
 * Created by crystal on 2018/2/5.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.graphics.drawable.Drawable;


import com.example.crystal.contact.Contacts;
import com.example.crystal.contact.R;
import com.example.crystal.contact.adapter.FragmentAdapter;
import com.example.crystal.contact.Fragment.Homepage;
import com.example.crystal.contact.Fragment.ContactsFragment;
import com.example.crystal.contact.Fragment.Me;
import com.example.crystal.contact.Fragment.Message;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rbChat, rbContacts, rbDiscovery, rbMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        /**
         * RadioGroup部分
         */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbChat = (RadioButton) findViewById(R.id.rb_chat);
        rbContacts = (RadioButton) findViewById(R.id.rb_contacts);
        rbDiscovery = (RadioButton) findViewById(R.id.rb_discovery);
        rbMe = (RadioButton) findViewById(R.id.rb_me);
        //RadioGroup选中状态改变监听

       /* Drawable drawable1 = getResources().getDrawable(R.drawable.rb_chat_selector);
        drawable1.setBounds(0, 0, 20, 20);
        Drawable drawable2 = getResources().getDrawable(R.drawable.rb_contacts_selector);
        drawable2.setBounds(0, 0, 20, 20);
        Drawable drawable3 = getResources().getDrawable(R.drawable.rb_me_selector);
        drawable3.setBounds(0, 0, 20, 20);
        Drawable drawable4 = getResources().getDrawable(R.drawable.rb_message_selector);
        drawable4.setBounds(0, 0, 20, 20);*/

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_chat:
                        /**
                         * setCurrentItem第二个参数控制页面切换动画
                         * true:打开/false:关闭
                         */
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_contacts:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_discovery:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });

        /**
         * ViewPager部分
         */
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Homepage homepage = new Homepage();
        Contacts contactsFragment = new Contacts();
        Message message = new Message();
        Me meFragment = new Me();
        List<Fragment> alFragment = new ArrayList<Fragment>();
        alFragment.add(homepage);
        alFragment.add(contactsFragment);
        alFragment.add(message);
        alFragment.add(meFragment);
        //ViewPager设置适配器
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), alFragment));
        //ViewPager显示第一个Fragment
        viewPager.setCurrentItem(0);
        //ViewPager页面切换监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_chat);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_contacts);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_discovery);
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

