package jacksong_syt.nowweather.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by D on 2017/5/16.
 */

public class WeatherRetrofit {
    public static final String BASE_URL = "https://free-api.heweather.com/";
    public static final String APP_KEY = "48b2162a12174baa810542caec986429";

    private static WeatcherClient client;
    private static Retrofit retrofit;

    static {
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public WeatcherClient getClient() {
        if (client == null) {
            client = retrofit.create(WeatcherClient.class);
        }
        return client;
    }

}
