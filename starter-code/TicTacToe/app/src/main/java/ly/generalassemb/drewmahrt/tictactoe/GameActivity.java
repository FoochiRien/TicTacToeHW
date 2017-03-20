package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    private TextView mnamePlyr, gamePlay;
    private boolean mgameMessage = true;
    private String mplyrOne, mplyrTwo;
    private boolean mgameStart, mgameEnd, winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //bring names over from mainactivity
        Intent intent = getIntent();

        mplyrOne = intent.getStringExtra("Player One");
        mplyrTwo = intent.getStringExtra("Player Two");

        TextView mnamePlyr = (TextView) findViewById(R.id.game_message_text);
        if (mgameMessage) {
            mnamePlyr.setText(mplyrOne + "'s Turn");
        } else {
            mnamePlyr.setText(mplyrTwo + "'s Turn");
        }

    }

    //I can get the name to pass over, but once I activate the following it crashes. I ran out of time.

    TextView a1 = (TextView) findViewById(R.id.textView);
    TextView a2 = (TextView) findViewById(R.id.textView2);
    TextView a3 = (TextView) findViewById(R.id.textView3);
    TextView b1 = (TextView) findViewById(R.id.textView4);
    TextView b2 = (TextView) findViewById(R.id.textView5);
    TextView b3 = (TextView) findViewById(R.id.textView6);
    TextView c1 = (TextView) findViewById(R.id.textView7);
    TextView c2 = (TextView) findViewById(R.id.textView8);
    TextView c3 = (TextView) findViewById(R.id.textView9);


    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView gamePlay = (TextView) v;
            if (mgameStart) {
                if (gamePlay.getText().equals("")){
                    if (mgameMessage) {
                        gamePlay.setText("X");
                        mgameMessage = !mgameMessage;
                    } else {
                        gamePlay.setText("O");
                        mgameMessage = !mgameMessage;
                    }
                }

            } else {
                    mgameEnd = determineWinner(gamePlay);

            }

            a1.setOnClickListener(OnClickListener);
            a2.setOnClickListener(OnClickListener);
            a3.setOnClickListener(OnClickListener);
            b1.setOnClickListener(OnClickListener);
            b2.setOnClickListener(OnClickListener);
            b3.setOnClickListener(OnClickListener);
            c1.setOnClickListener(OnClickListener);
            c2.setOnClickListener(OnClickListener);
            c3.setOnClickListener(OnClickListener);
        }

        //determine winner of game

        public boolean determineWinner(TextView gamePlay) {
            winner = true;
            //horizontal
            if ((a1 == a2) && (a2 == a3) || (a3 == a1)) {
                return winner;
            } else if ((b1 == b2) && (b2 == b3) || (b3 == b1)) {
                return winner;
            } else if ((c1 == c2) && (c2 == c3) || (c3 == c1)) {
                return winner;
            }//vertical
            else if ((a1 == b1) && (b1 == c1) || (c1 == a1)) {
                return winner;
            } else if ((a2 == b2) && (b2 == c2) || (c2 == a2)) {
                return winner;
            } else if ((a3 == b3) && (b3 == c3) || (c3 == a3)) {
                return winner;
            }//diagaonal
            else if ((a1 == b2) && (b2 == c3)) {
                return winner;
            } else if ((a3 == b2) && (b2 == c1)) {
                return winner;
            }
            return winner;
        }


    };

}


