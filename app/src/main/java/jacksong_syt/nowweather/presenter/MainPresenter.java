package jacksong_syt.nowweather.presenter;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import jacksong_syt.nowweather.bean.Weather;
import jacksong_syt.nowweather.iview.IMainInfoView;
import jacksong_syt.nowweather.network.WeatherClient;
import jacksong_syt.nowweather.network.WeatherRetrofit;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static jacksong_syt.nowweather.network.WeatherRetrofit.APP_KEY;


/**
*
*@author JackSong
*@email sytmeaning@gmail.com
*create at 2017/5/17 21:33
*/

public class MainPresenter extends MvpBasePresenter<IMainInfoView> {
    public final void setWeatherInfo(final String cityName) {
        final IMainInfoView view = getView();
        if (view != null) {
            WeatherRetrofit retrofit = new WeatherRetrofit();
            WeatherClient client = retrofit.getClient();
            final Call<Weather> call = client.getFeed(cityName, APP_KEY);
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Response<Weather> response, Retrofit retrofit) {
                    Log.e("onResponse:------> ",response.body().toString());

                    Weather weather = response.body();
                    Log.e("onResponse:body===",weather.toString());




                    view.getWeatherInfo(weather);
                    view.getAqi(weather.getHeWeather5().get(0).getAqi());
                    view.getLocation(weather.getHeWeather5().get(0).getBasic());
                    view.getDetailInfo(weather.getHeWeather5().get(0).getDaily_forecast().get(0));
                    view.getHourlyInfo(weather.getHeWeather5().get(0).getHourly_forecast().get(0));

                }

                @Override
                public void onFailure(Throwable t) {


                }
            });
        }else {
            Log.e("View", "== null ");
        }
    }

}
