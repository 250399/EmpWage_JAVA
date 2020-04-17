import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
class EmployeeWage{
    static Scanner sc = new Scanner(System.in);
    static Map<String,Integer> companyWages = new HashMap<String,Integer>();
    public static void main(String[] args) {
        Companies CompanyOne = new Companies(20,8,20,100,"Reliance");
        computeEmployeeWage(CompanyOne.companyName, CompanyOne.FULL_DAY_HOUR,CompanyOne.TOTAL_WORKING_HOURS,CompanyOne.WORKING_DAY_IN_MONTH,CompanyOne.WAGE_PER_HOUR);
        Companies CompanyTwo = new Companies(20,8,20,100,"BL");
        computeEmployeeWage(CompanyTwo.companyName, CompanyTwo.FULL_DAY_HOUR,CompanyTwo.TOTAL_WORKING_HOURS,CompanyTwo.WORKING_DAY_IN_MONTH,CompanyTwo.WAGE_PER_HOUR);
        printCompanyWages();
    }

    static void printCompanyWages(){
        companyWages.forEach((company,wage)->System.out.println("Total wage for company: "+company+" is: "+wage));
    }
    static void computeEmployeeWage(String companyName, int FULL_DAY_HOUR,int TOTAL_WORKING_HOURS, int WORKING_DAY_IN_MONTH,int WAGE_PER_HOUR){
        int dailyHours=0;
        int monthlyHours=0;
        int hours=0;
        int days=0;
        final int FULL_TIME = 1;
        final int PART_TIME = 2;
        while( hours <= TOTAL_WORKING_HOURS && days <= WORKING_DAY_IN_MONTH ){       
            dailyHours=0;
            int employeeCheck = (int) Math.round(Math.random()*10)%3;
            switch (employeeCheck){
            case FULL_TIME:
                dailyHours = FULL_DAY_HOUR+dailyHours;
                break;
            case PART_TIME:
                dailyHours=FULL_DAY_HOUR/2+dailyHours;
                break;
            default:
                dailyHours+=0;                
            }
            hours+=dailyHours;
            days++;
            monthlyHours+=dailyHours;
        }
        companyWages.put(companyName,(WAGE_PER_HOUR*monthlyHours));
    }

}

class Companies{
    final int WAGE_PER_HOUR ;
    final int FULL_DAY_HOUR ;
    final int WORKING_DAY_IN_MONTH;
    final int TOTAL_WORKING_HOURS;
    String companyName ;
    Companies(int wagePerHour, int fullDayHours, int totalWorkingDayinMonth,int totalWorkingHours,String companyName){
        this.WAGE_PER_HOUR=wagePerHour;
        this.FULL_DAY_HOUR=fullDayHours;
        this.WORKING_DAY_IN_MONTH=totalWorkingDayinMonth;
        this.TOTAL_WORKING_HOURS=totalWorkingHours;
        this.companyName=companyName;
    }
}