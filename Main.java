package project1;
import java.util.Scanner;
import java.util.Random;
class Play{
	public int number;
	public int noOfGuesses=0;
	public int inputNumber;
	
	public int getNumeberOfGuesses()					//getter function to get guesses number
	{
		return noOfGuesses;
	}
	public void setNumberOfGuesses(int noOfGuesses)		//setter function to set guesses number
	{
		this.noOfGuesses=noOfGuesses;		
	}
	
		
	Play()										//constructor to get random number
	{
		Random obj=new Random();
		this.number=obj.nextInt(100);
		
	}
	void takeuserInput() 						//function to get user input
	{
		System.out.print("\nGuess the Number:   ");
		Scanner scan=new Scanner(System.in);
		inputNumber=scan.nextInt();
		
	}
	boolean isCorrectNumber()					//function to check is user's input is correct or not
	{
		noOfGuesses++;
		if(inputNumber==number)
		{
			System.out.printf("\n!! Congratulations! You guess the correct Number in %d number of Guesses....!!!!",noOfGuesses);
			return true;
		}
		else if(inputNumber<number)
		{
			System.out.printf("The number is greater than %d",inputNumber);
		}
		else if(inputNumber>number)
		{
			System.out.printf("The number is smaller than %d",inputNumber);
		}
		return false;
	}
	public int total_score(int m, int n)			//to obtain score for the round
	{
		int score=n-m+1;							//n=total attempt & m=no. of guesses
		return score;
	}
}

public class Main {
	
	public static void main(String[] args) {
		System.out.println("!!!...Welcome to Guess the Number Game...!!!\n");
		Play obj2=new Play();
		int count=0;
		System.out.println("******************************************");
		System.out.println("\t(: Round 1 :)");
		System.out.println("******************************************");
		System.out.println("\nGuess the number in 10 maximum chances\n");

		boolean b=false;
		while(b!=true && count!=10)
		{
			
			obj2.takeuserInput();
			b=obj2.isCorrectNumber();
			
			System.out.println();
			count++;
		}
		if(b==false)
			System.out.printf("The Number is %d",obj2.number);
		
		int score1=obj2.total_score(count, 10);
		
		obj2.noOfGuesses=0;
		System.out.println("\n\n******************************************");
		System.out.println("\t(: Round 2 :)");
		System.out.println("******************************************");
		System.out.println("\nGuess the number in 7 maximum chances\n");
		count=0;
		b=false;
		while(b!=true && count!=7)
		{
			
			obj2.takeuserInput();
			b=obj2.isCorrectNumber();
			
			System.out.println();
			count++;
		}
		if(b==false)								//to determine the correct no. if we didn't got
			System.out.printf("The Number is %d",obj2.number);
		
		int score2=obj2.total_score(count, 7);;
		
		float final_score=(float)((score1+score2)/0.17);
		
		System.out.println("\n\n******************************************");
		System.out.printf("Congratulations! You Scored %.2f points",final_score);
		System.out.println("\n******************************************");
		
	}
}

