package com.abhishek_k.todoapp;

import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.abhishek_k.todoapp.model.Todo;

import java.util.List;

public class TodoListFragment extends ListFragment {

    private static final String LOG_TAG = TodoListFragment.class.getName();
    private static final int REQUEST_CODE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.todo_list_title);
        TodoAdapter adapter = new TodoAdapter(TodoManager.get(getActivity()).getTodos());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(LOG_TAG, "onListItemClick() List item got selected: " + position);
        Intent intent = new Intent(getActivity(), TodoPagerActivity.class);
        intent.putExtra(TodoFragment.EXTRA_CRIME_ID, ((TodoAdapter) getListAdapter()).getItem(position).getId());
        startActivityForResult(intent, REQUEST_CODE);
    }

    private class TodoAdapter extends ArrayAdapter<Todo> {

        public TodoAdapter(List<Todo> todos) {
            super(getActivity(), 0, todos);
        }

        /**
         * @param position:    position for which the view needs to be obtained
         * @param convertView: existing list item, that the "adapter can reconfigure" and return instead of creating brand new
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                Log.d(LOG_TAG, "getView(), new view is getting inflated");
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_todoitem_view, null);
            }
            Todo todo = getItem(position);
            CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.todo_completed_checkBox);
            TextView taskDetailsView = (TextView) convertView.findViewById(R.id.todo_taskDetails);
            TextView dueDateView = (TextView) convertView.findViewById(R.id.todo_dueDate);
            checkBox.setChecked(todo.isCompleted());
            taskDetailsView.setText(todo.getTask());
            dueDateView.setText(todo.getDueOn().toString());
            if (position % 2 == 0)
                convertView.setBackgroundColor(Color.rgb(236, 236, 234));
            else {
                convertView.setBackgroundColor(Color.WHITE);
            }
            return convertView;
        }
    }

}
