package com.www.puttaapp;// this is the package name.
// below imported of all the required java packages.

import static com.www.puttaapp.R.id.btn6;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MemberShipPage002 extends AppCompatActivity {
    // here the required variables has been declared
    DBHelper mDb;
    EditText fn7200, ln7200, phone7200, member7200, Cost1;
    Button btttn1, btttn2, btttn3, btttn4, btttn5, bb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_ship_page002);

        mDb = new DBHelper(this);// here is the object of DBHelper that created
        //Here, we will get the all IDs of Edittext that created

        fn7200 = (EditText) findViewById(R.id.edit_1);
        ln7200 = (EditText) findViewById(R.id.edit_2);
        phone7200 = (EditText) findViewById(R.id.edit_3);
        member7200 = (EditText) findViewById(R.id.edit_4);
        Cost1 = (EditText) findViewById(R.id.edit_5);

        // //Here, we will get all the IDs of button that created.
        btttn1 = (Button) findViewById(R.id.btn1);
        btttn2 = (Button) findViewById(R.id.btn2);
        btttn3 = (Button) findViewById(R.id.btn3);
        btttn4 = (Button) findViewById(R.id.btn4);
        btttn5 = (Button) findViewById(R.id.btn5);
        bb6 = (Button) findViewById(R.id.btn6);


        //here, all the 6 of methods that applied has been defined
        add_Data7200();
        update_Data7200();
        delete_Data7200();
        view_Data7200();
        clear_Data7200();
        cal_Data7200();
    }


    //This is the add data method
    public void add_Data7200() {
        btttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insert = mDb.insertData(fn7200.getText().toString(), ln7200.getText().toString(), phone7200.getText().toString(), member7200.getText().toString(), Cost1.getText().toString());
                if (insert == true)
                    Toast.makeText(MemberShipPage002.this, "New client has been added successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this, "Please try again, data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    // This is the update data method
    public void update_Data7200() {
        btttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean update = mDb.updateData(fn7200.getText().toString(), ln7200.getText().toString(), phone7200.getText().toString(), member7200.getText().toString());
                if (update == true)
                    Toast.makeText(MemberShipPage002.this, "Data has updated successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this, "try again: Data not updated", Toast.LENGTH_LONG).show();
            }
        });
    }


    //delete date method
    public void delete_Data7200() {
        btttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer del = mDb.deleteData(phone7200.getText().toString());
                if (del > 0)
                    Toast.makeText(MemberShipPage002.this, "Data of Client removed", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MemberShipPage002.this, "Data you entered not removed", Toast.LENGTH_LONG).show();
            }
        });
    }

    //view data method
    public void view_Data7200() {
        btttn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor r = mDb.getAllData();
                if (r.getCount() == 0) {
                    show_Message7200("Found Error", "Nothings are found");
                    return;
                }
                StringBuffer view7200 = new StringBuffer();
                while (r.moveToNext()) {

                    view7200.append("First_Name:" + r.getString(0) + "\n");
                    view7200.append("Last_Name:" + r.getString(1) + "\n");
                    view7200.append("Phone_Number:" + r.getString(2) + "\n");
                    view7200.append("Membership per month:" + r.getString(3) + "\n");
                }
                show_Message7200("Subscribers Details", view7200.toString());
            }
        });
    }


    //clear method for remove all the written text in the all Edit_texts
    public void clear_Data7200() {
        btttn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn7200.setText("");
                ln7200.setText("");
                phone7200.setText("");
                member7200.setText("");
            }
        });
    }

    // this is method that applied to make calculation for clients subscription.
    public void cal_Data7200() {
        bb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fn7200.getText().toString().isEmpty() || ln7200.getText().toString().isEmpty() || phone7200.getText().toString().isEmpty() || member7200.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill all The Details", Toast.LENGTH_LONG).show();
                } else {
                    double MemberShip_price = 15.0;
                    double Months1 = Double.parseDouble(member7200.getText().toString());
                    double avgerge7200 = (MemberShip_price * Months1);
                    Cost1.setText(Double.toString(avgerge7200));

                }

            }
        });
    }

    //status bar method
    public void show_Message7200(String title, String mes) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setCancelable(true);
        ad.setTitle(title);
        ad.setMessage(mes);
        ad.show();
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
            Intent intent01 = new Intent(MemberShipPage002.this, MenuPage002.class);
            startActivity(intent01);
            finish();
            return true;
        } else if (item.getItemId() == R.id.about_us) {
            Intent intent02 = new Intent(MemberShipPage002.this, AboutUs.class);
            startActivity(intent02);
            finish();
            return true;
        } else if (item.getItemId() == R.id.View_invoice4) {
            Intent intent03 = new Intent(MemberShipPage002.this, MemberShipPage002.class);
            startActivity(intent03);
            finish();
            return true;
        } else if (item.getItemId() == R.id.MET_sub) {
            Intent intent04 = new Intent(MemberShipPage002.this, SubscriptionActivities.class);
            startActivity(intent04);
            finish();
            return true;
        } else if (item.getItemId() == R.id.contact_us) {
            Intent intent05 = new Intent(MemberShipPage002.this, ContactPage002.class);
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