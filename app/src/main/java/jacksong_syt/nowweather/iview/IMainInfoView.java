package jacksong_syt.nowweather.iview;

import com.hannesdorfmann.mosby.mvp.MvpView;

import jacksong_syt.nowweather.bean.Weather;

/**
 * Created by D on 2017/5/16.
 */

public interface IMainInfoView extends MvpView {
    void getWeatherInfo(Weather weather);

    void getAqi(Weather.HeWeather5Bean.AqiBean aqiBean);
    void getLocation(Weather.HeWeather5Bean.BasicBean basicBean);
    void getDetailInfo(Weather.HeWeather5Bean.DailyForecastBean dailyForecastBean);
    void  getHourlyInfo(Weather.HeWeather5Bean.HourlyForecastBean hourlyForecastBean);

}
