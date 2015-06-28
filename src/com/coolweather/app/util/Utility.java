package com.coolweather.app.util; 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/** 
 * @author ���� E-mail: 
 * @version ����ʱ�䣺2015-6-27 ����5:23:05 
 * ��˵�� 
 */
public class Utility {

	
	/**
	 * @param coolWeatherDB
	 * @param response�����ʹ�����������ص�ʡ������
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
				//���������������ݴ洢��province��
				coolWeatherDB.saveProvince(province);
				}
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * @param coolWeatherDB
	 * @param response�����ʹ�����������ص��м���Ϣ
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
	 * @param response�����ʹ�����������ص��ؼ���Ϣ
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
	
	
	/**
	 * @param context�������������ص�JSON���ݣ����������������ݴ洢������
	 * @param response
	 */
	public static void handleWeatherResponse(Context context,String response){
		
		
		try {
			
			JSONObject jsonObject=new JSONObject(response);
			JSONObject weatherInfo=jsonObject.getJSONObject("weatherinfo");
			String cityName=weatherInfo.getString("city");
			String weatherCode=weatherInfo.getString("cityid");
			String temp1=weatherInfo.getString("temp1");
			String temp2 =weatherInfo.getString("temp2");
			String weatherDesp =weatherInfo.getString("weather");
			String publishTime =weatherInfo.getString("ptime");
			saveWeatherInfo(context,cityName,weatherCode,temp1,temp2,weatherDesp,publishTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**�����������ص�����������Ϣ�洢��sharedpreferences�ļ���
	 * @param context
	 * @param cityName
	 * @param weatherCode
	 * @param temp1
	 * @param temp2
	 * @param weatherDesp
	 * @param publishTime
	 */
	private static void saveWeatherInfo(Context context, String cityName,
			String weatherCode, String temp1, String temp2, String weatherDesp,
			String publishTime) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy��M��d��",Locale.CHINA);
	SharedPreferences.Editor editor=PreferenceManager
			.getDefaultSharedPreferences(context).edit();
	editor.putBoolean("city_selected", true);
	editor.putString("city_name", cityName);
	editor.putString("weather_code", weatherCode);
	editor.putString("temp1", temp1);
	editor.putString("temp2", temp2);
	editor.putString("weather_desp", weatherDesp);
	editor.putString("publish_time", publishTime);
	editor.putString("current_date", sdf.format(new Date()));
	editor.commit();
		
	}
	
}
 