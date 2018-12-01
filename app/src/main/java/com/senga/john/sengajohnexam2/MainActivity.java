package com.senga.john.sengajohnexam2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

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

    public void getAve(View v){
        String firstName = fname.getText().toString();
        String lastName = lname.getText().toString();
        int examGrade1 = Integer.parseInt(exam1.getText().toString());
        int examGrade2 = Integer.parseInt(exam2.getText().toString());
        int aveGrade = (examGrade1+examGrade2)/2;

        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "external.txt");

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(firstName.getBytes());
            Toast.makeText(this, "Data saved in sd card", Toast.LENGTH_LONG).show();
            fos.close();
        }
        catch(Exception e){
            Toast.makeText(this, "Error writing on sd card", Toast.LENGTH_LONG).show();
        }
    }
}
