package com.sar.user.rxjava_retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.reactivex.functions.Consumer;

public class RecyclerAdapter extends RecyclerView.Adapter<ShowRecyler> {

    Context context;
    List<Post> post;

    public RecyclerAdapter(@NonNull Context context, List<Post> post) {
        this.context = (Context) context;
        this.post = post;
    }



    @NonNull
    @Override
    public ShowRecyler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);
        return new ShowRecyler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowRecyler showRecyler, int i) {
                showRecyler.userid.setText(String.valueOf(post.get(i).userId));
        showRecyler.title.setText(String.valueOf(post.get(i).userId));
        showRecyler.body.setText(String.valueOf(post.get(i).userId));
    }

    @Override
    public int getItemCount() {
        return post.size();
    }
}
