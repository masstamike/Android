package csci567.eventreceiver;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private OnClickListener badListener = new OnClickListener () {
		public void onClick(View v) {
			Notification n  = new NotificationCompat.Builder(getBaseContext())
	        .setContentTitle("Bad Button")
	        .setContentText("The bad button was touched.")
	        .setSmallIcon(R.drawable.ic_launcher).build();
	  
			NotificationManager notificationManager = 
				(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

			notificationManager.notify(0, n);
		}
	};
	
	private OnClickListener goodListener = new OnClickListener () {
		public void onClick (View v) {

			Notification n  = new NotificationCompat.Builder(getBaseContext())
	        .setContentTitle("Good Button")
	        .setContentText("The good button was pressed.")
	        .setSmallIcon(R.drawable.ic_launcher).build();
	  
			NotificationManager notificationManager = 
				(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

			notificationManager.notify(0, n);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button badButton = (Button) findViewById(R.id.bad);
		badButton.setOnClickListener(badListener);
		Button goodButton = (Button) findViewById(R.id.good);
		goodButton.setOnClickListener(goodListener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
