package net.mouluso.liverolehistory.storage.constants;

public class StorageConstants {
	public static final String DATABASE_NAME = "LiveRoleHistory";
	public static final int DATABASE_VERSION = 1;
	
	
	public static final String HISTORY_TABLE = "Historys";
	public static final String EVENTS_TABLE = "Events";
	public static final String ID = "_id";
	public static final String NAME = "Name";
	public static final String DESCRIPTION = "Description";
	public static final String HISTORY_ID = "HistoryId";
	public static final String ORDER = "NextEventId";
	public static final String TREASURE = "Treasure";
	public static final String IMAGE = "Image";
	public static final String QUESTION = "_question";
	public static final String ANSWER = "_answer";
	public static final String SEARCH = "search";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";

	public static final String CREATE_HISTORY_TABLE = 
			"CREATE TABLE " + HISTORY_TABLE + "(" + 
					ID + " INTEGER PRIMARY KEY," +
					NAME + " TEXT NOT NULL, " +
					IMAGE + " TEXT NOT NULL," +
					DESCRIPTION + " TEXT NOT NULL);"
					;

	public static final String CREATE_EVENTS_TABLE =
			"CREATE TABLE " + EVENTS_TABLE + "(" +
					ID + " INTEGER PRIMARY KEY," +
					DESCRIPTION + " TEXT NOT NULL," +
					HISTORY_ID + " INTEGER NOT NULL," +
					ORDER + " INTEGER NOT NULL," +
					QUESTION + " INTEGER NOT NULL," +
					ANSWER + " INTEGER NOT NULL," +
					SEARCH + " TEXT NOT NULL," +
					LATITUDE + " INTEGER NOT NULL," +
					LONGITUDE + " INTEGER NOT NULL);"					
					;
	
}
