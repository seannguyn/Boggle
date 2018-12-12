
public class TestInput {
	
	public static final TestInput Tester = new TestInput();
	
	private TestInput() { };
	
	public boolean checkError(String[] args) {
		if (args.length != 1) {
			System.out.println("Only 1 argument should be passed");
			return true;
		} else {
			if (!isPerfectSquare((double)args[0].length())) {
				System.out.println("Invalid Board dimension");
				return true;
			} 
		}
		return false;
	}
	
	private static boolean isPerfectSquare(double x)  
    { 
          
        // Find floating point value of 
        // square root of x. 
        double sr = Math.sqrt(x); 
      
        // If square root is an integer 
        return ((sr - Math.floor(sr)) == 0); 
    }
	
	public static TestInput getTester() {
		return Tester;
	}
}
