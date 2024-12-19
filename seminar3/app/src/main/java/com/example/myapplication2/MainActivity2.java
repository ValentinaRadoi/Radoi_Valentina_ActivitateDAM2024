package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import domain.DateConverter;
import domain.Student;
import domain.StudyType;

public class MainActivity2 extends AppCompatActivity {

    public static final String STUDENT_KEY = "student_key";

    private TextInputEditText tietName;
    private TextInputEditText tietEnr;
    private Spinner spnFac;
    private RadioGroup rdg;
    private Button btnSave;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        intent = getIntent();
    }

    private void initComponents() {
        tietName = findViewById(R.id.main2_tiet);
        tietEnr = findViewById(R.id.main2_tiet_enr);
        spnFac = findViewById(R.id.spinner);
        rdg = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.button3);
        btnSave.setOnClickListener(v -> {
            //ne aflam dupa apasarea butonului
            if(isValid()){
                Student student = buildStudentFromView();
                Log.i("MainActivity2", "Student =" +student.toString());

                intent.putExtra(STUDENT_KEY, student);
                setResult(RESULT_OK, intent);
                finish();
            }

        });

    }

    private Student buildStudentFromView() {
        String name = tietName.getText().toString();
        Date EnrollmentDate = DateConverter.toDate(tietEnr.getText().toString());
        String faculty = (String) spnFac.getSelectedItem();
        StudyType studyType = rdg.getCheckedRadioButtonId() == R.id.radioButton? StudyType.FULL_TIME : StudyType.DISTANCE;

        return new Student(name, EnrollmentDate, faculty, studyType);
    }

    private boolean isValid() {
        if (tietName.getText() == null || tietName.getText().toString().trim().length() < 3) {
            Toast.makeText(getApplicationContext(), R.string.main2_invalid_name_minim_3_caractere, Toast.LENGTH_SHORT).show();
            return false;


        }
        if (tietEnr.getText() == null || DateConverter.toDate
                (tietEnr.getText().toString()) == null) {
            Toast.makeText(getApplicationContext(), R.string.main2_invalid_date_format, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}