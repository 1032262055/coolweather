package android.coolweather.com.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus on 2017/6/7.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("lv")
    public String love;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
