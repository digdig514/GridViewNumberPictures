package com.example.digdig.creategriedviewexemple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digdig.creategriedviewexemple.model.CustomNumberAdapter;
import com.example.digdig.creategriedviewexemple.model.FileNumberManagement;
import com.example.digdig.creategriedviewexemple.model.Numbers;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
GridView gridViewNumbers;
EditText  editTextNumbers;
ArrayList<Numbers> listOfNumbers;
            //ArrayAdapter<Numbers> adapterNumbers;
CustomNumberAdapter customAdapterNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        gridViewNumbers = (GridView) (findViewById(R.id.gridViewNumbers));
        editTextNumbers = (EditText) findViewById(R.id.editText);
        listOfNumbers = FileNumberManagement.readFile(this,"numbers.txt");
        //adapterNumbers = new ArrayAdapter<Numbers>(this,R.layout.one_element,listOfNumbers);
       // gridViewNumbers.setAdapter(adapterNumbers);
        customAdapterNumber = new CustomNumberAdapter(this,listOfNumbers);
        gridViewNumbers.setAdapter(customAdapterNumber);
        gridViewNumbers.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (!editTextNumbers.getText().toString().isEmpty()) {
            Numbers noObj = new Numbers(editTextNumbers.getText().toString());
            listOfNumbers.set(position, noObj);
            customAdapterNumber.notifyDataSetChanged();
        } else
        {
            Toast.makeText(this,"data are empty",Toast.LENGTH_LONG).show();
        }

    }
}
