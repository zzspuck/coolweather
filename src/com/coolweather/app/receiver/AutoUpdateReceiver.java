package com.coolweather.app.receiver; 

import com.coolweather.app.service.AutoUpdateService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-29 上午12:37:02 
 * 类说明 
 */
public class AutoUpdateReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
Intent i=new Intent(context,AutoUpdateService.class);
		context.startService(i);
		
		
	}

}
 