package com.example.vibhor.databaseapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vibhor on 25-Jun-16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String  CUSTOMER_ID ="_ID" ;
    public static final String  CUSTOMER_NAME = "NAME";
    public static final String PHONE_NUMBERS = "PHONE_NUMBERS";
    private static final String DB_NAME = "Customer_details.db";
    private static int DB_VERSION=1;
    public static final String TABLE_NAME = "DETAIL";
    public static  final String Query = "CREATE TABLE "+ TABLE_NAME + "(" +

            CUSTOMER_NAME + " VARCHAR2 " +
            " , " + PHONE_NUMBERS + "  INTEGERS)";


    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DataBaseHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
