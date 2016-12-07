package edu.ltu.dailyhoroscope;
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