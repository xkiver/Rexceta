package com.example.jesi.rexceta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.Context;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Jesi on 05-10-16.
 */

public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    private List<Item_Receta> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleView;
        public RatingBar mValorationView;
        public TextView mDescriptionView;
        public ImageView mImageView;
        public BitmapFactory.Options options = new BitmapFactory.Options();

        public ViewHolder(View v) {
            super(v);

            mTitleView = (TextView) v.findViewById(R.id.textView6);
            mValorationView = (RatingBar) v.findViewById(R.id.ratingBar3);
            mDescriptionView = (TextView) v.findViewById(R.id.textView8);
            mImageView = (ImageView) v.findViewById(R.id.imageView4);
        }
    }

    public UIAdapter(List<Item_Receta> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item_Receta recet = mDataset.get(position);

        holder.mTitleView.setText(recet.getNombre());
        holder.mValorationView.setRating(recet.getValoracion());
        holder.mDescriptionView.setText(recet.getDescripcion());
       // holder.mImageView.setImageDrawable(Drawable.createFromPath("http://deliveryitalianfood.com/WebRoot/Store19/Shops/b4185ff1-3979-41c1-b630-4b577c7750d5/5468/52B2/9673/0DC5/0CA2/0A48/354B/97A5/Pizza_mexicana.jpg"));
        Picasso.with(ListaRecetas.this).load(recet.getImagen()).into(holder.mImageView);
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}