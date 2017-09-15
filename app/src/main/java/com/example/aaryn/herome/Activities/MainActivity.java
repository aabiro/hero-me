package com.example.aaryn.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aaryn.herome.Fragments.MainFragment;
import com.example.aaryn.herome.Fragments.PickPowerFragment;
import com.example.aaryn.herome.Fragments.StoryFragment;
import com.example.aaryn.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, StoryFragment.StoryFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {             //need this or get crash
            fragment = new MainFragment();
            FragmentTransaction transaction =  manager.beginTransaction();
            transaction.add(R.id.fragment_container,fragment);
            transaction.commit();
        }
    }

    public void loadPickPowerScreen(){
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        //this will add to backstack or replace it - good way
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,pickPowerFragment).addToBackStack(null).commit();
        //this will add to the screen - good for puttin ontop of existing screen
       // this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,pickPowerFragment).commit();
    }

    public void loadStoryScreen(){
        StoryFragment storyFragment = new StoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,storyFragment).addToBackStack(null).commit();
    }


    //use to start over
    public void loadFirstScreen(){
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mainFragment).addToBackStack(null).commit();
    }


    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStoryFragmentInteraction(Uri uri) {

    }
}
