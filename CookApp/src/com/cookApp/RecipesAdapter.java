package com.cookApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RecipesAdapter {
	static final String DATABASE_NAME = "ingredients.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	
	static final String DATABASE_CREATE = "CREATE TABLE " + "RECIPES" +
			"( " + "NAME text primary key, DETAILS text" + ")";
	
	
	public SQLiteDatabase db;
	private final Context context;
	private DataBaseHelper dbHelper;
	
	
	public RecipesAdapter(Context _context) {
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public RecipesAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void Close() {
		db.close();
	}
	
	public SQLiteDatabase getDatabaseInstance() {
		return db;
	}
	
	public void insertRecipeEntry(String name, String details) {
		ContentValues newValues = new ContentValues();
		newValues.put("NAME", name);
		newValues.put("DETAILS", details);
		db.insert("RECIPES", null, newValues);
	}
	
	/*public int countPhotos(String area, String location) {
		Cursor c = db.rawQuery("SELECT LOCATION FROM MOLEPHOTOS WHERE AREA = \"" + area + "\"" + " AND LOCATION = \"" + location + "\"", null);
		int count = c.getCount();
		c.close();
		return count;
	}
	
	public String[] photoNames(String area, String location) {
	Cursor c = db.rawQuery("SELECT PHOTO FROM MOLEPHOTOS WHERE AREA = \"" + area + "\"" + " AND LOCATION = \"" + location + "\"", null);
	int count = c.getCount();
	String arr[]=new String[count];
	int i=0;
	c.moveToFirst();
	while (c.isAfterLast() == false) 
	{
	    arr[i]  = c.getString(0);
	    i++;
	    c.moveToNext();
	}
	return arr;
}*
	
	/*public int deleteEntry(String mlocation) {
		String where = "LOCATION=?";
		int numberOfEntriesDeleted = db.delete("MOLES", where, new String[]{mlocation});
		return numberOfEntriesDeleted;
	}
	
	public String getSingleEntry(String mlocation) {
		Cursor cursor = db.query("MOLES", null, "LOCATION=?", new String[]{mlocation}, null, null, null);
		if ( cursor.getCount()<1 ) {
			cursor.close();
			return "NOT EXIST";
		}
		
		cursor.moveToFirst();
		String area = cursor.getString(cursor.getColumnIndex("AREA"));
		cursor.close();
		return area;
	}
	
	
	public Boolean checkLocations(String location) {
		Cursor c = db.rawQuery("SELECT LOCATION FROM MOLES WHERE LOCATION = \"" + location + "\"", null);
		int count = c.getCount();
		if (count>0) {
			return true; //meaning false
		} else {
			return false;
		}		
		
	}
	
	public void updateEntry(String mlocation, String area, String photo) {
		ContentValues updatedValues = new ContentValues();
		updatedValues.put("LOCATION", mlocation);
		updatedValues.put("AREA", area);
		updatedValues.put("PHOTO", photo);
		
		String where = "LOCATION=?";
		db.update("PHOTOMOLES", updatedValues, where, new String[]{mlocation});
	}*/


}
