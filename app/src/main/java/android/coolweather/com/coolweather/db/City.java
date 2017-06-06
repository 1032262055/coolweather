package android.coolweather.com.coolweather.db;

import DataSupport;

/**
 * Created by asus on 2017/6/6.
 */

public class City extends DataSupport {
    private int id;
    private String cityName;//记录城市名字
    private int cityCode;//记录城市代号
    private int provinceId;//记录当前市所属省的id值

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public void setId(int id) {
        this.id = id;
    }
}
