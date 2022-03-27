package Class;

import java.awt.Component;
import java.awt.Container;

import accounts.Error;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Publishing.getInternetDateAndTime;

class loadComponents extends Thread{

	@Override
	public void run() {
		NewStudent.load();
		Application.merite();
		TestBox.loadAllTests();
		ExamBox.loadExams();
		
}}
	class loadComponents1 extends Thread{
		@Override
		public void run() {

			NewCourse.load();
		}
		
	}
	class error extends Thread{
		@Override
		public void run() {

			Error e = new Error();
			e.setVisible(true);
		}
		
	}
	class date extends Thread{
		@Override
		public void run() {
        	try {
				Thread.sleep(25000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
	}

public class Threads {
	public static void start() {
	loadComponents l = new loadComponents();
	l.start();
	loadComponents1 l1 = new loadComponents1();
	l1.start();
	}
	public static void loadTime() {
		date l2 = new date();
		l2.start();
	}
}

