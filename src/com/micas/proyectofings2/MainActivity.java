










package com.micas.proyectofings2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	FrameLayout tableroCeldas[][] = new FrameLayout[8][14];
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        PintarTablero();
    }
    
    @SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public void PintarTablero() {
    	
    	int ancho=0;
    	int alto=0;
    	WindowManager winMan = getWindowManager();
    	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
    		Point tamanio = new Point();
    	    winMan.getDefaultDisplay().getSize(tamanio);
    	    ancho = tamanio.x;
    	    alto = tamanio.y;
    	} else {
    	    Display display = winMan.getDefaultDisplay();
    	    ancho = display.getWidth();
    	    alto = display.getHeight();
    	}
    	
        TableRow.LayoutParams tamanioCasilla = new TableRow.LayoutParams(ancho/8, alto/14);
        TableLayout table = new TableLayout(this);
        int k=1;
        for (int y = 0; y < 14; y++) {
	        if((y+1)%2==0) k=0;
	        else k=1;
            TableRow row = new TableRow(this);
            for (int x = 0; x < 8; x++) {
                tableroCeldas[x][y] = new FrameLayout(this);
                tableroCeldas[x][y].setLayoutParams(tamanioCasilla);
                if(k==0) {
                	if ((x==1&&y==0) || (x==1&&y==12)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaiquierda);
                	else if ((x==3&&y==0) || (x==1&&y==2)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaabajoyizquierda);
                	else if ((x==3&&y==2) || (x==5&&y==2)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaabajo);
                	else if ((x==6&&y==1) || (x==6&&y==13)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaderecha);
                	else if ((x==2&&y==11) || (x==4&&y==11) || (x==0&&y==7) || (x==2&&y==7) || (x==6&&y==7)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaarriba);
                	else if ((x==4&&y==13) || (x==6&&y==11)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscurarayaarribayderecha);
                	else if (x==3&&y==6) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscuracentroarribaizquierda);
                	else if (x==4&&y==7) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscuracentroabajoderecha);
                	else tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaoscura);
                }else{
                	if ((x==1&&y==1) || (x==1&&y==13)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaizquierda);
                	else if ((x==4&&y==0) || (x==6&&y==2)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaabajoyderecha);
                	else if ((x==2&&y==2) || (x==4&&y==2)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaabajo);
                	else if ((x==6&&y==0) || (x==6&&y==12)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaderecha);
                	else if ((x==3&&y==11) || (x==5&&y==11) || (x==1&&y==7) || (x==5&&y==7) || (x==7&&y==7)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaarriba);
                	else if ((x==3&&y==13) || (x==1&&y==11)) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclararayaarribayizquierda);
                	else if (x==4&&y==6) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclaracentroarribaderecha);
                	else if (x==3&&y==7) tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclaracentroabajoizquierda);
                	else tableroCeldas[x][y].setBackgroundResource(R.drawable.hierbaclara);
                }
                row.addView(tableroCeldas[x][y]);
                
                tableroCeldas[x][y].setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						for(int fila=0;fila<tableroCeldas.length;fila++) {
							for(int col=0;col<tableroCeldas[fila].length;col++) {
								String x = String.valueOf(fila);
								String y = String.valueOf(col);
								String tabid = String.valueOf(tableroCeldas[fila][col]);
								String vid = String.valueOf(v);
								if (tabid.equals(vid)) {
									Toast.makeText(getApplicationContext(),x + "," + y, Toast.LENGTH_SHORT).show();
									//Toast.makeText(getApplicationContext(),tableroCeldas[0][1].getContentDescription(), Toast.LENGTH_SHORT).show();
								}
							}
						}
						//v.setBackgroundResource(R.drawable.purple);
					}
                });
                if(k==0) k++;
                else if(k==1) k = 0;
            }
            table.addView(row);
        }
        setContentView(table);
    }
}