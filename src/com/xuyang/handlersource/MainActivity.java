package com.xuyang.handlersource;

public class MainActivity extends Activity {
    private TextView mTextView;


    //主线程
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            mTextView.setText((String) msg.obj);
            System.out.println("线程名称2：" + Thread.currentThread());
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate 执行了");
        mTextView = findViewById(R.id.text_view);


        //子线程
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名称1：" + Thread.currentThread());

                Message message = new Message();
                message.obj = "后台数据";
                mHandler.sendMessage(message);
            }

            ;
        }.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume ִ执行了");
    }
}
