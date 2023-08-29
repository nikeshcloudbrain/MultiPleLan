package com.example.multiplelandemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.multiplelandemo.databinding.ItemLanBinding;

import java.util.ArrayList;
import java.util.List;


public class LanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity con;
    private ArrayList<LanguageModel> arrayL;
    private final OnItemClickListener listener;
    int selectedPosition = -1;
    int lastSelectedPosition = -1;

    public LanAdapter(Activity context, ArrayList<LanguageModel> arrayL,OnItemClickListener listener) {
        this.con = context;
        this.arrayL = arrayL;
        this.listener = listener;

    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLanBinding binding;

        public ViewHolder(@NonNull ItemLanBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(ItemLanBinding.inflate(LayoutInflater.from(con), viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {


        ViewHolder myViewHolder = (ViewHolder) holder;
//        Log.e("TAG", "onBindViewHolder: " + arrayL.get(i).getPreview());
        Glide.with(con).load(arrayL.get(i).getCcimage()).into(myViewHolder.binding.englishImg);

        myViewHolder.binding.firstEngTxt.setText(arrayL.get(i).getFirsttype());
        myViewHolder.binding.secondEngTxt.setText(arrayL.get(i).getSecondtype());
        myViewHolder.binding.thridTxt.setText(arrayL.get(i).getThirdtype());
        myViewHolder.binding.mainRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lastSelectedPosition = selectedPosition;
                selectedPosition = i;
                notifyItemChanged(lastSelectedPosition);
                notifyItemChanged(selectedPosition);
              listener.onItemClick(arrayL.get(i).getCode());
                notifyDataSetChanged();
            }
        });

        if (selectedPosition == i) {
            myViewHolder.binding.englishSelectImg.setImageResource( R.drawable.ic_true);
        } else {
            myViewHolder.binding.englishSelectImg.setImageResource( R.drawable.ic_untrue);
        }


    }


    @Override
    public int getItemCount() {
        return arrayL.size();
    }


}

