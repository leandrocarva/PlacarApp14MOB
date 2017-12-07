package br.com.fiap.placarapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String timeCasa;
    private String timeVisitante;

    private TextView tvTimeCasa;
    private TextView tvTimeVisitante;

    private TextView tvPlacarCasa;
    private TextView tvPlacarVisitante;

    private int golCasa;
    private int golVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvTimeCasa = (TextView) findViewById(R.id.tvTimeCasa);
        tvTimeVisitante = (TextView) findViewById(R.id.tvTimeVisitante);

        tvPlacarCasa = (TextView) findViewById(R.id.tvPlacarCasa);
        tvPlacarVisitante = (TextView) findViewById(R.id.tvPlacarVisitante);

        if (getIntent() != null) {
            timeCasa = getIntent().getStringExtra("TIMECASA");
            timeVisitante = getIntent().getStringExtra("TIMEVISITANTE");

            tvTimeCasa.setText(timeCasa);
            tvTimeVisitante.setText(timeVisitante);
        }
         /* quando a tela é recriada inserimos os dados*/
        if (savedInstanceState != null) {
            golCasa = savedInstanceState.getInt("GOLCASA");
            golVisitante = savedInstanceState.getInt("GOLVISITANTE");
        }

        tvPlacarCasa.setText(String.valueOf(golCasa));
        tvPlacarVisitante.setText(String.valueOf(golVisitante));
    }



    public void golCasa(View v) {
        golCasa++;
        tvPlacarCasa.setText(String.valueOf(golCasa));
    }

    public void golVisitante(View v) {
        golVisitante++;
        tvPlacarVisitante.setText(String.valueOf(golVisitante));
    }

    @Override /* para quando girar o cel ou entrar uma ligação faz com que não perdemos os dados*/
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("GOLCASA",golCasa);
        outState.putInt("GOLVISITANTE",golVisitante);
    }
}
