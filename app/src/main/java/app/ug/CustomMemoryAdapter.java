package app.ug;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMemoryAdapter extends RecyclerView.Adapter<CustomMemoryAdapter.CustomViewHolder>{
    private Context context;
    private ArrayList<Memory> memories;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView campus;
        public TextView title;
        public TextView description;

        public CustomViewHolder(View view){
            super(view);
            date = (TextView) view.findViewById(R.id.memoryDate);
            campus = (TextView) view.findViewById(R.id.memoryCampus);
            title = (TextView) view.findViewById(R.id.memoryTitle);
            description = (TextView) view.findViewById(R.id.memoryDescription);
        }
    }

    public CustomMemoryAdapter(Context context, ArrayList<Memory> memories){
        this.context = context;
        this.memories = memories;
    }

    @Override
    public CustomMemoryAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory, parent, false);

        return new CustomMemoryAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomMemoryAdapter.CustomViewHolder holder, int position){
        Memory memory = memories.get(position);

        holder.date.setText(memory.getDate());
        holder.campus.setText("Campus " + memory.getCampus());
        holder.title.setText(memory.getTitle());
        holder.description.setText(memory.getDescription());
        /*holder.cover.setImageBitmap(banner.getImage());
        holder.cover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                context.startActivity(new Intent(context, CulturalActivity.class));
            }
        });//*/
    }

    @Override
    public int getItemCount(){
        return memories.size();
    }
}
