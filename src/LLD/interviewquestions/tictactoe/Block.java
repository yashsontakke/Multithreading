package LLD.interviewquestions.tictactoe;

enum PieceType{
    O,
    X
}

public class Block {
    int r;
    int c ;
    boolean isOccupied ;
    PieceType pieceType;

    Block(int r , int c ){
        this.r = r;
        this.c = c;
    }

}
