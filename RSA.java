import java.util.*;
public class RSA 
{
	private static  int p=109;
	private static int q=307;
	public static int n=p*q;
	private int totient=(p-1)*(q-1);
	public static int e=3011; //gcd of e and toient is 1 and e<totient
	private static int d=1811; //e*d%toient =1
	
	public static int gcd(int x, int y) //Euclidean algorithm
	{		
		if(y==0) return x;
		return gcd(y, x%y);
	}
	
	public static void main(String[] args)
	{
		
		//int indexs=0;
		System.out.println("what message would you like encypted");
		Scanner message= new Scanner(System.in);
		int x=message.nextInt();
		message.close();
		int y=x;
		for(int i=1; i<e; i++) //raises our input to the e power moded by our product
		{
			x=(x*y)%(n);
			//System.out.println((i+1) + " "+x);
		}
		System.out.println(x);
		y=x;
		for(int i=1; i<d; i++) //Decrpyt using the public and private keys
		{
			x=(x*y)%(p*q);
		}
		System.out.println(x);
		//attempt of a QFT/ shor's algroithm but without the qubits
		
		int r=0;
		int temp;
		int minR=0;
		int a=y;
		for(int i=1; i<n; i++)
		{
			temp=i;
			if(gcd(i, n)==1)
			{
				
				r=1;
				while(temp%n!=1)//period finding algorithm
				{
					
					r++;
					temp=(temp*i)%n;
					
				}
				if((r<minR && r%2==0 )||(minR==0 && r%2==0))
				{
						a=i;
						minR=r;	
				}
				
			}			
		}
		temp=a;
		System.out.println(minR + " " + a);
		for(int i=1; i<minR/2; i++)
		{
			temp=temp*a;
		}
		System.out.println(gcd(temp-1, n)+ " " + gcd(temp+1, n));
		
	/*	char[] cArray = message.nextLine().toCharArray();
		int[] numerical= new int[cArray.length];
		for(int i=0; i<numerical.length; i++)
		{
			numerical[i]=cArray[i];
			if(numerical[i]>90)
			{
				numerical[i]=numerical[i]-32;
			}
			if(numerical[i]<65 || numerical[i]>90)
			{
					numerical[i]=-1;
					if(i!=numerical.length-1) indexs++;
			}
			
		}
		for(int index=0; index<numerical.length; index++)
		{
			if(numerical[index]!=-1) 
			{
				for(int c=65; c<=90; c++)
				{
					if(numerical[index]==c)
					{
						numerical[index]=c-65;
						c=91;
					}
				}
			}
		}*/
	
		/*int y=0;
		int temp=0;
		int [] array2= new int[indexs+1];
		for(int i=0; i<numerical.length; i++) System.out.println(numerical[i]);
		for(int i=0; i<numerical.length; i++)
		{
			if(numerical[i]==-1 )
			{
				array2[y++]=temp;
				temp=0;
			}
			else temp=temp*100+numerical[i];
			
		}
		if(numerical[numerical.length-1]!=-1) array2[y]=temp;
		int []array3= new int[array2.length];
		for(int i=0; i<array2.length; i++)
		{
			array3[i]=array2[i];
		}
		for(int i=0; i<array2.length; i++)
		{
			for(int j=1; j<e; j++)
			{
				array2[i]=array3[i]*array2[i];
			}
		}
		for(int i=0; i<array2.length; i++)
		{
			array2[i]=array2[i]%48;
		}
		ArrayList<Character> encrypted= new ArrayList<Character>();
		y=0;
		while(array2.length>y)
		{
			encrypted.add((char)(array2[y]%100%26+65));
			array2[y]=array2[y]/100;
			if(array2[y]==0) 
			{
				y++;
				encrypted.add(' ');
			}
		}
		for(int i=0; i<encrypted.size(); i++)
		{
			System.out.print(encrypted.get(i));
		}*/
		
		
		
	}
}
