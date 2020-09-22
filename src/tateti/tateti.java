package tateti;

import java.util.Scanner;

public class tateti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menu=0;
		Scanner listener= new Scanner( System.in);
		Board_Game bg= new Board_Game();
		////MENU
		do {
			System.out.println("------------BIENVENIDO----------------");
			System.out.println("1-Jugadar 2 jugadores");
			System.out.println("2- jugagar contra pc");
			System.out.println("3- salir");
			menu=listener.nextInt();
			
			switch(menu) {
				
				case 1:
					Player j1= new Player();
					Player j2= new Player();
					boolean end_game=false;
					int pos;
					do {
						///FRIST check IF THE OTHER PLAYER WON OR NOT. IF WON, THE GAME WILL BE END. IF NOT THE PLAYER CAN PLAY HIS TURN. 	 THE PORGRAM ASK ABOUT THe	POSICION WHAT YOU WANT PLAY.   
						
						System.out.println(bg.drawig(j1, j2));
						
						if(!bg.you_win(j2)) {	
							do {
								System.out.println("Turno jugador 1");
								pos=choose_movement(listener);
								if(!bg.free_position(pos)) {
									System.out.println("Posicion ocupada");
								}
							}while(!bg.free_position(pos));
							bg.player_play(j1, pos);
						}else {
							end_game=true;
						}
						
						////PLAYER 2
						System.out.println(bg.drawig(j1, j2));
						if(!bg.you_win(j1)) {
							System.out.println("Turno jugador 2");
							do {
								System.out.println("Elige posicion jugador dos");
								pos=choose_movement(listener);
								if(!bg.free_position(pos)) {
									System.out.println("Posicion ocupada");
								}		
							}while(!bg.free_position(pos));
							bg.player_play(j2, pos);
						}else {
							end_game=true;
						}
						
					}while(!end_game); ///this loop end when any player return true
					
					if(bg.you_win(j1)) {
						System.out.println(j1.get_name()+" Fue el ganador");
					}else if(bg.you_win(j2)) {
						System.out.println(j2.get_name()+" Fue el ganador");
					}
					
					break;
				case 2:
					System.out.println("Estas jugando contra la pc");
					break;
				case 3:
					menu=3;
					listener.close();
					break;
				}
		}while(menu!=3);
		System.out.println("Gracias por jugar");
		
		
		
		
		/*
		Player j1= new Player();
		Player j2= new Player();
		Board_Game bg= new Board_Game();
		System.out.println(bg.drawig(j1, j2));
		System.out.println(bg.free_position(1));
		bg.player_play(j1, 1);
		System.out.println(bg.free_position(1));
		System.out.println(bg.drawig(j1, j2));
		*/
	}
	
	
	

	
	////////////////STACTIC METHODOS//////////////////
	static int choose_movement(Scanner listener) { 
		return listener.nextInt();
	}
	
	
	
}