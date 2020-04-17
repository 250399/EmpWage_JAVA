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
        int employeeCheck = (int) Math.round(Math.random()*10)%3;
        switch (employeeCheck){
		case FULL_TIME:
			System.out.println("Employee is Present");
            dailyHours = FULL_DAY_HOUR;
            break;
		
        case PART_TIME:
			System.out.println("Employee is Present");
            dailyHours=FULL_DAY_HOUR/2;
            break;
        default:
			System.out.println("Employee is Absent");
			dailyHours = 0;
        
    }
		System.out.println("Employee daily wage is "+(WAGE_PER_HOUR * dailyHours));   }

}