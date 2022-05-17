 package Publishing;
 import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.SwingWorker;

import org.apache.commons.net.ntp.NTPUDPClient;
   import org.apache.commons.net.ntp.TimeInfo;

import Class.Threads;

    public class getInternetDateAndTime {
    	public static String onlineTime = "22/10/2021::17/3";
       public static String TIME_SERVER = "time-a.nist.gov";  
       public static boolean isWorking = false;

       public static TimeInfo timeInfo;
public static void main(String[] args) throws Exception {
		System.out.println(getOnlineTime());
		}


public static String onlineTime(){
	
	try {
		String s = getOnlineTime();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(onlineTime);
	//Thread.currentThread().stop();
	return onlineTime;
}
public static String getOnlineTime() throws Exception{

	//for(int i = 0; i<3; i++) {
	
	
	generateTime();
	//break;
	//Thread.currentThread().stop();

//	}
	return onlineTime;
}

public static void generateTime(){

	isWorking = false;
	for(int i = 0; i< 100; i++) {
		if(!isWorking) {
	new SwingWorker<Void, Void>() {
        public Void doInBackground() throws Exception{
	String date = null;

	if(Connection.isConnectedToInternet()) {
		System.out.println("Getting online time...");
		/*
		 * try { Thread.sleep(4000); } catch (InterruptedException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */
		
		//ntp.xs4all.nl
    	Thread.sleep(1000);
	    NTPUDPClient timeClient = new NTPUDPClient();
	    System.out.println("1 completed");

    	Thread.sleep(500);
	    InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
	    System.out.println("2 completed");
    	Thread.sleep(1000);
            	TimeInfo i = timeClient.getTime(inetAddress);
        	    timeInfo = i;
	    System.out.println("3 completed");
    	Thread.sleep(1000);
	    long returnTime = timeInfo.getReturnTime();
	    System.out.println("4 completed");
	    Date time = new Date(returnTime);
	    System.out.println("5 completed");
	    long systemtime = System.currentTimeMillis();
	    System.out.println("6 completed");
	    timeInfo.computeDetails();
	    System.out.println("7 completed");
	    Date realdate = new Date(systemtime + timeInfo.getOffset());
	    System.out.println("8 completed");
		
    date = realdate.getDate()+"/"+(realdate.getMonth()+1)+"/"+(realdate.getYear()+1900)+"::"+realdate.getHours()+":"+realdate.getMinutes()+":"+realdate.getSeconds();
    onlineTime = date;
	/*
	 * try { Thread.sleep(7000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 */
    
	}else {
		onlineTime = "22/10/2021::17/3";
	}
	isWorking = true;
	 return null;
        }
    }.execute();

	}else{
		break;
	}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
}