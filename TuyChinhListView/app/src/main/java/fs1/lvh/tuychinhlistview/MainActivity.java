package fs1.lvh.tuychinhlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //tim ListView
        ListView lvDSMonAn = (ListView) findViewById(R.id.lvDSMonAn);

        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();

        MonAn bunCaSua = new MonAn(
                "Bún cá sứa",
                45000,
                // PHÂN TÍCH UX: Đoạn mô tả nên tập trung vào trải nghiệm vị giác thay vì chỉ liệt kê nguyên liệu.
                // Tôi đã viết lại để kích thích vị giác hơn.
                "Đặc sản xứ biển với nước dùng ngọt thanh, sứa giòn sần sật và chả cá nhồng dai ngon.",
                // LƯU Ý: Bạn nhớ đổi tên file ảnh trong thư mục res/drawable thành buncasua.png/jpg tương ứng
                R.drawable.buncasua
        );

        MonAn nemNuong = new MonAn(
                "Nem nướng",
                55000,
                // PHÂN TÍCH RỦI RO: Đoạn text này khá dài, nếu hiển thị trên màn hình điện thoại nhỏ (như tỷ lệ màn hình hẹp),
                // TextView của bạn có bị cắt chữ (ellipsize) không? Bạn cần test kỹ độ dài tối đa của đoạn mô tả.
                "Nem thịt heo nướng lụi xèo xèo, cuốn cùng bánh tráng chiên giòn, rau sống và chấm sốt thịt băm béo ngậy.",
                R.drawable.nemnuong
        );

        MonAn banhCan = new MonAn(
                "Bánh căn hải sản",
                60000,
                // LỜI KHUYÊN KỸ THUẬT: Ký tự đặc biệt (như dấu gạch chéo "/") trong chuỗi String cứng
                // có thể gây ra vấn đề về hiển thị trên một số thiết lập font chữ nhất định.
                // Luôn kiểm tra giao diện thực tế.
                "Bánh nướng khuôn đất giòn rụm, nhân tôm/mực tươi rói, ăn kèm xíu mại và xoài băm chua chua.",
                R.drawable.banhcan
        );

        MonAn bunLaCaDam = new MonAn(
                "Bún lá cá dầm",
                40000,
                "Bún lá xép vòng xoáy đặc trưng, chan nước lèo nấu từ cá ngừ dầm nát đậm đà hương vị biển cả.",
                R.drawable.bunlacadam
        );
        MonAn nem = new MonAn(
                "Nem",
                35000,
                "Nem rán vàng giòn, nhân thịt và miến, ăn kèm rau sống.",
                R.drawable.nem
        );

        dsMonAn.add(banhCan);
        dsMonAn.add(bunCaSua);
        dsMonAn.add(nemNuong);
        dsMonAn.add(bunLaCaDam);
        dsMonAn.add(nem);

        MonAnAdapter monAnAdapter = new MonAnAdapter(this, dsMonAn);
        lvDSMonAn.setAdapter(monAnAdapter);

        //bat xu ly su kien
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //lay pham tu duoc cham
                MonAn monAnDuocChon = dsMonAn.get(i);
                Toast.makeText(MainActivity.this, monAnDuocChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}