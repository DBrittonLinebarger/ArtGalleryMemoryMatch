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


        Fragment fragment1 = null;
    switch (item.getItemId()) {
      case R.id.navigation_home:
         fragment1 = DashboardFragment.newInstance();
        break;
      case R.id.navigation_dashboard:
         fragment1 = DashboardFragment.newInstance();
        break;
      case R.id.navigation_notifications:
         fragment1 = DashboardFragment.newInstance();
        break;
    }
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container, fragment1).commit();
    return true;

  }


}
