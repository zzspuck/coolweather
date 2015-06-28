package com.coolweather.app.util; 
/** 
 * @author 作者 E-mail: 
 * @version 创建时间：2015-6-27 下午5:11:56 
 * 类说明 
 */
public interface HttpCallbackListener {

	void onFinish(String response);
	void onError (Exception e);
	
}
 