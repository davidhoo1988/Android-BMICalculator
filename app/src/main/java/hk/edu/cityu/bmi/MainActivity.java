package hk.edu.cityu.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText vHeight;
    EditText vWeight;
    Button submitButton;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //--- get views
        vHeight = (EditText) findViewById(R.id.height);
        vWeight = (EditText) findViewById(R.id.weight);
        submitButton = (Button) findViewById(R.id.submit);
    }
    public void calcBMI(View view) {
        String height = vHeight.getText().toString();
        String weight = vWeight.getText().toString();

        if (height.equals("") || weight.equals("")) {
            Toast.makeText(MainActivity.this, R.string.bmi_warning,Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, ReportActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("height", height);
            bundle.putString("weight", weight);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
