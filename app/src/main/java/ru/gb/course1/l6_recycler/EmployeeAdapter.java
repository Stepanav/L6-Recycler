package ru.gb.course1.l6_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private ArrayList<EmployeeEntity> data = new ArrayList<>();
    private OnEmployeeDeleteListener onDeleteClickListener;


    public void setOnDeleteClickListener(OnEmployeeDeleteListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public void setData(ArrayList<EmployeeEntity> employeeList) {
        data = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new EmployeeViewHolder(inflater, parent, onDeleteClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final EmployeeEntity employeeEntity = getItem(position);
        holder.bind(getItem(position));
    }

    private EmployeeEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }


}
