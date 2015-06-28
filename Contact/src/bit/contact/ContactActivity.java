package bit.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

public class ContactActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.showNumbersByName("赵六");
   //     this.insertContact(" 王五", "13456784");
   //     deleteContact("王五");
    }
    public void showNumbersByName(String name){
    	String[] args= new String[]{name};
    	ContentResolver cr = this.getContentResolver();
    	Cursor c = cr.query(ContactsContract.Data.CONTENT_URI , null, 
    			ContactsContract.Data.DISPLAY_NAME +" = ? AND "+
    			ContactsContract.Data.MIMETYPE+" = '"+ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE +"'"
    			, args, null);
		
    	while(c.moveToNext()){
    		String number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
    		Log.d("mjd", number);
    	}
    	c.close();
  
    }
    public void insertContact(String name,String phoneNumber){
    	ContentResolver cr=this.getContentResolver();
    	ContentValues values=new ContentValues();
    	Uri uri=cr.insert(ContactsContract.RawContacts.CONTENT_URI, values);
    	long id=ContentUris.parseId(uri);
    	
    	values.put(ContactsContract.Data.RAW_CONTACT_ID, id);
    	values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
    	values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
    	cr.insert(ContactsContract.Data.CONTENT_URI, values);
    	
    	values.clear();
    	values.put(ContactsContract.Data.RAW_CONTACT_ID, id);
    	values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
    	values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneNumber);
    	values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
    	cr.insert(ContactsContract.Data.CONTENT_URI, values);
    }
    public void deleteContact(String name){
    	ContentResolver cr=this.getContentResolver();
    	Cursor c=cr.query(ContactsContract.Data.CONTENT_URI, null, ContactsContract.Data.DISPLAY_NAME+"="+name+"AND"+ContactsContract.Data.MIMETYPE+"="+ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, null, null);
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		int raw_id=c.getInt(c.getColumnIndex(ContactsContract.Data.RAW_CONTACT_ID));
    		cr.delete(ContactsContract.RawContacts.CONTENT_URI, ContactsContract.RawContacts._ID+"="+raw_id, null);
    	}
    	c.close();
    }
}