package com.aakash.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String Tag = "IntentButton";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button Left, Right, btnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //owner (Lifecycle aware components)
        getLifecycle().addObserver(new Observer());

        fragmentManager = getSupportFragmentManager();
        Left = findViewById(R.id.btnLeft);
        Left.setOnClickListener(v -> leftFragment());
        Right = findViewById(R.id.btnRight);
        Right.setOnClickListener(v -> rightFragment());
    }

    public void onClickCounter(View view) {
        Log.d(Tag,"Counter button clicked in the second activity");
    }
    private void rightFragment() {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.flFragment);
        if (fragment instanceof FirstFragment) {
            fragment = new SecondFragment();
        } else if (fragment instanceof SecondFragment) {
            fragment = new ThirdFragment();
        } else if (fragment instanceof ThirdFragment) {
            fragment = new FourthFragment();
        } else if (fragment instanceof FourthFragment) {
            fragment = new FirstFragment();
        } else {
            fragment = new FirstFragment();
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

    private void leftFragment() {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.flFragment);
        if (fragment instanceof FirstFragment) {
            fragment = new FourthFragment();
        } else if (fragment instanceof SecondFragment) {
            fragment = new FirstFragment();
        } else if (fragment instanceof ThirdFragment) {
            fragment = new SecondFragment();
        } else if (fragment instanceof FourthFragment) {
            fragment = new ThirdFragment();
        } else {
            fragment = new FirstFragment();
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = fragmentManager.findFragmentById(R.id.flFragment);
        if (fragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        } else {
            super.onBackPressed();
        }
    }

//    public void buttonClicked(View view) {
//        Log.d(Tag, "Button Clicked in the main activity");
//    }
}