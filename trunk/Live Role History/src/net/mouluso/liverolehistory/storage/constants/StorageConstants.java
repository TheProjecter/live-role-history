package net.mouluso.liverolehistory.storage.constants;

public class StorageConstants {
	public static final String DATABASE_NAME = "LiveRoleHistory";
	public static final int DATABASE_VERSION = 1;
	
	//DEBUGGING
	public static final String LOCATION_TABLE = "Location";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	
	public static final String CREATE_LOCATION_TABLE = 
			"CREATE TABLE " + LOCATION_TABLE + "(" + 
					LATITUDE + " INTEGER," + 
					LONGITUDE + " INTEGER" +");";
	
	
	//----EXAMPLE
//	public static final String TASK_TABLE = "Task";
//	public static final String ID = "_id";
//	public static final String DESCRIPTION = "description";
//	public static final String DATE = "date";
//	public static final String PRIORITY = "priority";
//	public static final String DONE = "done";
//	
//	public static final String CREATE_TASK_TABLE = 
//			"CREATE TABLE " + TASK_TABLE + "(" + 
//					ID + " INTEGER PRIMARY KEY," + 
//					DESCRIPTION + " TEXT NOT NULL," +
//					DATE + " TEXT NOT NULL," +
//					PRIORITY + " INTEGER NOT NULL," +
//					DONE + " INTEGER NOT NULL" +
//			");";
	
	
	public static final String HISTORY_TABLE = "Historys";
	public static final String EVENTS_TABLE = "Events";
	public static final String TREASURE_TABLE = "Treasure";
	public static final String TIMED_ACTIONS_TABLE = "TimedActions";
	public static final String QUESTION_ACTIONS_TABLE = "QuestionActions";
	public static final String ID = "_id";
	public static final String NAME = "Name";
	public static final String DESCRIPTION = "Description";
	public static final String HISTORY_ID = "HistoryId";
	public static final String NEXT_EVENT_ID = "NextEventId";
	public static final String ACTION_NAME = "ActionName";
	public static final String ACTION_ID = "ActionId";
	public static final String TREASURE_ID = "TreasureId";
	public static final String TYPE = "Type";
	public static final String IMAGE = "Image";
	public static final String TIME = "_time";
	public static final String QUESTION = "_question";
	public static final String ANSWER = "_answer";

	public static final String CREATE_HISTORY_TABLE = 
			"CREATE TABLE " + HISTORY_TABLE + "(" + 
					ID + " INTEGER PRIMARY KEY," +
					DESCRIPTION + " TEXT NOT NULL);"
					;

	public static final String CREATE_EVENTS_TABLE =
			"CREATE TABLE " + EVENTS_TABLE + "(" +
					ID + " INTEGER PRIMARY KEY," +
					DESCRIPTION + " TEXT NOT NULL," +
					HISTORY_ID + " INTEGER NOT NULL," +
					NEXT_EVENT_ID + " INTEGER NOT NULL," +
					ACTION_NAME + " INTEGER NOT NULL," +
					ACTION_ID + " INTEGER NOT NULL," +
					TREASURE_ID + " INTEGER NOT NULL," +
					LATITUDE + " INTEGER NOT NULL," +
					LONGITUDE + " INTEGER NOT NULL);"					
					;
	public static final String CREATE_TREASURE_TABLE =
			"CREATE TABLE " + TREASURE_TABLE + "(" +
					ID + " INTEGER PRIMARY KEY," +
					TYPE + " TEXT NOT NULL," +
					IMAGE + " TEXT NOT NULL);"
					;
	
	public static final String CREATE_TIMEDACTIONS_TABLE =
			"CREATE TABLE " + TIMED_ACTIONS_TABLE + "(" +
					ID + " INTEGER PRIMARY KEY," +
					TIME + " INTEGER NOT NULL);"
					;
	public static final String CREATE_QUESTIONACTIONS_TABLE = 
			"CREATE TABLE " + QUESTION_ACTIONS_TABLE + "(" +
					ID + " INTEGER PRIMARY KEY" +
					QUESTION + " TEXT NOT NULL," +
					ANSWER + " TEXT NOT NULL);"
					;
}
