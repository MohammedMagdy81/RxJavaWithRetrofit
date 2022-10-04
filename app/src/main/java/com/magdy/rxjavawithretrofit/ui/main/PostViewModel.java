package com.magdy.rxjavawithretrofit.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.magdy.rxjavawithretrofit.data.PostClient;
import com.magdy.rxjavawithretrofit.pojo.Post;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<Post>> postsLiveData = new MutableLiveData<>();

    CompositeDisposable disposable= new CompositeDisposable();
    public void getPosts() {
        Observable observable = PostClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
       disposable.add(observable.subscribe(o-> postsLiveData.setValue((List<Post>) o) ,e-> Log.d("MyTag", "getPosts: "+ e)));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
