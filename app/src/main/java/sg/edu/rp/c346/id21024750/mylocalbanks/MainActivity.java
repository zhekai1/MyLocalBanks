package sg.edu.rp.c346.id21024750.mylocalbanks;

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

    TextView textViewDBS;
    TextView textViewOCBC;
    TextView textViewUOB;

    String bankClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDBS = findViewById(R.id.textViewDBS);
        textViewOCBC = findViewById(R.id.textViewOCBC);
        textViewUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(textViewDBS);
        registerForContextMenu(textViewOCBC);
        registerForContextMenu(textViewUOB);
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
            textViewDBS.setText("DBS");
            textViewOCBC.setText("OCBC");
            textViewUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            textViewDBS.setText("星展银行");
            textViewOCBC.setText("华侨银行");
            textViewUOB.setText("大华银行");
            return true;
        } else {
            textViewDBS.setText("Error translation");
            textViewOCBC.setText("Error translation");
            textViewUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        if (bankClicked.equalsIgnoreCase("DBS")) {
            bankClicked = "DBS";
            bankClicked = "星展银行";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
            startActivity(intent);
            Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +63272265));
            startActivity(intent);
        } else if (bankClicked.equalsIgnoreCase("OCBC")) {
            bankClicked = "OCBC";
            bankClicked = "华侨银行";
            Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking/"));
            startActivity(intent3);
            Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +65381111));
            startActivity(intent4);
        } else if (bankClicked.equalsIgnoreCase("UOB")) {
            bankClicked = "UOB";
            bankClicked = "大华银行";
            Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pib.uob.com.sg/PIBLogin/Public/processPreCapture.do?keyId=lpc"));
            startActivity(intent5);
            Intent intent6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +62266121));
            startActivity(intent6);
        }
    }


}