package ru.gb.course1.l6_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

    private final ArrayList<EmployeeEntity> employeeList = new ArrayList<>();

    private static ArrayList<EmployeeEntity> CreateDummyEmployeesData() {
        final ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities.add(new EmployeeEntity(
                "0",
                "Иван",
                "Иванов",
                "88005553535",
                500_000,
                "Android developer"
        ));

        employeeEntities.add(new EmployeeEntity(
                "1",
                "Пётр",
                "Петров",
                "88005553535",
                400_000,
                "iOS developer"
        ));

        employeeEntities.add(new EmployeeEntity(
                "2",
                "Сидр",
                "Сидоров",
                "88005553535",
                1_000_000,
                "Самый главный директор"
        ));
        employeeEntities.add(new EmployeeEntity(
                "3",
                "Мария",
                "Иванова",
                "88005553535",
                500_000,
                "PHP developer"
        ));
        employeeEntities.add(new EmployeeEntity(
                "4",
                "Юрий",
                "Юрьев",
                "88005553535",
                100_000,
                "Junior developer"
        ));

        employeeEntities.add(new EmployeeEntity(
                "5",
                "Игнат",
                "Игнатьев",
                "88005553535",
                300_000,
                "Designer"
        ));

        return employeeEntities;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeList.addAll(CreateDummyEmployeesData());

        initRecycler();

    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeAdapter();
        adapter.setData(employeeList);
        adapter.setOnDeleteClickListener(employeeEntity -> {
            deleteEmployee(employeeEntity);
        });

        recyclerView.setAdapter(adapter);
    }

    private void deleteEmployee(EmployeeEntity employeeEntity) {
        employeeList.remove(findPosition(employeeEntity));
        adapter.setData(employeeList);

        Toast.makeText(this, employeeEntity.getName() + "Fired", Toast.LENGTH_SHORT).show();
    }

    private int findPosition(EmployeeEntity employeeEntity) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeEntity.getId().equals(employeeList.get(i).getId())) {
                return i;
            }
        }
        throw new IllegalArgumentException("Нет такого элемента");
    }
}