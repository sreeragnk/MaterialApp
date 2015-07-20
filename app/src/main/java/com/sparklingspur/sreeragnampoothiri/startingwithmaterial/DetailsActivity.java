package com.sparklingspur.sreeragnampoothiri.startingwithmaterial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by sreerag.nampoothiri on 24-Jun-15.
 */
public class DetailsActivity extends Activity {

    public final static String ID = "ID";
    public Contact mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        mContact = Contact.getItem(getIntent().getIntExtra(ID, 0));
        TextView mName = (TextView) findViewById(R.id.DETAILS_name);
        mName.setText(mContact.get(Contact.Field.NAME));
    }
}
