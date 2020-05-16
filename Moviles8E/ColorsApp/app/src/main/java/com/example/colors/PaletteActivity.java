package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    //Variables
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;
    private TextView select = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //Get Components ID's
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);
        select = findViewById(R.id.color);

        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

        registerForContextMenu(vieColors);

    }

    //#############################################
    //MENUS
    //#############################################

    //This method lets us show the menu on mobile app
    //Note: Only in this activity
    //Note: The options on this method have not actions.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.icTransparente :
                sbrAlpha.setProgress(0);
                break;
            case R.id.icHelp :
                Intent inten = new Intent(this, HelpActivity.class);
                startActivity(inten);
                break;

            //case R.id.icVoice :
               // Toast.makeText(this,
                      //  "I am your voice assistant", Toast.LENGTH_SHORT).show();
                //break;
            case R.id.iteTransparent :
                //Change color
                sbrAlpha.setProgress(0);
                //Toast.makeText(this,
                // "You have pressed Transparent", Toast.LENGTH_SHORT).show();
                select.setText("Transparent");
                break;

            case R.id.iteSemitransparent :
                //Change color
                sbrAlpha.setProgress(128);
                //Toast.makeText(this,
                       // "You have pressed Transparent", Toast.LENGTH_SHORT).show();
                select.setText("Semitransparent");
                break;

            case R.id.iteOpaque :
                sbrAlpha.setProgress(255);
                select.setText("Opaque");
                break;

            case R.id.iteBlack :
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(255);
                select.setText("Black");
                break;

            case R.id.iteWhite :
                sbrRed.setProgress(255);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(255);
                sbrAlpha.setProgress(255);
                select.setText("White");
                break;

            case R.id.iteRed :
                sbrRed.setProgress(255);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(255);
                select.setText("Red");
                break;

            case R.id.iteGreen :
                sbrRed.setProgress(0);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(255);
                select.setText("Green");
                break;

            case R.id.iteBlue :
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(255);
                sbrAlpha.setProgress(255);
                select.setText("Blue");
                break;

            case R.id.iteCyan :
                sbrRed.setProgress(0);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(255);
                sbrAlpha.setProgress(255);
                select.setText("Cyan");
                break;

            case R.id.iteMagenta :
                sbrRed.setProgress(245);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(135);
                sbrAlpha.setProgress(255);
                select.setText("Magenta");
                break;

            case R.id.iteYellow :
                sbrRed.setProgress(255);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(255);
                select.setText("Yellow");
                break;

            case R.id.iteAboutof :
                Intent intent = new Intent(this, AboutofActivity.class);
                startActivity(intent);
                break;

            case R.id.iteReset:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(0);
                break;

            case R.id.iteClose:
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    //ContextMenu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //Code the items' actions.
        switch (item.getItemId()) {
            case R.id.iteReset:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                sbrAlpha.setProgress(0);
                break;

            case R.id.iteHelp :
                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                break;
        }

        return super.onContextItemSelected(item);
    }

    //#############################################
    //SEEKBAR'S
    //#############################################

    //Notification that the progress level has changed.
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);

        //Toast.makeText(this, "The new color is: "+a, Toast.LENGTH_SHORT).show();
    }

    //Notification that the user has started a touch gesture
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        //Toast.makeText(this, "The user has started a touch gesture", Toast.LENGTH_SHORT).show();
    }

    //Notification that the user has finished a touch
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        //Toast.makeText(this, "The user has finished a touch", Toast.LENGTH_SHORT).show();
    }
}
