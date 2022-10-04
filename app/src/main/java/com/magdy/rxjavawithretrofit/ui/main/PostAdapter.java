package com.magdy.rxjavawithretrofit.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.magdy.rxjavawithretrofit.R;
import com.magdy.rxjavawithretrofit.pojo.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    ArrayList<Post> posts= new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        return new PostViewHolder(v);
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            Post post= posts.get(position);
            holder.body.setText(post.getBody());
            holder.title.setText(post.getTitle());
            holder.id.setText(post.getUserId()+"");
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title,body,id;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.titleTv);
            body= itemView.findViewById(R.id.bodyTv);
            id= itemView.findViewById(R.id.idTv);
        }
    }
}
