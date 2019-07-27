package com.xuyang.handlersource;

public class HandlerTest {
	public static void main(String[] args) {


        //1，主线程的Looper对象自动生成，不需手动生成；而子线程的Looper对象则需手动通过Looper.prepare()创建
        //2，在子线程若不手动创建Looper对象 则无法生成Handler对象
		Looper.prepare();

        ActivityThread thread = new ActivityThread();
        thread.attach(false);

        Looper.loop();
	}
}
