package com.example.vibhor.databaseapp.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vibhor.databaseapp.R;
import com.example.vibhor.databaseapp.db.DatabaseSource;

public class ShowDataActivity extends AppCompatActivity {

    private Button showButton,backButton;
    private TextView showDataTextView;
   DatabaseSource mDatabaseSource;

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
        setContentView(R.layout.activity_show_data);

      showButton= (Button) findViewById(R.id.show_button);
      backButton= (Button) findViewById(R.id.back_button);
        showDataTextView= (TextView) findViewById(R.id.textView);



        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowDataActivity.this,MainActivity.class));
            }
        });
    }
}
