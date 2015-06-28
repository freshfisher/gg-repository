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
public class ZhenDaActivity extends Activity {
	private ListDataUtils dataList;
	
	private int mNameIndex;
	private int mDataIndex;
	private int mType;
	private TextView tvName;
	private TextView tvContent;
	private Button bContinue;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhen_da);
        Bundle bundle = this.getIntent().getExtras();  
        mNameIndex = bundle.getInt("NameIndex");
        mType = bundle.getInt("Type");
        dataList = ListDataUtils.getInstance();
        
        tvName = (TextView)findViewById(R.id.tvName);
        tvContent = (TextView)findViewById(R.id.tvContent);
        bContinue = (Button)findViewById(R.id.bContinue);
        
        tvName.setText(dataList.mNameList.get(mNameIndex));
        
        Random rd = new Random(System.currentTimeMillis());
        switch (mType){
        case 0:
        	mDataIndex = rd.nextInt(dataList.mZhenXinHua.size());
        	tvContent.setText(dataList.mZhenXinHua.get(mDataIndex));
        	break;
        case 1:
        	mDataIndex = rd.nextInt(dataList.mDaMaoXian.size());
        	tvContent.setText(dataList.mDaMaoXian.get(mDataIndex));
        	break;
        default:
        	assert(false);
        	break;
        }
        bContinue.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ZhenDaActivity.this, SelectActivity.class);
				ZhenDaActivity.this.startActivity(i);
				ZhenDaActivity.this.finish();
			}
        	
        });
    }
}
