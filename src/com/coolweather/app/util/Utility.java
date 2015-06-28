package com.coolweather.app.util; 

import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-27 下午5:23:05 
 * 类说明 
 */
public class Utility {

	
	/**
	 * @param coolWeatherDB
	 * @param response解析和处理服务器返回的省级数据
	 * @return
	 */
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB
			coolWeatherDB,String response){
		
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces=response.split(",");
			if (allProvinces !=null&&allProvinces.length>0) {
				
				for(String p : allProvinces){
				String[] array=p.split("\\|");
				Province province =new Province();
				province.setProvinceCode(array[0]);
				province.setProvinceName(array[1]);
				//将解析出来的数据存储到province表
				coolWeatherDB.saveProvince(province);
				}
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * @param coolWeatherDB
	 * @param response解析和处理服务器返回的市级信息
	 * @param provinceId
	 * @return
	 */
	public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
		
		if (!TextUtils.isEmpty(response)) {
			String [] allCities=response.split(",");
			if (allCities!=null&&allCities.length>0) {
				
				for (String c:allCities) {
					String[] array=c.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					coolWeatherDB.savaCity(city);
				}
				return true;
			}
			
			
		}
		return false;
	}
	/**
	 * @param coolWeatherDB
	 * @param response解析和处理服务器返回的县级信息
	 * @param cityId
	 * @return
	 */
	public static boolean handlerCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
		
		
		if (!TextUtils.isEmpty(response)) {
			String [] allCounties=response.split(",");
			if (allCounties!=null&&allCounties.length>0) {
				for (String c:allCounties) {
					String[]array=c.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
			
		}
		return false;
	}
	
}
 