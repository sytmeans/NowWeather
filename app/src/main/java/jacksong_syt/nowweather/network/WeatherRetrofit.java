package jacksong_syt.nowweather.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by D on 2017/5/16.
 */

public class WeatherRetrofit {
    public static final String BASE_URL = "https://free-api.heweather.com/v5/";
    public static final String APP_KEY = "48b2162a12174baa810542caec986429";

    private static WeatherClient client;
    private static Retrofit retrofit;

    static {
        Gson gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public WeatherClient getClient() {
        if (client == null) {
            client = retrofit.create(WeatherClient.class);
        }
        return client;
    }

}
