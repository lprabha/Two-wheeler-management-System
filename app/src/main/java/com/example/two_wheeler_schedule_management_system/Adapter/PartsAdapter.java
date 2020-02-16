package com.example.two_wheeler_schedule_management_system.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.Models.PartsModel;
import com.example.two_wheeler_schedule_management_system.R;
import com.example.two_wheeler_schedule_management_system.URL.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder>{
    List<PartsModel> partsModels;
    Context context;

    public PartsAdapter(Context context, List<PartsModel> partsModels) {
        this.context = context;
        this.partsModels = partsModels;
    }

    @NonNull
    @Override
    public PartsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate( R.layout.partsitem,viewGroup,false);
        return new PartsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsViewHolder partsViewHolder, int i) {
        final PartsModel partsModel = partsModels.get(i);
        partsViewHolder.PartsName.setText("Parts Name: "+partsModel.getPartName());
        partsViewHolder.Price.setText("Price: "+partsModel.getPartPrice());
        partsViewHolder.Model.setText("Model: "+partsModel.getPartModel());

        String imgPath = Url.imagePath + partsModel.getPartImage();
        Picasso.get().load(imgPath).into(partsViewHolder.ImgParts);


        Toast.makeText(context, ""+partsModel.getPartName(), Toast.LENGTH_SHORT).show();


//        partsViewHolder.viewMore.setOnCLickListner(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Context vcontext = view.getContext();
//                String provide_path = BASE_URL+"/images/"+parts.getPartsname();
//
//                System.out.println(provide_path);
//
//                Intent showParts = new Intent(context, ShowClickedParts.class );
//                showParts.putExtra("Parts Name", parts.getPartsname());
//                showParts.putExtra("Price", parts.getPrice());
//                showParts.putExtra("Model", parts.getModel());
//                showParts.putExtra("Description", parts.getDescription());
//                showParts.putExtra("Parts Image", BASE_URL+"/images/"+parts.getImageId());
//
//                vcontext.startActivity(showParts);
//            }
//        });
    }

    @Override
    public int getItemCount() {

        return partsModels.size();
    }

    public class PartsViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView ImgParts;
        public TextView PartsName, Price, Model;
        public Button viewMore;

        public PartsViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgParts = itemView.findViewById(R.id.imgparts);
            PartsName = itemView.findViewById(R.id.partsname);
            Price = itemView.findViewById(R.id.partsprice);
            Model = itemView.findViewById(R.id.partsmodel);
//            viewMore=itemView.findViewById(R.id.);

        }
    }
}
