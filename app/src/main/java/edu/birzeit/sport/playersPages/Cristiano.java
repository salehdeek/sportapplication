package edu.birzeit.sport.playersPages;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.birzeit.sport.R;
import edu.birzeit.sport.services.PlayerService;

public class Cristiano extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] teams = {};
    PlayerService playerService = PlayerService.getPlayerService();
    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cristiano);
        setSpinnerData();


    }

    private void setSpinnerData() {
      spinner = findViewById(R.id.teams_spinner);
        teams = playerService.getTeams();
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                teams);

        arrayAdapter.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Toast.makeText(this, "105 GOALS WITH RM", Toast.LENGTH_LONG).show();
        }
        if (position == 1) {
            Toast.makeText(this, "15 GOALS WITH MU", Toast.LENGTH_LONG).show();

        }
        if (position == 2) {
            Toast.makeText(this, "10 GOALS WITH JV", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}