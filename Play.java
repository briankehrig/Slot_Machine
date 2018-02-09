import java.util.Scanner;		//import the scanner utility
/*
*	The play class is the main game which will be played. it incorporates the Game and Reel classes 
*	it has no instance variables and its only method is the main method in which the game runs.
*/
public class Play {
        public static void main(String[] args){		//main method (this is where the magic happens ;) 
                Reel leftReel = new Reel();		//create the left reel
                Reel middleReel = new Reel();		//create the middle reel
                Reel rightReel = new Reel();		//create the right reel

                Scanner sc = new Scanner(System.in);	//create an instance of Scanner
                int userChoice = 0;			//variable to keep track of the user's choice
                while(userChoice == 0){			//while loop that checks if the user's input is valid
			System.out.println("Would you like to enable GUI for this game? (Yes/No)");
			String mmchoice = sc.nextLine(); //take user input as a string
			switch (mmchoice.toUpperCase()) {//switch statement to go through all posibilities
			case "YES":  userChoice = 1;
				break;
			case "Y":  userChoice = 1;
				break;
			case "NO":  userChoice = 2;
				break;
			case "N":  userChoice = 2;
				break;
			case "QUIT":  userChoice =3;
				break;
			case "Q":  userChoice = 3;
				break;
			default: System.out.println("Invalid selection (yes/no/quit)");
				break;
			} 
		}
		if (userChoice == 2){		//if the user choses the option with no gui
			Game game = new Game(leftReel,middleReel,rightReel);	//create a new instance of Game which is constructed with the reels we created
			game.rollAll();						//roll all reels so there will be data to display
			game.showGame();					//show the reels
			while(game.getPlayerBalance()>0){			//while the player has money
				System.out.println("You have "+game.getPlayerBalance()+"$, how much would you like to bet? (10/20/30)");
				int userBet = 0;				//variable to keep track of the users bet
				int didWin = 0;					//variable to see if the user won
				while(userBet == 0){				//while the user has not bet a valid amount
					String betVal = sc.nextLine();		//take in user input
					switch (betVal) {			//switch statement to go through the possibilities of the user's bet
					case "10":  userBet = 1;
						break;
					case "20":  userBet = 2;
						break;
					case "30":  userBet = 3;
						break;
					default: System.out.println("Invalid selection (10/20/30)");
						break;
					}
				}
				if ((game.getPlayerBalance() - (userBet*10)) >=0){	//check to make sure the bet wont give the player a negative balace
					if(userBet == 1){				//if the user has bet 10
						game.bet(10);				//bet 10
						game.rollAll();				//roll all reels
						didWin = game.winTest();		//test to see if the player has won
						game.showGame();			//show the reels
						if (didWin > 0){			//if the player won
							int winnings = game.winnings(10,didWin);	//calculate winnings
							game.collectWinnings(winnings);			//collect winnings
							System.out.println("YOU HAVE WON $"+winnings+"!");//tell player how much they have won
						}
					}
					if(userBet == 2){				//if the user has bet 20
						game.bet(20);				//bet 20
						game.rollAll();				//roll all reels
						didWin = game.winTest();		//test for a win
						game.showGame();			//show the reels
						if (didWin > 0){			//if the player won
							int winnings = game.winnings(20,didWin);	//calculate winnings
							game.collectWinnings(winnings);			//collect winnings
							System.out.println("YOU HAVE WON $"+winnings+"!");//tell the player how much they have won
						}
					}
					if(userBet == 3){				//if the user bets 30
						game.bet(30);				//bet 30
						game.rollAll();				//roll all reels
						didWin = game.winTest();		//test for a win
						game.showGame();			//show the reels
						if (didWin > 0){			//if the player won
							int winnings = game.winnings(30,didWin);	//calculate winnings
							game.collectWinnings(winnings);			//collect winnings
							System.out.println("YOU HAVE WON $"+winnings+"!");//tell the player how much they have won
						}
					}
				}
			}
			System.out.println("You have no more money. oops! ");		//tell the player they have no more money (need to re-evaluate life choices)
		}
	}
}