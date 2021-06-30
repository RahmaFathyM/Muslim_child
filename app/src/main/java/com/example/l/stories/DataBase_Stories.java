package com.example.l.stories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase_Stories extends SQLiteOpenHelper {

    public static final String DB_NAME = "story_db" ;
    public static final int DB_ID = 2 ;
    public static  final  String STORY_TB_NAME = "story";
    public static final String STORY_CLN_STORYNAME = "StoryName";
    public static final String STORY_CLN_ID_IMG = "IdImage";

    public DataBase_Stories(@Nullable Context context) {
        super(context,DB_NAME, null , DB_ID);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {     // it's called  when construct dataBase , db variable from db .
        db.execSQL("CREATE TABLE "+ STORY_TB_NAME +" ("+ STORY_CLN_ID_IMG +" INTEGER ,"+" "+ STORY_CLN_STORYNAME + " TEXT)"); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {   // it's called in every update for database =  it's caalled when change the value of version .
        db.execSQL("DROP TABLE IF EXISTS " + STORY_TB_NAME);                                   // if you add thing to db or you changed the version  .. it will delete db and create it again .
        onCreate(db);                                                              // we use ALTER when the app is download actualy ...//
         }
    public boolean insertStory(Stories_Card stories_card){
        SQLiteDatabase db = getWritableDatabase();  // key = the name of cln , value : stories_card .
        ContentValues values = new ContentValues();  // this class store the value that i want add it to the table .
        values.put(STORY_CLN_STORYNAME , stories_card.getNameStory()); // add to this cln .. this value .
        values.put(STORY_CLN_ID_IMG ,stories_card.getId());
        long result =  db.insert(STORY_TB_NAME , null,values);
        return result != -1 ;
    }
    public ArrayList getAllStories(){
        ArrayList <Stories_Card> stories_cards = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor= db.rawQuery( "SELECT * FROM " +  STORY_TB_NAME ,null );
        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex(STORY_CLN_STORYNAME));
                int id = cursor.getInt(cursor.getColumnIndex(STORY_CLN_ID_IMG));
                Stories_Card stories_card = new Stories_Card(name, id);
                stories_cards.add(stories_card);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return stories_cards ;
    }
}

