package com.example.bt2_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các đối tượng giao diện
    private EditText edtA, edtB;
    private Button btnSum;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID từ XML sang Java
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnSum = findViewById(R.id.btnSum);
        txtResult = findViewById(R.id.txtResult);

        // Lắng nghe sự kiện click nút
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        String s1 = edtA.getText().toString();
        String s2 = edtB.getText().toString();

        // Kiểm tra dữ liệu đầu vào
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Vui lòng không để trống!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(s2);
            double tong = a + b;

            // Hiển thị kết quả (Dùng String.format để bỏ bớt số 0 thừa nếu là số nguyên)
            if (tong == (long) tong) {
                txtResult.setText("Kết quả: " + (long) tong);
            } else {
                txtResult.setText("Kết quả: " + tong);
            }

        } catch (Exception e) {
            Toast.makeText(this, "Lỗi định dạng số!", Toast.LENGTH_SHORT).show();
        }
    }
}