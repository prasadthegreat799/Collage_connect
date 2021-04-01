package com.prasadthegreat.ourcampus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class homeadapterclass extends FirebaseRecyclerAdapter<homemodel, com.prasadthegreat.ourcampus.homeadapterclass.myviewholder>
{
    Context context;

    public homeadapterclass(@NonNull FirebaseRecyclerOptions<homemodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull homemodel model) {
            holder.worktxt1.setText(model.getWorktitle());
            System.out.println("Work Data:"+model.getWorkdata());
            holder.worktitle2.setText(model.getWorkdata());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlehomedata,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{


        TextView worktxt1,worktitle2;
        public myviewholder(@NonNull View itemView) {

            super(itemView);
            worktxt1=(TextView)itemView.findViewById(R.id.worktxt);
            worktitle2=(TextView)itemView.findViewById(R.id.worktitle);
        }
    }
}
