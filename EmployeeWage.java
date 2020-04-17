import java.lang.Math;
class EmployeeWage{
    public static void main(String[] args) {
        final int FULL_TIME = 1;
        final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		//variable
        int dailyHours;
		//computation
        double employeeCheck = Math.round(Math.random()*10)%3;
		if ( employeeCheck == FULL_TIME ){
			System.out.println("Employee is Present");
			dailyHours = FULL_DAY_HOUR;
		}
        else if( employeeCheck == PART_TIME ){
			System.out.println("Employee is Present");
            dailyHours=FULL_DAY_HOUR/2;
        }
        else {
			System.out.println("Employee is Absent");
			dailyHours = 0;
		}
		System.out.println("Employee daily wage is "+(WAGE_PER_HOUR * dailyHours));   }

}