package net.mouluso.liverolehistory.adapters;

import java.util.ArrayList;

import net.mouluso.liverolehistory.R;
import net.mouluso.liverolehistory.model.History;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryArrayAdapter extends ArrayAdapter<History> {
	  private final Context context;
	  private final ArrayList<History> values;

	public HistoryArrayAdapter(Context context, ArrayList<History> values) {
	    super(context, R.layout.listview_histories, values);
	    this.context = context;
	    this.values = values;
	  }
	
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.historyadapter, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.historyadapter_label);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.historyadapter_icon);
	    textView.setText(values.get(position).getName());
	    
	    imageView.setImageResource(context.getResources().getIdentifier(values.get(position).getImage(),
	    		"drawable", context.getPackageName()));
	    
	    return rowView;
	  }
}
