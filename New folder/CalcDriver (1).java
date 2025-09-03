public class CalcDriver {

	public static void main (String [] args){
		String cmd;
		double op1, op2;
		CalcOperations operation = new CalcOperations(); // create / instantiate CalcOperations object
		
		if (args.length == 3) {
			op1 = Double.valueOf(args[0]);
			cmd = args[1].toLowerCase();
			op2 = Double.valueOf(args[2]);
			
			switch (cmd) { // must be an int, char, or String
				case "+": operation.add2(op1,op2); // calling add2 method in object operation
						  break;
				case "-": operation.sub2(op1,op2);// calling sub2 method in object operation
						  break;
				default:
					System.out.println("ERROR: Operator " + cmd + " not recognized");
			}
		}
		else
			System.out.println("ERROR 3 values required: Op1 Operator Op2");
	}
}
		