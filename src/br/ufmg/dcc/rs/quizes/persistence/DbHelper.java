package br.ufmg.dcc.rs.quizes.persistence;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.ufmg.dcc.rs.quizes.activities.Messages;
import br.ufmg.dcc.rs.quizes.model.Profile;
import br.ufmg.dcc.rs.quizes.model.Question;



public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // correct option
	private static final String KEY_CATEG = "categ"; // category
	private static final String KEY_TYPE = "type"; // type
	private static final String KEY_OPTA = "opta"; // option a
	private static final String KEY_OPTB = "optb"; // option b
	private static final String KEY_OPTC = "optc"; // option c
	private static final String KEY_OPTD = "optd"; // option d
	

	private static final String TABLE_PROFILE = "profile";
	private static final String KEY_PROFILE_ID = "id";
	private static final String KEY_NAME = "name"; // option b
	private static final String KEY_POINTS = "points"; // option c
	private static final String KEY_MONEY = "money"; // option d
	
	private SQLiteDatabase dbase;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		createTables(db);
		List questions = QuestionDatabase.getInstance()
				.getAllQuestions();
		for (int i=0;i<questions.size();i++) {
			Question question = (Question)questions.get(i);
			addQuestion(question);
		}
		// db.close();
		// System.gc();
	}

	private void createTables(SQLiteDatabase db) {
		try {
			// Tabela de Questoes
			String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
					+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ KEY_QUES + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_CATEG
					+ " TEXT, " + KEY_TYPE + " TEXT, " + KEY_OPTA + " TEXT, "
					+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD
					+ " TEXT)";
			db.execSQL(sql);
			
			// Tabela de Profile
			sql = "CREATE TABLE IF NOT EXISTS " + TABLE_PROFILE + " ( "
					+ KEY_PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ KEY_NAME + " TEXT, " + KEY_POINTS + " INTEGER, " + KEY_MONEY
					+ " INTEGER)";
			db.execSQL(sql);
		} catch (Exception e) {
			Log.d("ERROR", Messages.ERROR_DB_CREATE_TABLES);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	private void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_CATEG, quest.getCATEG());
		values.put(KEY_TYPE, quest.getTYPE());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}
	
	// Adding new question
	private void addProfile(Profile profile) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_POINTS, profile.getPoints());
		values.put(KEY_MONEY, profile.getMoney());
		values.put(KEY_NAME, profile.getName());
		// Inserting Row
		dbase.insert(TABLE_PROFILE, null, values);
	}
	
	// Adding new question
	public void updateProfile(Profile profile) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_POINTS, profile.getPoints());
		values.put(KEY_MONEY, profile.getMoney());
		values.put(KEY_NAME, profile.getName());
		// Inserting Row
		String args[] = null;
		args[0] =  profile.getId().toString();
		dbase.update(TABLE_PROFILE, values, KEY_PROFILE_ID + " = ?", args);
	}
	
	public Profile getProfile() {
		Profile profile = new Profile();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_PROFILE;
		dbase = ((DbHelper) this).getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		try {
			if (cursor.moveToFirst()) {
				profile = setProfile(cursor);
			}
		} catch (IllegalArgumentException e) {
			Log.d("ERROR", Messages.ERROR_DB_SELECT);
		}
		// return quest list
		return profile;
	}

	public List getAllQuestions() {
		List quesList = new ArrayList();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = ((DbHelper) this).getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		try {
			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Question quest = new Question();
					quest = setQuestion(cursor);
					quesList.add(quest);
				} while (cursor.moveToNext());
			}
		} catch (IllegalArgumentException e) {
			Log.d("ERROR", Messages.ERROR_DB_SELECT);
		}
		// return quest list
		return quesList;
	}

	public List getQuestionsByCategory(String category) {
		List quesList = new ArrayList();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " WHERE "
				+ KEY_CATEG + "LIKE" + "'" +category+ "'";
		dbase = ((DbHelper) this).getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		try {
			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Question quest = new Question();
					quest = setQuestion(cursor);
					quesList.add(quest);
				} while (cursor.moveToNext());
			}
		} catch (IllegalArgumentException e) {
			Log.d("ERROR", Messages.ERROR_DB_SELECT);
		}
		// return quest list
		return quesList;
	}
	
	public List getQuestionsByType(String type) {
		List quesList = new ArrayList();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " WHERE "
				+ KEY_TYPE + " LIKE '" + type + "'";
		dbase = ((DbHelper) this).getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		try {
			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Question quest = new Question();
					quest = setQuestion(cursor);
					quesList.add(quest);
				} while (cursor.moveToNext());
			}
		} catch (IllegalArgumentException e) {
			Log.d("ERROR", Messages.ERROR_DB_SELECT);
		}
		// return quest list
		return quesList;
	}
	
	private Question setQuestion(Cursor cursor){
		Question quest = new Question();
		quest.setID(cursor.getInt(cursor
				.getColumnIndexOrThrow(KEY_ID)));
		quest.setQUESTION(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_QUES)));
		quest.setANSWER(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_ANSWER)));
		quest.setCATEG(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_CATEG)));
		quest.setTYPE(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_TYPE)));
		quest.setOPTA(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_OPTA)));
		quest.setOPTB(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_OPTB)));
		quest.setOPTC(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_OPTC)));
		quest.setOPTD(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_OPTD)));
		return quest;
	}
	
	private Profile setProfile(Cursor cursor){
		Profile profile = new Profile();
		profile.setId(cursor.getInt(cursor
				.getColumnIndexOrThrow(KEY_PROFILE_ID)));
		profile.setPoints(cursor.getInt(cursor
				.getColumnIndexOrThrow(KEY_POINTS)));
		profile.setMoney(cursor.getInt(cursor
				.getColumnIndexOrThrow(KEY_MONEY)));
		profile.setName(cursor.getString(cursor
				.getColumnIndexOrThrow(KEY_NAME)));
		return profile;
	}
}