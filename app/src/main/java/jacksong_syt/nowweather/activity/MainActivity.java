package jacksong_syt.nowweather.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacksong_syt.nowweather.R;
import jacksong_syt.nowweather.bean.AQI;
import jacksong_syt.nowweather.bean.Basic;
import jacksong_syt.nowweather.bean.Forecast;
import jacksong_syt.nowweather.bean.Now;
import jacksong_syt.nowweather.bean.Suggestion;
import jacksong_syt.nowweather.iview.IMainInfoView;
import jacksong_syt.nowweather.presenter.MainPresenter;


/**
 * @author JackSong
 * @email sytmeaning@gmail.com
 * create at 2017/5/13 21:06
 */


public class MainActivity extends MvpActivity<IMainInfoView, MainPresenter> implements IMainInfoView {


    //test for butternife
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    //MainView Butternife
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
//    @BindView(R.id.weather_layout)
//    ScrollView scrollView;
//    @BindView(R.id.title_city)
//    TextView titleCity;
//    @BindView(R.id.title_update_time)
//    TextView titleUpDateTime;
//    @BindView(R.id.degree_text)
//    TextView degreeText;
//    @BindView(R.id.weather_info_text)
//    TextView wetherInfoText;
//    @BindView(R.id.forecast_layout)
//    LinearLayout forecastLayout;
//    @BindView(R.id.aqi_text)
//    TextView aqiText;
//    @BindView(R.id.pm_25)
//    TextView pm25;
//    @BindView(R.id.comfort_text)
//    TextView comfortText;
//    @BindView(R.id.car_wash_text)
//    TextView carWashText;
//    @BindView(R.id.sport_text)
//    TextView sprotText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setSubtitle("");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.setting:
                Toast.makeText(this, "you click setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shareWeather:
                Toast.makeText(this, "you click sharea", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bg_View:
                Toast.makeText(this, "you click bg", Toast.LENGTH_SHORT).show();
            case R.id.close:
                Toast.makeText(this, "you click close ", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void getWeatherInfo(String cityName) {

    }

    @Override
    public void setAQIInfo(AQI aqi) {

    }

    @Override
    public void setAQICityInfo(AQI.AQICity aqiCity) {
//        aqiText.setText(aqiCity.getAqi());
//        pm25.setText(aqiCity.getPm25());

    }

    @Override
    public void setNowInfo(Now now) {
//        degreeText.setText(now.getTemperature());
        //getWeatherInfo(now.get);

    }

    @Override
    public void setNowMoreInfo(Now.More nowMore) {

    }

    @Override
    public void setBasicInfo(Basic basic) {

    }

    @Override
    public void setUpdateInfo(Basic.Update update) {

    }

    @Override
    public void setSuggetsionInfo(Suggestion suggestion) {

    }

    @Override
    public void setComfortInfo(Suggestion.Comfort comfort) {
//        comfortText.setText(comfort.getComfortInfo());

    }

    @Override
    public void setCarWashInfo(Suggestion.CarWash carWash) {
//        carWashText.setText(carWash.getCarWashInfo());
    }

    @Override
    public void setSportInfo(Suggestion.Sport sport) {
//        sprotText.setText("运动建议: "+sport.getSportInfo());
    }

    @Override
    public void setForecastInfo(Forecast forecast) {

    }

    @Override
    public void setTemperatureInfo(Forecast.Temperature temperature) {

    }

    @Override
    public void setForecastMoreInfo(Forecast.More forecastMore) {

    }


}
