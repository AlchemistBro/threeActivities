package com.example.a1811intent;


import static com.example.a1811intent.MainActivity.KEY;
import static com.example.a1811intent.MainActivity.REQUESTCODE1;
import static com.example.a1811intent.MainActivity.REQUESTCODE3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1811intent.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String str = getIntent().getStringExtra(KEY);
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();

        binding.toFirst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(KEY, "From second activity");
                startActivity(intent);
                finishAffinity();
                Toast.makeText(SecondActivity.this, "From second activity", Toast.LENGTH_SHORT).show();

            }
        });
        binding.toThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra(KEY,"From second activity");
                startActivityForResult(intent,REQUESTCODE3);
            }
        });




        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "From second activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE3 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(KEY);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }



}