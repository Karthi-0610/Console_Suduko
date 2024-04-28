import java.util.*;
public class Suduko {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int board[][]=new int[9][9];
        System.out.println("For Empty space print zero(0)");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]=scan.nextInt();
            }
        }

        Sudukoboard(board,0,0);
    }


    public static void Sudukoboard(int[][] board,int row,int column){
        int rw=(column==9)?row+1:row;
        int cl=(column==9)?0:column;

        if(rw==9){
            print(board);
            return;
        }

        if(board[rw][cl]==0){
            for(int i=1;i<=9;i++){
                if(validnumber(board,rw,cl,i)){
                    board[rw][cl]=i;
                    Sudukoboard(board,rw,cl+1);
                    board[rw][cl]=0;
                }
            }
        }else{
            Sudukoboard(board,rw,cl+1);
        }
    }

    public static boolean validnumber(int[][] board,int row,int column,int val){
        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(board[i][column]==val){
                return false;
            }
        }

        row=row-(row%3);
        column=column-(column%3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[row+i][column+j]==val){
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(int[][] board){
        System.out.println("------------------");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }
}
