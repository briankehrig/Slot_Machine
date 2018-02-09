/*
*       this class is the game class and is used to handle all of the basic functions of the game
*       there are instance variables for each of the three reels of the slot machine and one for the players money.
*       This class also contains method variables to show the reels, roll the reels, get the player balance, bet money, collect winnings
*       and test if the player won. this class also has a constructor that is to be used setting the instance variables for the left, middle,
*       and right reels as well as the player balance to the default value of 100.
*/

public class Game{
        private Reel leftReel;          //instance variable for the left reel
        private Reel midReel;           //instance variable for the middle reel
        private Reel rightReel;         //instance variable for the right reel
        private int playerBalance;      //instance variable for the player's money

        public Game(Reel l,Reel m,Reel r){      //constructor which takes parameters of 3 Reels for the left middle and right
                this.leftReel = l;              //set the left reel
                this.rightReel = r;             //set the right reel
                this.midReel = m;               //set the middle reel
                this.playerBalance = 100;       //set the player balance to 100
        }

        public void showGame(){                         //method used to show the reels
                int[] leftList = leftReel.getReel();    //get data from left reel
                int[] midList = midReel.getReel();      //get data from middle reel
                int[] rightList = rightReel.getReel();  //get data from right reel
                System.out.println(leftList[0]+"          "+midList[0]+"          "+rightList[0]);      //print the top line
                System.out.println(leftList[1]+"          "+midList[1]+"          "+rightList[1]);      //print the middle line
                System.out.println(leftList[2]+"          "+midList[2]+"          "+rightList[2]);      //print the bottom line
        }
        public void rollAll(){          //method used to roll all reels
                leftReel.rollReel();    //roll the left reel
                rightReel.rollReel();   //roll the right reel
                midReel.rollReel();     //roll the middle reel
        }
        public int getPlayerBalance(){          //getter for the player balance
                return this.playerBalance;      //return the player balance
        }
        public void bet(int amnt){              //method used to bet
                this.playerBalance -= amnt;     //subtract bet amount from playerBalance
        }
        public void collectWinnings(int moneys){        //method to collect winnings
                this.playerBalance += moneys;           //add winnings to player balance
        }
        public int winTest(){                           //method to test if the player won
                int[] leftList = leftReel.getReel();    //get the data from left reel
                int[] midList = midReel.getReel();      //get data from middle reel
                int[] rightList = rightReel.getReel();  //get data from right reel

                int winLines = 0;                       //variable to count how many lines were won on
                //int[] wonOn = new ArrayList<>(5);
                int x = 0;                              //variable for itteration
                for(x=0;x<3;x++){                       //loop to itterate through and see if the player won on the horizontal lines
                        if ((leftList[x] == midList[x]) && (leftList[x] == rightList[x]) && (midList[x] == rightList[x])){      //if the values in a line are all the same
                                //wonOn[winLines] = x;
                                winLines++;             //increment winlines by one

                        }
                }
                if((leftList[0] == midList[1]) && (leftList[0] == rightList[2]) && (midList[1] == rightList[2])){       //chech to see if there is a win on the diagnol
                        winLines++;                     //increment winLines by one
                }
                if((leftList[2] == midList[1]) && (leftList[2] == rightList[0]) && (midList[1] == rightList[0])){       //check the other diagnol
                        winLines++;                     //increment winLines by one
                }
                return winLines;                        //return winLines
                        
        }
        public int winnings(int betamt,int linesWon){   //method to determine how much the player won
                int win = (betamt*linesWon*2);          //calculate winnings
                return win;                             //return winnings
        }
}

