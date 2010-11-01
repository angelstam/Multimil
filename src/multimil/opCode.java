package multimil;

public class opCode
{
    public byte size;
    public String cycles;
    public String addr;
    public String arg;
    public String name;
    
    public opCode( byte size, String cycles, String addr, String arg,
		   String name)
    {
	this.size = size;
	this.cycles = cycles;
	this.addr = addr;
	this.arg = arg;
	this.name = name;
    }
    
}
    