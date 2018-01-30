package org.bubulescu.searchactionbar;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends AppCompatActivity {

    private static String[] towns = {"Zagreb", "Split", "Splitski", "Splitskom", "Splitu", "Osijek", "Zadar"};
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        tvResult = findViewById(R.id.tvResult);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            String result = search(query);
            //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            tvResult.setText(result);
        }
    }

    private String search(String query) {
        StringBuilder sb = new StringBuilder();
        for (String town : towns) {
            if (town.toLowerCase().startsWith(query.toLowerCase())) {
                if (sb.length() > 1) sb.append("\n");
                sb.append(town);
            }
        }
        if (sb.length() == 0) {
            sb.append("Nema rezultata");
        }
        return sb.toString();
    }
}
