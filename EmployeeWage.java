import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.lang.reflect.Array;
class EmployeeWage{
    static Scanner sc = new Scanner(System.in);
    static Map<String,Integer> companyWages = new HashMap<String,Integer>();
    // static ArrayList<Companies> companiesArray = new ArrayList<>();
    static Companies companiesArray[];
    public static void main(String[] args) {

        System.out.println("1.Add company 2.Exit");
        int choice = sc.nextInt();
        switch(choice){
            case 1: addCompany();
                break;
            case 2:System.exit(1);
            default:System.out.println("Invalid choice");
        }


        // Companies CompanyOne = new Companies(20,8,20,100,"Reliance");
        // computeEmployeeWage(CompanyOne.companyName, CompanyOne.FULL_DAY_HOUR,CompanyOne.TOTAL_WORKING_HOURS,CompanyOne.WORKING_DAY_IN_MONTH,CompanyOne.WAGE_PER_HOUR);
        // Companies CompanyTwo = new Companies(20,8,20,100,"BL");
        // computeEmployeeWage(CompanyTwo.companyName, CompanyTwo.FULL_DAY_HOUR,CompanyTwo.TOTAL_WORKING_HOURS,CompanyTwo.WORKING_DAY_IN_MONTH,CompanyTwo.WAGE_PER_HOUR);
        printCompanyWages();
    }

    static void addCompany(){
        int wage;
        int totalDays;
        int hoursInDay;
        int totalHours;
        String name="";
        int numberOfCompanies;
        System.out.println("Enter number of companies you want to add");
        numberOfCompanies=sc.nextInt();
        companiesArray= new Companies[numberOfCompanies];
        for(int companyIndex=0;companyIndex<numberOfCompanies;companyIndex++){
            System.out.println("Enter name of Company");
            name=sc.next();
            System.out.println("Enter wage per hour");
            wage=sc.nextInt();
            System.out.println("Enter total days");
            totalDays=sc.nextInt();
            System.out.println("Enter hours per day");
            hoursInDay=sc.nextInt();
            System.out.println("Enter total hours in month");
            totalHours=sc.nextInt();
            companiesArray[companyIndex]=new Companies(wage,hoursInDay,totalDays,totalHours,name);
            computeEmployeeWage(companiesArray[companyIndex].companyName,companiesArray[companyIndex].FULL_DAY_HOUR,companiesArray[companyIndex].TOTAL_WORKING_HOURS,companiesArray[companyIndex].WORKING_DAY_IN_MONTH,companiesArray[companyIndex].WAGE_PER_HOUR);
            
        }
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