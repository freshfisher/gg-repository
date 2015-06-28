package bit.example.homework;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView teAddName;
	private Button bAddName;
	private ListView lvNames;
	private Button bStart;
	private NameAdapter baNameList = new NameAdapter();
	private ListDataUtils dataList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dataList = ListDataUtils.getInstance();
		teAddName = (TextView) findViewById(R.id.teAddName);
		bAddName = (Button) findViewById(R.id.bAddName);
		bStart = (Button) findViewById(R.id.bStart);
		lvNames = (ListView) findViewById(R.id.lvNames);

		bAddName.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name =  teAddName.getText().toString();
				if (name.equals("")) {
					Toast.makeText(MainActivity.this, "名字不能为空 :)", Toast.LENGTH_LONG).show();
				} else {
					dataList.mNameList.add(name);
					teAddName.setText("");
					baNameList.notifyDataSetChanged();
				}
				
			}

		});

		bStart.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (dataList.mNameList.size() > 0) {
					Intent i = new Intent(MainActivity.this, SelectActivity.class);
					MainActivity.this.startActivity(i);
				} else {
					Toast.makeText(MainActivity.this, "请先添加名字 :)", Toast.LENGTH_LONG).show();
				}
				
			}

		});
		lvNames.setAdapter(baNameList);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class NameAdapter extends BaseAdapter {

		public int getCount() {
			// TODO Auto-generated method stub
			return dataList.mNameList.size();
		}

		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return dataList.mNameList.get(arg0);
		}

		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater
						.from(MainActivity.this);
				convertView = inflater.inflate(R.layout.list_name_item, null);
			}
			TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
			Button bDelName = (Button)convertView.findViewById(R.id.bDelName);
			tvName.setText(dataList.mNameList.get(position));
			bDelName.setOnClickListener(new OnNameItemClickListener(position));
			return convertView;
		}
	}
	class OnNameItemClickListener implements OnClickListener {
		private int mPostion;
		public OnNameItemClickListener(int _postion) {
			mPostion = _postion;
		}
		public void onClick(View v) {
			// TODO Auto-generated method stub
			dataList.mNameList.remove(mPostion);
			baNameList.notifyDataSetChanged();
		}
	}

	
}
