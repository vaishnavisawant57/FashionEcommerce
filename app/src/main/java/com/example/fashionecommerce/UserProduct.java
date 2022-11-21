package com.example.fashionecommerce;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fashionecommerce.Model.Products;
import com.example.fashionecommerce.Model.Users;
import com.example.fashionecommerce.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserProduct extends AppCompatActivity {
    private List<Products> prodList=new ArrayList<>();
    private String CategoryName;
    TextView catName;
    private DatabaseReference ProductsRef;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_product);
        CategoryName = getIntent().getExtras().get("category").toString();
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        ProductsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren())
                {
                    if(item.child("category").getValue(String.class).equals(CategoryName)) {
                        Products pr=new Products(item.child("pname").getValue(String.class),item.child("description").getValue(String.class),item.child("price").getValue(String.class),item.child("image").getValue(String.class),item.child("category").getValue(String.class),item.child("pid").getValue(String.class),item.child("date").getValue(String.class),item.child("time").getValue(String.class));
                        prodList.add(pr);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        catName=findViewById(R.id.categoryName);
        catName.setText(CategoryName);
        layoutManager = new LinearLayoutManager(this);
    }
    @Override
    protected void onStart() {

        super.onStart();
        CustomListAdaptor adapter = new CustomListAdaptor(this, prodList);
        ListView listView = (ListView) findViewById(R.id.productList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(UserProduct.this,ProductDetailsActivity.class);
                intent.putExtra("pid",prodList.get(i).getPid());
                startActivity(intent);
            }
        });
    }
}