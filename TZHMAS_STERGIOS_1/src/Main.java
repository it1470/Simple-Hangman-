import java.util.Random;                //TZIMAS STERGIOS it1470
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
      int wins = 0,losses = 0,games = 0;
      int goodguess,badguess ;
	  Scanner in = new Scanner(System.in);
	  char z;
	  do {	
		System.out.println("-Start a new game (N) ");
	    System.out.println("-Statistics (S) ");
	    System.out.println("-Exit (X) ");
	    z = in.next(".").charAt(0); 
	    if(z >'Z') {                               //SE PERIPTWSH POY DEN DWSEI KEFALAIO
		    z = Character.toUpperCase(z);
		  }
	    if(!((z == 'N') || (z == 'S') || (z == 'X'))) {	    	
	    	do {
	    		System.out.print("You gave an invalid answer,try again:");
	    		z = in.next(".").charAt(0);        //AN DEN DWSEI  N - S - X 
	    		if(z >'Z') {                       //SE PERIPTWSH POY DEN DWSEI KEFALAIO
	    		    z = Character.toUpperCase(z);
	    		 }
	    	}while(!((z == 'N') || (z == 'S') || (z == 'X')));
	     }
	    if(z =='N') {
		 goodguess = 0;
		 badguess = 0;
	     games++;
	     Random rnd = new Random();
		 int n1 = rnd.nextInt(50);	
		 Dictionary x = new Dictionary();
		 String y = x.getWord(n1);   //APOTHIKEUW THN LEKSH STON Y
		 int c = y.length();         //BRISKW TON ARITHMO TWN GRAMMATWN
		 char[] m = new char[c];	
		 for(int i=0; i<c; i++) { //EXOUME ENAN PINAKA ME MHKOS C POU EXEI ENA ENA TA GRAMMATA THS LEKSHS
			m[i] = y.charAt(i); 
		  }
		 char[] n = new char[c];
		 for(int i=0; i<c; i++) { //GEMIZOUME ENAN KENO PINAKA ME PAULES ANALOGA ME TON ARITHMO TWN GAMMATWN
		   n[i] = '-';
		 }
		 boolean flag = true;
		 int death = 8;
		 do {
			 int test = 0;
			 System.out.print("The random word is now : ");
			 for(int i=0; i<c; i++) {
			    System.out.print(n[i]);
			  }
			  System.out.println("  You have " + death + " guesses left");
			  System.out.print("Your guess :");
			  char guess = in.next(".").charAt(0);  //RWTAME GRAMMA
			  if(Character.isDigit(guess) == true) { //SE PERIPTWSH OPOY DWSEI ARITHMO  
				   do {
					   System.out.print("You have entered a number,please enter a letter:");  
					   guess = in.next(".").charAt(0);
				   }while   (Character.isDigit(guess) == true);
			  }
			  if(guess >'Z') {                    //SE PERIPTWSH POY DEN DWSEI KEFALAIO
			      guess = Character.toUpperCase(guess);
			  }
			  boolean check = false;            //MAS BOITHAEI NA DOUME AN BRIKAME SWSTO GRAMMA
		      for(int i=0; i<c; i++) {
		    	 if  (guess == m[i] ) {
		        	n[i] = m[i];                        //AN TO GRAMMA UPARXEI TO BAZEI STON PINAKA ME TIS PAULES
		            check = true;
		            goodguess++;
		            System.out.println("Your guess is CORRECT");
		    	 }
		      }
			  if ( check == false ) {                   //AN DEN YPAEXEI TO GRAMMA
				  badguess++;
				  System.out.println("There are no " +guess +" in the word");
				  death--;
			  }
			  if (death == 0) {                          //AN TELEIWSOYN TA GUESSES
				  System.out.println("You have no guesses left");
				  losses++;
				  flag = false;
			  }
		      for(int i=0; i<c; i++) {                 //O TROPOS MOY NA TSEKAREI KATHE FORA AN EXEI VREI OLH THN LEKSH
		          if(n[i] == m[i]) {
		        	test++;
		            if(test == c) {
		              System.out.println("Congratulations! You guessed the word:");
		              for(int u=0; u<c; u++)
		            	System.out.print(n[u]);
		              wins++;
		              flag = false;
		            } 
		          }
		      }
		 }while(flag == true);
		 
		 System.out.println("You had " +goodguess +" goodguesses and " +badguess +" bad guesses");	 
		 
	     }else if( z == 'S'){
			System.out.println("You have played so far " + games +" games." +"You won " + wins +" times and lost " + losses +" times" );
		 }
		 else {
		    System.exit(0);
		 }	
			
	 }while ((z!='x')||(z!='X'));
   }
}



	
	

