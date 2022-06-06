package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import Model.MainDB;

public class Covid19CaseRecord {

     // my sqlite database
    private MainDB mainDB;
    private Context context;

    private final String TABLE_NAME = "covid19Case";
    private final String COL_ID = "ID";
    private final String COL_PATIENT = "patientID";
    private final String COL_ACTIVE = "activeDate";
    private final String COL_CASE_TYPE = "caseType";
    private final String COL_CASE = "isActiveCase";
    private final String COL_RECOVERY = "recoveryDate";

    // Constructor
    public Covid19CaseRecord(Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    /**
        CREATE
    */
    // method: add positive case
    public void addPositiveCase(String icNumber, String caseType, String date) {
       
        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

        // pass values along with its key and value pair.
        cv.put(COL_PATIENT, icNumber);
        cv.put(COL_ACTIVE, date);
        cv.put(COL_CASE_TYPE, caseType);
        cv.put(COL_CASE, 1); // is active case
        cv.put(COL_RECOVERY, (String) null); // havnt recovery

        try {
            // insert into database
            db.insert(TABLE_NAME, null, cv);
            Toast.makeText(context, "Added successfully.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Insert data failed.", Toast.LENGTH_SHORT).show();
        }
        
        db.close();
    }

    /**
        READ 
    */
    // method: get total active case
    public ArrayList<Covid19CaseModel> readCovid19Case() {

        SQLiteDatabase db = mainDB.getReadableDatabase();

        // creating a cursor with query to read data from database.
        Cursor cursorCovid19Case = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Covid19CaseModel> covid19CaseRecordArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCovid19Case.moveToFirst()) {
            do {
                // adding the data from cursor to our array list.
                covid19CaseRecordArrayList.add(new Covid19CaseModel(cursorCovid19Case.getInt(0), cursorCovid19Case.getString(1), cursorCovid19Case.getString(2), cursorCovid19Case.getString(3), cursorCovid19Case.getInt(4), cursorCovid19Case.getString(5)));
            } while (cursorCovid19Case.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCovid19Case.close();
        return covid19CaseRecordArrayList;
    }

    /**
        UPDATE
    */
    // method: edit covid-19 information & news
    public void updateExistingCase(int id, String icNumber, String activeDate, String caseType) {

        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

        // pass values along with its key and value pair.
        cv.put(COL_PATIENT, icNumber);
        cv.put(COL_ACTIVE, activeDate);
        cv.put(COL_CASE_TYPE, caseType);

        try {
            // update into database
            db.update(TABLE_NAME, cv, "ID=?", new String[] {String.valueOf(id)});
            Toast.makeText(context, "Update successfully. ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Update data failed.", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    // method: close case
    public void closeCase(int id, String recoveryDate) {

        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

        // pass values along with its key and value pair.
        cv.put(COL_CASE, 0);
        cv.put(COL_RECOVERY, recoveryDate);

        try {
            // update into database
            db.update(TABLE_NAME, cv, "ID=?", new String[] {String.valueOf(id)});
            Toast.makeText(context, "Close case successfully. ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Close case failed.", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}
