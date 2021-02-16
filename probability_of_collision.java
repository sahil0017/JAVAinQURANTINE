package Day1;

public class probability_of_collision {
	
	static int findTotalOutcome(String a,String b)
	{
		int n=a.length();
		int m=b.length();
		
		if(n>m)
			return m*(m+1)/2;
		
		return (n*(n+1)/2)+n*(n-m);
		
	}

	public static void main(String[] args) {
		String s1="TBCTTBCTB";
		String s2="CBTBBTCBT";
		System.out.println("Probability of two trucks collision ");
		findProbability(s1,s2);

	}
	
	public static void findProbability(String a,String b)
	{
		int total_outcome=findTotalOutcome(a,b);
		
		double favourable_Outcome=findFavourableOutcome(a,b);
		
		System.out.printf("%f", favourable_Outcome/total_outcome);
	}

    static double findFavourableOutcome(String a, String b) {
		int n=a.length();
		int m=b.length();
		
		double answer=0;
		
		int count_of_truck_in_b=0;
		
		for(int i=0;i<m;i++)
		{
			if(b.charAt(i)=='T')
				 count_of_truck_in_b++;
		}
		
		for(int i=0;i<n&&i<m;i++)
		{
			if(a.charAt(i)=='T')
				answer+=count_of_truck_in_b;
			
			if(b.charAt(i)=='T')
				count_of_truck_in_b--;
		}
		
		return answer;
	}

}
