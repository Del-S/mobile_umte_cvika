package com.cviceni.cv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cviceni.R;

import java.util.List;

public class BanAdapter extends ArrayAdapter<Ban>{

    public BanAdapter(Context context, int resource, List<Ban> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_ban, null);
        }

        Ban ban = getItem(position);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.txtTitle);

        txtTitle.setText(ban.getTitle());
        txtDescription.setText(ban.getDescription());

        return convertView;
    }
}
