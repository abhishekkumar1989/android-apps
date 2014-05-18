package com.abhishek_k.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.abhishek_k.todoapp.model.Todo;

import java.util.List;
import java.util.UUID;

public class TodoPagerActivity extends FragmentActivity {

    private ViewPager viewPager;
    private List<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        todos = TodoManager.get(this).getTodos();
        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        setContentView(viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return TodoFragment.newInstance(todos.get(position).getId());
            }

            @Override
            public int getCount() {
                return todos.size();
            }
        });
        UUID crimeId = (UUID) getIntent().getSerializableExtra(TodoFragment.EXTRA_CRIME_ID);
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(crimeId)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
