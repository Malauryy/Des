package com.btsinfo.des;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {


    private Spinner spinner_face;
    private Spinner spinner_nbdes;
    private Button bt_lancer;
    private TextView tv_result;
    private Integer resultat;
    private Integer nmbFace;
    private Integer nmbdes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner_face = (Spinner) findViewById(R.id.spinner_face);
        spinner_nbdes = (Spinner) findViewById(R.id.spinner_nmbdes);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bt_lancer = (Button) findViewById(R.id.bt_lancer);

        // on créer un adaptateur pour pouvoir lier notre liste déroulante à nos item dans le strings.xml
        ArrayAdapter<CharSequence> adFace = ArrayAdapter.createFromResource(this,R.array.face, android.R.layout.simple_spinner_dropdown_item);
        // on deroule la liste par le bas
        adFace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // on applique l'adaptateur au spinner
        spinner_face.setAdapter(adFace);

        // on créer un adaptateur pour pouvoir lier notre liste déroulante à nos item dans le strings.xml
        ArrayAdapter<CharSequence> adNmbdes = ArrayAdapter.createFromResource(this,R.array.nmbdes, android.R.layout.simple_spinner_dropdown_item);
        // on deroule la liste par le bas
        adNmbdes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // on applique l'adaptateur au spinner
        spinner_nbdes.setAdapter(adNmbdes);


        // on commence nos action :

        spinner_face.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               nmbFace = Math.toIntExact(adapterView.getItemIdAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner_nbdes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nmbdes = Math.toIntExact(adapterView.getItemIdAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        bt_lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result_final();
            }
        });

    }

    public int Result(){
        int nbFace = nmbFace;
        int nbdes = nmbdes;
        int nb = 0;

        if (nbFace == 0){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(5);
            // tv_result.setText("votre dés affiche "+  nb);
        }

        if (nbFace == 1){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(7);

        }

        if (nbFace == 2){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(9);

        }

        if (nbFace == 3){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(11);

        }

        if (nbFace == 4){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(13);

        }
        if (nbFace == 5){

            SecureRandom random = new SecureRandom();
            nb =random.nextInt(21);

        }

        return nb;

    }

    public void Result_final() {

        int nbdes = nmbdes;
        int nb;
        nb =-1;
        if (nbdes == 0){

             tv_result.setText("Votre dés affiche " + nb + "\n" + Result());

        }

        if(nbdes == 1){
            tv_result.setText("Votre premier dés affiche : " + Result()+ "\nVotre deuxième dés affiche : " + Result());
        }
        if(nbdes == 2){
            tv_result.setText("Votre premier dés affiche : " + Result()+
                              "\n\nVotre deuxième dés affiche : " + Result()+
                              "\n\nVotre deuxième dés affiche : " + Result() );
        }
        if(nbdes == 3){
            tv_result.setText("Votre premier dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result());
        }
        if(nbdes == 4){
            tv_result.setText("Votre premier dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result()+
                    "\n\nVotre deuxième dés affiche : " + Result());
        }
    }

    public String Result_img(int resultd) {

        String img;
        img =  resultd + ".png";

        return img;
    }







}