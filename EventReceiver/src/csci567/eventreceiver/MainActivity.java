package csci567.eventreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private OnClickListener badListener = new OnClickListener () {
		public void onClick(View v) {
			Button badButton = (Button) findViewById(R.id.bad);
			badButton.setText("Loser");
		}
	};
	
	private OnClickListener goodListener = new OnClickListener () {
		public void onClick (View v) {
			Button goodButton = (Button) findViewById(R.id.good);
			goodButton.setText("You are Wonderful!");
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
