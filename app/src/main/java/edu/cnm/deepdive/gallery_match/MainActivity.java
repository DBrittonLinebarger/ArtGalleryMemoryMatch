package edu.cnm.deepdive.gallery_match;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
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
    switch (item.getItemId()) {
      case R.id.navigation_home:
        mTextMessage.setText(R.string.title_home);
        return true;
      case R.id.navigation_dashboard:
        mTextMessage.setText(R.string.title_dashboard);
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.container, new DashboardFragment()).commit();
        return true;
      case R.id.navigation_notifications:
        mTextMessage.setText(R.string.title_notifications);
        return true;
    }
    return false;
  }


}
