package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class Covid19InfoRecord {

    // my sqlite database
    private MainDB mainDB;
    private Context context;

    private final String TABLE_NAME = "covid19Info";
    private final String COL_TITLE = "covidInfoTitle";
    private final String COL_DATE = "covidInfoDate";
    private final String COL_CONTENT = "covidInfoContent";

    // Constructor
    public Covid19InfoRecord(Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    /**
        CREATE
    */
    // method: create covid-19 information & news
    public void publish(String title, String date, String content) {

        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

        // pass values along with its key and value pair.
        cv.put(COL_TITLE, title);
        cv.put(COL_DATE, date);
        cv.put(COL_CONTENT, content);

        
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
    // method: create covid-19 information & news
    public ArrayList<Covid19InfoModel> readCovid19Info() {

        SQLiteDatabase db = mainDB.getReadableDatabase();

        // creating a cursor with query to read data from database.
        Cursor cursorCovid19Info = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Covid19InfoModel> covid19InfoRecordArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCovid19Info.moveToFirst()) {
            do {
                // adding the data from cursor to our array list.
                covid19InfoRecordArrayList.add(new Covid19InfoModel(cursorCovid19Info.getInt(0), cursorCovid19Info.getString(1), cursorCovid19Info.getString(2), cursorCovid19Info.getString(3)));
            } while (cursorCovid19Info.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCovid19Info.close();
        return covid19InfoRecordArrayList;
    }

    /**
        UPDATE
    */
    // method: edit covid-19 information & news
    public void updateCovidInfo(int id, String title, String date, String content) {

        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        // variable for content values.
        ContentValues cv = new ContentValues();

        // pass values along with its key and value pair.
        cv.put(COL_TITLE, title);
        cv.put(COL_DATE, date);
        cv.put(COL_CONTENT, content);

        try {
            // update into database
            db.update(TABLE_NAME, cv, "ID=?", new String[] {String.valueOf(id)});
            Toast.makeText(context, "Update successfully. " + id, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Update data failed.", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    /**
        DELETE
    */
    // method: delete covid-19 information & news
    public void deleteCovidInfo(int id) {

        // create variable for our sqlite database
        // call method to write database
        SQLiteDatabase db = mainDB.getWritableDatabase();

        try {
            // delete row in database
             db.delete(TABLE_NAME, "ID=?", new String[] {String.valueOf(id)});
            Toast.makeText(context, "Delete item successfully. " + id, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Delete item failed.", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}
