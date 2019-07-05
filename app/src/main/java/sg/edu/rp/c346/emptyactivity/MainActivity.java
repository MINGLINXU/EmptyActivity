package sg.edu.rp.c346.emptyactivity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //step 1a: obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 1b: obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //step 1c: Add the key-value pair
        prefEdit.putString("greetings", "Hello!");

        //step 1d: call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // String msg = "No greetings!";

        //step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("greetings","No greeting!");

        Toast toast = Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }
}
