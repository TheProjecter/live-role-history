package net.mouluso.liverolehistory;

import java.util.List;

import net.mouluso.liverolehistory.gps.GPSListener;
import net.mouluso.liverolehistory.gps.GPSReadable;
import net.mouluso.liverolehistory.overlays.MyLocationOverlay;
import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapRoleActivity extends MapActivity implements GPSReadable{

	private MapView mv;
	private Location location;
	private GPSListener gpsListener;
	private GeoPoint locationToLocate;
	private MyLocationOverlay markOverlay;
	private OverlayItem mark;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mv = (MapView) findViewById(R.id.mapview);
        mv.setSatellite(true);
        mv.getController().setZoom(20);
        this.gpsListener = new GPSListener(getApplicationContext(), this);
        DatabaseOperations.getInstance(getApplicationContext()).insertLocation();
        locationToLocate = DatabaseOperations.getInstance(getApplicationContext()).getLocation();
        
        List<Overlay> mapOverlays = mv.getOverlays();
        Drawable markDrawable = this.getResources().getDrawable(R.drawable.me_location);
        markOverlay = new MyLocationOverlay(markDrawable, this);
        mapOverlays.add(markOverlay);
        
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
		if(this.location != null){
			GeoPoint gp = new GeoPoint((int)(location.getLatitude() * 1E6), (int) (location.getLongitude() * 1E6));
			mark = new OverlayItem(gp, "", "");
			mv.getController().animateTo(gp);
			markOverlay.setMark(mark);
		}
		
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

	public void checkLocation(View v){
		if(this.location==null) return;
		Location loc =  new Location("Database");
		loc.setLatitude(locationToLocate.getLatitudeE6() / 1E6);
		loc.setLongitude(locationToLocate.getLongitudeE6() / 1E6);
		
		
		float distance = loc.distanceTo(this.location);
		
		if(distance < 5){
			Toast.makeText(getApplicationContext(), "WIN", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(getApplicationContext(), "Te faltan: " + distance + " metros", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void setLocation(Location l) {
		this.location = l;
	}
}
