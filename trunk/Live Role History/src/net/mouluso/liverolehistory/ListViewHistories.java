package net.mouluso.liverolehistory;

import java.util.ArrayList;

import net.mouluso.liverolehistory.adapters.HistoryArrayAdapter;
import net.mouluso.liverolehistory.model.History;
import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewHistories extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_histories);
        
        ArrayList<History> histories = DatabaseOperations.getInstance(getApplicationContext()).getHistoryList();
        HistoryArrayAdapter adaptador = new HistoryArrayAdapter(getApplicationContext(), histories);
        ListView listviewHistorias = (ListView) findViewById(android.R.id.list);
        listviewHistorias.setAdapter(adaptador);
    }

}
