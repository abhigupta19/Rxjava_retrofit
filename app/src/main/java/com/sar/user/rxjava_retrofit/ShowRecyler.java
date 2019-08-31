package com.sar.user.rxjava_retrofit;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ShowRecyler extends RecyclerView.ViewHolder{
TextView userid,title,body;
    public ShowRecyler(@NonNull View itemView) {
        super(itemView);
        userid=(TextView)itemView.findViewById(R.id.textView);
        title=(TextView)itemView.findViewById(R.id.textView2);
        body=(TextView)itemView.findViewById(R.id.textView3);

    }
}
