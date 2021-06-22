package com.febryan.kisahnabi;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.febryan.kisahnabi.model.ResultItem;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKisahNabiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kisah_nabi);

        ImageView imageDetail = findViewById(R.id.img_detail);
        TextView tvIsiDetail = findViewById(R.id.tv_list_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        ResultItem resultItem = getIntent().getParcelableExtra("DETAIL");
        tvIsiDetail.setText(resultItem.getDescription());
        toolBarLayout.setTitle(resultItem.getName());
        Glide.with(this)
                .load(resultItem.getImageUrl())
                .error(R.drawable.ic_launcher_background)
                .into(imageDetail);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}