import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
 
public class extraa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a day: ");
        int day = sc.nextInt();
        GregorianCalendar calendar = new GregorianCalendar(2022 , Calendar.SEPTEMBER, day);
        //System.out.print(calendar);
        int blankdays = 0;  
        blankdays = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        

        for (int i = 0; i < blankdays; i++) {  
        	   System.out.print("   ");  
        } 
        
        
        for (int i = 1; i <= 30; i++) {  
        	  
        	   if (i <= 9) {  
        	    System.out.print(" ");  
        	   }  
        	   System.out.print(i);  
        	  
        	   if ((blankdays + i) % 7 == 0) {  
        	    System.out.println();  
        	   } else {  
        	    System.out.print(" ");  
        	   }  
        	  }  
        	   
        

	}

}
