package com.company;

public class SalaryManager {

    private static final double HealthInsurancePercents = 4.5;
    private static int HealthInsurance;

    private static double SocialInsurancePercents = 0;
    private static int SocialInsurance = 0;

    private static double IncomeTaxPercents;
    private static int IncomeTax;

    public static void GetSalaryDetails(int grossWage, int advance, boolean isStudent){
        CheckGrosswage(grossWage);
        CheckAdvance(advance);

        SetPercents(grossWage, isStudent);

        SetHealthInsurance(grossWage);
        SetSocialInsurance(grossWage, isStudent);
        SetIncomeTax(grossWage);

        System.out.println("HRUBA MZDA: " + grossWage); // kdyby to nebyl pouze školní projekt, vytvořil bych nějaké resourcy pro dané stringy, ale tlačí mě čas
        System.out.println("ZÁLOHY: " + advance);
        System.out.println("STATUS STUDENTA: " + isStudent + "\n");

        System.out.println("ZDRAVOTNÍ POJÍŠTĚNÍ V PROCENTECH: " + HealthInsurancePercents + "%");
        System.out.println("SOCIÁLNÍ POJÍŠTĚNÍ V PROCENTECH: " + SocialInsurancePercents + "%");
        System.out.println("DANĚ V PROCENTECH: " + IncomeTaxPercents + "%\n");

        System.out.println("CENA ZA ZDRAVOTNÍ POJÍŠTĚNÍ: " + HealthInsurance);
        System.out.println("CENA ZA SOCIÁLNÍ POJÍŠTĚNÍ: " + SocialInsurance);
        System.out.println("CENA ZA DANĚ: " + IncomeTax + "\n");

        int salary = getSalary(grossWage,advance);

        if(salary < 0){
            System.out.println("Pozor, jsou přeplatky v zalohach! -> Proto je čista mzda v negativnich čislech.");
        }

        System.out.println("ČISTÁ MZDA: " + salary);

    }

    private static int getSalary(int grossWage, int advance) {
        return grossWage - HealthInsurance - SocialInsurance - IncomeTax - advance;
    }

    private static void CheckAdvance(int advance) {
        if (advance < 0) throw new RuntimeException("Advance cannot be negative");
    }

    private static void CheckGrosswage(int grossWage) {
        if(grossWage < 1) throw new RuntimeException("Grosswage cannot be 0 or negative");
    }

    private static void SetIncomeTax(int grossWage) {
        IncomeTax = (int) ((grossWage / 100) * IncomeTaxPercents);
    }

    private static void SetSocialInsurance(int grossWage, boolean isStudent) {
        if(!isStudent){
            SocialInsurance = (int) ((grossWage / 100) * SocialInsurancePercents);
        }
    }

    private static void SetHealthInsurance(int grossWage) {
        HealthInsurance = (int) ((grossWage / 100) * HealthInsurancePercents);
    }

    private static void SetPercents(int grossWage, boolean isStudent) {
        SetIncomeTaxPercents(grossWage);

        if(!isStudent){
            SetSocialInsurancePercents();
        }
    }

    private static void SetSocialInsurancePercents() {
        SocialInsurancePercents = 6.5;
    }

    private static void SetIncomeTaxPercents(int grossWage) {
        IncomeTaxPercents = (grossWage > 30000) ? 20 : 15;
    }
}
