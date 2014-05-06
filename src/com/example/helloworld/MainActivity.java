package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author 323145
 * 
 */
public class MainActivity extends Activity {

	Button bcalcIMC, grosButton, bRAZ = null;
	TextView resultIMC = null;
	EditText edTaille, edPoids = null;
	CheckBox megaFct = null;
	String megaText = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		bcalcIMC = (Button) findViewById(R.id.butCalcIMC);
		bRAZ = (Button) findViewById(R.id.butRAZ);
		resultIMC = (TextView) findViewById(R.id.imcResult);
		edPoids = (EditText) findViewById(R.id.editPoids);
		edTaille = (EditText) findViewById(R.id.editTaille);
		megaFct = (CheckBox) findViewById(R.id.checkmegaFonction);
		megaText = (String) getString(R.string.megaFonction);
		// grosButton = (Button) findViewById(R.id.grosBoutton);
		//
		// b1.setOnTouchListener(touchListenerButton1);
		// b1.setOnClickListener(clickListenerButton1);
		//
		// grosButton.setOnTouchListener(new View.OnTouchListener() {
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// float posx = event.getX();
		// float posy = event.getY();
		// int width = grosButton.getWidth();
		// int height = grosButton.getHeight();
		// grosButton.setTextSize(Math.abs(posx - width / 2)
		// + Math.abs(posy - height / 2));
		// return true;
		// // return onTouch(v, event);
		// }
		// });

		bcalcIMC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (megaFct.isChecked()) {
					resultIMC.setText(megaText);
					return;
				}
				resultIMC.setText(calcIMC(edTaille.getText().toString(),
						edPoids.getText().toString()));
			}
		});
	}

	/**
	 * calculate the IMC = weight / tall�
	 * 
	 * @param taille
	 *            @String. if String is empty, initialize value to 0
	 * @param poids
	 *            @String. if String is empty, initialize value to 0
	 * @return float, if poids equals 0, returns the String "IMC"
	 */
	private String calcIMC(String taille, String poids) {
		float t, p;
		try {
			t = Float.valueOf(taille);
		} catch (NumberFormatException e) {
			t = 0;
		}
		try {
			p = Float.valueOf(poids);
		} catch (NumberFormatException e) {
			p = 0;
		}
		// avoid division by 0
		if (t == 0){
			Toast.makeText(this, "taille trop petite", Toast.LENGTH_SHORT).show();
			return "IMC";
		} else {
			return String.valueOf(p / (float) Math.pow(t, 2));
		}
	}
}
