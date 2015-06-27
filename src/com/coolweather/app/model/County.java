package com.coolweather.app.model;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-27 上午1:04:18 
 * 类说明 
 */
public class County {
private int id;
private String countyName;
private String countyCode;
private int cityId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCountyName() {
	return countyName;
}
public void setCountyName(String countyName) {
	this.countyName = countyName;
}
public String getCountyCode() {
	return countyCode;
}
public void setCountyCode(String countyCode) {
	this.countyCode = countyCode;
}
public int getCityId() {
	return cityId;
}
public void setCityId(int cityId) {
	this.cityId = cityId;
}

}
 