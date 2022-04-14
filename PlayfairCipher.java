package playfairCipher;
import java.util.*;
public class PlayfairCipher {
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the plain text: ");
		String plain=sc.next();
		System.out.println("Enter the key: ");
		String key=sc.next();
                System.out.println("\nEncryption using playfair:\n");
		String pairplain=pair(plain);
		char[][] keymatrix=formKeyMatrix(key);
		System.out.println("Filler letter: X\n");
		System.out.println("5x5 key matrix(considering I and J as a single letter): ");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(keymatrix[i][j]+" ");
			}
			System.out.println("");
		}
		String ciphertext=toCipherOrPlain(keymatrix,pairplain);
		System.out.println("\nCorresponding Cipher text: "+ciphertext);
		System.out.println("\nDecryption using playfair:\n");
		String paircipher=pair(ciphertext);
		String pt=toCipherOrPlain(keymatrix,paircipher);
		String plaintext=removeFiller(pt);
		System.out.println("Cipher text: "+ciphertext);
		System.out.println("Corresponding Plain text: "+plaintext);

	}	
	public static String pair(String plain)
	{
		String pair="";
		char filler='X';
		for(int i=0;i<plain.length();i+=2)
		{
			if(plain.charAt(i)!=plain.charAt(i+1)) //if the letters to be paired are not same->pair them
			{
				pair+=plain.charAt(i)+""+plain.charAt(i+1);
			}
			else //if the letters to be paired are same->pair the first letter with filler
			{
				pair+=plain.charAt(i)+""+filler;
				i-=1;
			}
		}
		return pair;
	}
	
	public static char[][] formKeyMatrix(String key)
	{
		key=key.replaceAll("J","I"); //replace all J's with I's in key
		char[][] keymatrix=new char[5][5];
		int a=0;
		int Jascii=74;
		Set<Character> unique= new LinkedHashSet<Character>();
		String uniquestr="";
		for(int p=0;p<key.length();p++)
		{
			unique.add(key.charAt(p)); //resultant set will contain only unique characters in the key
		}
		for(char i=65;i<91;i++)
		{
			if(i!=Jascii) //The key matrix will not contain J (as I and J are considered as a single letter(I))
			unique.add(i);
		}
		Iterator<Character> iter=unique.iterator();
		while(iter.hasNext())
		{
			uniquestr+=iter.next();
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				keymatrix[i][j]=uniquestr.charAt(a);
				a++;
			}
		}
		return keymatrix;
	}
	public static String toCipherOrPlain(char[][] key, String pair)
	{
		boolean found1=false;
		boolean found2=false;
		int frow = 0,fcol=0,srow=0,scol=0;
		String cipherorplain="";
		for(int ind=0;ind+1<pair.length();ind+=2)
		{
			found1=false;
			found2=false;
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(pair.charAt(ind)==key[i][j]) 
					{
						frow=i;
						fcol=j;
						found1=true;
					}
					if(pair.charAt(ind+1)==key[i][j])
					{
						srow=i;
						scol=j;
						found2=true;
					}
					if(found1 & found2)
						break;
				}
				if(found1 & found2)
					break;
			}

			if(frow==srow) //case I - both the letters are in the same row
			{
				if(fcol+1<5)
				{
					cipherorplain+=key[frow][fcol+1];
				}
				else
				{
					cipherorplain+=key[frow][0];
				}
				if(scol+1<5)
				{
					cipherorplain+=key[srow][scol+1];
				}
				else
				{
					cipherorplain+=key[frow][0];
				}
			}
			else if(fcol==scol) //case II - both the letters are in the same column
			{
				if(frow+1<5)
				{
					cipherorplain+=key[frow+1][fcol];
				}
				else
				{
					cipherorplain+=key[0][fcol];
				}
				if(srow+1<5)
				{
					cipherorplain+=key[srow+1][fcol];
				}
				else
				{
					cipherorplain+=key[0][fcol];
				}
			}
			else // Case III - both the letters are neither in the same row nor in the same column
			{
				cipherorplain+=key[frow][scol];
				cipherorplain+=key[srow][fcol];
			}

		}
       return cipherorplain;
	}
	public static String removeFiller(String text)
	{
		StringBuilder ct=new StringBuilder(text);
		for(int i=0;i<ct.length();i++)
		{
			if(ct.charAt(i)=='X')
			{
				ct.deleteCharAt(i);
				
			}
		}
		return ct.toString();	
	}
	}




