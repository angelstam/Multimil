package multimil;
import java.io.*;
/**
 * Main class for Multimil.
 * 
 * @author angelstam
 */
public class Main
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Multimil disassembler for SY6502.");
		opHandler handler = new opHandler("../codematrix");
		handler.generateInstructions("../doc/multimil.bin");
	}
	
}
