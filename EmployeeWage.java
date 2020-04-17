import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.lang.reflect.Array;
class EmployeeWage{
    static Scanner sc = new Scanner(System.in);
    static Map<String,Integer> companyWages = new HashMap<String,Integer>();
    static ArrayList<Companies> companiesArray = new ArrayList<>();
    
    public static void main(String[] args) {
        while(true){
            System.out.println("1.Add company \n2.Renove company\n3.Compute Wages for companies \n4.Print Wages for companies \n5.Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1: 
                    addCompany();
                    break;
                case 2:
                    removeCompany();
                    break;
                case 3:
                    computeWages();
                    break;
                case 4:
                    printCompanyWages();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void removeCompany(){
        if(companiesArray.size()==0){
            System.out.println("No companies in array. Please add some first!");
            return;
        }
        String name="";
        System.out.println("Enter company name to delete");
        name=sc.next();
        for(int index=0;index<companiesArray.size();index++){
            if((companiesArray.get(index).companyName.toString().toLowerCase().equals(name.toLowerCase()))){
                companyWages.remove(companiesArray.get(index).companyName);
                companiesArray.remove(index);

            }
        }
        System.out.println("Removed Company :"+name);
    }

    static void computeWages(){
        if(companyWages.size()==companiesArray.size()){
            System.out.println("Add new companies for evaluatuion");
            return;
        }
        for(int index=companyWages.size();index<companiesArray.size();index++)
            computeEmployeeWage(companiesArray.get(index).companyName,companiesArray.get(index).FULL_DAY_HOUR,companiesArray.get(index).TOTAL_WORKING_HOURS,companiesArray.get(index).WORKING_DAY_IN_MONTH,companiesArray.get(index).WAGE_PER_HOUR);
    }

    static void addCompany(){
        int wage;
        int totalDays;
        int hoursInDay;
        int totalHours;
        String name="";
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
        companiesArray.add(new Companies(wage,hoursInDay,totalDays,totalHours,name));
    }
    
    static void printCompanyWages(){
        if(companyWages.size()==0){
            System.out.println("Please add some companies first");
        }else
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