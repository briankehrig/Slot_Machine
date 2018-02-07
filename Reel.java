import java.util.Random;

public class Reel{
        private int topBox;
        private int middlebox;
        private int bottomBox;

        public void rollReel(){
                int max = 5;
                int min = 1;
                int x = 0;
                int i = 0;
                Random rand = new Random(); 
                int tempTop = rand.nextInt((max - min) + 1) + min;
                this.topBox = tempTop;
                int tempMid = rand.nextInt((max - min) + 1) + min;
                while (x != 1){
                        if (tempMid != this.topBox){
                                this.middlebox = tempMid;
                                x = 1;
                        }
                        else{
                                tempMid = rand.nextInt((max - min) + 1) + min;
                        }

                }
                int tempBot = rand.nextInt((max - min) + 1) + min;
                while (i != 1){
                        if (tempBot != this.topBox && tempBot != this.middlebox){
                                this.bottomBox = tempBot;
                                i = 1;
                        }
                        else{
                                tempBot = rand.nextInt((max - min) + 1) + min;
                        }

                }
        }
        public int[] getReel(){
                int[] lst = {this.topBox,this.middlebox,this.bottomBox};
                return lst;
        }
}