package com.example.groupprojectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditFoodItemActivity extends AppCompatActivity {
    public static final String ID = "id";
    public static final String NAME = "name";

    DatabaseHelper mDatabaseHelper;
    private Button btnDelete, btnReturn;
    private EditText editName;
    private String name;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_item);

        mDatabaseHelper = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.itemName);
        btnDelete = (Button) findViewById(R.id.buttonDelete);
        btnReturn = (Button) findViewById(R.id.buttonReturn);

        Intent intent = getIntent();
        id = intent.getIntExtra(ID, -1);
        name = intent.getStringExtra(NAME);
        editName.setText(name);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(Integer.toString(id));
                editName.setText("");
                Toast.makeText(EditFoodItemActivity.this, "Removed from database", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditFoodItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditFoodItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
