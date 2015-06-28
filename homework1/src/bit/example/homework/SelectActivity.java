/**
 * 
 */
package bit.example.homework;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class SelectActivity extends Activity {
	private int mNameIndex;
	private TextView tvName;
	private Button bZhenXinHua;
	private Button bDaMaoXian;
	private ListDataUtils dataList;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        dataList = ListDataUtils.getInstance();
        tvName = (TextView) findViewById(R.id.tvName);
        bZhenXinHua = (Button)findViewById(R.id.bZhenXinHua);
        bDaMaoXian = (Button)findViewById(R.id.bDaMaoXian);
        
        Random rd = new Random(System.currentTimeMillis());
        mNameIndex = rd.nextInt(dataList.mNameList.size());
        tvName.setText(dataList.mNameList.get(mNameIndex));
        bZhenXinHua.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SelectActivity.this, ZhenDaActivity.class);
				//真心话Type为0
				i.putExtra("Type", 0);
				i.putExtra("NameIndex", mNameIndex);
				SelectActivity.this.startActivity(i);
				SelectActivity.this.finish();
			}
        	
        });
        bDaMaoXian.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SelectActivity.this, ZhenDaActivity.class);
				//大冒险Type为1
				i.putExtra("Type", 1);
				i.putExtra("NameIndex", mNameIndex);
				SelectActivity.this.startActivity(i);
				SelectActivity.this.finish();
			}
        	
        });
    }
}
