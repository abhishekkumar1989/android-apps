package com.abhishek_k.todoapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public abstract class FragmentParentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, createFragment()).commit();
        }
    }

    public abstract Fragment createFragment();

}
