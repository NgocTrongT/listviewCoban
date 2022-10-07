package com.example.listview_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lvAnimal;
Button btn_add;
Button btn_edit;
Button btn_delete;
EditText edt_animal;

int adress = 1;

ArrayList<String> arrayCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAnimal = (ListView) findViewById(R.id.listviewAnimal);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        edt_animal = (EditText) findViewById(R.id.edt_animal);

        arrayCourse = new ArrayList<>();

        arrayCourse.add("Tiger");
        arrayCourse.add("Panda");
        arrayCourse.add("Dog");
        arrayCourse.add("Cat");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayCourse);
        lvAnimal.setAdapter(adapter);
        lvAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayCourse.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        lvAnimal.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "long click: " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String animal = edt_animal.getText().toString();
                arrayCourse.add(animal);
                adapter.notifyDataSetChanged();
            }
        });

        lvAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_animal.setText(arrayCourse.get(i));
                adress = i;
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(adress,edt_animal.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        lvAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_animal.setText(arrayCourse.get(i));
                adress = i;
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(adress);
                adapter.notifyDataSetChanged();
            }
        });
    }
}