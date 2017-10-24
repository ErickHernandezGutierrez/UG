package app.ug;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
    //Members
    private Activity activity;
    private LayoutInflater inflater;
    private List<Offer> offers;
    private AssetManager assetManager;

    //Constructors
    public CustomListAdapter(){}
    public CustomListAdapter(Activity activity, List<Offer> offers){
        this.activity = activity;
        this.offers = offers;
        assetManager = activity.getAssets();
    }

    //Methods
    @Override
    public int getCount(){
        return offers.size();
    }

    @Override
    public Object getItem(int location){
        return offers.get(location);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item_offer, null);

        TextView index  = (TextView) convertView.findViewById(R.id.index);
        TextView name   = (TextView) convertView.findViewById(R.id.name);
        TextView area   = (TextView) convertView.findViewById(R.id.area);
        TextView campus = (TextView) convertView.findViewById(R.id.campus);

        Offer offer = offers.get(position);

        index.setText(String.valueOf(position));
        index.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifRegular.otf"));
        name.setText(offer.getName());
        name.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifBold.otf"));
        area.setText(offer.getArea());
        area.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifRegular.otf"));
        campus.setText("Campus " + offer.getCampus());
        campus.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifRegular.otf"));

        return convertView;
    }

    public void setList(List<Offer> offers){
        this.offers = offers;
    }
}
