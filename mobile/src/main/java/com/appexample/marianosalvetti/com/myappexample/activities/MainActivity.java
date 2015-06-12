package com.appexample.marianosalvetti.com.myappexample.activities;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.appexample.marianosalvetti.com.myappexample.fragments.FragmentRecibeParams;
import com.appexample.marianosalvetti.com.myappexample.fragments.MyAccountFragment;
import com.appexample.marianosalvetti.com.myappexample.fragments.SearchFragment;
import com.appexample.marianosalvetti.com.myappexample.fragments.SettingsFragment;
import com.appexample.marianosalvetti.com.myappexample.fragments.StatsFragment;
import com.appexample.marianosalvetti.com.myappexample.slidemenu.NavigationDrawerCallbacks;
import com.appexample.marianosalvetti.com.myappexample.slidemenu.NavigationDrawerFragment;
import com.appexample.marianosalvetti.com.myappexample.R;
import com.appexample.marianosalvetti.com.myappexample.utils.LoggingUtility;


public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks,
        SearchFragment.OnArticuloSelectedListener {

    private static final String LOG_TAG = "MainActivity";

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private String mActivityTitle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoggingUtility.d(LOG_TAG, "Starting the onCreate method ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        mActivityTitle = getTitle().toString();

        // Set up the drawer.
        LoggingUtility.d(LOG_TAG, "Set up the drawer, using title: " + mActivityTitle);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        // Set up initial Fragment
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG);
        if (fragment == null) {
            fragment = new SearchFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, SearchFragment.TAG).commit();
        setTitle("Search");
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    //    Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        LoggingUtility.d(LOG_TAG, "Menu item selected -> " + position);
        Fragment fragment;
        switch (position) {
            case 0: //search//todo
                fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG);
                if (fragment == null) {
                    fragment = new SearchFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, SearchFragment.TAG).commit();
                setTitle("Search");
                break;
            case 1: //stats
                fragment = getSupportFragmentManager().findFragmentByTag(StatsFragment.TAG);
                if (fragment == null) {
                    fragment = new StatsFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, StatsFragment.TAG).commit();
                setTitle("Stats");
                break;

            case 2: //my account //todo
                fragment = getSupportFragmentManager().findFragmentByTag(MyAccountFragment.TAG);
                if (fragment == null) {
                    fragment = new MyAccountFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, MyAccountFragment.TAG).commit();
                setTitle("my account");
                break;

            case 3: //settings //todo
                fragment = getSupportFragmentManager().findFragmentByTag(SettingsFragment.TAG);
                if (fragment == null) {
                    fragment = new SettingsFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, SettingsFragment.TAG).commit();
                setTitle("settings");

                break;

            case 4: //other activity, for example //todo
                Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
                //Creamos la informacion a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE","el parametro");
                //Agrego la informacion al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        if (id == R.id.action_filter) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onArticuloSelected(String str) {
        Fragment fragmentRecibeParams = getSupportFragmentManager().findFragmentByTag(FragmentRecibeParams.TAG);
        if (fragmentRecibeParams == null) {
            fragmentRecibeParams = new FragmentRecibeParams();
        }
        Bundle args = new Bundle();
        args.putString("str", str);
        fragmentRecibeParams.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragmentRecibeParams, FragmentRecibeParams.TAG);
        transaction.addToBackStack(null);

        transaction.commit();
        setTitle("Recibe Params");

    }
}
