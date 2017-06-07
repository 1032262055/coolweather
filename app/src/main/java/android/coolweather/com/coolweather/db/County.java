package android.coolweather.com.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2017/6/6.
 */

public class County extends DataSupport {
    private int id;
    private String countyName;//记录县的名字
    private String weatherId;//记录县所对应的的天气
    private int cityId;//记录当前县所属市的id值

    public int getId() {
        return id;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Override
    public synchronized boolean save() {
        return super.save();
    }
}
