package com.example.dbapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    DatabaseHandler db = new DatabaseHandler(this);

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	
	public void addText(View view) {
		EditText edit = (EditText) findViewById(R.id.edit);
		String txt = edit.getText().toString();
		db.addString(txt);
	}
	
	public void getText(View view) {
		TextView txt = (TextView) findViewById(R.id.txt);
		List <String> data = db.getAllStrings();
		String output = "";
		for(int i = 0; i<data.size();i++)
			output+=data.get(i)+'\n';
		txt.setText(output);
	}
	
}