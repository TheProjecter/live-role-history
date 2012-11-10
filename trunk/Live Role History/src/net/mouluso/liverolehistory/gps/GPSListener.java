package net.mouluso.liverolehistory.gps;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPSListener implements LocationListener {

	private LocationManager locationManager;
	private Context context;
	private GPSReadable reader;
	
	private static int gpsIntervalUpdate = 5 * 1000;
	
	public GPSListener(Context context, GPSReadable reader){
		this.context = context;
		locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, gpsIntervalUpdate, 0, this);
		this.reader = reader;
	}
	
	public void onLocationChanged(Location location) {
		this.reader.setLocation(location);

	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
