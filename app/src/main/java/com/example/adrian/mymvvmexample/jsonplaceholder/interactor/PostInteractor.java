package com.example.adrian.mymvvmexample.jsonplaceholder.interactor;

/**
 * Created by Adrian_Czigany on 3/8/2017.
 */

public interface PostInteractor {

    public void findAllPost();

    public void findPostById(final int  id);
}
