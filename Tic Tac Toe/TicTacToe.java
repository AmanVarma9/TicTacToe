import java.util.Scanner;
public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char  board[][]={{'_','_','_'},
                             {'_','_','_'},
                             {'_','_','_'}};
            printBoard(board);
            for(int i=0;i<=9;i++){
              if(i%2==0){
                System.out.println("Turn X");
               int spot[]=askUser(board);
               board[spot[0]][spot[1]]='X';
               printBoard(board);
              }else{
                System.out.println("Turn O");
                int spot[]=askUser(board);
                board[spot[0]][spot[1]]='O';
                printBoard(board);}

                if(checkWin(board)==3){
                  System.out.println("X wins");
                  break;
                }
                else if(checkWin(board)==(-3)){
                  System.out.println("O wins");
                  break;
                }
                else if(i==8){
                  System.out.println("Its a tie");
                  break;
                }
              
            }

            sc.close();
        }


          
        public static void printBoard(char board[][]){
          for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
              System.out.print(board[i][j]+" ");
            }System.out.println("\t\n");
          }
        }
  
        public static int[] askUser(char board[][]){
          System.out.println("Pick a row and column number");
          System.out.print("\tRow:");
          int row=sc.nextInt();
          System.out.print("\tColunm:");
          int column=sc.nextInt();
          while(board[row][column]!=('_')){
            System.out.println("The spot is taken, Try again");
            System.out.print("\tRow:");
            row=sc.nextInt();
            System.out.print("\tColunm:");
            column=sc.nextInt();
          }
          int[] spot={row,column};
          return spot;
        }
   
    public static int checkWin(char board[][]){
      int counter=0;
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
          if(board[i][j]=='X'){
            counter++;
          }else if(board[i][j]=='O'){
            counter--;
          }
        }if(counter==3||counter==(-3)){
          return counter;
        }else{
          counter=0;
        }
      }

      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
          if(board[j][i]=='X'){
            counter++;
          }else if(board[j][i]=='O'){
            counter--;
          }
        }if(counter==3||counter==-3){
          return counter;
        }else {counter=0;
        }
      }
      for(int i=0;i<3;i++){
        if(board[i][i]=='X'){
          counter++;
        }else if(board[i][i]=='O'){
          counter--;
        }
      }if(counter==3||counter==-3){
        return counter;
      }else{
        counter=0;
      }
      for(int i=0;i<3;i++){
        int rowinx=2-i;
        if(board[rowinx][i]=='X'){
          counter++;
        }else if(board[rowinx][i]=='O'){
          counter--;
        }
      }if(counter==3||counter==-3){
        return counter;
      }else{
        counter=0;
      }
      return counter;
  }
}
