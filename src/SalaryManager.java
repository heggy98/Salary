public class SalaryManager {

    private static final double Health_Insurance_Percents = 0.45;
    private double Social_Insurance_Percents;
    private double Income_Tax_Percents;

    private double GetSalary(double grossWage, double advance, boolean isStudent){

        SetPercents(grossWage, isStudent);
        
    }

    private void SetPercents(double grossWage, boolean isStudent) {
        Income_Tax_Percents = (grossWage > 30000) ? 0.20 : 0.15;

        if(!isStudent){
            Social_Insurance_Percents = 0.65;
        }
    }
}
