/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamettt;

/**
 *
 * @author Sounak
 */
public class TicTacToe{
    public char[][] board;
    TicTacToe(){
        board=new char[][]{{'_','_','_'},
            {'_','_','_'},
            {'_','_','_'}};
    }
     char ai='x',player='o';
     int evaluate(){
         char[][] b=board;
        for(int row=0;row<3;row++){
            if(b[row][0]==b[row][1] && b[row][1]==b[row][2]){
                if(b[row][0]==ai)
                    return 10;
                else if(b[row][0]==player)
                    return -10;
            }
        }
        for(int col=0;col<3;col++){
            if(b[0][col]==b[1][col] && b[1][col]==b[2][col]){
                if(b[0][col]==ai)
                    return 10;
                else if(b[0][col]==player)
                    return -10;
            }
        }
        if(b[0][0]==b[1][1] && b[1][1]==b[2][2]){
            if(b[0][0]==ai)
                return 10;
            else if(b[0][0]==player)
                return -10;
        }
        if(b[0][2]==b[1][1] && b[1][1]==b[2][0]){
            if(b[0][2]==ai)
                return 10;
            else if(b[0][2]==player)
                return -10;
        }
        return 0;
    }
     Boolean isMovesLeft(){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]=='_')
                    return true;
        return false;
    }

     void display(){
         char[][] b=board;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(b[i][j]+"\t");
            System.out.println();
        }
        System.out.println(".................");
    }
}

