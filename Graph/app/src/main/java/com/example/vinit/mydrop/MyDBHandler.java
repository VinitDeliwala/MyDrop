package com.example.vinit.mydrop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "MyDrop.db";
    public static final String TABLE_MOVIENAME = "sis";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_MOVIENAME="nname";
    public static final String COLUMN_NLIKE = "nlike";
    public static final String COLUMN_NSHARE = "nshare";
    public static final String COLUMN_NCOMMENT = "ncomment";
    public static final String COLUMN_NEVENTS= "nevents";
    public static final String COLUMN_NALBUMS = "nalbums";


    public static final String TABLE_RMOVIENAME = "ndate";
    public static final String R_COLUMN_ID="_id";
    public static final String R_COLUMN_IDD="idd";
    public static final String R_COLUMN_ATTTR="attr";
    public static final String R_COLUMN_JAN="JAN";
    public static final String R_COLUMN_FEB = "FEB";
    public static final String R_COLUMN_MAR = "MAR";
    public static final String R_COLUMN_APR = "APR";
    public static final String R_COLUMN_MAY = "MAY";
    public static final String R_COLUMN_JUN = "JUN";
    public static final String R_COLUMN_JUL = "JUL";
    public static final String R_COLUMN_AUG = "AUG";
    public static final String R_COLUMN_SEP = "SEP";
    public static final String R_COLUMN_OCT = "OCT";
    public static final String R_COLUMN_NOV = "NOV";
    public static final String R_COLUMN_DEC = "DEC";


    public static final String TABLE_ALLMOVIENAME = "AllMovie";
    public static final String ALL_COLUMN_ID="_id";

    public static final String ALL_COLUMN_GENRE = "genre";
    public static final String ALL_COLUMN_PLOT = "plot";
    public static final String ALL_COLUMN_DIRECTOR = "director";
    public static final String ALL_COLUMN_YOUTUBE = "youtube";
    public static final String ALL_COLUMN_RELEASED = "released";


    Calendar c = Calendar.getInstance();

    // Login table name
    private static final String TABLE_USER = "user";

    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_UID = "uid";
    private static final String KEY_CREATED_AT = "created_at";





    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MOVIENAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MOVIENAME + " TEXT, " +
                COLUMN_NLIKE + " TEXT, " +
                COLUMN_NSHARE + " TEXT, " +
                COLUMN_NCOMMENT + " TEXT, " +
                COLUMN_NEVENTS + " TEXT, " +
                COLUMN_NALBUMS + " TEXT, " +
                " UNIQUE (" + COLUMN_MOVIENAME + ") );";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_RMOVIENAME + "(" +
                R_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                R_COLUMN_IDD + " TEXT, " +
                R_COLUMN_ATTTR + " TEXT, " +
                R_COLUMN_JAN + " TEXT, " +
                R_COLUMN_FEB + " TEXT, " +
                R_COLUMN_MAR + " TEXT, " +
                R_COLUMN_APR + " TEXT, " +
                R_COLUMN_MAY + " TEXT, " +
                R_COLUMN_JUN + " TEXT, " +
                R_COLUMN_JUL + " TEXT, " +
                R_COLUMN_AUG + " TEXT, " +
                R_COLUMN_SEP + " TEXT, " +
                R_COLUMN_OCT + " TEXT, " +
                R_COLUMN_NOV + " TEXT, " +
                R_COLUMN_DEC + " TEXT, " +
                " UNIQUE (" + R_COLUMN_ID + ") );";
        db.execSQL(query2);


        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE," + KEY_UID + " TEXT,"
                + KEY_CREATED_AT + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIENAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RMOVIENAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void add(MovieFav moviename){
        ContentValues values = new ContentValues();
        values.put(COLUMN_MOVIENAME, moviename.get_moviename());
        values.put(COLUMN_NLIKE, moviename.get_genere());
        values.put(COLUMN_NSHARE, moviename.get_plot());
        values.put(COLUMN_NCOMMENT, moviename.get_director());
        values.put(COLUMN_NEVENTS, moviename.get_youtube());
        values.put(COLUMN_NALBUMS, moviename.get_released());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MOVIENAME, null, values);
        db.close();
    }



    public void addall(DateDB data){
        ContentValues values = new ContentValues();
        values.put(R_COLUMN_IDD,data.get_idd());
        values.put(R_COLUMN_ATTTR, data.get_attr());
        values.put(R_COLUMN_JAN, data.get_jan());
        values.put(R_COLUMN_FEB, data.get_feb());
        values.put(R_COLUMN_MAR, data.get_mar());
        values.put(R_COLUMN_APR, data.get_apr());
        values.put(R_COLUMN_MAY, data.get_may());
        values.put(R_COLUMN_JUN, data.get_jun());
        values.put(R_COLUMN_JUL, data.get_jul());
        values.put(R_COLUMN_AUG, data.get_aug());
        values.put(R_COLUMN_SEP, data.get_sep());
        values.put(R_COLUMN_OCT, data.get_oct());
        values.put(R_COLUMN_NOV, data.get_nov());
        values.put(R_COLUMN_DEC, data.get_dec());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_RMOVIENAME, null, values);
        db.close();
    }

    public void deletemovietable(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ALLMOVIENAME);
//        db.execSQL("DELETE FROM " + TABLE_RMOVIENAME);
        db.close();
    }


    //Delete a product from the database
    public void deleteMoviename(String moviename){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MOVIENAME + " WHERE " + COLUMN_MOVIENAME + "=\"" + moviename + "\";");
        db.close();
    }

    public Boolean ifpresent(String moviename){
        String query = "SELECT " +COLUMN_MOVIENAME + " FROM " + TABLE_MOVIENAME +  " WHERE " + COLUMN_MOVIENAME + "=\"" + moviename + "\";";
        String dbString = "";

        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("moviename")) != null) {
                dbString += c.getString(c.getColumnIndex("moviename"));
            }
            c.moveToNext();
        }
        db.close();
        Log.d("state1", dbString);
        System.out.println(dbString.length() + "db");
        if(dbString==""){
            return false;
        }else{
            return true;
        }


    }


    public String databaseToString(){
        String dbString = "";
        String Check = null;
        String query = "SELECT" + COLUMN_MOVIENAME +  "FROM " + TABLE_MOVIENAME + " WHERE 1";
        Log.d(Check,query);
        //Cursor points to a location in your results
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("plot")) != null) {
                dbString += c.getString(c.getColumnIndex("plot"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public Cursor fetchFavMovies() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor = db.query(TABLE_MOVIENAME, new String[]{COLUMN_ID,
                        COLUMN_MOVIENAME, COLUMN_NLIKE, COLUMN_NSHARE, COLUMN_NCOMMENT,
                        COLUMN_NEVENTS, COLUMN_NALBUMS},
                null, null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        db.close();
        return mCursor;
    }
    public Cursor fetchFav() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor = db.query(TABLE_RMOVIENAME, new String[]{R_COLUMN_ID,
                        R_COLUMN_IDD, R_COLUMN_ATTTR, R_COLUMN_JAN,
                        R_COLUMN_FEB, R_COLUMN_MAR,R_COLUMN_APR,R_COLUMN_MAY,R_COLUMN_JUN,R_COLUMN_JUL,R_COLUMN_AUG,R_COLUMN_SEP,R_COLUMN_OCT,R_COLUMN_NOV,R_COLUMN_DEC},
                null, null, null, null,null,null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        db.close();
        return mCursor;
    }



    public void addUser(String name, String email, String uid, String created_at) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_EMAIL, email); // Email
        values.put(KEY_UID, uid); // Email
        values.put(KEY_CREATED_AT, created_at); // Created At

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("uid", cursor.getString(3));
            user.put("created_at", cursor.getString(4));
        }
        cursor.close();
        db.close();
        // return user

        return user;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

    }

}









