package com.example.swipe2;

import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView tvAfirmacao;
    private ImageView ivEsquerda, ivDireita;
    private String tipo;
    private String[] afirmacoes;
    private String[][] estados;
    private String[] regioes;
    private boolean[] gabarito;
    private LinearLayout layout;
    private int contador, acertos = 0,contador2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        regioes = new String[] {
                "Centro-Oeste",
                "Nordeste",
                "Norte",
                "Sudeste",
                " Sul"
        };

        estados = new String[5][];

        estados[2] = new String[]{
                "Acre",
                "Amapá",
                "Amazonas",
                "Pará",
                "Rondônia",
                "Roraima",
                "Tocantins"
        };

        estados[1] = new String[]{
                "Alagoas",
                "Bahia",
                "Ceará",
                "Maranhão",
                "Paraíba",
                "Pernambuco",
                "Piauí",
                "Rio Grande do Norte",
                "Sergipe"
        };

        estados[0] = new String[]{
                "Goiás",
                "Mato Grosso",
                "Mato Grosso do Sul",
                "Distrito Federal"
        };

        estados[3] = new String[]{
                "Espírito Santo",
                "Minas Gerais",
                "São Paulo",
                "Rio de Janeiro"
        };

        estados[4] = new String[]{
                "Paraná",
                "Rio Grande do Sul",
                "Santa Catarina "
        };



        gabarito = new boolean[]{  true, true, false};

        tipo = getIntent().getExtras().getString("tipo");
        contador = 0;
        contador2 = 0;

        layout = (LinearLayout) findViewById(R.id.layout);
        tvAfirmacao = (TextView) findViewById(R.id.tvAfirmacao);
   //     ivDireita = (ImageView) findViewById(R.id.ivDireita);
      //  ivEsquerda = (ImageView) findViewById(R.id.ivEsquerda);

        if (tipo.equals("vertical")){
            ivEsquerda.setImageResource(R.drawable.abaixo);
            ivDireita.setImageResource(R.drawable.acima);
        }

        tvAfirmacao.setText( regioes[contador] );

        layout.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {
                if(contador >= 5) {
                    contador = 1;
                }
                else {
                    contador++;
                }
                contador2 = 0;

                tvAfirmacao.setText( regioes[contador]);
            }

            @Override
            public void onSwipeTop() {

                if(contador <= 0 )
                    contador = 4;
                else
                contador --;
                contador2 = 0;
               // contador = 1;

                tvAfirmacao.setText( regioes[contador]);
            }

            @Override
            public void onSwipeRight() {

                contador2 ++;
                if(contador2 > estados[contador].length)
                    contador = 0;
                 tvAfirmacao.setText( estados[contador][contador2]);
            }

            @Override
            public void onSwipeLeft() {
                
                contador2 --;
                if(contador2 < 0 )
                    contador = estados[contador].length;
                tvAfirmacao.setText( estados[contador][contador2]);
            }
        });


    }


}




