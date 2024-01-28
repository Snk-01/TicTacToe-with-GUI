/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamettt;

/**
 *
 * @author Sounak
 */
import java.util.ArrayList;

public class minimax_algorithm extends TicTacToe{
    public boolean isfirst=false;
    Move findBestMove(){
        if(isfirst){
            isfirst=false;
            return new Move((int)(Math.random()*3),(int)(Math.random()*3));
        }
        int bestval=-1000;
        Move bestmove=new Move(-1,-1);
        ArrayList<Move> list = new ArrayList<Move>();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='_'){
                    board[i][j]=ai;
                    int moveval=minimax(board,0,false);
                    board[i][j]='_';
                    if(moveval>bestval){
                        bestmove.row=i;
                        bestmove.col=j;
                        bestval=moveval;
                        list= new ArrayList<Move>();
                    }

                    if(moveval==bestval)list.add(new Move(i,j));
                }
            }
        }
//        System.out.println(list.size());
        return list.get((int)(Math.random()*list.size()));
    }
    int minimax(char[][] board,int depth,boolean isMax){
        int score=evaluate();
        if(score==10)
            return score;
        if(score==-10)
            return score;
        if(!isMovesLeft())
            return 0;
        int best;
        if(isMax){
            best = -1000;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]=='_'){
                        board[i][j]=ai;
                        best=Math.max(best,minimax(board,depth+1, false));
                        board[i][j]='_';
                    }
                }
            }
        }
        else{
            best = 1000;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]=='_'){
                        board[i][j]=player;
                        best=Math.min(best,minimax(board,depth+1, true));
                        board[i][j]='_';
                    }
                }
            }

        }
        return best;
    }
}

