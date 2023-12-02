package com.example.a1811intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1811intent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static final String KEY = "";
    static final int REQUESTCODE1=1;
    static final int REQUESTCODE2=2;
    static final int REQUESTCODE3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(KEY,"From first activity");
                startActivityForResult(intent,REQUESTCODE2);
            }
        });
        binding.toThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                intent.putExtra(KEY,"From first activity");
                startActivityForResult(intent,REQUESTCODE3);

            }
        });
        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "From first activity");
                setResult(RESULT_OK, intent);
                finish(); // Закрываем текущую активити
            }
        });


        

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE1 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(MainActivity.KEY);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUESTCODE3 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(MainActivity.KEY);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }


}