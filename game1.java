import java.util.*;
class game{
   static char[][]board;
     game(){
        board=new char[3][3];
        initboard();
    }
    void initboard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }
    static void displayboard(){
        System.out.println("-------------");
         for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
            System.out.print(board[i][j]+" | ");   
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    static void placemark(int row,int col,char mark){
        if(row>=0&&row<=2&&col>=0&&col<=2){
            board[row][col]=mark;
        }
        else{
            System.out.println("invalid position");
        }
        
    }
   static boolean checkcolwin(){
        for(int j=0;j<=2;j++){
            if(board[0][j]!=' '&&board[0][j]==board[1][j]&&board[1][j]==board[2][j]){
                return true;
            }
        }
        return false;
    }
    static boolean checkrowwin(){
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;
    }
    static boolean checkdiagwin(){
        if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]||board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
            return true;
        }
        else{
            return false;
        }
    
	}
	static boolean checkDraw(){
		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				if(board[i][j]==' '){
					return false;
				}
			}
		}
		return true;
	}
}

class humanplayer{
    String name;
    char mark;
 humanplayer(String name,char mark){
    this.name=name;
    this.mark=mark;
    }
    void makemove(){
        Scanner sc=new Scanner(System.in);
        int row,col;
       do{
         System.out.println("enter the row and col");
         row=sc.nextInt();
         col=sc.nextInt();
       }while(!isvalidmove(row, col));
       game.placemark(row, col, mark);

       
    }
    boolean isvalidmove(int row,int col){
        if(row>=0&&row<=2&&col>=0&&col<=2){
            if(game.board[row][col]==' '){
                return true;
            }
        }
        return false;
    }
}

class launchgame{
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
		
		System.out.println("enter first player name");
        String name1=sc.next();
        System.out.println("enter second player name");
        String name2=sc.next();
		boolean playAgain=true;
		int p1score=0;
		int p2score=0;
		while(playAgain){
		game b=new game();
		
       humanplayer p1=new humanplayer(name1, 'X');
        humanplayer p2=new humanplayer(name2, 'O');
        humanplayer cp;
        cp=p1;
         game.displayboard();
        while(true){
            System.out.println(cp.name+" TURN ");
        cp.makemove();
        game.displayboard();
        if(game.checkcolwin()||game.checkdiagwin()||game.checkrowwin()){
            System.out.println(cp.name +" has won ");
		   if(cp==p1){
			  p1score++;			  
		   }
		   else{
			   p2score++;
		   }
            break;
        }
		else if(game.checkDraw()){
			System.out.println("Game is a draw");
			break;
		}
		
        else{
            if(cp==p1){
                cp=p2;
            }
            else{
                cp=p1;
            }
        }
        }
		System.out.println(name1+" score is : "+p1score);
		System.out.println(name2+" score is : "+p2score);
		 System.out.println("Do you want to play again? (Y/N)"); // Ask the players if they want to play again
            String playAgainInput = sc.next();
			
            if (!playAgainInput.equalsIgnoreCase("Y")) { // If the players don't want to play again, exit the loop
                playAgain = false;
				System.out.println("Thanks for playing");
				
            }
			else{
			System.out.println("Do You want to play with same name or different\n to choose press s for same name or d for different");
			String n=sc.next();
			
			if(n.equals("d")||n.equals("D")){
				System.out.println("enter first player name");
				name1=sc.next();
				System.out.println("enter second player name");
				name2=sc.next();
				p1score=0;
				p2score=0;
			}
			}
			

		}
		
    }
}