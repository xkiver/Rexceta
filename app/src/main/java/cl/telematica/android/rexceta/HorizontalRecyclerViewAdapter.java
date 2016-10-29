package cl.telematica.android.rexceta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.List;

import static android.webkit.URLUtil.isValidUrl;


public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private List<item_recomendados> mDataset;
    FragmentActivity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public ImageView mImageViewVid;




        public ViewHolder(View v) {
            super(v);

            mImageView = (ImageView) v.findViewById(R.id.image_sugerencia);
        }
    }

    public HorizontalRecyclerViewAdapter(List<item_recomendados> myDataset) {
        mDataset = myDataset;
        //this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_imagen, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final item_recomendados recet = mDataset.get(position);

        if(isValidUrl(recet.getImagen())){
            new DownloadImageTask(holder.mImageView).execute(recet.getImagen());
        }else{
            holder.mImageView.setImageResource(R.drawable.sinimagen);
        }



    }
    @Override
    public int getItemCount() {

        return mDataset.size();
    }



    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }

}
