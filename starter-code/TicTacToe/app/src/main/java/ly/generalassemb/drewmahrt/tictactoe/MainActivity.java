package ly.generalassemb.drewmahrt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String mplyrOne, mplyrTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.start_game_button);
        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                //collects names entered by the players
                EditText editText = (EditText) findViewById(R.id.player_one_name);
                EditText editText1 = (EditText) findViewById(R.id.player_two_name);
                mplyrOne = editText.getText().toString();
                mplyrTwo = editText1.getText().toString();
                intent.putExtra("Player One",mplyrOne);
                intent.putExtra("Player Two", mplyrTwo);
                //add where to put the names once they are sent to GameActivity

                startActivity(intent);
            }
        });

    }
}
