package accounts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Statement;

import Application.Home;
import Class.Application;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowStateListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Loading extends JFrame {

	public static ResultSet getResult() {
		return result;
	}



	public static void setResult(ResultSet result) {
		Loading.result = result;
	}

	public static JPanel contentPane;
	public static List<JComponent> c = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private static ResultSet result;
	private static boolean isLoading;
	
	public Loading() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Login.setAsPopup(this);
		
		JLabel lblNewLabel = new JLabel("Veuillez patienter...");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon("Icons\\loading.gif"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		

		setLocationRelativeTo(null);
		}



public static ResultSet loadData(Statement st, String s) {

	Loading l = new Loading();
	if(!isLoading) {
	l.setVisible(true);
	}
    new Thread(new Runnable(){
    @Override
    public void run(){
    	try {
    		isLoading = true;
    		setResult(st.executeQuery(s));
    		isLoading = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		 SwingUtilities.invokeLater(new Runnable(){
            @Override public void run(){
            	if(!isLoading) {
           	 l.setVisible(false);
          }}
         });
    }

}).start();

	return getResult();
    
}
}