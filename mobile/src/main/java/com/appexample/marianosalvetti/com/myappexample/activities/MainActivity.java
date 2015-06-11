package com.appexample.marianosalvetti.com.myappexample.activities;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.appexample.marianosalvetti.com.myappexample.fragments.ItemFragment;
import com.appexample.marianosalvetti.com.myappexample.fragments.StatsFragment;
import com.appexample.marianosalvetti.com.myappexample.slidemenu.NavigationDrawerCallbacks;
import com.appexample.marianosalvetti.com.myappexample.slidemenu.NavigationDrawerFragment;
import com.appexample.marianosalvetti.com.myappexample.R;
import com.appexample.marianosalvetti.com.myappexample.utils.LoggingUtility;


public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {

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
        fragment = getFragmentManager().findFragmentByTag(StatsFragment.TAG);
        if (fragment == null) {
            fragment = new StatsFragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.container, fragment, StatsFragment.TAG).commit();

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    //    Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
        LoggingUtility.d(LOG_TAG, "Menu item selected -> " + position);
        Fragment fragment;
        switch (position) {
            case 0: //search//todo
                break;
            case 1: //blanck
                fragment = getFragmentManager().findFragmentByTag(StatsFragment.TAG);
                if (fragment == null) {
                    fragment = new StatsFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, StatsFragment.TAG).commit();
                break;

            case 2: //my account //todo
                break;

            case 3: //settings //todo
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


}
