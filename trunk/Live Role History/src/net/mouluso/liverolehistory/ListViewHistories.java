package net.mouluso.liverolehistory;

import java.util.ArrayList;

import net.mouluso.liverolehistory.adapters.HistoryArrayAdapter;
import net.mouluso.liverolehistory.model.History;
import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListViewHistories extends ListActivity implements OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_histories);
        
        ArrayList<History> histories = DatabaseOperations.getInstance(getApplicationContext()).getHistoryList();
        HistoryArrayAdapter adaptador = new HistoryArrayAdapter(getApplicationContext(), histories);
        ListView listviewHistorias = (ListView) findViewById(android.R.id.list);
        listviewHistorias.setAdapter(adaptador);
        listviewHistorias.setOnItemClickListener(this);
    }

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		int history = (Integer) view.getTag();
		int event = DatabaseOperations.getInstance(getApplicationContext()).loadGame(history);
		
		if(event > 0){
			Intent i = new Intent(this.getApplicationContext(), LoadGameActivity.class);
	    	i.putExtra("history", history);
	    	i.putExtra("event", event);
	    	startActivity(i);
		}else{
			Intent i = new Intent(getApplicationContext(), MapRoleActivity.class);
			i.putExtra("history", history);
			startActivity(i);
		}
	}

}
