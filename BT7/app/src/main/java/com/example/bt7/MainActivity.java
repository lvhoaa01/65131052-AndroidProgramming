package com.example.bt7;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        ListView lvDanhSach = findViewById(R.id.lvDanhSach);
        String[] duLieu = {"Lập trình Java", "Lập trình C++"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1
        );

        lvDanhSach.setAdapter(adapter);

        lvDanhSach.setOnItemClickListener((parent, view, position, id) -> {
            String mucDuocChon = duLieu[position];

            Toast.makeText(this, "Bạn đang xem" + mucDuocChon, Toast.LENGTH_SHORT).show();
        });
    }
}