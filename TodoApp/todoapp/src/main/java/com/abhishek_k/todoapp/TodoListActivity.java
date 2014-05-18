package com.abhishek_k.todoapp;

import android.app.Fragment;

public class TodoListActivity extends FragmentParentActivity {

    @Override
    public Fragment createFragment() {
        return new TodoListFragment();
    }

}
