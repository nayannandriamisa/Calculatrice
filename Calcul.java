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

public class Calcul extends Activity {

    private TextView tv_calcul; // Affichage du résultat du calcul
    private Button bt_retour;   // Bouton de retour

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calcul);

        deserialiserRessources();

        initConnection();

        Intent intent = this.getIntent();

        float op1 = intent.getFloatExtra(MainActivity.OPERANDE_1,0);
        float op2 = intent.getFloatExtra(MainActivity.OPERANDE_2,0);
        String oper = intent.getStringExtra(MainActivity.OPERATEUR);

        if (oper.equals("+")) {
            float res = op1 + op2;
            tv_calcul.setText(String.valueOf(op1) +" "+ oper +" " + String.valueOf(op2) + " = " + String.valueOf(res));
        } else if (oper.equals("-")) {
            float res = op1 - op2;
            tv_calcul.setText(String.valueOf(op1) + " "+ oper +" " + String.valueOf(op2) + " = " + String.valueOf(res));
        } else if (oper.equals("×") || oper.equals("*")) {
            float res = op1 * op2;
            tv_calcul.setText(String.valueOf(op1) + " "+ oper +" " + String.valueOf(op2) + " = " + String.valueOf(res));
        } else if (oper.equals("÷") || oper.equals("/")) {
            float res = op1/op2;
            tv_calcul.setText(String.valueOf(op1) + " "+ oper +" " + String.valueOf(op2) + " = " + String.valueOf(res));
        } else {
            tv_calcul.setText("Erreur");
        }
    }

    /**
     * Désérialise les ressources
     */
    private void deserialiserRessources() {
        this.tv_calcul = (TextView) this.findViewById(R.id.tv_res);
        this.bt_retour = (Button) this.findViewById(R.id.bt_retour);
    }

    /**
     * Mise en place des écouteurs
     */
    private void initConnection() {
        // A compléter
        bt_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra("res", tv_calcul.getText().toString());
                intent.putExtra("id",1);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

}