package com.example.centrereservation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.centrereservation.controller.HomeFragment;
import com.example.centrereservation.controller.ReservationFragment;
import com.example.centrereservation.controller.activity_reservation;
import com.example.centrereservation.controller.salleActivity1;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class list_adapter_salle extends FirebaseRecyclerAdapter<salle,list_adapter_salle.MyViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public list_adapter_salle(@NonNull FirebaseRecyclerOptions<salle> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull salle model) {

        holder.availab_salle.setText("Availability :" + String.valueOf(model.getAvailability()));
        holder.nbSeats_sal.setText("NbSeats : " + String.valueOf(model.getNbSeats()));
        holder.typesalle.setText("TypeSalle :" + String.valueOf(model.getTypeSalle()));
        Glide.with(holder.img_salle.getContext()).load(model.getImage()).into(holder.img_salle);
//        holder.img_salle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity=(AppCompatActivity)view.getContext();
//
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.home,new ReservationFragment()).commit();
//            }
//        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_des_salles,parent,false);
        return new MyViewHolder(v);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_salle;
        TextView availab_salle,nbSeats_sal,typesalle;


        public MyViewHolder (@NonNull  View Itemview) {
            super(Itemview);
            img_salle=Itemview.findViewById(R.id.image_salle);
            availab_salle=Itemview.findViewById(R.id.availability_);
            nbSeats_sal=Itemview.findViewById(R.id.nbSeats_);
            typesalle=Itemview.findViewById(R.id.typeSalle_);

        }

    }
}
