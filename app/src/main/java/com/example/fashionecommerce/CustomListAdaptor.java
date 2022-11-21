package com.example.fashionecommerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fashionecommerce.Model.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdaptor extends ArrayAdapter {
    List<Products>result;
    Context context;
    public CustomListAdaptor(Context context, List<Products>result) {
        super(context, 0, result);
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder stu=new ViewHolder();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.product_items_layout, parent, false);
            stu.tvname = (TextView)convertView.findViewById(R.id.product_name);
            stu.tvdesc = (TextView)convertView.findViewById(R.id.product_description);
            stu.tvprice = (TextView)convertView.findViewById(R.id.product_price);
            stu.img = (ImageView) convertView.findViewById(R.id.product_image);
            convertView.setTag(stu);
        }else{
            stu = (ViewHolder)convertView.getTag();
        }

        stu.tvname.setText(result.get(position).getPname());
        stu.tvdesc.setText(result.get(position).getDescription());
        stu.tvprice.setText(result.get(position).getPrice());
        Picasso.get().load(result.get(position).getImage()).into(stu.img);
        return convertView;
    }

    static class ViewHolder{
        TextView tvname;
        TextView tvdesc;
        TextView tvprice;
        ImageView img;
    }
}
