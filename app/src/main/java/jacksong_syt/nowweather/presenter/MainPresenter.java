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
            WeatcherClient client = retrofit.getClient();
            final Call<Weather> call = client.getFeed("北京", APP_KEY);
            call.enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Response<Weather> response, Retrofit retrofit) {

                    Weather weather = response.body();

                    Basic basic = weather.getBasic();
                    Basic.Update update = basic.getUpdate();

                    AQI aqi = weather.getAqi();
                    AQI.AQICity aqiCity = aqi.getCity();


                    Now now = weather.getNow();
                    Now.More nowMore = now.getMore();


                    Suggestion suggestion = weather.getSuggestion();
                    Suggestion.Comfort comfort = suggestion.getComfort();
                    Suggestion.CarWash carWash = suggestion.getCarWash();
                    Suggestion.Sport sport = suggestion.getSport();

                    //Forecast forecast =weather.getForecastList();

                    for (int i = 0; i < weather.getForecastList().size(); i++) {
                        Forecast forecast = weather.getForecastList().get(i);
                        view.setForecastInfo(forecast);

                        Forecast.More forecastMore = forecast.getMore();
                        view.setForecastMoreInfo(forecastMore);
                        Forecast.Temperature temperature = forecast.getTemperature();
                        view.setTemperatureInfo(temperature);
                    }

                    view.getWeatherInfo(cityName);

                    view.setBasicInfo(basic);
                    view.setUpdateInfo(update);

                    view.setAQIInfo(aqi);
                    view.setAQICityInfo(aqiCity);

                    view.setNowInfo(now);
                    view.setNowMoreInfo(nowMore);

                    view.setSuggetsionInfo(suggestion);
                    view.setComfortInfo(comfort);
                    view.setCarWashInfo(carWash);
                    view.setSportInfo(sport);





                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }
    }

}
