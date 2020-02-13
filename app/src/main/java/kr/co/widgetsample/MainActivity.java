package kr.co.widgetsample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment)
                .addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                    @Override
                    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(!destination.getLabel().equals("main"));
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_btn2:
                return true;
            case android.R.id.home:
                Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment).navigate(R.id.mainFragment);
                setTitle(R.string.app_name);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
