import java.util.ArrayList;

public class Game{
        private Reel leftReel;
        private Reel midReel;
        private Reel rightReel;
        private int playerBalance;

        public Game(Reel l,Reel m,Reel r){
                this.leftReel = l;
                this.rightReel = r;
                this.midReel = m;
                this.playerBalance = 100;
        }

        public void showGame(){
                int[] leftList = leftReel.getReel();
                int[] midList = midReel.getReel();
                int[] rightList = rightReel.getReel();
                System.out.println(leftList[0]+" "+midList[0]+" "+rightList[0]);
                System.out.println(leftList[1]+" "+midList[1]+" "+rightList[1]);
                System.out.println(leftList[2]+" "+midList[2]+" "+rightList[2]);
        }
        public void rollAll(){
                leftReel.rollReel();
                rightReel.rollReel();
                midReel.rollReel();
        }
        public int getPlayerBalance(){
                return this.playerBalance;
        }
        public void bet(int amnt){
                this.playerBalance -= amnt;
        }
        public void collectWinnings(int moneys){
                this.playerBalance += moneys;
        }
        public int winTest(){
                int[] leftList = leftReel.getReel();
                int[] midList = midReel.getReel();
                int[] rightList = rightReel.getReel();

                int winLines = 0;
                //int[] wonOn = new ArrayList<>(5);
                int x = 0;
                for(x=0;x<3;x++){
                        if ((leftList[x] == midList[x]) && (leftList[x] == rightList[x]) && (midList[x] == rightList[x])){
                                //wonOn[winLines] = x;
                                winLines++;

                        }
                }
                if((leftList[0] == midList[1]) && (leftList[0] == rightList[2]) && (midList[1] == rightList[2])){
                        winLines++;
                }
                if((leftList[2] == midList[1]) && (leftList[2] == rightList[0]) && (midList[1] == rightList[0])){
                        winLines++;
                }
                return winLines;
                        
        }
        public int winnings(int betamt,int linesWon){
                int win = (betamt*linesWon*2);
                return win;
        }
}

