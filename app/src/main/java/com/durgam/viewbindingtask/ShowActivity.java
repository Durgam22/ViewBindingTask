package com.durgam.viewbindingtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.durgam.viewbindingtask.databinding.ActivityShowBinding;

import java.util.zip.Inflater;

public class ShowActivity extends AppCompatActivity {

    ActivityShowBinding showBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showBinding = ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(showBinding.getRoot());

        Intent receivedIntent = getIntent();
        showBinding.dataReceivedText.setText(receivedIntent.getStringExtra("outputText"));

        showBinding.BackDataBtn.setOnClickListener(v -> {
            String backDataText = showBinding.editDataToSend.getText().toString();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("showData",backDataText);
            startActivity(intent);
        });
    }
}