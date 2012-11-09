package net.mouluso.liverolehistory.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPSListener implements LocationListener {

	private LocationManager locationManager;
	private Context context;
	private GPSReadable reader;
	
	public GPSListener(Context context, GPSReadable reader){
		this.context = context;
		locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		//TODO mirar que coño significa esto
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
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
