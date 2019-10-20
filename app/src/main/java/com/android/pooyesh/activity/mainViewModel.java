package com.android.pooyesh.activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.pooyesh.models.Movie;
import com.android.pooyesh.MyAPP;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class mainViewModel extends ViewModel {

 Retrofit retrofit;
 MainActivity mainActivity;
 Call<List<Movie>> listCall;

 MutableLiveData<List<Movie>> DataResponse = new MutableLiveData<>();

    @Inject
    public mainViewModel(Retrofit retrofit, Call<List<Movie>> listCall, MainActivity mainActivity) {
        this.retrofit = retrofit;
        this.listCall = listCall;
        this.mainActivity = mainActivity;

    }


    public void GetMovieData() {

        MyAPP.getComponent().InjectRetrofit(mainActivity);
        MyAPP.getComponent().InjectCallMovie(mainActivity);


        listCall.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, final Response<List<Movie>> response) {

                if (response.isSuccessful()) {

                    try {

                        DataResponse.setValue(response.body());

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });

    }
}
