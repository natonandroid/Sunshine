package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private Button mUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mUpButton = (Button)findViewById(R.id.my_button);
        mUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = DetailActivity.this;
                String message = "UP Button clicked!\n";
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
