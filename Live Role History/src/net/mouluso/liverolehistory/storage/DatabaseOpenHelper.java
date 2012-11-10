package net.mouluso.liverolehistory.storage;

import net.mouluso.liverolehistory.storage.constants.StorageConstants;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	Context context;
	public DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(StorageConstants.CREATE_LOCATION_TABLE);
		db.execSQL(StorageConstants.CREATE_HISTORY_TABLE);
		
		DatabaseOperations.getInstance(context);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
