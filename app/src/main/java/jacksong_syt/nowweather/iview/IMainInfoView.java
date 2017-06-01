package jacksong_syt.nowweather.iview;

import com.hannesdorfmann.mosby.mvp.MvpView;

import jacksong_syt.nowweather.bean.AQI;
import jacksong_syt.nowweather.bean.Basic;
import jacksong_syt.nowweather.bean.Forecast;
import jacksong_syt.nowweather.bean.Now;
import jacksong_syt.nowweather.bean.Suggestion;
import jacksong_syt.nowweather.bean.Weather;

/**
 * Created by D on 2017/5/16.
 */

public interface IMainInfoView extends MvpView {
    void getWeatherInfo(String cityName);

    void setAQIInfo(AQI aqi);
    void  setAQICityInfo(AQI.AQICity aqiCity);

    void setNowInfo(Now now);
    void setNowMoreInfo(Now.More nowMore);

    void setBasicInfo(Basic basic);
    void setUpdateInfo(Basic.Update update);

    void setSuggetsionInfo(Suggestion suggestion);
    void setComfortInfo(Suggestion.Comfort comfort);
    void setCarWashInfo(Suggestion.CarWash carWash);
    void setSportInfo(Suggestion.Sport sport);

    void setForecastInfo(Forecast forecast);
    void setTemperatureInfo(Forecast.Temperature temperature);
    void setForecastMoreInfo(Forecast.More forecastMore);

}
