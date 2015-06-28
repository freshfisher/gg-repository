package chengfa.Activity03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class result extends Activity{
	//1.接受传递值
	//2.计算乘积
	//3.显示结果
	private TextView resultview = null;
	private Button   returnbutton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		resultview=(TextView)findViewById(R.id.calculateresult);
		returnbutton=(Button)findViewById(R.id.returnbutton);
		returnbutton.setText(R.string.returnbutton);
		Intent intent = getIntent();
		String factoronestr = intent.getStringExtra("one");
		String factortwostr = intent.getStringExtra("two");
		float factoroneint = Float.parseFloat(factoronestr);
		float factortwoint = Float.parseFloat(factortwostr);
		float result = factoroneint*factortwoint;
		resultview.setText(result + "");
		returnbutton.setOnClickListener(new returnListener());
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
			//finish();
			System.exit(0);
		}
	return super.onOptionsItemSelected(item);
}
class returnListener implements OnClickListener{

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent returnintent = new Intent();
		returnintent.setClass(result.this, Activity03.class);
		result.this.startActivity(returnintent);
	}
	
}

}
