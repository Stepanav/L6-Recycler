package ru.gb.course1.l6_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private LinearLayout listLinearLayout;

    private final ArrayList<EmployeeEntity> employeeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeList.addAll(CreateDummyEmployeesData());

        listLinearLayout = findViewById(R.id.list_linear_layout);

        Button button = new Button(this);
        button.setText("Привет");
        listLinearLayout.addView(button);


        for (EmployeeEntity employeeEntity : employeeList) {
            View employeeItemView = getLayoutInflater().inflate(R.layout.item_employee, listLinearLayout, false);
            ((TextView) employeeItemView.findViewById(R.id.name_text_view)).setText(employeeEntity.getName());
            ((TextView) employeeItemView.findViewById(R.id.surname_text_view)).setText(employeeEntity.getSurname());
            ((TextView) employeeItemView.findViewById(R.id.position_text_view)).setText(employeeEntity.getPosition());
            listLinearLayout.addView(employeeItemView);
        }

    }

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
}