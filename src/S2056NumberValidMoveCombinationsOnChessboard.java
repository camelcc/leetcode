// https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/discuss/1554261/Java-or-Brute-force
public class S2056NumberValidMoveCombinationsOnChessboard {
    static int[][] B_DIRS= {{1,-1},{1,1},{-1,1},{-1,-1}}, R_DIRS= {{1,0},{0,1},{-1,0},{0,-1}},
            Q_DIRS= {{1,-1},{1,1},{-1,1},{-1,-1},{1,0},{0,1},{-1,0},{0,-1}};
    static int B= 0, R= 1, Q= 2;            // piece types
    static int DIR= 0, MULT= 1, X= 0, Y= 1; // move ids (direction, distance multiplier), direction indexes

    int[] pieces;  // piece types
    int[][] positions; // original positions
    int[][] lastMove; // last generated move combination
    int[][] sim; // simulated position (used in isValid)
    int k; // number of pieces
    int count; // valid move combinations

    public int countCombinations(String[] pieces, int[][] positions) {
        this.k= pieces.length;
        this.pieces= new int[k];
        for(int i=0; i<k; i++)
            if(pieces[i].equals("bishop")) this.pieces[i]= B;
            else if(pieces[i].equals("rook")) this.pieces[i]= R;
            else this.pieces[i]= Q;
        this.positions= positions;

        this.count= 0;
        this.lastMove= new int[k][];
        this.sim= new int[k][2];
        generateCombinations(0);
        return this.count;
    }

    // generate combinations of moves for all pieces
    void generateCombinations(int piece){
        if(piece==k){
            count+= isValid() ? 1 : 0;
            return;
        }
        while(nextMove(piece))
            generateCombinations(piece+1);
        lastMove[piece]= null;
    }

    // generate next move for the specified piece
    boolean nextMove(int piece){
        if(lastMove[piece]==null){
            lastMove[piece]= new int[]{0,0}; // last move for piece i: direction index, mult [1..7]
            return true;
        }
        int[][] dirs= pieces[piece]==B ? B_DIRS : pieces[piece]==R ? R_DIRS : Q_DIRS;
        int[] last= lastMove[piece];
        for(;last[DIR]<dirs.length; ++last[DIR], last[MULT]=0){
            int dir= last[DIR];
            ++last[MULT];
            int x= positions[piece][X]+last[MULT]*dirs[dir][X], y= positions[piece][Y]+last[MULT]*dirs[dir][Y];
            if(x>=1 && x<=8 && y>=1 && y<=8) return true;
        }
        return false;
    }

    // simulate the combination to verify if it is valid
    boolean isValid(){
        for(int piece=0; piece<k; piece++){
            sim[piece][X]= positions[piece][X];
            sim[piece][Y]= positions[piece][Y];
        }
        for(int time=1; time<=7; time++){
            for(int piece=0; piece<k; piece++){
                int[][] dirs= pieces[piece]==B ? B_DIRS : pieces[piece]==R ? R_DIRS : Q_DIRS;
                int[] last= lastMove[piece];
                int dir= last[DIR], mult= last[MULT];
                if(mult>=time){
                    sim[piece][X]+= dirs[dir][X];
                    sim[piece][Y]+= dirs[dir][Y];
                }
                for(int piece2= 0; piece2<piece; piece2++){
                    // check if collides
                    if(sim[piece][X]==sim[piece2][X] && sim[piece][Y]==sim[piece2][Y]){
                        //System.out.println("Collision at: " + sim[piece][X] + " " + sim[piece][Y] + ", time=" + time);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
