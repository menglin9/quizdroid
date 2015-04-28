package lifecounter.menglin9.washington.edu.quiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Math_Q5Answer extends ActionBarActivity {

    TextView t1;
    TextView t2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_q5_answer);

        final Data app = (Data)getApplication();

        int answerId =  app.getId();

        t1 = (TextView) findViewById(R.id.yourAnswer);
        Log.e("id", "" + answerId);
        t1.setText("You answer is " + app.getRecord());

        t2 = (TextView) findViewById(R.id.dataRecord);
        t2.setText("You have " + app.getMath() + " out of 5 correct");

        b = (Button) findViewById(R.id.finishButtom);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setMath(0);
                Intent next = new Intent(Math_Q5Answer.this, MainActivity.class);
                startActivity(next);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math__q5_answer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
