package level1;

import java.util.Scanner;

public class SetsOfMoves {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println(" Give your directions ");
		String str=scan.nextLine();
		scan.close();
		if(IsCircular(str))
			System.out.println("Your Displacement is 0");
		else
			System.out.println(" You have travelled some distance");

	}
	
	public static boolean IsCircular(String str)
	{
		//initial co-ordinates
		int x=0,y=0;
		char dir='N' ; //default direction
		
		for(char ch:str.toCharArray())
		{
			switch(ch)
			{
			case 'M':
				if(dir=='N') {
					y++;
				}
				else if(dir=='S')
				{
					y--;
				}
				else if(dir=='E')
				{
					x++;
				}
				else if(dir=='W')
				{
					x--;
				}break;
			case 'L':
				if(dir=='N')
				{
					dir='W';
				}
				else if(dir=='W')
				{
					dir='S';
				}
				else if(dir=='S')
				{
					dir='E';
				}
				else if(dir=='E')
				{
					dir='N';
				} break;
				
			case 'R':
				if(dir=='N')
				{
					dir='E';
				}
				else if(dir=='W')
				{
					dir='N';
				}
				else if(dir=='S')
				{
					dir='W';
				}
				else if(dir=='E')
				{
					dir='S';
				}		
			}
		}
		return (x==0&&y==0);
						
	}

}
