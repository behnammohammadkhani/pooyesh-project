package com.android.pooyesh.di;


import com.android.pooyesh.activity.MainActivity;

@dagger.Component(modules = {NetworkModule.class})
public interface Component {

    void InjectRetrofit(MainActivity mainActivity);
    void InjectCallMovie(MainActivity mainActivity);
    void InjectMainViewModel(MainActivity mainActivity);

}
