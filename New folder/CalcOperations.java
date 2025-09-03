public class CalcOperations {
	public void add2(double op1, double op2) {
		System.out.println(op1 + op2);
	}
	public void sub2(double op1, double op2) {
		System.out.println(op1 - op2);
	}
	public static void main(String[] args){
		//create an object out of the calc operations class
		CalcOperations ops= new CalcOperations();
		ops.add2(10,9);

	}
}