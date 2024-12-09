package com.example.spinn_adap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner foodSpinner;
    private TextView selectedFoodTextView;
    private String[] foodItems = {"Pizza", "Burger", "Pasta", "Sandwich", "Noodles"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodSpinner = findViewById(R.id.food_spinner);
        selectedFoodTextView = findViewById(R.id.selected_food_text_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, foodItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(adapter);
        foodSpinner.setOnItemSelectedListener(this);}
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedFood = foodItems[position];
        selectedFoodTextView.setText("Selected Food: " + selectedFood);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle the case when nothing is selected
        selectedFoodTextView.setText("No food selected");
    }
}