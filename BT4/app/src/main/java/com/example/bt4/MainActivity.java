package com.example.bt4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSo1, edtSo2;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ các thành phần giao diện
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvKetQua = findViewById(R.id.tvKetQua);

        // 2. Gán sự kiện click cho 4 nút.
        // Thay vì viết 4 đoạn code dài, ta gom lại gọi chung 1 hàm tinhToan()
        btnCong.setOnClickListener(v -> tinhToan("+"));
        btnTru.setOnClickListener(v -> tinhToan("-"));
        btnNhan.setOnClickListener(v -> tinhToan("*"));
        btnChia.setOnClickListener(v -> tinhToan("/"));
    }

    // Hàm xử lý chung cho cả 4 phép tính
    private void tinhToan(String phepTinh) {
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

            // Xử lý phép tính tương ứng
            switch (phepTinh) {
                case "+": ketQua = a + b; break;
                case "-": ketQua = a - b; break;
                case "*": ketQua = a * b; break;
                case "/":
                    if (b == 0) {
                        Toast.makeText(this, "Lỗi: Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ketQua = a / b;
                    break;
            }

            // In kết quả ra màn hình và đổi màu chữ cho rõ nét
            tvKetQua.setText(String.valueOf(ketQua));
            tvKetQua.setTextColor(android.graphics.Color.BLACK);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}