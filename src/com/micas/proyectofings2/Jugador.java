package com.micas.proyectofings2;

import android.content.Context;
import android.widget.ImageButton;

public class Jugador extends ImageButton {
	
	int x=-1;
	int y = -1;
	
	Jugador(Context algo,int xo,int yo) {
		super(algo);
		x= xo;
		y= yo;
	}
}
