package com.sar.user.rxjava_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
     Api api;
     RecyclerView recyclerView;
     CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=Retrofitclient.getInstance();
        api=retrofit.create(Api.class);
        recyclerView=findViewById(R.id.rex);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        compositeDisposable.add((Disposable) api.getPost().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i("jii",throwable.getMessage());
            }
        }).subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) throws Exception {
                RecyclerAdapter adapter=new RecyclerAdapter(MainActivity.this,posts);
                recyclerView.setAdapter(adapter);
            }


        })) ;



    }
}
