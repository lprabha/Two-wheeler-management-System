package com.example.two_wheeler_schedule_management_system;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.two_wheeler_schedule_management_system.Models.PartsModel;
import com.example.two_wheeler_schedule_management_system.URL.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder>{
    List<PartsModel> partsList;
    Context context;
    Bitmap bitmap;

    public static final String BASE_URL = "http://10.0.2.2:6060/";

    public PartsAdapter(Context context, List<PartsModel> partsList) {
        this.context = context;
        this.partsList = partsList;
    }

    @NonNull
    @Override
    public PartsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.partsitem,viewGroup,false);
        return new PartsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsViewHolder partsViewHolder, int i) {
        final PartsModel partsModel = partsList.get(i);
//             Parts parts = partsList.get(i)
        partsViewHolder.PartsName.setText("Parts Name: "+partsModel.getPartName());
        partsViewHolder.Price.setText("Price: "+partsModel.getPartPrice());
        partsViewHolder.Model.setText("Model: "+partsModel.getPartsModel());

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

        return partsList.size();
    }

    public class PartsViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView ImgParts;
        public TextView PartsName, Price, Model;
        public Button viewMore;

        public PartsViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgParts = itemView.findViewById(R.id.partsimage);
            PartsName = itemView.findViewById(R.id.partsname);
            Price = itemView.findViewById(R.id.price);
            Model = itemView.findViewById(R.id.model);
//            viewMore=itemView.findViewById(R.id.);

        }
    }
}
