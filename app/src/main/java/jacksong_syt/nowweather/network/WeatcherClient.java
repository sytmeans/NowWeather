package jacksong_syt.nowweather.network;

import jacksong_syt.nowweather.bean.Weather;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by D on 2017/5/16.
 */

public interface WeatcherClient {
    @GET("v5")
    Call<Weather> getFeed(@Query("cityName") String cityName, @Query("key") String APP_KEY);
}
