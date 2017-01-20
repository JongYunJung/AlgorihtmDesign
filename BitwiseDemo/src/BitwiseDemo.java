
public class BitwiseDemo {

	public static void printBits(short c)
	{
		for(int i = 15; i >= 0; i--)
		{
			if((c & (1 << i)) != 0) System.out.print(1);
			else System.out.print(0);
			if(i % 8 == 0) System.out.print(' ');
		}
		System.out.print('\n');
	}
	public static void main(String[] args) {
		short c = -127;
		
		printBits(c); 
		System.out.println("-------------");
		for(int i = 0; i < 4; i++)
		{
			c >>= 1;
			printBits(c);
		}
		System.out.println("-------------");
		c = -127;
		
		for(int i = 0; i < 4; i++)
		{
			c >>>= 1;
			printBits(c);
		}
		System.out.println("-------------");
		c = (short)0xffff;
		for(int i = 0; i < 4; i++)
		{
			c <<= 1;
			printBits(c);
		}
		System.out.println("-------------");
		c = (short)0x7fff;
		for(int i = 0; i < 4; i++)
		{
			c >>= 1;
			printBits(c);
		}
		c = (short)0x7fff;
		System.out.println("-------------");
		for(int i = 0; i < 4; i++)
		{
			c >>>= 1;
			printBits(c);
		}
		
	}

}
