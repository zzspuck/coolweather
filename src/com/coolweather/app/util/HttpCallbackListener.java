package com.coolweather.app.util; 
/** 
 * @author ���� E-mail: 
 * @version ����ʱ�䣺2015-6-27 ����5:11:56 
 * ��˵�� 
 */
public interface HttpCallbackListener {

	void onFinish(String response);
	void onError (Exception e);
	
}
 