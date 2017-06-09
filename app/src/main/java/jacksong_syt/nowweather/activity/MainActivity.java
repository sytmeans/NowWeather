package jacksong_syt.nowweather.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacksong_syt.nowweather.R;
import jacksong_syt.nowweather.bean.Weather;
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

    @BindView(R.id.toolbarCityName)
    TextView toolbarCityName;
    @BindView(R.id.now_weather_info)
    TextView nowWeather;
    @BindView(R.id.tempeater)
    TextView tempeater;
    @BindView(R.id.air_quilaity)
    TextView airQuilaity;
    @BindView(R.id.update_time)
    TextView updateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setSubtitle("");
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        initToolBar();
        initSwipeRefresh();
        initNavigation();


    }

    private void initNavigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initSwipeRefresh() {
        swipeRefresh.setColorSchemeResources(R.color.blue);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    private void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
    }

    private void refreshContent() {
        getPresenter().setWeatherInfo("上海");


        swipeRefresh.setRefreshing(false);

        //开线程进行刷新。其实没必要。swipeRefreshLayout已经进行线程刷新。
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        tempeater.setText("27 ℃");
////                        toolbarCityName.setText("北京");
////                        nowWeather.setText("多云");
////                        airQuilaity.setText("轻度污染");
////                        updateTime.setText("21:00 刷新");
//                        getPresenter().setWeatherInfo("上海");
//
//
//                        swipeRefresh.setRefreshing(false);
//                    }
//                });
//            }
//        }).start();
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
    public void getWeatherInfo(Weather weather) {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void getAqi(Weather.HeWeather5Bean.AqiBean aqiBean) {
        airQuilaity.setText(aqiBean.getCity().getQlty() + aqiBean.getCity().getAqi());

    }

    @Override
    public void getLocation(Weather.HeWeather5Bean.BasicBean basicBean) {
        toolbarCityName.setText(basicBean.getCity());
    }

    @Override
    public void getDetailInfo(Weather.HeWeather5Bean.DailyForecastBean dailyForecastBean) {
        nowWeather.setText(dailyForecastBean.getCond().getTxt_d());

    }

    @Override
    public void getHourlyInfo(Weather.HeWeather5Bean.HourlyForecastBean hourlyForecastBean) {
        tempeater.setText(hourlyForecastBean.getTmp()+" ℃");
        updateTime.setText(hourlyForecastBean.getDate());
    }


}
