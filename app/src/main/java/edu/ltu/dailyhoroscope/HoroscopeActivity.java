package edu.ltu.dailyhoroscope;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.CheckBox;
import android.content.ContentValues;
import android.os.AsyncTask;

public class HoroscopeActivity extends AppCompatActivity {

    public static final String EXTRA_HOROSCOPENO = "horoscopeNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        //Get the horoscope from the intent
        int horoscopeNo = (Integer)getIntent().getExtras().get(EXTRA_HOROSCOPENO);
        Horoscope horoscope = Horoscope.horoscopes[horoscopeNo];
        HoroscopeText detailhoroscope = HoroscopeText.horoscopesummary[horoscopeNo];

        //Create a cursor
        try {
            SQLiteOpenHelper horoscopeDatabaseHelper = new HoroscopeDatabaseHelper(this);
            SQLiteDatabase db = horoscopeDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query (HoroscopeDatabaseHelper.TABLE_HOROSCOPE,
                    new String[] {HoroscopeDatabaseHelper.COLUMN_NAME, HoroscopeDatabaseHelper.COLUMN_DESC,
                            HoroscopeDatabaseHelper.COLUMN_SYMB, HoroscopeDatabaseHelper.COLUMN_MONTH},
                    "_id = ?",
                    new String[] {Integer.toString(horoscopeNo+1)},
                    null, null,null);

            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {

                //Get the horoscope details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                String symbolText = cursor.getString(2);
                String monthText = cursor.getString(3);

                //Populate the drink name
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);

                //Populate the drink description
                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);

                //Populate the horoscope symbol
                TextView symbol = (TextView)findViewById(R.id.symbol);
                //symbol.setText(horoscope.getSymbol());
                symbol.setText(symbolText);

                //Populate the horoscope month
                TextView month = (TextView)findViewById(R.id.month);
                //month.setText(horoscope.getMonth());
                month.setText(monthText);

                BottomHoroscopeFragment bottomFragment = (BottomHoroscopeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                bottomFragment.setSummaryText(detailhoroscope.getHoroscope());

            }
            cursor.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
     }
}
    /*//Inner class to update the horoscope.
    private class UpdateHoroscopeTask extends AsyncTask<Integer, Void, Boolean> {
        ContentValues horoscopeValues;
        protected void onPreExecute() {
            //CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            //horoscopeValues = new ContentValues(); horoscopeValues.put("FAVORITE", favorite.isChecked());
        }
        protected Boolean doInBackground(Integer... horoscopes) {
            int horoscopeNo = horoscopes[0];
            SQLiteOpenHelper horoscopeDatabaseHelper = new HoroscopeDatabaseHelper(HoroscopeActivity.this);
            try {
                SQLiteDatabase db = horoscopeDatabaseHelper.getWritableDatabase();
                db.update("HOROSCOPE", horoscopeValues,
                        "_id = ?", new String[] {Integer.toString(horoscopeNo)});
                db.close();
                return true;
            } catch(SQLiteException e) {
                return false;
            }
        }
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(HoroscopeActivity.this,
                        "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }*/