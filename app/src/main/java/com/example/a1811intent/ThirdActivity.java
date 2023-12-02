package com.example.a1811intent;

import static com.example.a1811intent.MainActivity.KEY;
import static com.example.a1811intent.MainActivity.REQUESTCODE1;
import static com.example.a1811intent.MainActivity.REQUESTCODE2;
import static com.example.a1811intent.MainActivity.REQUESTCODE3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a1811intent.databinding.ActivitySecondBinding;
import com.example.a1811intent.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String str = getIntent().getStringExtra(KEY);
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();

        binding.toFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra(KEY, "From third activity");
                startActivity(intent);
                finishAffinity();
                Toast.makeText(ThirdActivity.this, "From third activity", Toast.LENGTH_SHORT).show();
            }
        });
        binding.toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
                intent.putExtra(KEY,"From third activity");
                startActivityForResult(intent,REQUESTCODE3);

            }
        });




        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY, "From third activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE3 && resultCode == RESULT_OK) {
            String str = data.getStringExtra(KEY);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }


}
