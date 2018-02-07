import java.util.Scanner;

public class Play {
        public static void main(String[] args){
                Reel leftReel = new Reel();
                Reel middleReel = new Reel();
                Reel rightReel = new Reel();

                Scanner sc = new Scanner(System.in);
                int userChoice = 0;
                while(userChoice == 0){
			System.out.println("Would you like to enable GUI for this game?");
			String mmchoice = sc.nextLine();
			switch (mmchoice.toUpperCase()) {
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
		if (userChoice == 2){
			Game game = new Game(leftReel,middleReel,rightReel);
			game.rollAll();
			while(game.getPlayerBalance()>=0){
				game.showGame();
				System.out.println("You have "+game.getPlayerBalance()+"$, how much would you like to bet? (10/20/30)");
				int userBet = 0;
				while(userBet == 0){
					String betVal = sc.nextLine();
					switch (betVal) {
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
				if ((game.getPlayerBalance() - (userBet*10)) >=0){
					if(userBet == 1){
						game.bet(10);
						game.rollAll();
					}
					if(userBet == 2){
						game.bet(20);
						game.rollAll();
					}
					if(userBet == 3){
						game.bet(30);
						game.rollAll();
					}
				}
			}
		}
	}
}