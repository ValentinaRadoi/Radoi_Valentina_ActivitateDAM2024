package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import domain.Student;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private ListView lvStudents;
    private List<Student> students = new ArrayList<>();
    private ActivityResultLauncher<Intent>launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fabAdd = findViewById(R.id.main_fab1);
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class); //intent face transferul de date de la o activitate la alta
            //startActivity(intent);
            launcher.launch(intent);
        });

        lvStudents = findViewById(R.id.main_lv);
        ArrayAdapter <Student>adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, students);
        lvStudents.setAdapter(adapter);

        launcher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), getAddStudentCallback());
    }

    private ActivityResultCallback<ActivityResult> getAddStudentCallback() {
        return result -> {
            if(result.getResultCode() == RESULT_OK && result.getData() != null);
            Student student = (Student) result.getData().getSerializableExtra(MainActivity2.STUDENT_KEY);

            students.add(student);

            ArrayAdapter <Student> adapter = (ArrayAdapter<Student>) lvStudents.getAdapter();
            adapter.notifyDataSetChanged();
        };
    }
}