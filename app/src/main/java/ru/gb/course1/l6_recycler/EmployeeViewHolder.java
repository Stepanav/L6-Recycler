package ru.gb.course1.l6_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Entity;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameTextView = itemView.findViewById(R.id.name_text_view);
    private final TextView surnameTextView = itemView.findViewById(R.id.surname_text_view);
    private final TextView positionTextView = itemView.findViewById(R.id.position_text_view);
    private final Button deleteButton = itemView.findViewById(R.id.delete_button);

    private OnEmployeeDeleteListener onEmployeeDeleteListener;

    public EmployeeViewHolder(
            @NonNull LayoutInflater inflater,
            @NonNull ViewGroup parent,
            OnEmployeeDeleteListener onEmployeeDeleteListener
    ) {
        super(inflater.inflate(R.layout.item_employee, parent, false));
        this.onEmployeeDeleteListener = onEmployeeDeleteListener;
    }

    public void bind(EmployeeEntity employee) {
        deleteButton.setOnClickListener(v -> onEmployeeDeleteListener.onDeleteEmployee(employee));

        nameTextView.setText(employee.getName());
        surnameTextView.setText(employee.getSurname());
        positionTextView.setText(employee.getPosition());
    }
}
