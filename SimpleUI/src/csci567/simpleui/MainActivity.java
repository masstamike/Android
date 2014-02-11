package csci567.simpleui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void changeText1 (View view) {
		TextView text = (TextView) findViewById(R.id.textView1);
		text.setText(R.string.goodbye);
	}
	
	public void changeText2 (View view) {
		TextView text = (TextView) findViewById(R.id.textView1);
		text.setText(R.string.hello);
	}

}
