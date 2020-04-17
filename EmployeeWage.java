import java.lang.Math;
class EmployeeWage{
    public static void main(String[] args) {
        final int fullTime = 1;
		final int wagePerHour = 20;
		final int fullDayHour = 8;
		//variable
        int dailyWage;
        int dailyHours;
		//computation
		double employeeCheck = Math.round(Math.random());
		if ( employeeCheck == fullTime ){
			System.out.println("Employee is Present");
			dailyHours = fullDayHour;
		}
		else {
			System.out.println("Employee is Absent");
			dailyHours = 0;
		}
		System.out.println("Employee daily wage is "+(wagePerHour * dailyHours));   }
  
}