package jacksong_syt.nowweather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by D on 2017/5/16.
 */
public class Now {

    @SerializedName("cond")
    private More more;

    @SerializedName("tmp")
    private String temperature;


    public More getMore() {
        return more;
    }

    public void setMore(More more) {
        this.more = more;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public  class More {
        @SerializedName("code")
        private String imageCode;

        @SerializedName("txt")
        private String info;


        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getImageCode() {
            return imageCode;
        }

        public void setImageCode(String imageCode) {
            this.imageCode = imageCode;
        }
    }


}

