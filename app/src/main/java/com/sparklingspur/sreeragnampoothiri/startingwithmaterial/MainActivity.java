package com.sparklingspur.sreeragnampoothiri.startingwithmaterial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv); // layout reference

        // Session manager
        session = new SessionManager(getApplicationContext());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true); // to improve performance

        rv.setAdapter(new DataManager()); // the data manager is assigner to the RV
        rv.addOnItemTouchListener( // and the click is handled
                new RecyclerClickListener(this, new RecyclerClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                        intent.putExtra(DetailsActivity.ID, Contact.CONTACTS[position].getId());

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                // the context of the activity
                                MainActivity.this,

                                // For each shared element, add to this method a new Pair item,
                                // which contains the reference of the view we are transitioning *from*,
                                // and the value of the transitionName attribute
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_circle),
                                        getString(R.string.transition_name_circle)),
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_name),
                                        getString(R.string.transition_name_name)),
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_phone),
                                        getString(R.string.transition_name_phone))
                        );
                        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
                    }
                }));
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

        if (id == R.id.action_signout){
            session.logoutUser();
        }

        return super.onOptionsItemSelected(item);
    }
}
