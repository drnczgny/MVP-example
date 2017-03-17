package com.example.adrian.mymvpexample.jsonplaceholder.interactor;

import android.util.Log;

import com.example.adrian.mymvpexample.jsonplaceholder.model.Post;
import com.example.adrian.mymvpexample.jsonplaceholder.service.PostService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public class PostInteractorImpl implements PostInteractor {

    private static final String TAG = PostInteractorImpl.class.getName();

    private Observer<List<Post>> postListObserver;
    private Observer<Post> postObserver;

    private PostService postService;

    public PostInteractorImpl(final PostService postService) {
        this.postService = postService;

        createPostListObserver();
        createPostObserver();
    }

    private void createPostListObserver() {
        Log.i(TAG, "createPostListObserver ...");

        postListObserver = new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Post> posts) {
                Log.i(TAG, "onNext");
                Log.i(TAG, posts.toString());
            }
        };
    }

    private void createPostObserver() {
        Log.i(TAG, "createPostObserver ...");

        postObserver = new Observer<Post>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Post post) {
                Log.i(TAG, "onNext");
                Log.i(TAG, post.toString());
            }
        };
    }

    @Override
    public void findAllPost() {
        postService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListObserver);
    }

    @Override
    public void findPostById(final int id) {
        postService.findPostById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postObserver);
    }

}