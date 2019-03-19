package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;

public class Circulo {
	
	
	public static final int LIMITE_ARRIBA=96;
	public static final int LIMITE_ABAJO=486;
	public static final int LIMITE_DERECHA=371;
	public static final int LIMITE_IZQUIERDA=20;
	
	
	
	private int x;
	private int y;
	
	int invertirX=1;
	int invertirY=1;
	
	
	private ArrayList<String> color;
	private String colorActual;
	
	
	public Circulo(int x, int y) {
		this.x= x;
		this.y=y;
		color=new ArrayList<String>();
		leerYPasarAArray();
		colorActual=color.get(2);
		
	}
	
	public void cambiarColor() {
		int pos=(int) ((Math.random()*5)+1);
		colorActual=color.get(pos-1);
	}
	
	public void mover() {
		
		if (x==LIMITE_DERECHA) {
			invertirX=-1;
			
		} else if(x==LIMITE_IZQUIERDA) {
			invertirX=invertirX*-1;
		}
		
		////////////////////
		if (y==LIMITE_ABAJO) {
			invertirY=invertirY*-1;
		} else if(y==LIMITE_ARRIBA) {
			invertirY=invertirY*-1;
		}
		
		x+=invertirX;
		y+=invertirY;
		
	}
	
	public void leerYPasarAArray() {
		
		File file= new File("data/colors.txt");
		try {
			FileReader aLeer= new FileReader(file);
			BufferedReader lector= new BufferedReader(aLeer);
			String linea="";
			int k=0;
			while(linea!=null) {
				linea=lector.readLine();
				if (linea!=null) {
					color.add(linea);
				}
				
				k++;
			}
			lector.close();
			} catch (IOException e) {
			// TODO: handle exception}
				e.printStackTrace();
			}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<String> getColor() {
		return color;
	}

	public void setColor(ArrayList<String> color) {
		this.color = color;
	}

	public String getColorActual() {
		return colorActual;
	}

	public void setColorActual(String colorActual) {
		this.colorActual = colorActual;
	}
	
}
