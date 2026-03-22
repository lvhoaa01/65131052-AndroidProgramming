package com.example.bt5;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtSo1, edtSo2;
    private Button btnCong, btnTru, btnChia, btnNhan;
    private TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnChia = findViewById(R.id.btnChia);
        btnNhan = findViewById(R.id.btnNhan);

        btnCong.setOnClickListener(v -> tinhtoan("+"));
        btnTru.setOnClickListener(v -> tinhtoan("-"));
        btnNhan.setOnClickListener(v -> tinhtoan("*"));
        btnChia.setOnClickListener(v -> tinhtoan("/"));

    }

    private void tinhtoan(String pheptinh){
        String s1 = edtSo1.getText().toString();
        String s2 = edtSo2.getText().toString();

        if(s1.isEmpty() || s2.isEmpty()){
            Toast.makeText(this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            double a = Double.parseDouble(s1);
            double b = Double.parseDouble(s2);
            double ketQua = 0;

            switch (pheptinh){
                case "+": ketQua = a + b; break;
                case "-": ketQua = a - b; break;
                case "*": ketQua = a * b; break;
                case "/":
                    if(b == 0){
                        Toast.makeText(this, "Lỗi không chia được cho 0, vui lòng nhập lại b!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ketQua = a/b;
                    break;
            }

            tvKetQua.setText(String.valueOf(ketQua));
            tvKetQua.setTextColor(Color.BLACK);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}