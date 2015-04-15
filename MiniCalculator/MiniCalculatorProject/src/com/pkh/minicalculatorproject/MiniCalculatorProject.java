package com.pkh.minicalculatorproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MiniCalculatorProject extends Activity implements OnClickListener {

	/**
	 * View initialization
	 */
	EditText textBoxA,textBoxB;
	TextView resultText;
	Button addButton,subButton,mulButton,divButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculato_view);
		/**
		 * initializing the view accordingly with the id (R.java)
		 */
		textBoxA=(EditText) findViewById(R.id.boxA);
		textBoxB=(EditText) findViewById(R.id.boxB);
		resultText=(TextView) findViewById(R.id.resultText);
		addButton=(Button) findViewById(R.id.addBtn);
		subButton=(Button) findViewById(R.id.subBtn);
		mulButton=(Button) findViewById(R.id.mulBtn);
		divButton=(Button) findViewById(R.id.divBtn);
		
		/**
		 * applying click listener for all the buttons
		 * *note1: we can apply click listener for all the views
		 * *note2: check the class is implements with onClickListener
		 * we can add button click listener as follows
		 * addButton.setOnClickListener(new ONclickListener(){ onClickView(view v){} };
		 */
		addButton.setOnClickListener(this);
		subButton.setOnClickListener(this);
		mulButton.setOnClickListener(this);
		divButton.setOnClickListener(this); 
		
	}
	
	
	
	@Override
	public void onClick(View v) {
		/**
		 * reading the value entered from textbox and conveting into integer
		 */
		String valueAString=textBoxA.getText().toString();
		String valueBString=textBoxB.getText().toString();
		if(valueAString!=null && valueBString!=null
				&& !valueAString.trim().equalsIgnoreCase("")
				&& !valueBString.trim().equalsIgnoreCase("")){
		int valueA=Integer.parseInt(valueAString);
		int valueB=Integer.parseInt(valueBString);
		int result=0;
			switch (v.getId()) {
			case R.id.addBtn:
				result=valueA+valueB;
				break;
			case R.id.subBtn:
				result=valueA-valueB;
				break;
			case R.id.mulBtn:
				result=valueA*valueB;
				break;
			case R.id.divBtn:
				result=valueA/valueB;
				break;
	
			default:
				break;
			}
			/**
			 * displaying the result in the TExt view and showing a toast message
			 */
			resultText.setText("Result="+result);
			Toast.makeText(getApplicationContext(),"Result="+result,Toast.LENGTH_LONG).show();
		}else{
			/**
			 * showing toast message, if the value entred in Box A & B 
			 * is inappropriate
			 */
			Toast.makeText(getApplicationContext(), "Please Enter Proper value", 0).show();
		}
	}

	

}
