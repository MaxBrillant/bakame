 package Publishing;
 import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.SwingWorker;

import org.apache.commons.net.ntp.NTPUDPClient;
   import org.apache.commons.net.ntp.TimeInfo;

import Class.Threads;
import CloudOperations.mysql;

    public class getInternetDateAndTime {
       public static String TIME_SERVER = "time-a.nist.gov";  
       public static boolean isWorking = false;

       public static TimeInfo timeInfo;
public static void main(String[] args) throws Exception {

	mysql.connectToDB();
		System.out.println(onlineTime());
}

public static String onlineTime(){
	
	String date = null;
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select now() ");
		rs.next();
		date = String.valueOf(rs.getTime(1));

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}	
	return date;
}
public static String getOnlineTime() {

	
	return onlineTime;
}

public static String getDate() {
	
	String date = null;
	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs=stmt.executeQuery("select now() ");
		rs.next();
		date = String.valueOf(rs.getDate(1).getDate()+"/"+(rs.getDate(1).getMonth()+1)+"/"+(rs.getDate(1).getYear()+1900));

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	}	
	return date;
}
}