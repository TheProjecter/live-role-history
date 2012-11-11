package net.mouluso.liverolehistory.storage;

import net.mouluso.liverolehistory.storage.constants.StorageConstants;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	public DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(StorageConstants.CREATE_HISTORY_TABLE);
		db.execSQL(StorageConstants.CREATE_EVENTS_TABLE);
		db.execSQL(StorageConstants.CREATE_GAMES_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
