package net.mouluso.liverolehistory;

import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(DatabaseOperations.getInstance(getApplicationContext()).getHistoryList().size() == 0){
        	DatabaseOperations.getInstance(getApplicationContext()).insertHistory(1, "O Alemán resacoso.",
    				"Axuda a un turista alemán a recupera-las súas cousas namentres disfruta de A Coruña.", 
    				"beer_icon");
    		DatabaseOperations.getInstance(getApplicationContext()).insertHistory(2, "O Pelegrín", 
    				"Un pelegrín perdido no tempo que tenta volver á casa namentres coñece o ámbito cultural de A Coruña.", 
    				"vieira_icon");
        }
    }
    
    public void play(View v){
    	Intent i = new Intent(this.getApplicationContext(), ListViewHistories.class);
    	startActivity(i);
    }
}
