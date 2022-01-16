package ru.gb.course1.l6_recycler.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.gb.course1.l6_recycler.R;
import ru.gb.course1.l6_recycler.domain.User;

public class NoteRepoImpl extends AppCompatActivity {

    User user = new User("undefined", 0);
    final static String userVariableKey = "USER_VARIABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable(userVariableKey, user);
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // получаем объект User в переменную
        user = (User) savedInstanceState.getSerializable(userVariableKey);
        TextView data_view_out = findViewById(R.id.data_view_out);
        data_view_out.setText(user.getUser_data());
    }

    public void saveData(View view) {

        // получаем введенные данные
        EditText data_View = findViewById(R.id.data_View);
        String user_data = data_View.getText().toString();

    }

    public void getData(View view) {

        // получаем сохраненные данные
        TextView dataView = findViewById(R.id.data_view_out);
        dataView.setText(user.getUser_data());
    }
}
