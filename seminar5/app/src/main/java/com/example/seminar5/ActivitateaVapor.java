package com.example.seminar5;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateaVapor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitatea_vapor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        Button btnVapor = findViewById(R.id.btn_const_vapor);
        btnVapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText denumire = findViewById(R.id.editTextText2);
                Spinner spin=findViewById(R.id.spinner2);
                EditText detalii = findViewById(R.id.editTextText3);
                RadioGroup rdg=findViewById(R.id.rGROUP);
                RatingBar rtg=findViewById(R.id.ratingBar);
                int selectedID=rdg.getCheckedRadioButtonId();

                int alesSpin= Integer.parseInt(spin.getSelectedItem().toString());
                String denumireString=denumire.getText().toString();
                String detaliiString=detalii.getText().toString();
                boolean curat=false;
                if(selectedID==R.id.radio_de_persoane)
                {
                    curat=true;
                }
                float grade=rtg.getRating()+30;

                Vapor v1 = new Vapor(denumireString,alesSpin,detaliiString,curat,grade);

                Log.d("#obiect",v1.toString());

                Intent intent = new Intent();
                intent.putExtra("vapor",v1);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }


}