package Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Covid19InfoModel extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "EHealth.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "covid19Case";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PATIENT = "patientID";
    private static final String COLUMN_CASE_TYPE = "caseType";
    private static final String COLUMN_CASE = "isActiveCase";
    private static final String COLUMN_ACTIVE = "activeDate";
    private static final String COLUMN_RECOVERY = "recoveryDate";


    public Covid19InfoModel(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PATIENT + " TEXT,  " +
                    COLUMN_CASE_TYPE + " TEXT, " +
                    COLUMN_CASE + " INTEGER, " +
                    COLUMN_ACTIVE + " DATE, " +
                    COLUMN_RECOVERY + " DATE);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
