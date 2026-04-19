package fs1.lvh.recycleview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder>{
    private List<Data> datas = new ArrayList<>();
    private Context context;

    public Adapter2(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv3.setText(datas.get(position).getText1());
        holder.tv4.setText(datas.get(position).getText2());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv3, tv4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv3 = itemView.findViewById(R.id.tv3);
            this.tv4 = itemView.findViewById(R.id.tv4);
            itemView.setOnClickListener(this);
        }

        public TextView getTv3() {
            return tv3;
        }

        public void setTv3(TextView tv3) {
            this.tv3 = tv3;
        }

        public TextView getTv4() {
            return tv4;
        }

        public void setTv4(TextView tv4) {
            this.tv4 = tv4;
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getBindingAdapterPosition();
            String content = "Đã chọn vào " + clickedPosition;
//            Toast.makeText();
        }
    }
}
