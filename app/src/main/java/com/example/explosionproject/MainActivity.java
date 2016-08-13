package com.example.explosionproject;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv_pic;
	private ExplosionField mExplosionField;
	private Button btn_do,btn_reset;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_pic=(ImageView)findViewById(R.id.iv_pic);
		mExplosionField = ExplosionField.attach2Window(MainActivity.this);
		btn_do=(Button)findViewById(R.id.btn_do);
		btn_do.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(iv_pic.getVisibility()==View.VISIBLE){
					mExplosionField.explode(iv_pic);
					iv_pic.postDelayed(new Runnable() {
						public void run() {
							iv_pic.setScaleX(1);
							iv_pic.setScaleY(1);
							iv_pic.setAlpha(1f);
							iv_pic.setVisibility(View.GONE);
						}
					}, ExplosionAnimator.DEFAULT_DURATION);
				}
			}
		});
		btn_reset=(Button)findViewById(R.id.btn_reset);
		btn_reset.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv_pic.setVisibility(View.VISIBLE);
			}
		});
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
