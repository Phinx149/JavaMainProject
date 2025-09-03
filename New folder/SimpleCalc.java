public class SimpleCalc {
    public static void main(String[] args){
        String cmd;
        double op1,op2;
        if (args.length==3){
            op1=Double.valueOf(args[0]);
            cmd=args[1].toLowerCase();
            op2=Double.valueOf(args[2]);
        switch (cmd) {
            case "+":System.out.println("Result= "+(op1+op2));
                break;
            case "-":System.out.println("Result= "+(op1-op2));
                break;
            case "x":System.out.println("Result= "+(op1*op2));
                break;
            case "div":System.out.println("Result= "+(op1/op2));
                break;
            default:
                System.out.println(cmd+" not recognized");




        }
        } else
            System.out.println("Error: 3 arguements required,op1 operatror op2");
    }
}

