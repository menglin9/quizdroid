package lifecounter.menglin9.washington.edu.quiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Math_Q2 extends ActionBarActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_3);

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestionGroup);
        submit = (Button) findViewById(R.id.submitButton);
        final Data app = (Data)getApplication();

        // get selected radio button from radioGroup return -1 if empty
        int selectedId = radioGroup.getCheckedRadioButtonId();
        Log.e("Hi", "" + selectedId);

        // show the submit button when any radio button has been selected
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submit.setVisibility(View.VISIBLE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // find the radio button by returned id
                int sId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(sId);

                // add correct answer if correct
                if (sId == R.id.answer2) {
                    app.setMath(app.getMath() + 1);
                }

                // save the answer data
                String answerData = (String) radioButton.getText();
                app.setRecord(answerData);
                Intent next = new Intent(Math_Q2.this, Math_Q2Answer.class);
                startActivity(next);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity1_3, menu);
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
