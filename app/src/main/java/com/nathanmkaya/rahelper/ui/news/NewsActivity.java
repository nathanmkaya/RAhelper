package com.nathanmkaya.rahelper.ui.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.News;
import com.nathanmkaya.rahelper.ui.BaseActivity;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity {

    @BindView(R.id.news_list)
    RecyclerView newsList;

    FirebaseRecyclerAdapter<News, NewsHolder> recyclerAdapter;
    DatabaseReference news = DbReference.news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //setContent(R.layout.activity_news);
        ButterKnife.bind(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(0);
        newsList.setLayoutManager(layoutManager);

        recyclerAdapter = new FirebaseRecyclerAdapter<News, NewsHolder>(News.class, R.layout.news, NewsHolder.class, news) {
            @Override
            protected void populateViewHolder(NewsHolder newsHolder, News news, int i) {

            }

            @Override
            public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                NewsHolder holder = super.onCreateViewHolder(parent, viewType);
                holder.setOnClickListener(new ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });

                return holder;
            }
        };
    }
}
