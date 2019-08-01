package com.example.vibhor.databaseapp.db;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;

        import com.example.vibhor.databaseapp.ui.MainActivity;

/**
 * Created by vibhor on 25-Jun-16.
 */
public class DatabaseSource {
    private MainActivity mainActivity = new MainActivity();

    private SQLiteDatabase mSqLiteDatabase;
    private DataBaseHelper mDataBaseHelper;
    private Context mContext;

    public DatabaseSource(Context mContext) {
        this.mContext = mContext;
        mDataBaseHelper = new DataBaseHelper(mContext);
    }


    //open

    public void openData() throws SQLiteException {
        mSqLiteDatabase = mDataBaseHelper.getWritableDatabase();

    }

    //close
    public void closeData() throws SQLiteException {
        mSqLiteDatabase.close();
    }

    //insert
    public long insertData(String firstName, String firstNumber, String secondName, String secondNumber) throws SQLiteException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.TABLE_NAME, firstName);
        contentValues.put(DataBaseHelper.TABLE_NAME, firstNumber);
        contentValues.put(DataBaseHelper.TABLE_NAME, secondName);
        contentValues.put(DataBaseHelper.TABLE_NAME, secondNumber);
        long id = mSqLiteDatabase.insert(DataBaseHelper.TABLE_NAME, null, contentValues);
        return id;


    }

    //update

    public int updateData(String firstName, String firstNumber, String secondName, String secondNumber) throws SQLiteException

    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.TABLE_NAME, firstName);
        contentValues.put(DataBaseHelper.TABLE_NAME, firstNumber);
        contentValues.put(DataBaseHelper.TABLE_NAME, secondName);
        contentValues.put(DataBaseHelper.TABLE_NAME, secondNumber);
        int rowUpdated = mSqLiteDatabase.update(
                DataBaseHelper.TABLE_NAME,
                contentValues,
                null,
                null
        );


        return rowUpdated;
    }

    //delete
    public int deleteData() {

      int deleteData =  mSqLiteDatabase.delete(
               mDataBaseHelper.TABLE_NAME,
               null,
               null
       );
        return  deleteData;
    }

}
