package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainDB extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "ehealth.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // creating a constructor for our database handler.
    public MainDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // method to execute sql query
        db.execSQL("CREATE TABLE covid19Case (ID INTEGER PRIMARY KEY AUTOINCREMENT, patientID TEXT, activeDate TEXT, caseType TEXT, isActiveCase INTEGER, recoveryDate TEXT);");
        db.execSQL("CREATE TABLE covid19Info (ID INTEGER PRIMARY KEY AUTOINCREMENT, covidInfoTitle TEXT, covidInfoDate TEXT, covidInfoContent TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS covid19Case");
        db.execSQL("DROP TABLE IF EXISTS covid19Info");
        onCreate(db);
    }
}

