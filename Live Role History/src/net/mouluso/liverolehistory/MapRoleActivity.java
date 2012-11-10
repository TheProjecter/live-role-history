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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapRoleActivity extends MapActivity implements GPSReadable{

	private static final int MESSAGE_DIALOG = 0;
	private static final int ENTER_DATA_DIALOG = 1;
	
	private MapView mv;
	private Location location;
	private GPSListener gpsListener;
	private GeoPoint locationToLocate;
	private MyLocationOverlay markOverlay;
	private OverlayItem mark;
	private RelativeLayout shadow;
	private Button locateMeButton;
	private Button checkLocationButton;
	private Button showHintButton;
	private ImageView dialogIcon;
	private TextView dialogMessage;
	private EditText dialogEnterData;
	private Button actionMessageButton;
	private Button searchInfoMessageButton;
	
    
	private int messageType;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mv = (MapView) findViewById(R.id.mapview);
        mv.setSatellite(true);
        mv.getController().setZoom(20);
        this.gpsListener = new GPSListener(getApplicationContext(), this);

        locationToLocate = new GeoPoint(45367824, 8908765);
        
        
        List<Overlay> mapOverlays = mv.getOverlays();
        Drawable markDrawable = this.getResources().getDrawable(R.drawable.me_location);
        markOverlay = new MyLocationOverlay(markDrawable, this);
        mapOverlays.add(markOverlay);
        
        shadow = (RelativeLayout) findViewById(R.id.shadow_layout);
        shadow.setVisibility(RelativeLayout.INVISIBLE);
        
        locateMeButton = (Button) findViewById(R.id.locate_me);
        checkLocationButton = (Button) findViewById(R.id.check_location);
        showHintButton = (Button) findViewById(R.id.show_hint);
        
        dialogIcon = (ImageView) findViewById(R.id.icon_dialog);
    	dialogMessage = (TextView)findViewById(R.id.message_dialog);
    	dialogEnterData = (EditText) findViewById(R.id.message_enter_data);
    	
    	actionMessageButton = (Button) findViewById(R.id.action_dialog);
    	searchInfoMessageButton = (Button) findViewById(R.id.search_dialog);
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
	
	public void showHint(View v){
		//configMessageDialog();
		configEnterDataDialog();
		enableMapButtons(false);
		shadow.setVisibility(RelativeLayout.VISIBLE);
	}
	
	public void doActionDialog(View v){
		switch(messageType){
		case MESSAGE_DIALOG: enableMapButtons(true); shadow.setVisibility(RelativeLayout.INVISIBLE); break;
		case ENTER_DATA_DIALOG: break;
		}
			
	}
	
	public void searchInfo(View v){
		
	}
	
	private void enableMapButtons(boolean enabled){
		locateMeButton.setEnabled(enabled);
		checkLocationButton.setEnabled(enabled);
		showHintButton.setEnabled(enabled);
	}
	
	private void configMessageDialog(){
		dialogIcon.setVisibility(RelativeLayout.VISIBLE);
		dialogMessage.setVisibility(RelativeLayout.VISIBLE);
		actionMessageButton.setVisibility(RelativeLayout.VISIBLE);
		searchInfoMessageButton.setVisibility(RelativeLayout.VISIBLE);
		
		dialogEnterData.setVisibility(RelativeLayout.INVISIBLE);
		messageType = MESSAGE_DIALOG;
		
		actionMessageButton.setText(R.string.close_action);
		searchInfoMessageButton.setText(R.string.search_info);
	}
	
	private void configEnterDataDialog(){
		dialogIcon.setVisibility(RelativeLayout.VISIBLE);
		dialogMessage.setVisibility(RelativeLayout.VISIBLE);
		actionMessageButton.setVisibility(RelativeLayout.VISIBLE);
		dialogEnterData.setVisibility(RelativeLayout.VISIBLE);
		
		searchInfoMessageButton.setVisibility(RelativeLayout.INVISIBLE);
		messageType = ENTER_DATA_DIALOG;
		
		actionMessageButton.setText(R.string.enter_data_action);
	}
	
	
	public void setLocation(Location l) {
		this.location = l;
	}
}