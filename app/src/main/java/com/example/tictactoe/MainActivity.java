package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //setting alternative tap (0=cross, 1=zero)
    int alternativeTap =0,x=0,o=0,roundCount=0;
    int[] overTap={2,2,2,2,2,2,2,2,2};
    int[] winningState={3,3,3,3,3,3,3,3,3};

    public void imgtap(View view){

        TextView textcross =(TextView)findViewById(R.id.textcross);
        TextView textzero =(TextView)findViewById(R.id.textzero);
        ImageView tap = (ImageView) view;

        int imageTag=Integer.parseInt(tap.getTag().toString());

        if (winningState[imageTag]==3) {
            winningState[imageTag]=alternativeTap;
            if (overTap[imageTag] == 2) {
                overTap[imageTag] = alternativeTap;
                if (alternativeTap == 0) {
                    tap.setImageResource(R.drawable.cross);
                    tap.animate().rotation(180).setDuration(500);
                    alternativeTap = 1;
                } else {
                    tap.setImageResource(R.drawable.zero);
                    tap.animate().rotation(360).setDuration(500);
                    alternativeTap = 0;
                }
            }
            roundCount++;
        }

        //TODO:checking for win players
        //for 1st row
        if ((winningState[0]==0)&&(winningState[1]==0)&&(winningState[2]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[0]==1)&&(winningState[1]==1)&&(winningState[2]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 2nd row
        if ((winningState[3]==0)&&(winningState[4]==0)&&(winningState[5]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[3]==1)&&(winningState[4]==1)&&(winningState[5]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 3rd row
        if ((winningState[6]==0)&&(winningState[7]==0)&&(winningState[8]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[6]==1)&&(winningState[7]==1)&&(winningState[8]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 1st column
        if ((winningState[0]==0)&&(winningState[3]==0)&&(winningState[6]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[0]==1)&&(winningState[3]==1)&&(winningState[6]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 2nd column
        if ((winningState[1]==0)&&(winningState[4]==0)&&(winningState[7]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[1]==1)&&(winningState[4]==1)&&(winningState[7]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 3rd column
        if ((winningState[2]==0)&&(winningState[5]==0)&&(winningState[8]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[2]==1)&&(winningState[5]==1)&&(winningState[8]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 1st diagonal
        if ((winningState[0]==0)&&(winningState[4]==0)&&(winningState[8]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[0]==1)&&(winningState[4]==1)&&(winningState[8]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }
        //for 2nd diagonal
        if ((winningState[2]==0)&&(winningState[4]==0)&&(winningState[6]==0)){
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();
            x++;
            textcross.setText("X : "+x);
            reset();
        }
        if ((winningState[2]==1)&&(winningState[4]==1)&&(winningState[6]==1)){
            Toast.makeText(this, "O wins", Toast.LENGTH_SHORT).show();
            o++;
            textzero.setText("O : "+o);
            reset();
        }

        //TODO: draw checking
        if (roundCount==9){
            Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show();
            reset();
        }
    }

    public void playAgain(View view) {
        reset();
    }

    public void reset(){
        //change game state back to 2
        for (int i=0;i<overTap.length;i++){
            overTap[i]=2;
        }
        //change winning state back to 3
        for (int i=0;i<winningState.length;i++){
            winningState[i]=3;
        }
        //make round count 0
        roundCount=0;
        //make alternative tap to 0
        alternativeTap=0;
        //reset all images
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gameBoard);
        for (int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(R.drawable.white);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
