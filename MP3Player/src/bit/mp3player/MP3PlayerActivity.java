package bit.mp3player;

import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MP3PlayerActivity extends Activity {
    
	
	/** Called when the activity is first created. */
    private ImageButton ib1=null;
    private ImageButton ib2=null;
    UpdateReceiver ur;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ib1=(ImageButton)findViewById(R.id.ib1);
        ib2=(ImageButton)findViewById(R.id.ib2);
        OnClickListener cl=new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent("mp3.control");
				if(v==ib1) intent.putExtra("action", 1);
				if(v==ib2) intent.putExtra("action", 2);
				sendBroadcast(intent);
			}};
			ib1.setOnClickListener(cl);
			ib2.setOnClickListener(cl);
			Intent intent=new Intent(MP3PlayerActivity.this,PlayerService.class);
			this.startService(intent);
			ur=new UpdateReceiver();
			IntentFilter filter=new IntentFilter("pic.update");
			this.registerReceiver(ur, filter);
    }
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
    	this.unregisterReceiver(ur);
		super.onDestroy();
	}
    public class UpdateReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			int update=intent.getIntExtra("update", 0);
			if(update==1||update==3){
				ib1.setImageResource(R.drawable.png2);
			}
			if(update==2){
				ib1.setImageResource(R.drawable.png3);
			}
		}}
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem mi=menu.add(0, Menu.FIRST, 0, "退出");
		mi.setIcon(android.R.drawable.ic_menu_delete);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==Menu.FIRST){
			showDialog(1);
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if(id!=1) return null;
		Builder builder=new AlertDialog.Builder(this);
		builder.setMessage("您确定退出吗？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MP3PlayerActivity.this,PlayerService.class);
				stopService(intent);
				System.exit(0);
			}});
		builder.setNegativeButton("取消", null);
		return builder.create();
	}
}