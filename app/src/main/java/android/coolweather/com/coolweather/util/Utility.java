package android.coolweather.com.coolweather.util;

import android.coolweather.com.coolweather.db.City;
import android.coolweather.com.coolweather.db.County;
import android.coolweather.com.coolweather.db.Province;
import android.coolweather.com.coolweather.gson.Weather;
import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asus on 2017/6/6.
 */

/**
 * 解析和处理服务器返回的省级数据
 */
public class Utility {
    public static boolean handProvinceResponse(String reponse){
        if (!TextUtils.isEmpty(reponse)){
            try {
                JSONArray allProvinces = new JSONArray(reponse);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handCityResponse(String reponse,int provinceId){
        if (!TextUtils.isEmpty(reponse)){
            try{
                JSONArray allCities = new JSONArray(reponse);
                for (int i=0;i < allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City  city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
/**
 * 解析和处理服务器返回的县级数据
 */
public static boolean handCountResponse(String reponse,int cityId){
    if(!TextUtils.isEmpty(reponse)){
        try{
            JSONArray allCounties = new JSONArray(reponse);
            for(int i = 0;i < allCounties.length();i++){
                JSONObject countyObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
    return false;
}

    /**
     * 将返回的JSON数据解析成Weather实体类
     * @param response
     * @return
     */
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
