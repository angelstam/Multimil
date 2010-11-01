package multimil;
import java.io.*;
import java.util.*;

public class opHandler
{
	private opCode codes[];
	public opHandler(String filename)
	{
		codes = new opCode[256];
		FileReader file;
		try
		{
			file = new FileReader(filename);
			BufferedReader breader = new BufferedReader(file);
			
			try
			{
				while(breader.ready())
				{
					processLine(breader.readLine());
				}
			}
			catch(IOException e)
			{
				System.out.println("trololo");
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("OP code file path is errorous.");
		}
		
		
	}
    
	private void processLine(String line)
	{
		StringTokenizer token = new StringTokenizer(line,"\t");
		int num = Integer.valueOf(token.nextToken(),16);
		opCode tmp = new opCode(Byte.valueOf(token.nextToken()),
					token.nextToken(),
					token.nextToken(),
					token.nextToken(),
					token.nextToken());
		codes[num] = tmp;
		

	}

	public void generateInstructions( String filename)
	{
		try
		{
			FileInputStream reader = new FileInputStream(filename);
			while (reader.available() > 0)
			{

				int data = reader.read();
			
				String hex =Integer.toHexString(data); 
				if (hex.length() == 1)
					hex = '0' + hex;
				
				if (codes[data] != null)
					System.out.println( hex + "  " +codes[data].name +
										"  ," +codes[data].size + 
										"  (" + codes[data].addr + ')');
										
				else
					System.out.println(hex  + "  -");
			}
		}
		
		catch(IOException e)
		{
			
		}
	}
}
