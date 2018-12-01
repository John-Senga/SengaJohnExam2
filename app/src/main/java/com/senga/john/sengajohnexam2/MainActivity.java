package com.senga.john.sengajohnexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, exam1, exam2, ave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        exam1 = findViewById(R.id.exam1);
        exam2 = findViewById(R.id.exam2);
        ave = findViewById(R.id.ave);
    }
}
