package android.coolweather.com.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2017/6/6.
 *
 */

public class Province extends DataSupport {
    private int id;
    private String provinceName;//记录省的名字
    private int provinceCode;//记录省的代号

    public String getProvinceName() {
        return provinceName;
    }

    public int getId() {
        return id;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public synchronized boolean save() {
        return super.save();
    }
}
