package com.android.pooyesh.di;


import com.android.pooyesh.models.GetDataService;
import com.android.pooyesh.activity.MainActivity;
import com.android.pooyesh.models.Movie;
import com.android.pooyesh.activity.mainViewModel;
import java.util.List;
import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    public Retrofit RetrofitProvider() {

        return new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public Call<List<Movie>> movieCallProvider(Retrofit retrofit) {
        Call<List<Movie>> movieCall;
        movieCall = retrofit.create(GetDataService.class).getAllMovies();

        return movieCall;
    }

    @Provides
    public mainViewModel mainViewModelProvider(Retrofit retrofit, Call<List<Movie>> call ) {
        MainActivity mainActivity = new MainActivity();
        return new mainViewModel(retrofit, call, mainActivity);

    }
}
