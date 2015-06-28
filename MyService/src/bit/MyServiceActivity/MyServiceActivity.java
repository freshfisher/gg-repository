package bit.MyServiceActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MyServiceActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void startAService(View view){
    	Intent intent = new Intent(MyServiceActivity.this,MyService02.class);
    	this.startService(intent);
    }
    public void stopAService(View view){
    	Intent intent = new Intent(MyServiceActivity.this,MyService02.class);
    	this.stopService(intent);
    }
    ServiceConnection con=new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}   	
    };
    public void bindAService(View view){
    	Intent intent = new Intent(MyServiceActivity.this,MyService02.class);
    	this.bindService(intent,con,BIND_AUTO_CREATE);
    }
    public void unbindAService(View view){
    	this.unbindService(con);
    }
}