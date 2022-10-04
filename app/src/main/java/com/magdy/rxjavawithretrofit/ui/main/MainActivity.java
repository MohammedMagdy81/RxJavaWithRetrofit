package com.magdy.rxjavawithretrofit.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.magdy.rxjavawithretrofit.R;
import com.magdy.rxjavawithretrofit.pojo.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel viewModel;
    PostAdapter postAdapter;
    RecyclerView postsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= new ViewModelProvider(this).get(PostViewModel.class);
        initViews();

        viewModel.getPosts();
        viewModel.postsLiveData.observe(this, posts -> {
            postAdapter.setPosts((ArrayList<Post>) posts);
        });
    }

    private void initViews() {
        postsRv= findViewById(R.id.postsRv);
        postAdapter= new PostAdapter();
        postsRv.setAdapter(postAdapter);
        postsRv.setHasFixedSize(true);
    }
}