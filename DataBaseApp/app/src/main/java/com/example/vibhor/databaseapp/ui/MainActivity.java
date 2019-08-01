package com.example.vibhor.databaseapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vibhor.databaseapp.R;
import com.example.vibhor.databaseapp.db.DatabaseSource;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG =MainActivity.class.getSimpleName();
    protected DatabaseSource mDatabaseSource;
    private Button button1,button2,button3;
    private EditText name1,name2,number1,number2;


    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        mDatabaseSource.openData();
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mDatabaseSource.closeData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseSource =new DatabaseSource(MainActivity.this);


        button1= (Button) findViewById(R.id.save_Button);
        button2= (Button) findViewById(R.id.update_Button);
        button3= (Button) findViewById(R.id.next_Button);
        name1= (EditText) findViewById(R.id.name_edit_text1);
        name2= (EditText) findViewById(R.id.name_edit_text2);
        number1= (EditText) findViewById(R.id.name_edit_number1);
        number2= (EditText) findViewById(R.id.name_edit_number2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstName= name1.getText().toString();
                String  firstNumber =name2.getText().toString();
                String secondName = number1.getText().toString();
                String secondNumber =number2.getText().toString();

                mDatabaseSource.insertData(firstName,firstNumber,secondName,secondNumber);
                Toast.makeText(MainActivity.this, "DataSaved", Toast.LENGTH_SHORT).show();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(MainActivity.this, "Data Have been updated", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this,ShowDataActivity.class));

            }
        });


    }
}
