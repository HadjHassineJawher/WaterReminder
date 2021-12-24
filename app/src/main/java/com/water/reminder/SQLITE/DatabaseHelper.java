package com.water.reminder.SQLITE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Warter_Reminder_DB";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "users";
    private static final String USER_ID = "id";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String WEIGHT = "weight";
    private static final String HEIGHT = "height";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " ( "
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USERNAME + "  VARCHAR(255), "
            + EMAIL + "  VARCHAR(255),"
            + PASSWORD + "  VARCHAR(255), "
            + WEIGHT + "  VARCHAR(255), "
            + HEIGHT + "  VARCHAR(255));";

    private String drop = "drop table if exists " + TABLE_NAME;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(drop);
        onCreate(db);
    }



    public void insetUser(String username, String email, String password, String weight, String height) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.USERNAME, username);
        contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.PASSWORD, password);
        contentValues.put(DatabaseHelper.WEIGHT, weight);
        contentValues.put(DatabaseHelper.HEIGHT, height);


        db.insert(TABLE_NAME, null, contentValues);
    }

    public User getUserByID(int id){

        SQLiteDatabase db=  this.getReadableDatabase();

        User user = new User();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME +" where id = ?", new String[]{Integer.toString(id)},null);
        //System.out.println(res.moveToFirst());
        if (res.moveToFirst()==true){
            user.setId(res.getString(res.getColumnIndex(USER_ID)));
            user.setUsername(res.getString(res.getColumnIndex(USERNAME)));
            user.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            user.setPassword(res.getString(res.getColumnIndex(PASSWORD)));
            user.setWeigth(res.getString(res.getColumnIndex(WEIGHT)));
            user.setHeigth(res.getString(res.getColumnIndex(HEIGHT)));
        }

        return user;
    }
    public User Login(String email, String password){

        SQLiteDatabase db=  this.getReadableDatabase();

        User user = new User();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME +" where "+EMAIL+" = ?"+" AND "+PASSWORD+" =?", new String[]{email,password},null);
        //System.out.println(res.moveToFirst());
        if (res.moveToFirst()==true){
            user.setId(res.getString(res.getColumnIndex(USER_ID)));
            user.setUsername(res.getString(res.getColumnIndex(USERNAME)));
            user.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            user.setPassword(res.getString(res.getColumnIndex(PASSWORD)));
            user.setWeigth(res.getString(res.getColumnIndex(WEIGHT)));
            user.setHeigth(res.getString(res.getColumnIndex(HEIGHT)));
        }

        return user;
    }

    public User CheckIfEmailExist(String email){

        SQLiteDatabase db=  this.getReadableDatabase();

        User user = new User();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME +" where "+EMAIL+" = ?", new String[]{email},null);
        //System.out.println(res.moveToFirst());
        if (res.moveToFirst()==true){
            user.setId(res.getString(res.getColumnIndex(USER_ID)));
            user.setUsername(res.getString(res.getColumnIndex(USERNAME)));
            user.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            user.setPassword(res.getString(res.getColumnIndex(PASSWORD)));
            user.setWeigth(res.getString(res.getColumnIndex(WEIGHT)));
            user.setHeigth(res.getString(res.getColumnIndex(HEIGHT)));
        }

        return user;
    }

    public ArrayList getAllUsers() {
        ArrayList usersList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            usersList.add(res.getString(res.getColumnIndex(USER_ID) )+":"
                         +res.getString(res.getColumnIndex(USERNAME))
                         +":"+res.getString(res.getColumnIndex(EMAIL))
                         +":"+res.getString(res.getColumnIndex(PASSWORD))
                         +":"+res.getString(res.getColumnIndex(WEIGHT))
                         +":"+res.getString(res.getColumnIndex(HEIGHT)));

            res.moveToNext();

        }
        return usersList;
    }



    public void deleteUser(int id){
        SQLiteDatabase db=  this.getWritableDatabase();
        db.delete(TABLE_NAME,"id = ?",new String[]{Integer.toString(id)});

    }

    public void updateUser(String username, String weight, String height,int id){
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,username);
        contentValues.put(WEIGHT,weight);
        contentValues.put(HEIGHT,height);

        db.update(TABLE_NAME,contentValues,"id= ?",new String[]{Integer.toString(id)});
    }
}
