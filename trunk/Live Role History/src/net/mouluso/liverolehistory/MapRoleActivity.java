package net.mouluso.liverolehistory;

import net.mouluso.liverolehistory.gps.GPSListener;
import net.mouluso.liverolehistory.gps.GPSReadable;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.Menu;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapRoleActivity extends MapActivity implements GPSReadable{

	private MapView mv;
	private Location location;
	private GPSListener gpsListener;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mv = (MapView) findViewById(R.id.mapview);
        mv.setSatellite(true);
        mv.getController().setZoom(20);
        this.gpsListener = new GPSListener(getApplicationContext(), this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void locateMe(View v){
		if(this.location != null)
			mv.getController().animateTo(new GeoPoint(
					(int)(location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6)));
		
		mv.invalidate();
	}
	
	public void shareGPlus(View v){
		Intent shareIntent = ShareCompat.IntentBuilder.from(MapRoleActivity.this)
				.setText("TEXTO A PUBLICAR")
				.setType("text/plain")
				.getIntent()
				.setPackage("com.google.android.apps.plus");
		startActivity(shareIntent);
	}

	public void setLocation(Location l) {
		this.location = l;
	}
}
