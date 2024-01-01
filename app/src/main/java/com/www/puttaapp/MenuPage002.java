package com.www.puttaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPage002 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page002);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "The Selected Item: " + item.getTitle(), Toast.LENGTH_LONG).show();


        if (item.getItemId() == R.id.menu_page) {
            Intent intent01 = new Intent(MenuPage002.this, MenuPage002.class);
            startActivity(intent01);
            finish();
            return true;
        } else if (item.getItemId() == R.id.about_us) {
            Intent intent02 = new Intent(MenuPage002.this, AboutUs.class);
            startActivity(intent02);
            finish();
            return true;
        } else if (item.getItemId() == R.id.View_invoice4) {
            Intent intent03 = new Intent(MenuPage002.this, MemberShipPage002.class);
            startActivity(intent03);
            finish();
            return true;
        } else if (item.getItemId() == R.id.MET_sub) {
            Intent intent04 = new Intent(MenuPage002.this, SubscriptionActivities.class);
            startActivity(intent04);
            finish();
            return true;
        } else if (item.getItemId() == R.id.contact_us) {
            Intent intent05 = new Intent(MenuPage002.this, ContactPage002.class);
            startActivity(intent05);
            finish();
            return true;
        } else if (item.getItemId() == R.id.close_app) {
            finish();
            System.exit(0);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}