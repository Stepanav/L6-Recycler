package ru.gb.course1.l6_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private ArrayList<EmployeeEntity> data = new ArrayList<>();


    public void setData(ArrayList<EmployeeEntity> employeeList) {
        data = employeeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemView = inflater.inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final EmployeeEntity employeeEntity = getItem(position);
        holder.nameTextView.setText(employeeEntity.getName());
        holder.surnameTextView.setText(employeeEntity.getSurname());
        holder.positionTextView.setText(employeeEntity.getPosition());
    }

    private EmployeeEntity getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView = itemView.findViewById(R.id.name_text_view);
        TextView surnameTextView = itemView.findViewById(R.id.surname_text_view);
        TextView positionTextView = itemView.findViewById(R.id.position_text_view);
        Button deleteButton = itemView.findViewById(R.id.delete_button);

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
