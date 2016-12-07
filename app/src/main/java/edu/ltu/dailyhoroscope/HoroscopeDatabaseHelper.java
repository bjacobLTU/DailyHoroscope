package edu.ltu.dailyhoroscope;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class HoroscopeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "horoscopedb"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database
    private static final String DATABASE_NAME = "horoscopeDB.db";
    public static final String TABLE_HOROSCOPE = "horoscopes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "horoscopename";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_SYMB = "symbol";
    public static final String COLUMN_MONTH = "month";

    HoroscopeDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)  {
        updateMyDatabase(db, 0, DB_VERSION);
    }
    /*public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE HOROSCOPE (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT;");
        int count = Horoscope.horoscopes.length;
        for (int i =0; i < count; i++) {
            insertHoroscope(db, Horoscope.horoscopes[i].getName(), Horoscope.horoscopes[i].getDescription());
        }
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            String query = "CREATE TABLE " + TABLE_HOROSCOPE + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DESC + " TEXT, " +
                    COLUMN_SYMB + " TEXT, " +
                    COLUMN_MONTH + " TEXT " +
                    ");";
            db.execSQL(query);
            int count = Horoscope.horoscopes.length;
            for (int i =0; i < count; i++) {
                insertHoroscope(db, Horoscope.horoscopes[i].getName(), Horoscope.horoscopes[i].getDescription(),
                        Horoscope.horoscopes[i].getSymbol(),Horoscope.horoscopes[i].getMonth());
                Log.d("TAG", "updateMyDatabase() returned: " + Horoscope.horoscopes[i].getName());
            }
        }
        /*if (oldVersion < 2) {
            db.execSQL("ALTER TABLE HOROSCOPE ADD COLUMN FAVORITE NUMERIC;");
        }*/
    }

    private static void insertHoroscope(SQLiteDatabase db, String addname,
                                        String adddescription, String addsymbol,
                                        String addmonth){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, addname);
        values.put(COLUMN_DESC, adddescription);
        values.put(COLUMN_SYMB, addsymbol);
        values.put(COLUMN_MONTH, addmonth);
        db.insert(TABLE_HOROSCOPE, null, values);
    }
}
