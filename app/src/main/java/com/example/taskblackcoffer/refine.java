package com.example.taskblackcoffer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class refine extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner queSet;
    TextView selectedOption, textcount;
    ImageView goback;
    EditText status;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        goback = findViewById(R.id.goback);
        queSet = findViewById(R.id.questions_set1);
        selectedOption = findViewById(R.id.avail_text);
        status = findViewById(R.id.status);
        textcount = findViewById(R.id.textcount);

        queSet = findViewById(R.id.questions_set1);
        ArrayAdapter<CharSequence> setOneAdapter = ArrayAdapter.createFromResource(this, R.array.AllQue, android.R.layout.simple_spinner_item);
        setOneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        queSet.setAdapter(setOneAdapter);
        queSet.setOnItemSelectedListener(this);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refine.super.onBackPressed();
            }
        });

        textcount.setText(String.valueOf(status.getText().toString().length()));

        status.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textcount.setText(String.valueOf(s.length()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (queSet.getSelectedItem().toString().length() > 40)
        {
           // Toast.makeText(this, "oh no!", Toast.LENGTH_SHORT).show();
            String selectedString = queSet.getSelectedItem().toString();
            String substring = selectedString.substring(0, 40) + "...";
            selectedOption.setText(substring);
            //Toast.makeText(this, substring, Toast.LENGTH_SHORT).show();
        }else {
            selectedOption.setText(queSet.getSelectedItem().toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}