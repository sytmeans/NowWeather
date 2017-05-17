package jacksong_syt.nowweather.iview;

import com.hannesdorfmann.mosby.mvp.MvpView;

import jacksong_syt.nowweather.bean.Weather;

/**
 * Created by D on 2017/5/16.
 */

public interface IMainInfoView extends MvpView {
    void setAQIInfo(Weather weather);

    void setNowInfo(Weather weather);

    void setBasicInfo(Weather weather);

    void setSuggetsionInfo(Weather weather);

    void setForecastInfo(Weather weather);
}
