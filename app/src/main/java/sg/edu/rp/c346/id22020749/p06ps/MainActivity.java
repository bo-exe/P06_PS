package sg.edu.rp.c346.id22020749.p06ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String Clicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展銀行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            Clicked = "DBS";
        }
        else if(v == tvOCBC) {
            Clicked = "OCBC";
        }
        else if(v == tvUOB) {
            Clicked = "UOB";
        }

        if(tvDBS.getText() == "DBS" || tvOCBC.getText() == "OCBC" || tvUOB.getText() == "UOB") {
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the bank");
        }
        else {
            menu.add(0, 0, 0, "网站");
            menu.add(0, 1, 1, "联系银行");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(Clicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111l));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }

        else if(Clicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333l));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }

        else if(Clicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121l));
                startActivity(intentCall);
                return true; //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}