package net.mouluso.liverolehistory;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class ListViewHistories extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_histories);
    }

}
