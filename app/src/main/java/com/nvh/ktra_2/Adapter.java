package com.nvh.ktra_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Contacts> peopleList;

    public Adapter(Context context, int layout, List<Contacts> peopleList) {
        this.context = context;
        this.layout = layout;
        this.peopleList = peopleList;
    }

    @Override
    public int getCount() {
        return peopleList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        CircleImageView image_avatar;
        ImageView image_star;
        TextView txtName,txtAddress,txtPhone;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            holder.image_avatar=(CircleImageView) view.findViewById(R.id.img);
            holder.txtName=(TextView) view.findViewById(R.id.text);

            view.setTag(holder);
        }
        else
            holder= (ViewHolder) view.getTag();
        Contacts people=peopleList.get(i);
        holder.image_avatar.setImageResource(people.getImg());
        holder.txtName.setText(people.title);
        return view;

    }
}
