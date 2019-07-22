//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import edu.cnm.deepdive.gallery_match.controller.DashboardFragment;

/**
 * Manages navigation between fragments using bottom navigation.
 * @author Denelle Britton Linebarger
 */
public class MainActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener {

  private TextView mTextMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mTextMessage = (TextView) findViewById(R.id.message);
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()) {
      case R.id.navigation_home:

        break;
      case R.id.navigation_dashboard:
        switchFragment(DashboardFragment.newInstance(), true, null);
        break;
      case R.id.navigation_notifications:

        break;
    }
    return true;
  }

  private void switchFragment(Fragment fragment, boolean useStack, String variant) {
    FragmentManager manager = getSupportFragmentManager();
    String tag = fragment.getClass().getSimpleName() + ((variant != null) ? variant : "");
    if (manager.findFragmentByTag(tag) != null) {
      manager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.container, fragment, tag);
    if (useStack) {
      transaction.addToBackStack(tag);
    }
    transaction.commit();
  }


  //private void addFragment(Fragment fragment, boolean useStack, String variant) {
  //  FragmentManager manager = getSupportFragmentManager();
  //  String tag = fragment.getClass().getSimpleName() + ((variant != null) ? variant : "");
  //  if (manager.findFragmentByTag(tag) != null) {
  //    manager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
  //  }
  //  FragmentTransaction transaction = manager.beginTransaction();
  //  transaction.add(R.id.container, fragment, tag);
  //  if (useStack) {
  //    transaction.addToBackStack(tag);
  //  } else {
  //    transaction.commit();
  //  }
  //
  //}


}