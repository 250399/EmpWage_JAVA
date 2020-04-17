import java.lang.Math;
class EmployeeWage{
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Program!");      
        checkPresentorAbsent();
    }
    static void checkPresentorAbsent(){
        String isPresent = (Math.round(Math.random())==1) ? "Present" : "Absent" ;
        System.out.println("Employee is "+isPresent);    
    }

}