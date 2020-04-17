import java.lang.Math;
class EmployeeWage{
    public static void main(String[] args) {
        final int FULL_TIME = 1;
        final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int WORKING_DAY_IN_MONTH=20;
        final int TOTAL_WORKING_HOURS=100;
        int dailyHours=0;
        int monthlyHours=0;
        int hours=0;
        int days=0;

        while( hours <= TOTAL_WORKING_HOURS || days <= WORKING_DAY_IN_MONTH ){       
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
		System.out.println("Employee daily wage is "+(WAGE_PER_HOUR * monthlyHours ));   }

}