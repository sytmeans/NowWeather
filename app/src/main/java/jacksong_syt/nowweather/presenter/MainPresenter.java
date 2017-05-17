package jacksong_syt.nowweather.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import jacksong_syt.nowweather.bean.AQI;
import jacksong_syt.nowweather.bean.Basic;
import jacksong_syt.nowweather.bean.Forecast;
import jacksong_syt.nowweather.bean.Now;
import jacksong_syt.nowweather.bean.Suggestion;
import jacksong_syt.nowweather.bean.Weather;
import jacksong_syt.nowweather.iview.IMainInfoView;
import jacksong_syt.nowweather.network.WeatcherClient;
import jacksong_syt.nowweather.network.WeatherRetrofit;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static jacksong_syt.nowweather.network.WeatherRetrofit.APP_KEY;

/**
 * Created by D on 2017/5/16.
 */

public class MainPresenter extends MvpBasePresenter<IMainInfoView> {
    public final void setWeatherInfo(final String cityName){
        final IMainInfoView view = getView();
        if (view !=null){
            WeatherRetrofit retrofit = new WeatherRetrofit();
            WeatcherClient client =retrofit.getClient();
            final Call<Weather> call = client.getFeed(cityName,APP_KEY);
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Response<Weather> response, Retrofit retrofit) {

                    Weather weather = response.body();
                    Basic basic = weather.getBasic();
                    AQI aqi = weather.getAqi();
                    Now now = weather.getNow();
                    Now.More more = now.getMore();

                    Suggestion suggestion = weather.getSuggestion();



                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }
    }

}
