package app.ug;

import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class CustomBannerAdapter extends RecyclerView.Adapter<CustomBannerAdapter.CustomViewHolder>{

    private Context context;
    private ArrayList<Banner> banners;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView cover;

        public CustomViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.bannerTitle);
            cover = (ImageView) view.findViewById(R.id.bannerCover);
        }
    }

    public CustomBannerAdapter(Context context, ArrayList<Banner> banners){
        this.context = context;
        this.banners = banners;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position){
        Banner banner = banners.get(position);

        holder.title.setText(banner.getName());
        holder.cover.setImageResource(banner.getImageID());
        holder.cover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(context, "Click...", Toast.LENGTH_SHORT).show();
                //context.startActivity(new Intent(context, CulturalActivity.class));
            }
        });
    }

    @Override
    public int getItemCount(){
        return banners.size();
    }
}