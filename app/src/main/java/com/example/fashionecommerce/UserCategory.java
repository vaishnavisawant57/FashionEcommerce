package com.example.fashionecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UserCategory extends AppCompatActivity {
    private ImageView tShirts, trousers, dresses, sweaters;
    private ImageView glasses, walletsBagsPurses, footwear;
    private ImageView watches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_category);

        tShirts = (ImageView) findViewById(R.id.t_shirts);
        trousers = (ImageView) findViewById(R.id.trousers);
        dresses = (ImageView) findViewById(R.id.dress);
        sweaters = (ImageView) findViewById(R.id.sweaters);

        glasses = (ImageView) findViewById(R.id.glasses);
        walletsBagsPurses = (ImageView) findViewById(R.id.purses_bags_wallets);
        footwear = (ImageView) findViewById(R.id.footwear);
        watches = (ImageView) findViewById(R.id.watches);

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "TShirts & Tops");
                startActivity(intent);
            }
        });
        trousers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Trousers");
                startActivity(intent);
            }
        });


        dresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this,UserProduct.class);
                intent.putExtra("category", "Dresses");
                startActivity(intent);
            }
        });


        sweaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Sweaters");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });


        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Wallets, Bags & Purses");
                startActivity(intent);
            }
        });


        footwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Footwear");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UserCategory.this, UserProduct.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });
    }
}