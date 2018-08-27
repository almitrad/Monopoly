import java.util.*;
public class Monopoly {
	
	public static String player1Name;
	public static String player2Name;

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		//CREATING ARRAY
		SquareType[] monopolyBoard = new SquareType[28];
		
		//CREATING PIECES
		monopolyBoard [0] = new Ends("Start/Go", "Ends", " ", " ", 0);
		monopolyBoard [1] = new Property("Fremont", 100.00, 20.00, "WHS", "Property", " ", " ");
		monopolyBoard [2] = new Property("Fremont", 200.00, 40.00, "Tesla", "Property", " ", " ");
		monopolyBoard [3] = new Property("Fremont", 100.00, 35.00, "Niles", "Property", " ", " ");
		monopolyBoard [4] = new Railroads(200.00, 25.00, "Warm Springs", "Railroads", " ", " ", 150);
		monopolyBoard [5] = new Property("EastBay", 200.00, 50.00, "O.CO Collesium", "Property", " ", " ");
		monopolyBoard [6] = new Property("EastBay", 250.00, 45.00, "Lawrence Lab",  "Property", " ", " ");
		monopolyBoard [7] = new Chance("Chance", "Chance", " ", " ", 0);
		monopolyBoard [8] = new Property("EasyBay", 100, 35, "Ardenwood", "Property" , " " , " "); 
		monopolyBoard [9] = new Ends("Jail", "Ends", " ", " ", 150);
		monopolyBoard [10] = new Property("EasyBay", 100.00, 35.00, "Cheeseboard", "Property", " ", " ");
		monopolyBoard [11] = new Property("Berkeley", 250.00, 50.00, "UC Berkeley", "Property", " ", " ");
		monopolyBoard [12] = new Railroads(200.00, 25.00, "Richmond", "Railroads", " ", " ", 150);
		monopolyBoard [13] = new Taxes(100.00, "PG&E", "Taxes", " ", " ", 0);
		monopolyBoard [14] = new Ends("Free Parking", "Ends", " ", " ", 0);
		monopolyBoard [15] = new Property("SFTouristy", 300.00, 60.00, "SF MOMA", "Property", " ", " ");
		monopolyBoard [16] = new Property("SFTouristy", 350.00, 65.00, "GGBridge", "Property", " ", " ");
		monopolyBoard [17] = new Chance("Chance", "Chance", " ", " ", 0);
		monopolyBoard [18] = new Property("SFTouristy", 200.00, 40.00, "Pier 39", "Property", " ", " ");
		monopolyBoard [19] = new Railroads(200.00, 25.00, "Daly City", "Railroads", " ", " ", 150);
		monopolyBoard [20] = new Property("SFLocal", 250.00, 45.00, "Exploratorium", "Property", " ", " ");
		monopolyBoard [21] = new Property("SFLocal", 175.00, 25.00, "Coit Tower", "Property", " ", " ");
		monopolyBoard [22] = new Property("SFLocal", 150.00, 20.00, "Yerba Buena", "Property", " ", " ");
		monopolyBoard [23] = new Ends("Go To Jail", "Ends", " ", " ", 0);
		monopolyBoard [24] = new Property("Inland", 450.00, 80.00, "Blackhawk", "Property", " ", " ");
		monopolyBoard [25] = new Property("Inland", 400.00, 70.00, "Stoneridge", "Property", " ", " ");
		monopolyBoard [26] = new Railroads(200.00, 25.00, "Dublin", "Railroads", " ", " ", 150);
		monopolyBoard [27] = new Taxes(150.00, "Shane Co.", "Taxes", " ", " ", 0);
		
		//PROPERTY COUNT ARRAY LIST
		 ArrayList <Integer> p1PropertyCount = new ArrayList <Integer>(); 
		 ArrayList <Integer> p2PropertyCount = new ArrayList <Integer>(); 
		
		
		//PRINTING INITIAL BOARD
		int i = 0;
		int j = 0;
		printBoard(monopolyBoard, i, j);
		
		//CREATING PIECES
		Pieces Player1 = new Player1();
		Pieces Player2 = new Player2();
		Bank bank = new Bank();
		Taxes tax = new Taxes();
				
		//RULES
		System.out.println("Welcome to Bay Area monopoly!");
		System.out.println("Player 1 please enter your name:");
		player1Name = input.nextLine();
		Player1.setOwner(player1Name);
		System.out.println("Player 2 please enter your name:");
		player2Name = input.nextLine();
		Player2.setOwner(player2Name);
		System.out.println(player1Name + " will be x " + player2Name + " will be o. ");
		
		//INITIAL POSITIONS
		int p1Position = 0;  
		int p1CurrentPosition = 0;
		Player1.setLocation(monopolyBoard[p1Position].getName());
		int p2Position = 0;
		int p2CurrentPosition = 0;
		Player2.setLocation(monopolyBoard[p2Position].getName());
		
				
		int x = 1;
	
		int p1FirstDiceValue = 0, p1SecondDiceValue = 0, p2FirstDiceValue = 0, p2SecondDiceValue = 0 ;
		while (Player1.getBalance() > 0 && Player2.getBalance() > 0 ) {
			
			while (x == 1) {
				if (Player1.getLocation() == "Go To Jail") {
					System.out.println("Sorry it is " + player2Name + "'s turn!");
					x = 2;
				}
				System.out.println("It is " + player1Name + "'s turn! Press 1 to roll the dice.");
				int p1Dice = input.nextInt();
				if (p1Dice == 1) {
					p1FirstDiceValue = (int)((Math.random() * 6) + 1);
					p1SecondDiceValue = (int)((Math.random() * 6) + 1);
				}
				else {
					System.out.println("It is " + player2Name + "'s turn.");
					x = 2; 
				}
				
				int p1Move = p1FirstDiceValue + p1SecondDiceValue;
				p1Position = p1Position + p1Move;
				int p1NewPosition = p1Position + p1Move;
				Player1.setLocation(monopolyBoard[p1Position].getName());
				System.out.println(Player1.getLocation());
				
				printBoard(monopolyBoard, i, j);
				
				boolean player1Rent = p1Rent (monopolyBoard,  i ,  j,  Player1,  Player2,  p1Position,  bank);
				if (player1Rent == false) {
				
				if (Player1.getLocation() == "Tax") {
					tax(Player1.getBalance(), tax.getPrice());
					x = 2;
				}
				else if (Player1.getLocation() == "Chance") {
				    player1Chance(monopolyBoard, i ,j, Player1, Player2, p1Position, bank);
				    x = 2;
				}
				else if (Player1.getLocation() == "Start/Go") {
					 passGoCollect200Player2(monopolyBoard, i,j, p1Position, p1NewPosition, p1Move, bank, Player1, Player2);
					 x = 2;
				}
				else if (Player1.getLocation() == "Jail") {
					System.out.println("You are just visiting!");
					x = 2;
				}
				else if (Player1.getLocation() == "Go To Jail") {
					 player1Jail(monopolyBoard, i ,j, Player1, Player2, p1Position, bank, 0);
					 x = 2;
				}
				else if(Player1.getLocation() == "Free Parking") {
					System.out.println("You've landed on free parking.");
					x = 2;
				}
				else {
					player1Buying (monopolyBoard,  i ,  j,  Player1,  Player2,  p1Position,  bank, p1PropertyCount);
					x = 2;
				}
			p1Housing(monopolyBoard,  i ,  j,  Player1,  Player2,  p1Position,  bank, p1PropertyCount);
			}//end player 1 rent
			if (player1Rent == true) {
				System.out.println("Sorry you must pay rent to player 2");
				System.out.println(Player1.getBalance());
			}
			}//end player1 while loop

			while (x == 2) {
				if (Player2.getLocation() == "Go To Jail") {
					System.out.println("Sorry it is " + player1Name + "'s turn!");
					x = 1;
				}
				System.out.println("It is " + player2Name + "'s turn! Press 1 to roll the dice.");
				int p2Dice = input.nextInt();
				if (p2Dice == 1) {
					p2FirstDiceValue = (int)((Math.random() * 6) + 1);
					p2SecondDiceValue = (int)((Math.random() * 6) + 1);
				}
				else {
					System.out.println("It is " + player1Name + "'s turn.");
					x = 1; 
				}
				
				int p2Move = p2FirstDiceValue + p2SecondDiceValue;
				p2Position = p2Position + p2Move;
				int p2NewPosition = p2Position + p2Move;
				Player2.setLocation(monopolyBoard[p2Position].getName());
				System.out.println(Player2.getLocation());
				
				printBoard(monopolyBoard, i, j);
				
				boolean player2Rent = p2Rent (monopolyBoard,  i ,  j,  Player1,  Player2,  p2Position,  bank);
				if (player2Rent == false) {
				
				if (Player2.getLocation() == "Tax") {
					tax(Player2.getBalance(), tax.getPrice());
					x = 1;
				}
				else if (Player2.getLocation() == "Chance") {
				    player2Chance(monopolyBoard, i ,j, Player1, Player2, p2Position, bank);
				    x = 1;
				}
				else if (Player2.getLocation() == "Start/Go") {
					 passGoCollect200Player2(monopolyBoard, i,j, p1Position, p2NewPosition, p2Move, bank, Player1, Player2);
					 x = 1;
				}
				else if (Player2.getLocation() == "Jail") {
					System.out.println("You are just visiting!");
					x = 1;
				}
				else if (Player2.getLocation() == "Go To Jail") {
					 player2Jail(monopolyBoard, i ,j, Player1, Player2, p2Position, bank, 0);
					 x = 1;
				}
				else if(Player2.getLocation() == "Free Parking") {
					System.out.println("You've landed on free parking.");
					x = 1;
				}
				else {
					player2Buying (monopolyBoard,  i ,  j,  Player1,  Player2,  p2Position,  bank, p1PropertyCount);
					x = 1;
				}
			p2Housing(monopolyBoard,  i ,  j,  Player1,  Player2,  p2Position,  bank, p1PropertyCount);
			}//end player 2 rent
			
			if (player2Rent == true) {
				System.out.println("Sorry you must pay rent to player 2");
				System.out.println(Player2.getBalance());
			}
			
			}//end player2 while loop
			
			if (Player1.getBalance() < 0) {
				boolean mortgage = p1Mortgage (monopolyBoard,  i ,  j,  Player1,  Player2,  p1Position,  bank,  p1PropertyCount);
				if (mortgage = true) {
					System.out.println("Yay! You are still in the game!");
				}
				else if (mortgage = false) {
					System.out.println(player2Name + " wins!");
					Player1.setBalance(0);
				}
			}//end p1 balance
			
			if (Player2.getBalance()<0) {
				boolean mortgage = p1Mortgage (monopolyBoard,  i ,  j,  Player1,  Player2,  p2Position,  bank,  p2PropertyCount);
				if (mortgage = true) {
					System.out.println("Yay! You are still in the game!");
				}
				else if (mortgage = false) {
					System.out.println(player1Name + " wins!");
					Player2.setBalance(0);
				}
			}//end p2 balance

		}//end positive balance while loop
		
	input.close();
	
	}//end main
	
	////////////////////////////////////////////////////////////////////////////////////////////METHODS////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void printBoard(SquareType [] monopolyBoard, int i, int j) {
		System.out.println("=================================================================================================================================================");
		System.out.println("||  "+ monopolyBoard[0].getName() + "  |     " + monopolyBoard[1].getName() + "     |    " + monopolyBoard[2].getName() + "    |    " + monopolyBoard[3].getName() + "    | " + monopolyBoard[4].getName() + " | " + monopolyBoard[5].getName() + " | " + monopolyBoard[6].getName() + " |   " + monopolyBoard[7].getName() + "   |  " + monopolyBoard[8].getName() + "  |    " + monopolyBoard[9].getName() + "    ||");
		System.out.println("||            |             |             |             |              |                |              |            |             |            ||");
		System.out.println("||     "+ monopolyBoard[0].getOwner() + "      |      " + monopolyBoard[1].getOwner() + "      |     " + monopolyBoard[2].getOwner() + "       |     " + monopolyBoard[3].getOwner() + "       |     " + monopolyBoard[4].getOwner() + "        |     " + monopolyBoard[5].getOwner() + "          |     " + monopolyBoard[6].getOwner() + "        |      " + monopolyBoard[7].getOwner() + "     |      " + monopolyBoard[8].getOwner() + "      |      " + monopolyBoard[9].getOwner() + "     ||");
		System.out.println("||            |             |             |             |              |                |              |            |             |            ||");
		System.out.println("||            |    " + monopolyBoard[1].getPrice() + "    |    " + monopolyBoard[2].getPrice() + "    |    " + monopolyBoard[3].getPrice() + "    |    " + monopolyBoard[4].getPrice() + "     |     " + monopolyBoard[5].getPrice() + "      |    " + monopolyBoard[6].getPrice() + "     |            |    " + monopolyBoard[8].getPrice() + "    |            ||");
		System.out.println("--------------=====================================================================================================================--------------");
		System.out.println("|| "+ monopolyBoard[27].getName() + "  |                                                                                                                   |" + monopolyBoard[10].getName() + " ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||      "+ monopolyBoard[27].getOwner() + "     |                                                                                                                   |      " + monopolyBoard[10].getOwner() + "     ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||   "+ monopolyBoard[27].getPrice() + "    |                                                                                                                   |   " + monopolyBoard[10].getPrice() + "    ||");
		System.out.println("---------------                                                                                                                   ---------------");
		System.out.println("||   "+ monopolyBoard[26].getName() + "   |                                                                                                                   |" + monopolyBoard[11].getName() + " ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||      "+ monopolyBoard[26].getOwner() + "     |                                                                                                                   |      " + monopolyBoard[11].getOwner() + "     ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||   "+ monopolyBoard[26].getPrice() + "    |                                                                                                                   |   " + monopolyBoard[11].getPrice() + "    ||");
		System.out.println("---------------                                                                                                                   ---------------");
		System.out.println("|| "+ monopolyBoard[25].getName() + " |                                                                                                                   | " + monopolyBoard[12].getName() + "   ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||      "+ monopolyBoard[25].getOwner() + "     |                                                                                                                   |      " + monopolyBoard[12].getOwner() + "     ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||   "+ monopolyBoard[25].getPrice() + "    |                                                                                                                   |   " + monopolyBoard[12].getPrice() + "    ||");
		System.out.println("---------------                                                                                                                   ---------------");
		System.out.println("|| "+ monopolyBoard[24].getName() + "  |                                                                                                                   |    " + monopolyBoard[13].getName() + "    ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||      "+ monopolyBoard[24].getOwner() + "     |                                                                                                                   |      " + monopolyBoard[13].getOwner() + "     ||");
		System.out.println("||            |                                                                                                                   |            ||");
		System.out.println("||   "+ monopolyBoard[24].getPrice() + "    |                                                                                                                   |   " + monopolyBoard[13].getPrice() + "    ||");
		System.out.println("--------------=====================================================================================================================--------------");
		System.out.println("||"+ monopolyBoard[23].getName() + "  | " + monopolyBoard[22].getName() + " | " + monopolyBoard[21].getName() + "  |" + monopolyBoard[20].getName() + "| " + monopolyBoard[19].getName() + "    |   " + monopolyBoard[18].getName() + "      |   " + monopolyBoard[17].getName() + "     |  " + monopolyBoard[16].getName() + "  |  " + monopolyBoard[15].getName() + "    |" + monopolyBoard[14].getName() + "||");
		System.out.println("||            |             |             |             |              |                |              |            |             |            ||");
		System.out.println("||      "+ monopolyBoard[23].getOwner() + "     |      " + monopolyBoard[22].getOwner() + "      |      " + monopolyBoard[21].getOwner() + "      |      " + monopolyBoard[20].getOwner() + "      |      " + monopolyBoard[19].getOwner() + "       |     " + monopolyBoard[18].getOwner() + "          |    " + monopolyBoard[17].getOwner() + "         |     " + monopolyBoard[16].getOwner() + "      |    " + monopolyBoard[15].getOwner() + "        |     " + monopolyBoard[14].getOwner() + "      ||");
		System.out.println("||            |             |             |             |              |                |              |            |             |            ||");
		System.out.println("||            |    " + monopolyBoard[22].getPrice() + "    |    " + monopolyBoard[21].getPrice() + "    |    " + monopolyBoard[20].getPrice() + "    |    " + monopolyBoard[19].getPrice() + "     |     " + monopolyBoard[18].getPrice() + "      |              |   " + monopolyBoard[16].getPrice() + "    |    " + monopolyBoard[15].getPrice() + "    |            ||");
		System.out.println("=================================================================================================================================================");
		
	}//end print board method
	
	public static double tax(double balance, double taxPrice ) {

		System.out.println("You've been taxed!");
		double newBalance = balance - taxPrice;
		return newBalance;
	
	}//end tax method
	
	public static void player1Chance(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank) {
		
		int x = (int)(Math.random() * 12) + 1; 
		
		if (x == 1) {
			System.out.println("Advance to Cheeseboard Pizza. If you pass GO collect $200");
			Player1.setLocation(monopolyBoard[10].getName());
			//move player1 to new location
			//go collect 200 method
		}
		else if (x == 2) {
			System.out.println("Go to Jail!");
			Player1.setLocation(monopolyBoard[9].getName());
		}
		else if (x == 3) {
			System.out.println("Give $200 to " + player2Name + " .");
			double player2OldBalance = Player2.getBalance();
			double player2NewBlanace = player2OldBalance + 200;
			Player2.setBalance(player2NewBlanace);
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance - 200;
			Player1.setBalance(player1NewBalance);
		}
		else if (x == 4) {
			System.out.println("Advance to Warm Spring bart startion. If you pass GO collect $200!");
			Player1.setLocation(monopolyBoard[4].getName());
			//move player1 to new location
			//go collect 200 method
		}
		else if (x == 5) {
			System.out.println("Get out of Jail free. Note: this card is only useful if you are in jail right now. Cannot be used in any other turn");
			if (Player1.getLocation() == "Jail") {
				Player1.setLocation(monopolyBoard[10].getName());
				//move player1 to new location
			}
			else {
				System.out.println("Sorry, you are not in jail right now! This card cannot be used!");
			}
		}
		else if (x == 6) {
			System.out.println("Parking fine. Advance to Free Parking spot but pay $15 to the bank.");
			Player1.setLocation(monopolyBoard[14].getName());
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance - 15;
			Player1.setBalance(player1NewBalance);
			//actually move player there	
		}
		else if (x == 7) {
			System.out.println("Advance to GO! Collect $200");
			Player1.setLocation(monopolyBoard[0].getName());
			//go collect 200 method
		}
		else if (x == 8) {
			System.out.println("You have been elected chairman! Pay " + player2Name + " $50");
			double player2OldBalance = Player2.getBalance();
			double player2NewBlanace = player2OldBalance + 50;
			Player2.setBalance(player2NewBlanace);
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance - 50;
			Player1.setBalance(player1NewBalance);
		}
		else if (x == 9) {
			System.out.println("Pay the poor tax of $15");
			double bankOldBalance = bank.getBalance();
			double bankNewBlanace = bankOldBalance + 15;
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance - 15;
			Player1.setBalance(player1NewBalance);
		}
		else if (x == 10) {
			System.out.println("You have to make general repairs on all your property. For each property pay $25");
			
		}
		else if (x == 11) {
			System.out.println("Go back 3 spaces!");
			Player1.setLocation(monopolyBoard[p1Position - 3].getName());
			//actually move player back 3 positions
		}
		else if (x == 12) {
			System.out.println("The bank will give you a divedent of $50");
			double bankOldBalance = bank.getBalance();
			double bankNewBlanace = bankOldBalance - 50;
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance + 50;
			Player1.setBalance(player1NewBalance);
		}
		System.out.println("Player 1: $" + Player1.getBalance());
	}//end player1 chance
	
	public static void player2Chance(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank) {
		
		int x = (int)(Math.random() * 12) + 1; 
		
		if (x == 1) {
			System.out.println("Advance to Cheeseboard Pizza. If you pass GO collect $200");
			Player2.setLocation(monopolyBoard[10].getName());
			//move player2 to new location
			//go collect 200 method
		}
		else if (x == 2) {
			System.out.println("Go to Jail!");
			Player2.setLocation(monopolyBoard[9].getName());
		}
		else if (x == 3) {
			System.out.println("Give $200 to " + player1Name + " .");
			double player1OldBalance = Player1.getBalance();
			double player1NewBlanace = player1OldBalance + 200;
			Player1.setBalance(player1NewBlanace);
			double player2OldBalance = Player2.getBalance();
			double player2NewBalance = player2OldBalance - 200;
			Player2.setBalance(player2NewBalance);
		}
		else if (x == 4) {
			System.out.println("Advance to Warm Spring bart startion. If you pass GO collect $200!");
			Player2.setLocation(monopolyBoard[4].getName());
			//move player12to new location
			//go collect 200 method
		}
		else if (x == 5) {
			System.out.println("Get out of Jail free. Note: this card is only useful if you are in jail right now. Cannot be used in any other turn");
			if (Player2.getLocation() == "Jail") {
				Player2.setLocation(monopolyBoard[10].getName());
				//move player1 to new location
			}
			else {
				System.out.println("Sorry, you are not in jail right now! This card cannot be used!");
			}
		}
		else if (x == 6) {
			System.out.println("Parking fine. Advance to Free Parking spot but pay $15 to the bank.");
			Player2.setLocation(monopolyBoard[14].getName());
			double player2OldBalance = Player2.getBalance();
			double player2NewBalance = player2OldBalance - 15;
			Player2.setBalance(player2NewBalance);
			//actually move player2 there	
		}
		else if (x == 7) {
			System.out.println("Advance to GO! Collect $200");
			Player2.setLocation(monopolyBoard[0].getName());
			//go collect 200 method
		}
		else if (x == 8) {
			System.out.println("You have been elected chairman! Pay " + player1Name + " $50");
			double player1OldBalance = Player1.getBalance();
			double player1NewBalance = player1OldBalance + 50;
			Player2.setBalance(player1NewBalance);
			double player2OldBalance = Player2.getBalance();
			double player2NewBalance = player2OldBalance - 50;
			Player2.setBalance(player2NewBalance);
		}
		else if (x == 9) {
			System.out.println("Pay the poor tax of $15");
			double bankOldBalance = bank.getBalance();
			double bankNewBalance = bankOldBalance + 15;
			double player2OldBalance = Player2.getBalance();
			double player2NewBalance = player2OldBalance - 15;
			Player2.setBalance(player2NewBalance);
		}
		else if (x == 10) {
			System.out.println("You have to make general repairs on all your property. For each property pay $25");
			
		}
		else if (x == 11) {
			System.out.println("Go back 3 spaces!");
			Player2.setLocation(monopolyBoard[p2Position - 3].getName());
			//actually move player back 3 positions
		}
		else if (x == 12) {
			System.out.println("The bank will give you a divedent of $50");
			double bankOldBalance = bank.getBalance();
			double bankNewBalance = bankOldBalance - 50;
			double player2OldBalance = Player2.getBalance();
			double player2NewBalance = player2OldBalance + 50;
			Player1.setBalance(player2NewBalance);
		}
		System.out.println("Player 2: $" + Player2.getBalance());
	}//end player2 chance method
	

	public static void passGoCollect200Player1 (SquareType[] monopolyBoard, int i, int j, int p1Position, int p1Move, int p1NewPosition, Bank bank, Pieces Player1, Pieces Player2) {
		
		if (p1Position > 0 && p1NewPosition < 28) {	
			double p1CurrentBalance = Player1.getBalance();
			double p1NewBalance = p1CurrentBalance + 200;
			Player1.setBalance(p1NewBalance);
			double bankCurrentBalance = bank.getBalance();
			double bankNewBalance = bankCurrentBalance - 200;
			bank.setBalance(bankNewBalance);
		}
		System.out.println("2. Player 1: $" + Player1.getBalance());
	}//end player1 pass go collect 200
	
	
	public static void passGoCollect200Player2 (SquareType[] monopolyBoard, int i, int j, int p2Position, int p1Move, int p2NewPosition, Bank bank, Pieces Player1, Pieces Player2) {
		
		if (p2Position > 0 && p2NewPosition < 28) {	
			double p2CurrentBalance = Player2.getBalance();
			double p2NewBalance = p2CurrentBalance + 200;
			Player2.setBalance(p2NewBalance);
			double bankCurrentBalance = bank.getBalance();
			double bankNewBalance = bankCurrentBalance - 200;
			bank.setBalance(bankNewBalance);
		}
		System.out.println("Player 2: $" + Player2.getBalance());
	}//end player2 pass go collect 200
	
	
	public static void player1Jail(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank, int counter) {
		Scanner input = new Scanner (System.in);
		counter += 1;
		System.out.println("You are in jail. If you have roll a double or have a chance card you may get out of jail");
		System.out.println("Press 1 to roll the dice and 2 if you have a chance card");
		int p1OutOfJail = input.nextInt();
		if (p1OutOfJail == 1) {
			int p1FirstDiceValue = (int)((Math.random() * 6) + 1);
			int p1SecondDiceValue = (int)((Math.random() * 6) + 1);
			if 	(p1FirstDiceValue == p1SecondDiceValue) {
				System.out.println("You are out of jail!");
				Player1.setLocation(monopolyBoard[10].getName());
			}
		}
		else if (p1OutOfJail == 2) {
			System.out.println("You are out of jail!");
			Player1.setLocation(monopolyBoard[10].getName());
		}
		else if (counter == 2){
			System.out.println("You are out of jail!");
			Player1.setLocation(monopolyBoard[10].getName());
		}
		System.out.println("Player 1: $" + Player1.getBalance());
	}//end player1 get out of jail
	
	
	public static void player2Jail(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank, int counter) {
		Scanner input = new Scanner (System.in);
		counter += 1;
		System.out.println("You are in jail. If you have roll a double or have a chance card you may get out of jail");
		System.out.println("Press 1 to roll the dice and 2 if you have a chance card");
		int p2OutOfJail = input.nextInt();
		if (p2OutOfJail == 1) {
			int p2FirstDiceValue = (int)((Math.random() * 6) + 1);
			int p2SecondDiceValue = (int)((Math.random() * 6) + 1);
			if 	(p2FirstDiceValue == p2SecondDiceValue) {
				System.out.println("You are out of jail!");
				Player2.setLocation(monopolyBoard[10].getName());
			}
		}
		else if (p2OutOfJail == 2) {
			System.out.println("You are out of jail!");
			Player2.setLocation(monopolyBoard[10].getName());
		}
		else if (counter == 2){
			System.out.println("You are out of jail!");
			Player2.setLocation(monopolyBoard[10].getName());
		}
		System.out.println("Player 2: $" + Player2.getBalance());
	}//end player2 get out of jail
	
	
	public static void player1Buying(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank, ArrayList <Integer> p1PropertyCount) {
		Scanner input = new Scanner (System.in);
		System.out.println("Would you like to buy the property or railroad you are currently on you are currently on. Press 1 for yes and 2 for no.");
		int p1BuyProperty = input.nextInt();
		
		if(p1BuyProperty == 1) {
			double p1CurrentBalance = Player1.getBalance();
			double p1NewBalance = p1CurrentBalance - monopolyBoard[p1Position].getPrice();
			System.out.println( monopolyBoard[p1Position].getPrice());
			Player1.setBalance(p1NewBalance);
			p1PropertyCount.add(p1Position);
			monopolyBoard[p1Position].setOwner("x");
		}
		else {
			System.out.println("It is Player 2's turn");
		}
		System.out.println("Player 1: $" + Player1.getBalance());
	}//end p1 buying method
	
	
	public static void player2Buying (SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank, ArrayList <Integer> p2PropertyCount) {
		Scanner input = new Scanner (System.in);
		System.out.println("Would you like to buy the property or railroad you are currently on you are currently on. Press 1 for yes and 2 for no.");
		int p2BuyProperty = input.nextInt();
		
		if(p2BuyProperty == 1) {
			double p2CurrentBalance = Player2.getBalance();
			double p2NewBalance = p2CurrentBalance - monopolyBoard[p2Position].getPrice();
			System.out.println(monopolyBoard[p2Position].getPrice());
			Player2.setBalance(p2NewBalance);
			p2PropertyCount.add(p2Position);
			monopolyBoard[p2Position].setOwner("o");
		}
		else {
			System.out.println("It is Player 2's turn");
		}
		System.out.println("Player 2: $" + Player2.getBalance());
	}//end p2 buying method
	
	
	public static void p1Housing(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank, ArrayList <Integer> p1PropertyCount) {
		
		for (int num = 0; i < 28; i++) {		
			if (	p1PropertyCount.contains(num)) {
				if (p1PropertyCount.contains(num + 1) && p1PropertyCount.contains(num + 2)) {
					monopolyBoard[num].setHasHouse("Player 1");	
					monopolyBoard[num + 1].setHasHouse("Player 1");
					monopolyBoard[num + 1].setHasHouse("Player 1");
				}
			}
		}
	}//end p1Housing
	
	
	public static void p2Housing(SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank, ArrayList <Integer> p2PropertyCount) {
		
		for (int num = 0; i < 28; i++) {		
			if (	p2PropertyCount.contains(num)) {
				if (p2PropertyCount.contains(num + 1) && p2PropertyCount.contains(num + 2)) {
					monopolyBoard[num].setHasHouse("Player 2");	
					monopolyBoard[num + 1].setHasHouse("Player 2");
					monopolyBoard[num + 1].setHasHouse("Player 2");
				}
			}
		}
	}//end p2Housing
	
	
	public static boolean p1Rent (SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank) {
		
		if (monopolyBoard[p1Position].getOwner() == "o" ) {
			double p1CurrentBalance = Player1.getBalance();
			double p1NewBalance = p1CurrentBalance - monopolyBoard[p1Position].getBaseRent();
			Player1.setBalance(p1NewBalance);
			return true;
		}
		return false;
	}//end p1 rent 
	
	
	public static boolean p2Rent (SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank) {
		if (monopolyBoard[p2Position].getOwner() == "x" ) {
			double p2CurrentBalance = Player2.getBalance();
			double p2NewBalance = p2CurrentBalance - monopolyBoard[p2Position].getBaseRent();
			Player2.setBalance(p2NewBalance);
			return true;
		}
		return false;
	}//end p2 rent
	
	
	public static boolean p1Mortgage (SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p1Position, Bank bank, ArrayList <Integer> p1PropertyCount) {
		
		Scanner input = new Scanner (System.in);
		System.out.println("You have no money.");
		System.out.println("If you would like to mortgage the property you are on, press 1. If you want to end the game or have no properties, press 0.");
		int mortgage = input.nextInt();
		
		if (mortgage == 1) {
			double p1CurrentBalance = Player1.getBalance();
			double p1NewBalance = p1CurrentBalance + monopolyBoard[p1Position].getPrice();
			System.out.println( monopolyBoard[p1Position].getPrice());
			Player1.setBalance(p1NewBalance);
			p1PropertyCount.remove(p1Position);
			monopolyBoard[p1Position].getPrice();
			monopolyBoard[p1Position].setOwner(" ");
			return true;
		}
		else if (mortgage == 2) {
			return false;
		}
		return false;
	}//end p1 mortgage
	
	
	public static boolean p2Mortgage (SquareType[]monopolyBoard, int i , int j, Pieces Player1, Pieces Player2, int p2Position, Bank bank, ArrayList <Integer> p2PropertyCount) {
		
		Scanner input = new Scanner (System.in);
		System.out.println("You have no money.");
		System.out.println("If you would like to mortgage the property you are on, press 1. If you want to end the game or have no properties, press 0.");
		int mortgage = input.nextInt();
		
		if (mortgage == 1) {
			double p2CurrentBalance = Player2.getBalance();
			double p2NewBalance = p2CurrentBalance + monopolyBoard[p2Position].getPrice();
			System.out.println( monopolyBoard[p2Position].getPrice());
			Player1.setBalance(p2NewBalance);
			p2PropertyCount.remove(p2Position);
			monopolyBoard[p2Position].getPrice();
			monopolyBoard[p2Position].setOwner(" ");
			return true;
		}
		else if (mortgage == 2) {
			return false;
		}
		return false;
		
	}//end p1 mortgage	
	
}//end monopoly class