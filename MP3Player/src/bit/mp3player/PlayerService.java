package bit.mp3player;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayerService extends Service{
	ControlReceiver cr;
	MediaPlayer player;
	int status=1;//1:尚未播放 2：正在播放 3：暂停
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		cr=new ControlReceiver();
		IntentFilter intentFilter=new IntentFilter("mp3.control");
		this.registerReceiver(cr, intentFilter);
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		this.unregisterReceiver(cr);
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		if(startId>1){
			intent=new Intent("pic.update");
			intent.putExtra("update", status);
			sendBroadcast(intent);
		}
		super.onStart(intent, startId);
	}
	public class ControlReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			int action=arg1.getIntExtra("action", 0);
			if(action==1){
				if(status==1){
					player=MediaPlayer.create(PlayerService.this, R.raw.pp);
					player.start();
					status=2;
					sendUpdate();
				}
				else if(status==2){
					player.pause();
					status=3;
					sendUpdate();
				}
				else if(status==3){
					player.start();
					status=2;
					sendUpdate();
				}
			}
			if(action==2){
				if(status==2||status==3){
					player.stop();
					status=1;
					sendUpdate();
				}
			}
		}
	public void sendUpdate(){
		Intent intent=new Intent("pic.update");
		intent.putExtra("update", status);
		sendBroadcast(intent);
	}	
	}
}
