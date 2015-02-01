package com.mycompany.myfirstapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    /** Called when the user clicks the Send button */
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendNotification(View view) {

        Toast.makeText(getApplicationContext(), "Demo background service", Toast.LENGTH_SHORT).show();
        switch(view.getId()){
            case R.id.buttonbasic:
                sendBasicNotification( );
                break;


        }
    }
    private void sendBasicNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentTitle("Basic Notification");
        builder.setContentText("Demo");
        builder.setSmallIcon(R.drawable.ic_launcher);

        Notification notification = builder.build();
        NotificationManager manager= (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8, notification);


    }




}
