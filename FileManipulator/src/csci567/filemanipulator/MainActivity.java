package csci567.filemanipulator;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String filename = "myfile";
		String string = "";
		FileOutputStream outputStream;

		try {
		  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
		  outputStream.write(string.getBytes());
		  outputStream.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void ReadFile(View view) {
		try {
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(
					openFileInput("myfile")));
			String inputString;
			StringBuffer stringBuffer = new StringBuffer();                
			while ((inputString = inputReader.readLine()) != null) {
				stringBuffer.append(inputString + "\n");
			}
			TextView tv1 = (TextView) findViewById(R.id.hello_there);
			tv1.setText(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void AppendFile(View view) {
		String filename = "myfile";
		EditText something = (EditText) findViewById(R.id.something);
		String string = something.getText().toString();
		string += "\n";
		FileOutputStream outputStream;

		try {
		  outputStream = openFileOutput(filename, Context.MODE_APPEND);
		  outputStream.write(string.getBytes());
		  outputStream.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	public void WriteFile(View view) {
		String filename = "myfile";
		EditText something = (EditText) findViewById(R.id.something);
		String string = something.getText().toString();
		string += "\n";
		FileOutputStream outputStream;
		
		try {
			outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(string.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
