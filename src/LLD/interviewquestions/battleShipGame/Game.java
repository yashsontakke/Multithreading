package LLD.interviewquestions.battleShipGame;

import java.util.ArrayDeque;
import java.util.Queue;

public class Game {
    Cube [][] board ;
    Player playerA;
    Player playerB;
    int len ;
    int leftShips ;
    int rightShips ;

    Game(int n , Player p1 , Player p2){
        board = new Cube [n][n];
        this.playerA = p1;
        this.playerB = p2;
        this.len = n ;
    }

    public boolean isGoodHit(int x , int y , Player player){
        return (player.isLeft && x<=len/2) || (!player.isLeft && x>len/2);
    };

    public boolean alreadyHit(Player player , int x  , int y ){
        int val = x*len+y;
        if(player.hits.contains((val))){
            return true ;
        }else{
            player.hits.add(val);
            return false ;
        }
    }

    public boolean isShipValidForPlayer(int x , int y , int size , Player player){

        if(player.isLeft && y-size>=0){
            return true ;
        }else if(!player.isLeft && y-size>len/2 ){
            return true ;
        }
        return false;
    }

    public boolean  canAddShip(int x , int y , int size ) {
        for(int i=x;i>=x-size && i>=0 ;i--){
            for(int j=y;j>=y-size && j>=0 ;j--){
                Cube cube = board[i][j];
                if(cube!=null) return false ;
            }
        }
        return true ;
    }

    public void play(Player p1 , Player p2 ){
        boolean a = true ;
        while(true){
            int x = (int)(Math.random() * 20) ;
            int y=0;
            if(a){
                y = (int)(Math.random() * 10) + 10;
            }else{
                y = (int)(Math.random() * 10) ;
            }

            //if already fired on that position don't fire again

            if(a){
                if(p1.hits.contains(x*20+y)){
                    System.out.println("PLayerA's turn already hit  on this point  ("+x +","+ y +")fire again");
                    continue ;
                }
                else p1.hits.add(x*20+y);
            }else {
                if(p2.hits.contains(x*20+y)){
                    System.out.println("PlayerB's turn already hit on this point (" +x +" "+ y+")fire again ");
                    continue ;
                }
                else p2.hits.add(x*20+y);
            }

            int hit = fire(x,y,a?p1:p2);
            System.out.println(a?"PlayerA's turn : Missile fired at ("+ x+","+y+") :"+(hit!=-1?"Hit":"Miss")
                    :"PlayerB's turn : Missile fired at ("+ x+","+y+") :" + (hit!=-1?"Hit":"Miss"));

            if(hit!=-1){
                System.out.println("Ship destroyed id  "+ hit);
                viewBattleField();
            }

            System.out.println("Ship Remaining - "+"PlayerA: "+ leftShips +", PlayerB: "+rightShips);
            a=!a;

            System.out.println();

            if(rightShips==0){
                System.out.println("CONGRATS : PlayerA wins");
                break ;
            }

            if(leftShips==0){
                System.out.println("CONGRATS : PlayerB wins");
                break ;
            }

        }
    }

    public void addShip(int x , int y , int size , String name , int id ,Player player ){

        Ship ship = new Ship(name,id,x,y,x-size,y-size);

        for(int i=x;i>=x-size && i>=0 ;i--){
            for(int j=y;j>=y-size && j>=0 ;j--){
                Cube  cube = new Cube(x,y,true,id,player);
                board[i][j]= cube;
                cube.shipId= ship.id;
                cube.isShipPresent= true;
                cube.player = player ;
            }
        }

        if(player.isLeft) leftShips++;
        else rightShips++;
    }

    public void initBattleField(Game game , Player p1 , Player p2){
        int id = 1;
        // for left player preparing battlefield
        for(int i=0;i<50;i++){
            int x = (int)(Math.random() * 20)  ;
            int y = (int)(Math.random() * 10) ;
            int size = (int)(Math.random() * 3) + 3;

            boolean isValid =  game.isShipValidForPlayer(x,y,size,p1);
            if(!isValid) continue;
            boolean canAdd = game.canAddShip(x,y,size);

            if(canAdd){
                game.addShip(x,y,size,p1.name+"SH"+id,id++,p1);
            }
        }

        id=1;
        // for right player preparing battlefield
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                int x = (int)(Math.random() * 20) ;
                int y = (int)(Math.random() * 10) + 10;
                int size = (int)(Math.random() * 3) + 3;
                boolean isValid =  game.isShipValidForPlayer(x,y,size,p2);
                if(!isValid) continue;
                boolean canAdd = game.canAddShip(x,y,size);
                if(canAdd ){
                    game.addShip(x,y,size,p2.name+"SH"+id,id++,p2);
                }
            }
        }

    }

    public void viewBattleField() {
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                Cube cube = board[i][j];
                if(cube!=null && cube.isShipPresent){
                    System.out.print(cube.player.name+cube.shipId+" - ");
                }else{
                    System.out.print("N"+0+" - ");
                }

            }
            System.out.println();
        }
    }

    public  int fire(int x , int y , Player p){
        Cube cube = board[x][y];
        int save= 0;
        if(cube==null || !cube.isShipPresent) return -1;

        else{
             save = cube.shipId;
            bfs(x,y);
            if(p.isLeft){
                rightShips--;
            }else{
                leftShips--;
            }
        }
        return save ;
    }

    public  void bfs (int x , int y ){
        int dir []= new int []{-1,0,1,0,-1};
        boolean [][] visited = new boolean [len][len];
        Queue<int []> q = new ArrayDeque<>();
        visited[x][y]=true ;
        q.add(new int []{x,y});

        while(!q.isEmpty()){
            int rem[] = q.remove();
            int a = rem[0];
            int b = rem[1];
            int shipId =  board[a][b].shipId;
            board[a][b].isShipPresent= false;
            board[a][b].shipId=-2;
            board[a][b].player= null;
            for(int i=0;i<4;i++){
                int xdash = rem[0]+dir[i];
                int ydash = rem[1]+dir[i+1];
                if(xdash>=0 && ydash>=0 && xdash< len && ydash< len && board[xdash][ydash]!=null &&
                        visited[xdash][ydash]==false && board[xdash][ydash].shipId==shipId){
                    visited[xdash][ydash]=true ;
                    q.add(new int []{xdash,ydash});
                }
            }
        }
    }
}
