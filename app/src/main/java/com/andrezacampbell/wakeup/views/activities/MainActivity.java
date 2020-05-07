package com.andrezacampbell.wakeup.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.andrezacampbell.wakeup.R;
import com.andrezacampbell.wakeup.views.fragments.HomeFragment;
import com.andrezacampbell.wakeup.views.fragments.NotificacoesFragment;
import com.andrezacampbell.wakeup.views.fragments.PontosFragment;
import com.andrezacampbell.wakeup.views.fragments.ProfileFragment;
import com.andrezacampbell.wakeup.views.fragments.SonhosFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new HomeFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new ProfileFragment()).commit();
                break;
            case R.id.nav_notificacoes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new NotificacoesFragment()).commit();
                break;
            case R.id.nav_score:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new PontosFragment()).commit();
                break;
            case R.id.nav_sonhos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmento_container, new SonhosFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Fazer a logica de logout do firebase e sair do app", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
