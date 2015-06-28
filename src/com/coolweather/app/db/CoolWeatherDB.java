package com.coolweather.app.db; 

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-27 上午1:12:08 
 * 类说明 
 */
public class CoolWeatherDB {
/**
 * 数据库名
 */
public static final String DB_NAME="cool_weather";

/**
 * 数据库版本
 */
public static final int VERSION=1;
private static CoolWeatherDB coolWeatherDB;
private SQLiteDatabase db;

/**
 * @param context将构造方法私有化
 */
private CoolWeatherDB(Context context){
	CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
	
	db=dbHelper.getWritableDatabase();
}
/**
 * @param context获取coolweather的实例
 * @return
 */
public synchronized static CoolWeatherDB getInstance(Context context){
	
	if (coolWeatherDB==null) {
		coolWeatherDB=new CoolWeatherDB(context);
	}
	return coolWeatherDB;
}
/**
 * @param province将province实例存储到数据库
 */
public void saveProvince(Province province){
	if (province !=null) {
		ContentValues values=new ContentValues();
		values.put("province_name", province.getProvinceName());
		values.put("province_code", province.getProvinceCode());
		db.insert("Province", null, values);
		
	}
	
	
}
/**
 * @return从数据库读取全国所有省份信息
 */
public List<Province> loadProvinces(){
	
	List<Province> list =new ArrayList<Province>();
	Cursor cursor=db
			.query("province", null, null, null, null, null, null, null);
	if (cursor.moveToFirst()) {
		do {
			Province province=new Province();
			province.setId(cursor.getInt(cursor.getColumnIndex("id")));
			province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
			province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
			
			
			list.add(province);
			
		} while (cursor.moveToNext());
		
		
		
	}
	return list;
}

/**
 * @param city将city实例存储到数据库
 */
public void savaCity(City city){
	if (city!=null) {
		ContentValues values=new ContentValues();
		values.put("city_name", city.getCityName());
		values.put("city_code", city.getCityCode());
		values.put("province_id", city.getProvinceId());
		db.insert("city", null, values);
		
	}
	
}

/**
 * @param provinceId从数据库读取某城市下所有的城市信息
 * @return
 */
public List<City> loadCities(int provinceId){
	
	List<City> list=new ArrayList<City>();
	Cursor cursor=db
			.query("city", null,"province_id=?", new String[]{String.valueOf(provinceId)}, null, null, null);
	
	if (cursor.moveToFirst()) {
		do {
			City city=new City();
			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
			city.setProvinceId(provinceId);
			list.add(city);
		} while (cursor.moveToNext());
		
	}
	return list;
}

/**
 * @param county 将county实例加入数据库
 */
public void saveCounty(County county){
	if (county !=null) {
		ContentValues values =new ContentValues();
		values.put("county_name", county.getCountyName());
		values.put("county_code", county.getCountyCode());
		values.put("city_id", county.getCityId());
		db.insert("county", null, values);
		
	}
}

/**
 * @param cityId从数据库中读取某城市下所有县的信息
 * @return
 */
public List<County> loadCounties (int cityId){
	List<County> list=new ArrayList<County>();
	Cursor cursor=db
			.query("county", null, "city_id=?", new String[]{String.valueOf(cityId)}, null, null, null);
	
	if (cursor.moveToFirst()) {
		
		do {
			County county=new County();
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
			county.setCityId(cityId);
			list.add(county);
			
		} while (cursor.moveToNext());
		
	}
	return list;
}
}
 