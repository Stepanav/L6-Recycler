package ru.gb.course1.l6_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private LinearLayout listLinearLayout;

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
        View rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(rootView);

        employeeList.addAll(CreateDummyEmployeesData());

        listLinearLayout = findViewById(R.id.list_linear_layout);

        Button button = ListViewUtils.createButtonView(this, v -> {
            listLinearLayout.removeAllViews();

        });
        listLinearLayout.addView(button);

        for (EmployeeEntity employeeEntity : employeeList) {
            View employeeItemView = ListViewUtils.createItemView(this, getLayoutInflater(), listLinearLayout, employeeEntity);
            listLinearLayout.addView(employeeItemView);
        }
    }
}