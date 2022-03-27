package CloudOperations;

import java.awt.Container;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import Application.Home;
import Publishing.Connection;
import Publishing.getInternetDateAndTime;

import java.util.List;

import javax.swing.SwingWorker;

public class aws{
	public static void main(String[] args) throws Exception {

		boolean isValid = false;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	 Date d;
	 Date t;
	try {

		getInternetDateAndTime.generateTime();
		String s = getInternetDateAndTime.onlineTime;
		List ot = Arrays.asList(s.split("::"));
		d = df.parse("17/09/2021");
		t = df.parse(ot.get(0).toString());
	 Calendar c = Calendar.getInstance();
	 c.setTime(d);
	 c.add(Calendar.DATE, 30);

	 Calendar ct = Calendar.getInstance();
	 ct.setTime(t);
	 
	 System.out.println(df.format(c.getTime())+" a "+ df.format(ct.getTime()));
	 if(c.before(ct) || c.equals(ct)) {
		 if(!"30".equals("0")) {
		 isValid = true;
		 }else {
			 isValid = false;
		 }
	 }else {
		 isValid = false;
	 }
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	System.out.println(isValid);
}
	
public static void upload(String path) {
	/*
	 * //downloadContent(path);
	 * 
	 * new SwingWorker<Void, Void>() { public Void doInBackground() throws
	 * Exception{
	 * 
	 * final String path1 = path.replace("\\", "/");
	 * if(Connection.isConnectedToInternet()) { System.out.println("Uploading...");
	 * PutObjectRequest request = new PutObjectRequest("bakamedata", path1, new
	 * File(path1)); Home.s3Client.putObject(request);
	 * System.out.println("--File "+path1+" uploaded successfully"); ; // this is
	 * run in a background thread // take care that calculate makes no Swing calls }
	 * return null; } }.execute();
	 * 
	 * Frame[] l = Frame.getFrames(); for(int i = 0; i<l.length; i++) {
	 * l[i].revalidate(); l[i].repaint(); }
	 */}
    
		public static void downloadContent(String path) {
			/*
			 * 
			 * new SwingWorker<Void, Void>() { public Void doInBackground() throws
			 * Exception{
			 * 
			 * final String path1 = path.replace("\\", "/");
			 * 
			 * if(Connection.isConnectedToInternet()) {
			 * if(Home.s3Client.doesObjectExist("bakamedata", path1)) {
			 * System.out.println("Downloading..."); S3Object fullObject; fullObject =
			 * Home.s3Client.getObject(new GetObjectRequest("bakamedata", path1));
			 * System.out.println("--File "+path1+" downloaded successfully"); // Print file
			 * content line by line InputStream is = fullObject.getObjectContent();
			 * BufferedReader reader = new BufferedReader(new InputStreamReader(is)); String
			 * line;
			 * 
			 * 
			 * List list = Arrays.asList(path1.split("/")); String destinationFolder = "";
			 * for(int i1 = 0; i1<list.toArray().length; i1++) {
			 * if(!list.get(i1).toString().contains("txt")) { if(i1>0) { destinationFolder =
			 * destinationFolder+"/"+list.get(i1).toString(); }else { destinationFolder =
			 * list.get(0).toString(); } }else { break; } File file2 = new
			 * File(destinationFolder); if(!file2.exists()) { file2.mkdir(); } }
			 * 
			 * 
			 * File file1 = new File(path1);
			 * 
			 * if(file1.exists()) { file1.delete(); }
			 * 
			 * try { file1.createNewFile(); PrintWriter pw = new PrintWriter(file1);
			 * 
			 * while ((line = reader.readLine()) != null) { pw.println(line); }
			 * 
			 * pw.close(); } catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace();
			 * 
			 * } }//else { // System.out.println(path+" doesn't exist"); } // this is run in
			 * a background thread //} // take care that calculate makes no Swing calls
			 * return null; } }.execute(); Frame[] l = Frame.getFrames(); for(int i = 0;
			 * i<l.length; i++) { l[i].revalidate(); l[i].repaint(); }
			 */}
}
