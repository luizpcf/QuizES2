package br.ufmg.dcc.rs.quizes.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

import br.ufmg.dcc.rs.quizes.model.Lesson;
import br.ufmg.dcc.rs.quizes.persistence.LessonDatabase;



public class LessonsActivity extends Activity {

	TextView lesson;
	Boolean board = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lessons);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lessons, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void lessonOne(View view) {

		createBoard();
		lesson.setText(LessonDatabase.getInstance().getLessonByCategory("Intro").getText());
	}
	
	public void lessonTwo(View view) {
		createBoard();
		lesson.setText(LessonDatabase.getInstance().getLessonByCategory("Padroes").getText());
	}
	
	public void createBoard(){
		if(!board){
			RelativeLayout layout = (RelativeLayout) findViewById(R.id.lessonact);
			
			ImageView img = new ImageView(findViewById(R.id.lessonact).getContext());
			img.setImageResource(R.drawable.blackboard2);
			RelativeLayout.LayoutParams imgLP;
			img.setLayoutParams(imgLP = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imgLP.setMargins(15, 0, 0, 0);
			layout.addView(img);
			
			lesson = new TextView(img.getContext());
			lesson.setMaxLines(150);
			lesson.setMovementMethod(new ScrollingMovementMethod());
			lesson.setText("");
			lesson.setTextSize(15);
			lesson.setTextColor(Color.WHITE);
			ScrollView scroller = new ScrollView(((LessonsActivity) this));
			RelativeLayout.LayoutParams scrollerLP;
			scroller.setLayoutParams(scrollerLP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
			scrollerLP.setMargins(29, 5, 15, 110);
			scroller.setLayoutParams(scrollerLP);
			scroller.addView(lesson);
			layout.addView(scroller);
			
			board=true;
		} 		
	}

}