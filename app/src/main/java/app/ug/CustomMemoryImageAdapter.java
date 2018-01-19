package app.ug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMemoryImageAdapter extends RecyclerView.Adapter<CustomMemoryImageAdapter.CustomViewHolder>{

    private Context context;
    private ArrayList<Bitmap> images;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;

        public CustomViewHolder(View view){
            super(view);
            image = (ImageView) view.findViewById(R.id.memoryImagesItem);
        }
    }

    public CustomMemoryImageAdapter(Context context, ArrayList<Bitmap> images){
        this.context = context;
        this.images = images;
    }

    @Override
    public CustomMemoryImageAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory_image, parent, false);

        return new CustomMemoryImageAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomMemoryImageAdapter.CustomViewHolder holder, int position){
        Bitmap bitmap = images.get(position);

        holder.image.setImageBitmap(bitmap);
        /*holder.cover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                context.startActivity(new Intent(context, CulturalActivity.class));
            }
        });//*/
    }

    @Override
    public int getItemCount(){
        return images.size();
    }
}
