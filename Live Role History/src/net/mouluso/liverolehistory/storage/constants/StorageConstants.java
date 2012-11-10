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
	
}
