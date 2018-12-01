package com.senga.john.sengajohnexam2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, exam1, exam2, ave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Practical Exam 2");

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
        String aveGrade = (examGrade1+examGrade2)/2+"";

        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "external.txt");

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            fos.write(firstName.getBytes());
            fos.write(lastName.getBytes());
            fos.write(aveGrade.getBytes());
            Toast.makeText(this, "Data saved in sd card", Toast.LENGTH_LONG).show();
            fos.close();

            showAve();
        }
        catch(Exception e){
            Toast.makeText(this, "Error writing on sd card", Toast.LENGTH_LONG).show();
        }
    }

    public void showAve(){
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "external.txt");
        FileInputStream fin = null;
        int c;
        StringBuffer buffer = new StringBuffer();
        try{
            fin = new FileInputStream(file);
            while((c=fin.read()) != -1){
                if(Character.isDigit((char)c))
                    buffer.append((char)c);
            }
            ave.setText(buffer.toString());
        }
        catch(Exception e){
            Toast.makeText(this, "Error reading", Toast.LENGTH_LONG).show();
        }
    }
}
