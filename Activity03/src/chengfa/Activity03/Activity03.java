package chengfa.Activity03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Activity03 extends Activity {
    /** Called when the activity is first created. */
	private EditText factorone=null;
	private EditText factortwo=null;
	private TextView symbol   =null;
	private Button   calculate=null;
	private Button   exitbutton=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        factorone=(EditText)findViewById(R.id.factorone);
        factortwo=(EditText)findViewById(R.id.factortwo);
        symbol   =(TextView)findViewById(R.id.symbol);
        calculate=(Button)findViewById(R.id.calculate);
        exitbutton=(Button)findViewById(R.id.exitbutton);
        symbol.setText(R.string.symbol);
        calculate.setText(R.string.calculate);
        exitbutton.setText(R.string.exit);
        calculate.setOnClickListener(new calculateListener());
        exitbutton.setOnClickListener(new exitListener());
        
    }
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 1, R.string.exit);
		menu.add(0, 2, 2, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	if(item.getItemId() == 1)
		{
			finish();
			//System.exit(0);
		}
	return super.onOptionsItemSelected(item);
}

class calculateListener implements OnClickListener{

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//取得两个控件的值
		String factoronestr = factorone.getText().toString();
		String factortwostr = factortwo.getText().toString();
		//将值放入Intent中
		Intent intent = new Intent();
		intent.putExtra("one", factoronestr);
		intent.putExtra("two", factortwostr);
		intent.setClass(Activity03.this, result.class);
		//启动StartActivity
		Activity03.this.startActivity(intent);
	}
}
class exitListener implements OnClickListener{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
}
}