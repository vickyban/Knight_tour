package com.prog32758;

import java.util.ArrayList;
import java.util.HashMap;

public class Knight {
    private int[][] board = new int[8][8];
    private int step;
    private int x;
    private int y;

    public int getStep() { return step; }
    public int[][] getBoard() { return board; }
    
    void moveKnight(int move){
        switch(move){
            case 0: x+=2; y+=1; break;
            case 1: x+=1; y+=2; break;
            case 2: x-=1; y+=2; break;
            case 3: x-=2; y+=1; break;
            case 4: x-=2; y-=1; break;
            case 5: x-=1; y-=2; break;
            case 6: x+=1; y-=2; break;
            case 7: x+=2; y-=1; break;
            default: return;
        }
        board[x][y] = ++step;
    }

    boolean canMove(int x, int y){
        if(x  >= 0 && x <= 7 && y >= 0 && y <= 7 && board[x][y] == 0 )
            return true;
        return false;
    }

    int getAccessibleIndex( int x, int y){
        int count = 0;
        if(canMove(x,y)) {
            if(canMove(x + 2, y + 1)) count++ ;
            if(canMove(x + 1, y + 2)) count++ ;
            if(canMove(x - 1, y + 2)) count++ ;
            if(canMove(x - 2, y + 1)) count++ ;
            if(canMove(x - 2, y - 1)) count++ ;
            if(canMove(x - 1, y - 2)) count++ ;
            if(canMove(x + 1, y - 2)) count++ ;
            if(canMove(x + 2, y - 1)) count++ ;
        }
        return count;
    }

    void runKnightTour(){
        HashMap<Integer, ArrayList<Integer>> accessMap = new HashMap<>();
        mapMoveToIndex(getAccessibleIndex( x+2, y+1), 0, accessMap);
        mapMoveToIndex(getAccessibleIndex( x+1, y+2), 1, accessMap);
        mapMoveToIndex(getAccessibleIndex( x-1, y+2), 2, accessMap);
        mapMoveToIndex(getAccessibleIndex( x-2, y+1), 3, accessMap);
        mapMoveToIndex(getAccessibleIndex( x-2, y-1), 4, accessMap);
        mapMoveToIndex(getAccessibleIndex( x-1, y-2), 5, accessMap);
        mapMoveToIndex(getAccessibleIndex( x+1, y-2), 6, accessMap);
        mapMoveToIndex(getAccessibleIndex( x+2, y-1), 7, accessMap);

        //System.out.println("Step" + this.step + ": " + accessMap);

        if(accessMap.containsKey(1)){
            this.pickMove(1,accessMap);
        }else if(accessMap.containsKey(2)) {
            this.pickMove(2,accessMap);
        }else if(accessMap.containsKey(3)) {
            this.pickMove(3,accessMap);
        }else if(accessMap.containsKey(4)) {
            this.pickMove(4,accessMap);
        }else if(accessMap.containsKey(5)) {
            this.pickMove(5,accessMap);
        }else if(accessMap.containsKey(6)) {
            this.pickMove(6,accessMap);
        }else if(accessMap.containsKey(7)) {
            this.pickMove(7,accessMap);
        }else if(accessMap.containsKey(8)) {
            this.pickMove(8,accessMap);
        }else {
            lastMove();
            //printResult();
            return;
        }
    }


    void lastMove(){
        int move = - 1 ;
        if(canMove(x + 2, y + 1)) move = 0;
        else if(canMove(x + 1, y + 2)) move = 1 ;
        else if(canMove(x - 1, y + 2)) move = 2 ;
        else if(canMove(x - 2, y + 1)) move = 3 ;
        else if(canMove(x - 2, y - 1)) move = 4 ;
        else if(canMove(x - 1, y - 2)) move = 5 ;
        else if(canMove(x + 1, y - 2)) move = 6 ;
        else if(canMove(x + 2, y - 1)) move = 7;
        moveKnight(move);
    }

    void setInitPost(int x, int y){
        if(x >= 0 && x <= 7 && y >= 0 && y <= 7){
            this.x = x;
            this.y = y;
        }
        board[x][y] = ++step;
    }

    void printResult(){
        for(int i = 0; i< 8; i++){
            for(int j = 0; j < 8; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    
    void mapMoveToIndex(int index , int move, HashMap<Integer,ArrayList<Integer>> map){
        if(map.containsKey(index)) map.get(index).add(move);
        else map.put(index, new ArrayList<Integer>(){{ add(move); }});
    }

    void pickMove(int key, HashMap<Integer,ArrayList<Integer>> map){
        int i = (int)(Math.random()*map.get(key).size());
        int move = map.get(key).get(i);
        moveKnight(move);
        runKnightTour();
    }

    void runDumpKnight(){
        ArrayList<Integer> validMoves = new ArrayList<>();
        if(canMove(x + 2, y + 1)) validMoves.add(0) ;
        if(canMove(x + 1, y + 2)) validMoves.add(1) ;
        if(canMove(x - 1, y + 2)) validMoves.add(2) ;
        if(canMove(x - 2, y + 1)) validMoves.add(3) ;
        if(canMove(x - 2, y - 1)) validMoves.add(4) ;
        if(canMove(x - 1, y - 2)) validMoves.add(5) ;
        if(canMove(x + 1, y - 2)) validMoves.add(6) ;
        if(canMove(x + 2, y - 1)) validMoves.add(7) ;

        if(validMoves.size() == 0){
            //printResult();
            return;
        }
        int move = validMoves.get((int) (Math.random() * validMoves.size()));
        moveKnight(move);
        runDumpKnight();
    }

}
