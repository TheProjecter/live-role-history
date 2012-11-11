package net.mouluso.liverolehistory;

import net.mouluso.liverolehistory.storage.DatabaseOperations;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
    	overridePendingTransition(R.anim.alpha_animation_in, R.anim.alpha_animation_out);
    }
    
    public void continueGame(View v){
    	Intent i = new Intent(this.getApplicationContext(), MapRoleActivity.class);
    	i.putExtra("history", history);
    	i.putExtra("event", event);
    	startActivity(i);
    	finish();
    	overridePendingTransition(R.anim.alpha_animation_in, R.anim.alpha_animation_out);
    }
    
    public void newGame(View v){
    	DatabaseOperations.getInstance(getApplicationContext()).deleteGame(history);
    	Intent i = new Intent(this.getApplicationContext(), MapRoleActivity.class);
    	i.putExtra("history", history);
    	startActivity(i);
    	finish();
    	overridePendingTransition(R.anim.alpha_animation_in, R.anim.alpha_animation_out);
    }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	    	finish();
	    	overridePendingTransition(R.anim.alpha_animation_in, R.anim.alpha_animation_out);
	    	return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
