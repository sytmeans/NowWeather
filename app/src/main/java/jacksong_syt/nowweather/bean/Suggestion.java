package jacksong_syt.nowweather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by D on 2017/5/16.
 */
public class Suggestion {
    @SerializedName("comf")
    private Comfort comfort;

    @SerializedName("cw")
    private CarWash carWash;

    private Sport sport;


    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    public CarWash getCarWash() {
        return carWash;
    }

    public void setCarWash(CarWash carWash) {
        this.carWash = carWash;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    private class Comfort {
        @SerializedName("txt")
        private String comfortInfo;

        public String getComfortInfo() {
            return comfortInfo;
        }

        public void setComfortInfo(String comfortInfo) {
            this.comfortInfo = comfortInfo;
        }
    }

    private class CarWash {
        @SerializedName("txt")
        private String carWashInfo;

        public String getCarWashInfo() {
            return carWashInfo;
        }

        public void setCarWashInfo(String carWashInfo) {
            this.carWashInfo = carWashInfo;
        }
    }

    private class Sport {
        @SerializedName("txt")
        private String SportInfo;

        public String getSportInfo() {
            return SportInfo;
        }

        public void setSportInfo(String sportInfo) {
            SportInfo = sportInfo;
        }
    }
}
