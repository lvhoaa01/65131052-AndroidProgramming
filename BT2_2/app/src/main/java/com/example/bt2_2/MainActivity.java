package com.example.bt2_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1, edtNumber2;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        String chuoiSo1 = edtNumber1.getText().toString();
        String chuoiSo2 = edtNumber2.getText().toString();

        if (chuoiSo1.isEmpty() || chuoiSo2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cả 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double so1 = Double.parseDouble(chuoiSo1);
            double so2 = Double.parseDouble(chuoiSo2);
            double tong = so1 + so2;
            tvResult.setText("Kết quả: " + tong);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}