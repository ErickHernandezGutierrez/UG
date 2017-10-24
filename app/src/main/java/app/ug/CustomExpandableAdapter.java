package app.ug;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.content.res.AssetManager;

public class CustomExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> headers;
    private HashMap<String, List<String>> childs;
    private AssetManager assetManager;

    public CustomExpandableAdapter(Context context, List<String> headers, HashMap<String, List<String>> childs) {
        this.context = context;
        this.headers = headers;
        this.childs  = childs;
        this.assetManager = context.getAssets();
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.childs.get(this.headers.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_expandable, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.menuItem);
        txtListChild.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifRegular.otf"));
        txtListChild.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childs.get(this.headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_expandable, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.menuGroup);
        lblListHeader.setTypeface(Typeface.createFromAsset(assetManager, "GandhiSerifBold.otf"));
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

