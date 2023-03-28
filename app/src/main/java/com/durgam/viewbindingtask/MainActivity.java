package com.durgam.viewbindingtask;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.durgam.viewbindingtask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.sendDataBtn.setOnClickListener(v -> {
            startShowActivity();
        });

        //Data received from show activity
        Intent receivedShowIntent = getIntent();
        mainBinding.dataReceivedText.setText(receivedShowIntent.getStringExtra("showData"));
    }
    private void startShowActivity() {
        String outputText = mainBinding.editData.getText().toString();
        Intent sendIntent = new Intent(this, ShowActivity.class);
        sendIntent.putExtra("outputText", outputText);
        startActivity(sendIntent);
    }
}