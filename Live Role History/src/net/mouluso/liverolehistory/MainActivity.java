package net.mouluso.liverolehistory;

import net.mouluso.liverolehistory.storage.DatabaseOperations;
import net.mouluso.liverolehistory.util.StartDataBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        StartDataBase.addEvents(getApplicationContext());
    }
    
    public void play(View v){
    	Intent i = new Intent(this.getApplicationContext(), ListViewHistories.class);
    	startActivity(i);
    	overridePendingTransition(R.anim.alpha_animation_in, R.anim.alpha_animation_out);
    	
    }
}
