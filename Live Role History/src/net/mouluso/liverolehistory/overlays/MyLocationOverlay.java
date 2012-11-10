package net.mouluso.liverolehistory.overlays;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyLocationOverlay extends ItemizedOverlay<OverlayItem> {

	private OverlayItem positionItem;
	private Context context;
	
	public MyLocationOverlay(Drawable defaultMarker, Context context) {
	  super(boundCenterBottom(defaultMarker));
	  this.context = context;
	  populate();
	}
	
	public void setMark(OverlayItem mark) {
		positionItem = mark;
	    populate();
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		return positionItem;
	}

	@Override
    protected boolean onTap(int index) {
        return super.onTap(index);
    }
	
	@Override
	public int size() {
		if(positionItem == null) return 0;
		else return 1;
	}

}
