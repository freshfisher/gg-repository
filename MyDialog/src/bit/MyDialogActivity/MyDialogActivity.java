package bit.MyDialogActivity;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MyDialogActivity extends Activity {
    /** Called when the activity is first created. */
	private Button[] btn=new Button[6];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn[0]=(Button)findViewById(R.id.btn0);
        btn[1]=(Button)findViewById(R.id.btn1);
        btn[2]=(Button)findViewById(R.id.btn2);
        btn[3]=(Button)findViewById(R.id.btn3);
        btn[4]=(Button)findViewById(R.id.btn4);
        btn[5]=(Button)findViewById(R.id.btn5);
        for(int i=0;i<btn.length;i++){
        	btn[i].setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					int id=0;
					for(int i=0;i<btn.length;i++){
						if(arg0==btn[i]){
							id=i;
							break;
						}
					}
					showDialog(id);
				}});
        }
    }
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		if(id==0){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setMessage("您确定要退出么");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					System.exit(0);
				}});
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					return;
				}});
			return builder.create();
		}
		if(id==1){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setItems(R.array.hobby, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MyDialogActivity.this, getResources().getStringArray(R.array.hobby)[which], 1000).show();
				}});
			return builder.create();
		}
		if(id==2){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setSingleChoiceItems(R.array.hobby, 0, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MyDialogActivity.this, getResources().getStringArray(R.array.hobby)[which], 1000).show();
					
				}});
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					return;
				}});
			return builder.create();
		}
		if(id==3){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			boolean[] checked={true,true,false,false,false};
			builder.setMultiChoiceItems(R.array.hobby, checked, new DialogInterface.OnMultiChoiceClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which,
						boolean isChecked) {
					// TODO Auto-generated method stub
					Toast.makeText(MyDialogActivity.this, getResources().getStringArray(R.array.hobby)[which], 1000).show();
				}});
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					return;
				}});
			return builder.create();
		}
		if(id==4){
			Calendar cal=Calendar.getInstance();
			DatePickerDialog dialog=new DatePickerDialog(MyDialogActivity.this,new DatePickerDialog.OnDateSetListener(){

				@Override
				public void onDateSet(DatePicker view, int year,
						int monthOfYear, int dayOfMonth) {
					// TODO Auto-generated method stub
					Toast.makeText(MyDialogActivity.this, "您选择了"+year+"年"+(monthOfYear+1)+"月", 1000).show();
					
				}},
			cal.get(Calendar.YEAR),
			cal.get(Calendar.MONTH),
			cal.get(Calendar.DAY_OF_MONTH)
			);
			return dialog;
		}
		if(id==5){
			Calendar cal=Calendar.getInstance();
			TimePickerDialog dialog=new TimePickerDialog(MyDialogActivity.this,new TimePickerDialog.OnTimeSetListener(){

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					Toast.makeText(MyDialogActivity.this, "您选择了"+hourOfDay+"点"+(minute)+"分", 1000).show();
				}},
				cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.MINUTE),
				true);
			return dialog;
		}
		return super.onCreateDialog(id);
	}
    
}