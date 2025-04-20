package LLD.interviewquestions.tictactoe;

public class Game {
    int size ;
    Block board [][] ;

    public Game(int size ){
        board= new Block[size][size];
        this.size = size;
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Block(i, j);
            }
        }
    }

    boolean play(Player p , int r , int  c){
        Block block = board[r][c];
        block.isOccupied = true ;
        block.pieceType = p.pieceType;
        System.out.println("Player" + p.playerID + "draw" + block.pieceType + "at positon "+ r+","+c);
        int count =0;
        for(int j=0;j<size;j++){
            if(board[r][j].pieceType==p.pieceType){
                count++;
            }
            if(count==size) return true ;

        }
        count=0;
        for(int i=0;i<size;i++){
            if(board[i][c].pieceType==p.pieceType){
                count++;
            }
            if(count==size) return true ;
        }
        count=0;

        for(int i=0,j=0;i<size;i++,j++){
            if(board[i][j].pieceType==p.pieceType){
                count++;
            }
            if(count==size) return true ;
        }

        return false ;
    }
    public static void main(String[] args) {
        Game game = new Game(3);

        Player p1 = new Player(1,PieceType.O);
        Player p2 = new Player(2,PieceType.X);

        Player p = p1;
        boolean finished = false;
        int filled =0;
        while(!finished){
            int x = (int)(Math.random()*3);
            int y = (int)(Math.random()*3);
            while(!game.board[x][y].isOccupied){
                if(game.play(p,x,y)){
                    System.out.println("Player " + p.playerID + "won");
                    for(int i=0;i< game.size;i++){
                        for(int j=0;j< game.size;j++){
                            PieceType pieceType = game.board[i][j].pieceType;
                            System.out.print(pieceType==null?". ":pieceType+" ");
                        }
                        System.out.println();
                    }
                    finished = true;
                    break ;
                };
                p=(p==p1)?p2:p1;
                filled +=1;
                if(filled== game.size* game.size) {
                    System.out.println("No Body Won ");
                    finished = true;
                };
            }
        }
    }
}
