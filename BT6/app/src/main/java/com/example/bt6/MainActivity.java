package com.example.bt6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSo1, edtSo2;
    private Button btnCong;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnCong = findViewById(R.id.btnCong);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnCong.setOnClickListener(v -> tinhToan());
    }

    // Hàm xử lý chung cho cả 4 phép tính
    private void tinhToan() {
        String s1 = edtSo1.getText().toString();
        String s2 = edtSo2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(s2);
            double ketQua = 0;
            ketQua = a + b;
            tvKetQua.setText(String.valueOf(ketQua));
            tvKetQua.setTextColor(android.graphics.Color.BLACK);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}