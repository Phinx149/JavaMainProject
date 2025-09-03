public class DoFunFormulas {
    public static void main(String[] args){
        FunFormulas ff_object=new FunFormulas();
        if (args.length != 1) {
            System.out.println("ERROR: 1 command line argument required: Two letter name of function to\n" + //
                    "compute. Type:\n" + 
                    "sd compute storm distance\n" + 
                    "ls to compute distance to lightning strike\n" + 
                    "wi to compute weight of ice cube\n" + 
                    "dt to computer distance traveled\n" + 
                    "sa to compute skin area");
            System.exit(1);
        }
        String formula = args[0];
        switch (formula) {
            case "ls":
                ff_object.ls();
                break;
            case "sd":
                ff_object.sd();
                break;
            case "wi":
                ff_object.wi();
                break;
            case "dt":
                ff_object.dt();
                break;
            case "sa":
                ff_object.sa();
                break;
        
            default:
            System.out.println("ERROR: Formula '" + formula + "' is not recognized. Please type one of the following:\n" +
            "sd to compute storm distance\n" +
            "ls to compute the distance to lightning strike\n" +
            "wi to compute weight of ice cube\n" +
            "dt to compute distance traveled\n" +
            "sa to compute body surface area");
            System.exit(1);
            break;
        }
    }
}
              
        

    



