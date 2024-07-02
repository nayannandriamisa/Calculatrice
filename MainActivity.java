package com.example.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Les clés pour les extras de l'Intent
    public final static String OPERANDE_1 = "operande_1";
    public final static String OPERANDE_2 = "operande_2";
    public final static String OPERATEUR = "operateur";

    private EditText operande_1;    // Zone d'édition pour l'operande 1
    private EditText operande_2;    // Zone d'édition pour l'operande 2
    private EditText operateur;     // Zone d'édition pour l'operateur
    private Button bt_calculer;     // Bouton pour calculer

    private TextView tv_resultat;   // Affichage du résultat du calcul

    public static final int REQ_CALCUL = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deserialiserRessources();

        initConnection();

    }

    /**
     * Désérialise les ressources
     */
    private void deserialiserRessources() {
        this.operande_1 = (EditText) this.findViewById(R.id.et_op1);
        this.operande_2 = (EditText) this.findViewById(R.id.et_op2);
        this.operateur = (EditText) this.findViewById(R.id.et_oper);
        this.bt_calculer = (Button) this.findViewById(R.id.bt_calculer);
    }

    /**
     * Mise en place des écouteurs
     */
    private void initConnection() {
        bt_calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op_1 = operande_1.getText().toString();
                String op_2 = operande_2.getText().toString();
                String oper = operateur.getText().toString();

                try {

                    float op1 = Float.parseFloat(op_1);
                    float op2 = Float.parseFloat(op_2);

                    Intent intent = new Intent(
                            MainActivity.this,
                            Calcul.class
                    );

                    intent.putExtra(OPERANDE_1,op1);
                    intent.putExtra(OPERANDE_2,op2);
                    intent.putExtra(OPERATEUR,oper);
                    startActivityForResult(intent, 1);


                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Syntaxe invalide", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // A compléter
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

            }

        } else {
            super.onActivityResult(requestCode,resultCode,data);
        }

    }

}