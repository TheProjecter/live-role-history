package net.mouluso.liverolehistory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void play(View v){
    	Intent i = new Intent(this.getApplicationContext(), MapRoleActivity.class);
    	startActivity(i);
    }
}
