package idk14.pfi3finalproject_group1;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        Firebase ref = new Firebase(Constants.FIREBASE_URL);

        //testing add treasures, data structure

        Treasure treasure1 = new Treasure(2);
        Treasure treasure2 = new Treasure(3);

        Firebase treasuresRef = ref.child("treasures");

        Map<String, Treasure> treasures = new HashMap<String, Treasure>();
        treasures.put("treasure1", treasure1);
        treasures.put("treasure2", treasure2);

        treasuresRef.setValue(treasures);


/*
        ref.setValue("I'm writing data", new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if (firebaseError != null) {
                    System.out.println("Data could not be saved. " + firebaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == R.id.help_fragment) {
            FragmentManager fm = getFragmentManager();
            HelpFragment hf = new HelpFragment();
            hf.show(fm, "Help");

            return false;
        }



        return super.onOptionsItemSelected(item);
    }
}
