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
		
		DatabaseOperations.getInstance(context).insertHistory("O Alemán resacoso.",
				"Axuda a un turista alemán a recupera-las súas cousas namentres disfruta de A Coruña.", 
				"beer_icon.png");
		DatabaseOperations.getInstance(context).insertHistory("O Pelegrín", 
				"Un pelegrín perdido no tempo que tenta volver á casa namentres coñece o ámbito cultural de A Coruña.", 
				"vieira_icon.jpg");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
