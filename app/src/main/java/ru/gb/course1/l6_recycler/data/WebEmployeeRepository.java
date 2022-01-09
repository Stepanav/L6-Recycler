package ru.gb.course1.l6_recycler.data;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

class WebEmployeeRepositoryImpl implements EmployeeRepository {

    //здесь получаем данные из интернета

    @Override
    public List<EmployeeEntity> getEmployees() {
        return new ArrayList<>();
    }

    @Override
    public void deleteEmployee(EmployeeEntity employeeEntity) {

    }
}