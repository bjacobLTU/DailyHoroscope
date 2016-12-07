package edu.ltu.dailyhoroscope;
/*
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends ListActivity {

    //private SQLiteDatabase db;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        //Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {
                        if (position == 0) {
                            Intent intent = new Intent(TopLevelActivity.this,
                                    HoroscopeActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        //Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listHoroscopes = getListView();

        try {
            SQLiteOpenHelper horoscopeDatabaseHelper = new HoroscopeDatabaseHelper(this);
            db = horoscopeDatabaseHelper.getReadableDatabase();

            cursor = db.query("HOROSCOPE",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listHoroscopes.setAdapter(listAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Close the cursor and database in the onDestroy() method
    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    public void onRestart() {
        super.onRestart();
        try {
            HoroscopeDatabaseHelper horoscopeDatabaseHelper = new HoroscopeDatabaseHelper(this);
            db = horoscopeDatabaseHelper.getReadableDatabase();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(TopLevelActivity.this, HoroscopeActivity.class);
        intent.putExtra(HoroscopeActivity.EXTRA_HOROSCOPENO, (int) id);
        startActivity(intent);
    }
}
*/

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

public class TopLevelActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listHoroscopes = getListView();
        ArrayAdapter<Horoscope> listAdapter = new ArrayAdapter<Horoscope>(this,
                android.R.layout.simple_list_item_1,
                Horoscope.horoscopes);
        listHoroscopes.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(TopLevelActivity.this, HoroscopeActivity.class);
        intent.putExtra(HoroscopeActivity.EXTRA_HOROSCOPENO, (int) id);
        startActivity(intent);
    }
}