package tateti;

public class Board_Game {
	private Player board_game[][];
	
	public Board_Game() {
		board_game= new Player[3][3];
		initialize();
	}

	private void initialize() {
		for (int i=0 ; i<3; i++) {
			for(int j=0; j<3; j++){
			board_game[i][j]=null;
			}
		}
	}
	
	public boolean you_win(Player p){
		boolean answer= false;
			if( board_game[0][0] == p && board_game[0][1] == p&& board_game[0][2]== p ) {
				answer= true;
			}else if(board_game[1][0] == p && board_game[1][1] == p&& board_game[1][2]== p) {
				answer= true;
			}else if(board_game[2][0] == p && board_game[2][1] == p&& board_game[2][2]== p) {
				answer= true;
			}else if(board_game[0][0] == p && board_game[1][0] == p&& board_game[2][0]== p) {
				answer= true;
			}else if(board_game[0][1] == p && board_game[1][1] == p&& board_game[2][1]== p) {
				answer= true;
			}else if(board_game[0][2] == p && board_game[1][2] == p&& board_game[2][2]== p) {
				answer= true;
			}else if(board_game[0][0] == p && board_game[1][1] == p&& board_game[2][2]== p) {
				answer= true;
			}else if(board_game[0][2] == p && board_game[1][1] == p&& board_game[2][0]== p) {
				answer= true;
			}
		return answer;
	}
	///RETURN TRUE IF YOU CAN USE THAHT position //// i should fix  what i find the posicion end the loop
	public boolean free_position(int pos) {
		boolean answer= false;
		int pos_cont=0;
		for (int i=0 ; i<3; i++) {
			for(int j=0; j<3; j++){
				pos_cont++;
				if(pos == pos_cont) {
					if(board_game[i][j]==null) {
						answer=true;
					}
				}
			}
		}
		return answer;
	}
	 public void get_player_move(int pos, Player p) {
		 int pos_cont=0;
			for (int i=0 ; i<3; i++) {
				for(int j=0; j<3; j++){
					pos_cont++;
					if(pos == pos_cont) {
						board_game[i][j]=p;
					}
				}
			}
	 }

	 public void player_play(Player p, int pos) {
		 int pos_cont=0;
			for (int i=0 ; i<3; i++) {
				for(int j=0; j<3; j++){
					pos_cont++;
					if(pos == pos_cont) {
						board_game[i][j]=p;	
						
					}
				}
			}
	 }
	 
	public String drawig(Player j1, Player j2) {
		 StringBuilder drawing= new StringBuilder();
		 int pos_cont=0;
		 for (int i=0 ; i<3; i++) {
				for(int j=0; j<3; j++){
					pos_cont++;
					
					if(board_game[i][j]==null) {
						drawing.append(pos_cont);
					}else if(board_game[i][j]==j1) {
						drawing.append("j1");
					}else if(board_game[i][j]==j2) {
						drawing.append("j2");
					}
					
					if(pos_cont%3==0) {
						drawing.append("\n");
					}
					
					drawing.append("|");
				}
			}
		return drawing.toString();
	}
}