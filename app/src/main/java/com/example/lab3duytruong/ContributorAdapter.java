package com.example.lab3duytruong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContributorAdapter extends BaseAdapter {

    private Context context;
    private List<Contributor> contributorList;
    private LayoutInflater inflater;

    public ContributorAdapter(Context context, List<Contributor> contributorList) {
        this.context = context;
        this.contributorList = contributorList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contributorList.size();
    }

    @Override
    public Object getItem(int position) {
        return contributorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_contributor, parent, false);
            holder = new ViewHolder();
            holder.imgContributor = convertView.findViewById(R.id.imgContributor);
            holder.txtName = convertView.findViewById(R.id.txtContributorName);
            holder.txtContributions = convertView.findViewById(R.id.txtContributions);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contributor contributor = contributorList.get(position);
        holder.imgContributor.setImageResource(contributor.getImageResource());
        holder.txtName.setText(contributor.getName());
        holder.txtContributions.setText(contributor.getContributions());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgContributor;
        TextView txtName;
        TextView txtContributions;
    }
}

