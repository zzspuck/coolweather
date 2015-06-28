package com.coolweather.app.db; 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/** 
 * @author ���� E-mail: 
 * @version ����ʱ�䣺2015-6-26 ����12:11:27 
 * ��˵�� 
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	/**
	 * province �������
	 */
	public static final String CREATE_PROVINCE="create table province("
	 +" id integer primary key autoincrement,"
	 +" province_name text,"
	 +" province_code text)";
	
	/**
	 * city�������
	 */
	public static final String CREATE_CITY="create table city("
	 +" id integer primary key autoincrement,"
	 +" city_name text,"
	 +" city_code text,"
	 +" province_id integer )";
	/**
	 * county�������
	 */
	public static final String CREATE_COUNTY="create table county("
	 +" id integer primary key autoincrement,"
	 +" county_name text,"
	 +" county_code text ,"
	 +" city_id integer)";
	
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
db.execSQL(CREATE_PROVINCE);//����province��
db.execSQL(CREATE_CITY);//����city��
db.execSQL(CREATE_COUNTY);//����county��
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
 