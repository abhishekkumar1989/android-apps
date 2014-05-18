package com.abhishek_k.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.abhishek_k.todoapp.model.Todo;

import java.util.UUID;

public class TodoFragment extends Fragment {

    private Todo todo;
    public static final String EXTRA_CRIME_ID = "com.abhishek_k.todomanager.todo_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID todoId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        todo = TodoManager.get(getActivity()).get(todoId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_details, container, false);
        ((EditText) view.findViewById(R.id.todo_description)).setText(todo.getTask());
        ((Button) view.findViewById(R.id.todo_dueDate)).setText(todo.getDueOn().toString());
        ((CheckBox) view.findViewById(R.id.todo_completed)).setChecked(todo.isCompleted());
        return view;
    }

    public static TodoFragment newInstance(UUID id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_CRIME_ID, id);
        TodoFragment fragment = new TodoFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
