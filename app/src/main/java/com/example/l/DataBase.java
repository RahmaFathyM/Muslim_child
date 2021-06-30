package com.example.l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.l.quran.QuranDataBase;

import java.util.ArrayList;




    public class DataBase extends SQLiteOpenHelper {
        public static final String DB_NAME = " quraan_db ";
        public static final int DB_VERSION =1;
        public static final String QURAAN_TABLE_NAME = "quraan";
        public static final String QURAAN_COLUMN_SORA = " namesora ";
        public static final String QURAAN_COLUMN_ID_IMG = "id";


        public DataBase(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+ QURAAN_TABLE_NAME +" ("+ QURAAN_COLUMN_SORA+" TEXT,"+" "+ QURAAN_COLUMN_ID_IMG + " INTEGER)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + QURAAN_TABLE_NAME);
            onCreate(db);
        }

        public boolean insertquraan(QuranDataBase quraanDataBase) {
            SQLiteDatabase db = getWritableDatabase();  // key = the name of cln , value : stories_card .
            ContentValues values = new ContentValues();  // this class store the value that i want add it to the table .
            values.put(QURAAN_COLUMN_ID_IMG , quraanDataBase.getImg()); // add to this cln .. this value .
            values.put(QURAAN_COLUMN_SORA ,quraanDataBase.getName());
            long result =  db.insert(QURAAN_TABLE_NAME , null,values);
            return result != -1 ;
            // if (result == -1)
            //  return false;
            //else return true;
        }

        public ArrayList getallsor() {
            ArrayList <QuranDataBase> stories_cards = new ArrayList<>();
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor= db.rawQuery( "SELECT * FROM " +  QURAAN_TABLE_NAME ,null );
            if(cursor!=null &&cursor.moveToFirst()){
                do {
                    String name = cursor.getString(cursor.getColumnIndex(QURAAN_COLUMN_SORA));
                    int id = cursor.getInt(cursor.getColumnIndex(QURAAN_COLUMN_ID_IMG));
                    QuranDataBase stories_card = new QuranDataBase(name, id);
                    stories_cards.add(stories_card);
                }while (cursor.moveToNext());
                cursor.close();
            }
            return stories_cards ;
        }

    }


