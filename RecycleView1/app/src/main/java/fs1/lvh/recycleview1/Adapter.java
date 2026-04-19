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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Data> datas = new ArrayList<>();

    private Context context;

    public Adapter(List<Data> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view); //Hoc thuoc
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv1.setText(datas.get(position).getText1());
        holder.tv2.setText(datas.get(position).getText2());
    }

    @Override
    public int getItemCount() { //Lay tong so phan tu du lieu
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv1, tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv1 = itemView.findViewById(R.id.tv1);
            this.tv2 = itemView.findViewById(R.id.tv2);
            itemView.setOnClickListener(this);
        }

        public TextView getTv1() {
            return tv1;
        }

        public void setTv1(TextView tv1) {
            this.tv1 = tv1;
        }

        public TextView getTv2() {
            return tv2;
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getBindingAdapterPosition();
            String tb = "Da chon vao " + clickedPosition;
            Toast.makeText(context, tb, Toast.LENGTH_SHORT).show();
        }

        public void setTv2(TextView tv2) {
            this.tv2 = tv2;
        }
    }
}
