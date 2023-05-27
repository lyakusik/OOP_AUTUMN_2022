 import java.util.*;
 
public class extra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a day: ");
        int day = sc.nextInt();
        GregorianCalendar calendar = new GregorianCalendar(2022 , Calendar.SEPTEMBER, day);
        System.out.print(calendar);
        String daysOfWeek[] = { "SUN", "MON", "TUE", "WED","THU", "FRI", "SAT" };
        
        int d = 1;
        int m = 1;
        int y = 1;
        int dy = 1;

        System.out.println("MONTH: Semptember");
        for (int  i = 0; i < 7; i++) {
        	System.out.print("   " + daysOfWeek[i]);
        }
        
        System.out.println();
        
        
       
        
        for (int i = 1; i <= 30; i++) {
            System.out.printf(" %4d ", i);
  
            if (((i ) % 7 == 0)
                || (i == 30))
                System.out.println();
        }
        

	}
	public static String padded(int n, int width) {
        String s = "" + n;
        for (int i = s.length(); i < width; i++) {
            s = " " + s;
        }

        return s;
    }

}