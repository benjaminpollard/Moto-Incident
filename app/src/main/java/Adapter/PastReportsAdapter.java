package Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import Models.ReportModel;
import app.mono.com.monoapp.R;

/**
 * Created by Ben on 09/01/2017.
 */

public class PastReportsAdapter extends RecyclerView.Adapter<PastReportsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imageView;
        public TextView info;
        public TextView loc;

        public ViewHolder(View view) {
            super(view);
            imageView =(ImageView) view.findViewById(R.id.past_info_image);
            info = (TextView) view.findViewById(R.id.past_info_info);
            loc = (TextView) view.findViewById(R.id.past_info_loc);
        }
    }

    List<ReportModel> reports;

    public PastReportsAdapter(List<ReportModel> reportsParam)
    {
        reports = reportsParam;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_past_reports,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ReportModel model = reports.get(position);
        holder.info.setText(model.getDescriptionModel().getDescription());


        Geocoder geocoder;
        List<android.location.Address> addresses;
        geocoder = new Geocoder(holder.imageView.getContext(), Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(model.getLocationModel().getLat(), model.getLocationModel().getLng(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

            holder.loc.setText(address);

        } catch (IOException e) {
            e.printStackTrace();
            holder.loc.setText("Location Not set");
        }

        File sd = Environment.getExternalStorageDirectory();
        if(model.getGalleryModel().getPhotos() != null && model.getGalleryModel().getPhotos().size() > 0 )
        {
            File image = new File(sd, model.getGalleryModel().getPhotos().get(0).getString());
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
            bitmap = Bitmap.createScaledBitmap(bitmap,60,60,true);
            holder.imageView.setImageBitmap(bitmap);
        }else
        {
            holder.imageView.setImageDrawable(holder.imageView.getContext().getResources().getDrawable(R.drawable.popup_fixed));
        }

    }

    @Override
    public int getItemCount() {
        return reports.size();
    }


}
