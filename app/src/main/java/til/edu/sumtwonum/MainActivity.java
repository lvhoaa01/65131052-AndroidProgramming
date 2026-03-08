package til.edu.sumtwonum;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import til.edu.helloworld.R;


public class MainActivity extends AppCompatActivity {

    private EditText edtSoA, edtSoB;
    private Button btnTinhTong;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tinh_tong);

        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTong();
            }
        });
    }

    private void tinhTong() {
        String chuoiA = edtSoA.getText().toString();
        String chuoiB = edtSoB.getText().toString();

        if (chuoiA.isEmpty() || chuoiB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double soA = Double.parseDouble(chuoiA);
        double soB = Double.parseDouble(chuoiB);

        double tong = soA + soB;

        tvKetQua.setText("Kết quả: " + tong);
    }
}