package com.shangchi.TempControl;

import java.text.SimpleDateFormat;

import com.shangchi.TempControl.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.format.Time;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	 
	TextView tvTime;
	private boolean isSwith1 = false;
	private boolean isSwith2 = false;
	private boolean isSwith3 = false;
	private boolean isSwith4 = false;
	Handler handler=new Handler(){  
	    public void handleMessage(Message msg) {  
	        // 要做的事情  
	        //要做的事情  
		    Time time = new Time();       
	        time.setToNow();      
	        int year = time.year;      
	        int month = time.month+1;      
	        int day = time.monthDay;      
	        int minute = time.minute;      
	        int hour = time.hour;
	        int sec = time.second;
	        tvTime.setText(     year +       
	                            "年" + month +       
	                            "月" + day +       
	                            "日" +   
	                            " " + hour +
	                            ":" + (minute>=10? minute: "0" + minute)+
	                            ":" + (sec>=10? sec: "0" + sec));  
	    }  
	};  

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		initListView();
		new Thread(new MyThread()).start(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	public class MyThread implements Runnable {  
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        while (true) {  
	            try {  
	                Thread.sleep(1000);// 线程暂停10秒，单位毫秒  
	                Message message = new Message();  
	                message.what = 1;  
	                handler.sendMessage(message);// 发送消息  
	            } catch (InterruptedException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	}  	
	private void initListView() {
	    tvTime = (TextView)findViewById(R.id.time);
	    Time time = new Time();       
        time.setToNow();      
        int year = time.year;      
        int month = time.month+1;      
        int day = time.monthDay;      
        int minute = time.minute;      
        int hour = time.hour;
        int sec = time.second;
        tvTime.setText(     year +       
                            "年" + month +       
                            "月" + day +       
                            "日" +   
                            " " + (hour>=10? hour: "0" + hour) +
                            ":" + (minute>=10? minute: "0" + minute)+
                            ":" + (sec>=10? sec: "0" + sec));    
        
		final TextView temproom1 = (TextView)findViewById(R.id.tempRoom1);         
        SpannableString styledTextroom1 = new SpannableString("1号温室");  
        styledTextroom1.setSpan(new TextAppearanceSpan(this, R.style.style2), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        temproom1.setText(styledTextroom1, TextView.BufferType.SPANNABLE);
        
		final TextView temproom2 = (TextView)findViewById(R.id.tempRoom2);         
        SpannableString styledTextroom2 = new SpannableString("2号温室");  
        styledTextroom2.setSpan(new TextAppearanceSpan(this, R.style.style2), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        temproom2.setText(styledTextroom2, TextView.BufferType.SPANNABLE);

		final TextView co21 = (TextView)findViewById(R.id.CO21);         
        SpannableString styledText = new SpannableString("CO2  ：340ppm");  
        styledText.setSpan(new TextAppearanceSpan(this, R.style.style0), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        styledText.setSpan(new TextAppearanceSpan(this, R.style.style1), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        styledText.setSpan(new TextAppearanceSpan(this, R.style.style0), 5, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); 
        co21.setText(styledText, TextView.BufferType.SPANNABLE);  
        
		final TextView co22 = (TextView)findViewById(R.id.CO22);         
        SpannableString styledText2 = new SpannableString("CO2  ：321ppm");  
        styledText2.setSpan(new TextAppearanceSpan(this, R.style.style0), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        styledText2.setSpan(new TextAppearanceSpan(this, R.style.style1), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  
        styledText2.setSpan(new TextAppearanceSpan(this, R.style.style0), 5, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); 
        co22.setText(styledText2, TextView.BufferType.SPANNABLE);  

        
        final TextView onoff1 = (TextView)findViewById(R.id.onoff1); 
        final TextView onoff2 = (TextView)findViewById(R.id.onoff2); 
        final TextView onoff3 = (TextView)findViewById(R.id.onoff3); 
        final TextView onoff4 = (TextView)findViewById(R.id.onoff4); 
        
	    final ImageButton btnSwitch1 = (ImageButton)findViewById(R.id.switch1);

	    btnSwitch1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isSwith1){
				btnSwitch1.setImageResource(R.drawable.jiare_2);
				onoff1.setText("开启");
				}else{
					btnSwitch1.setImageResource(R.drawable.jiare_1);
					onoff1.setText("关闭");
				}
				isSwith1 = !isSwith1;
			}
		});
	    final ImageButton btnSwitch2 = (ImageButton)findViewById(R.id.switch2);

	    btnSwitch2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isSwith2){
				btnSwitch2.setImageResource(R.drawable.tongfeng_2);
				onoff2.setText("开启");
				}else{
					btnSwitch2.setImageResource(R.drawable.tongfeng_1);
					onoff2.setText("关闭");
				}
				isSwith2 = !isSwith2;
			}
		});
	    final ImageButton btnSwitch3 = (ImageButton)findViewById(R.id.switch3);

	    btnSwitch3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isSwith3){
				btnSwitch3.setImageResource(R.drawable.zhileng_2);
				onoff3.setText("开启");
				}else{
					btnSwitch3.setImageResource(R.drawable.zhileng_1);
					onoff3.setText("关闭");
				}
				isSwith3 = !isSwith3;
			}
		});
	    final ImageButton btnSwitch4 = (ImageButton)findViewById(R.id.switch4);

	    btnSwitch4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!isSwith4){
				btnSwitch4.setImageResource(R.drawable.buguang_2);
				onoff4.setText("开启");
				}else{
					btnSwitch4.setImageResource(R.drawable.buguang_1);
					onoff4.setText("关闭");
				}
				isSwith4 = !isSwith4;
			}
		});
	}
}
