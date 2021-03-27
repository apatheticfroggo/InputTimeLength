import java.time.*;
import java.util.Scanner;
public class InputTimeLength
{
	private int days = 0;
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	
	public InputTimeLength()
	{
		Scanner futDate = new Scanner(System.in);
		System.out.println("This program will find the duration of time between now and a future time");
		
		System.out.println("Enter the year of your desired future date - YYYY");
		int futYear = futDate.nextInt();
		
		System.out.println("Enter the month - MM");
		int futMonth = futDate.nextInt();
		
		System.out.println("Enter the date - DD");
		int futDay = futDate.nextInt();
		
		System.out.println("Enter the hour - 24hr format - HH");
		int futHour = futDate.nextInt();
		
		System.out.println("Enter the minute - MM");
		int futMinute = futDate.nextInt();
		
		System.out.println("Enter the seconds - SS");
		int futSecond = futDate.nextInt();
		System.out.println();
		findDuration(futYear,futMonth,futDay,futHour,futMinute,futSecond);
	}
	private void findDuration(int initY, int initMo,int initD, int initH, int initMin, int initS)
	{
		LocalDateTime specDate = LocalDateTime.of(initY,initMo,initD,initH,initMin,initS);
		//convert specDate in context of time-zone
		ZonedDateTime specDateInZone = specDate.atZone(ZoneId.systemDefault());
		
		//convert specDate to seconds since epoch
		long secondsSpec = specDateInZone.toEpochSecond();
		
		//get milliseconds since epoch of current time
		long millisCurrent = System.currentTimeMillis();
		long secondsCurrent = millisCurrent/1000;
		//get difference of Spec and Current in seconds
		long secondsDiff = secondsSpec-secondsCurrent;
		
		//convert seconds to days,hours,minutes
		int secsPerDay = 86400;
		days = (int)secondsDiff/secsPerDay;
		secondsDiff -= (days*secsPerDay);
		
		int secsPerHour = 3600;
		hours = (int)secondsDiff/secsPerHour;
		secondsDiff -=(hours*secsPerHour);
		
		int secsPerMinute = 60;
		minutes = (int)secondsDiff/secsPerMinute;
		secondsDiff -=(minutes*secsPerMinute);
		
		seconds = (int)secondsDiff;
	}
	public String toString()
	{
		return ("Days:" +days+ " Hours:"+hours+" Minutes:"+minutes+" Seconds:"+seconds);
	}
	public static void main(String[] args)
	{
		boolean keepRunning = true;
		InputTimeLength graduationDay = new InputTimeLength();
		while(keepRunning)
		{
		   System.out.println(graduationDay);
		}
	}
}