import java.lang.Math;
class EmployeeWage{
    public static void main(String[] args) {
        final int FULL_TIME = 1;
        final int PART_TIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int WORKING_DAY_IN_MONTH=20;
        int dailyHours=0;
        int monthlyHours=0;
        
        for(int i=0;i<WORKING_DAY_IN_MONTH;i++){       
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
                
        }
        monthlyHours+=dailyHours;
    }
		System.out.println("Employee daily wage is "+(WAGE_PER_HOUR * monthlyHours ));   }

}