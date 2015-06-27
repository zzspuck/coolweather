package com.coolweather.app.model; 

import android.R.integer;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-26 下午10:27:13 
 * 类说明 
 */
public class City {
private int id;
private String cityName;
private String cityCode;
private int provinceId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getCityCode() {
	return cityCode;
}
public void setCityCode(String cityCode) {
	this.cityCode = cityCode;
}
public int getProvinceId() {
	return provinceId;
}
public void setProvinceId(int provinceId) {
	this.provinceId = provinceId;
}
}
 