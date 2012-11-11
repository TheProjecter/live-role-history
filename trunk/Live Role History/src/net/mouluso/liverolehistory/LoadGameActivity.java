package net.mouluso.liverolehistory;

import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoadGameActivity extends Activity {

	int history;
	int event;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_game_activity);
        
        history = getIntent().getExtras().getInt("history");
        event = getIntent().getExtras().getInt("event");
    }
    
    public void goBack(View v){
    	finish();
    }
    
    public void continueGame(View v){
    	Intent i = new Intent(this.getApplicationContext(), MapRoleActivity.class);
    	i.putExtra("history", history);
    	i.putExtra("event", event);
    	startActivity(i);
    	finish();
    }
    
    public void newGame(View v){
    	DatabaseOperations.getInstance(getApplicationContext()).deleteGame(history);
    	Intent i = new Intent(this.getApplicationContext(), MapRoleActivity.class);
    	i.putExtra("history", history);
    	startActivity(i);
    	finish();
    }
}
