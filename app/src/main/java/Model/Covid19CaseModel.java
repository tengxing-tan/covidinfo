package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import Model.MainDB;

public class Covid19CaseModel {

     // my sqlite database
    private MainDB mainDB;
    private Context context;

    private final String TABLE_NAME = "covid19Case";
    private final String COL_PATIENT = "patientID";
    private final String COL_CASE_TYPE = "caseType";
    private final String COL_ACTIVE = "activeDate";
    private final String COL_CASE = "isActiveCase";
    private final String COL_RECOVERY = "recoveryDate";

    // Constructor
    public Covid19CaseModel(Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    // method: add positive case
    public void addPositiveCase(String icNumber, String caseType, String date) {
       // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

// pass values along with its key and value pair.
        cv.put(COL_PATIENT, icNumber);
        cv.put(COL_CASE_TYPE, caseType);
        cv.put(COL_ACTIVE, date);
        cv.put(COL_CASE, 1);
        cv.put(COL_RECOVERY, (String) null);

        try {
            db.insert(TABLE_NAME, null, cv);
            Toast.makeText(context, "Added successfully.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Insert data failed.", Toast.LENGTH_SHORT).show();
        }
        
        db.close();
    }
}
