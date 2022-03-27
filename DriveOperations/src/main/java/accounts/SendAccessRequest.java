package accounts;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import app.App;
import app.Cours;
import app.LPane;
import app.NewTest;
import app.WrapLayout;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Application.ResizeImages;
import Class.NewCourse;
import CloudOperations.mysql;
import Publishing.getInternetDateAndTime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class SendAccessRequest extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();
	public static JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendAccessRequest frame = new SendAccessRequest("Max");
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
	public SendAccessRequest(String userId) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 500, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(60, 60, 60));
	panel_1.setPreferredSize(new Dimension(10, 110));
	contentPane.add(panel_1, BorderLayout.NORTH);
	panel_1.setLayout(null);
	
	JButton btnNewButton_1 = new JButton("Retour");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserPanel l = new UserPanel(userId);
			l.setVisible(true);
			setVisible(false);
		
		}
	});
	btnNewButton_1.setFocusPainted(false);
	btnNewButton_1.setBorderPainted(false);
	btnNewButton_1.setBackground(new Color(60, 60, 60));
	btnNewButton_1.setForeground(new Color(255, 255, 255));
	btnNewButton_1.setIconTextGap(0);
	btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
	btnNewButton_1.setIcon(ResizeImages.resize(25, 25, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\l_arrow.png"));
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	btnNewButton_1.setBounds(0, 0, 74, 40);
	panel_1.add(btnNewButton_1);

	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnNewButton_1.setBackground(new Color(60, 60, 60).brighter());
		}@Override
		public void mouseExited(MouseEvent e) {
			btnNewButton_1.setBackground(new Color(60, 60, 60));
			btnNewButton_1.setForeground(Color.white);
		}
	});
	
	JLabel lblNewLabel = new JLabel("Etablissements utilisants CiGi Bakame");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(58, 83, 357, 24);
	panel_1.add(lblNewLabel);
	
	JLabel lblMaxBrillant = new JLabel("<html><div style='text-align: left;'>Avant d'avoir l'acces aux etablissements existants, vous devez envoyer une demande d'acces a l' administrateur de cet etablissement. Si l'acces est autorise, vous pourrez utiliser Bakame pour gerer cet etablissement.<dynamic></div></html>");
	lblMaxBrillant.setVerticalAlignment(SwingConstants.TOP);
	lblMaxBrillant.setHorizontalAlignment(SwingConstants.LEFT);
	lblMaxBrillant.setForeground(Color.WHITE);
	lblMaxBrillant.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblMaxBrillant.setBounds(79, 0, 385, 85);
	panel_1.add(lblMaxBrillant);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(-11, 77, 485, 8);
	panel_1.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBorder(null);
	contentPane.add(scrollPane, BorderLayout.CENTER);
	
	panel_2 = new JPanel();
	panel_2.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel_2);
	panel_2.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
	
	
	JPanel panel_3 = new JPanel();
	panel_3.setBackground(new Color(60, 60, 60).brighter());
	panel_3.setPreferredSize(new Dimension(450, 40));
	panel_2.add(panel_3);
	panel_3.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Ecole Internationale de Bujumbura");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(10, 0, 244, 40);
	panel_3.add(lblNewLabel_1);
	
	JLabel lblEnvoye = new JLabel("Envoy\u00E9e");
	lblEnvoye.setHorizontalAlignment(SwingConstants.CENTER);
	lblEnvoye.setForeground(Color.WHITE);
	lblEnvoye.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblEnvoye.setBounds(277, 0, 74, 40);
	panel_3.add(lblEnvoye);
	
	JButton btnX = new JButton("Annuler");
	btnX.setVerticalTextPosition(SwingConstants.BOTTOM);
	btnX.setIconTextGap(0);
	btnX.setHorizontalTextPosition(SwingConstants.CENTER);
	btnX.setForeground(Color.WHITE);
	btnX.setFont(new Font("Roboto", Font.PLAIN, 18));
	btnX.setFocusPainted(false);
	btnX.setBorder(new LineBorder(new Color(255, 255, 255)));
	btnX.setBackground(new Color(85, 85, 85));
	btnX.setBounds(353, 7, 87, 26);
	panel_3.add(btnX);
	setLocationRelativeTo(null);
	
	loadEstablishments(userId);
	}
	

	public static void loadEstablishments(String userId) {
		panel_2.removeAll();

		
		try {
			Statement stmt= mysql.con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from users_in_schools AS UIS "
					+ "JOIN schools AS s "
					+ "WHERE UIS.user_id <> '"+userId+"' AND UIS.school_id = s.school_id AND s.is_active = 1");
			while(rs.next())
			{
						JPanel panel_3 = new JPanel();
						panel_3.setBackground(new Color(60, 60, 60).brighter());
						panel_3.setPreferredSize(new Dimension(450, 40));
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						
						JLabel lblNewLabel_1 = new JLabel(rs.getString("s.short_name"));
						lblNewLabel_1.setForeground(Color.WHITE);
						lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
						lblNewLabel_1.setBounds(10, 0, 244, 40);
						panel_3.add(lblNewLabel_1);
						
						
						if(!requestSent(userId, rs.getString("s.school_id"))) {
						JButton btnEnvoyer = new JButton("Envoyer");
						btnEnvoyer.setVerticalTextPosition(SwingConstants.BOTTOM);
						btnEnvoyer.setIconTextGap(0);
						btnEnvoyer.setHorizontalTextPosition(SwingConstants.CENTER);
						btnEnvoyer.setForeground(Color.WHITE);
						btnEnvoyer.setFont(new Font("Roboto", Font.PLAIN, 18));
						btnEnvoyer.setFocusPainted(false);
						btnEnvoyer.setBorder(new LineBorder(new Color(255, 255, 255)));
						btnEnvoyer.setBackground(new Color(60, 60, 60).brighter());
						btnEnvoyer.setBounds(321, 3, 119, 34);
						panel_3.add(btnEnvoyer);
						
						btnEnvoyer.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseEntered(MouseEvent e) {
											btnEnvoyer.setBackground(Color.white);
											btnEnvoyer.setForeground(Color.black);
										}@Override
										public void mouseExited(MouseEvent e) {
											btnEnvoyer.setBackground(new Color(60, 60, 60).brighter());
											btnEnvoyer.setForeground(Color.white);
										}public void mouseClicked(MouseEvent e) {

											btnEnvoyer.setText("En cours...");
											try {
												sendrequest(userId, l.get(0).toString());
											} catch (Exception e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
											loadEstablishments(userId);
											try {
												Thread.sleep(10000);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											btnEnvoyer.setText("Envoyer");
											panel_3.revalidate();
											panel_3.repaint();
											
										}
									});
						}else {
							JLabel lblEnvoye = new JLabel("Envoy\u00E9e");
							lblEnvoye.setHorizontalAlignment(SwingConstants.CENTER);
							lblEnvoye.setForeground(Color.WHITE);
							lblEnvoye.setFont(new Font("Roboto", Font.PLAIN, 15));
							lblEnvoye.setBounds(277, 0, 74, 40);
							panel_3.add(lblEnvoye);
							
							JButton btnX = new JButton("Annuler");
							btnX.setVerticalTextPosition(SwingConstants.BOTTOM);
							btnX.setIconTextGap(0);
							btnX.setHorizontalTextPosition(SwingConstants.CENTER);
							btnX.setForeground(Color.WHITE);
							btnX.setFont(new Font("Roboto", Font.PLAIN, 18));
							btnX.setFocusPainted(false);
							btnX.setBorder(new LineBorder(new Color(255, 255, 255)));
							btnX.setBackground(new Color(85, 85, 85));
							btnX.setBounds(353, 7, 87, 26);
							panel_3.add(btnX);
							
							btnX.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									btnX.setBackground(Color.white);
									btnX.setForeground(Color.black);
								}@Override
								public void mouseExited(MouseEvent e) {
									btnX.setBackground(new Color(60, 60, 60).brighter());
									btnX.setForeground(Color.white);
								}public void mouseClicked(MouseEvent e) {
									cancelRequest(userId, l.get(0).toString());
									loadEstablishments(userId);
									panel_2.revalidate();
									panel_2.repaint();
								}
							});
						}
			}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				if(panel_2.getComponentCount()==0) {
					JLabel lblNewLabel_2 = new JLabel("Vous ne pouvez pas envoyer de demandes pour le moment");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel_2.add(lblNewLabel_2);
				}
	}
	

	public static void sendrequest(String userId, String schoolId) throws Exception {

		File file1 = new File("Data/Establishments/"+schoolId+"/Requests.txt");
		List<String> comp = new ArrayList();
		boolean exists = false;
		try {
			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i<lines1.length; i++) {
			comp.add(lines1[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		getInternetDateAndTime.generateTime();
		
		comp.add(userId+"//"+getInternetDateAndTime.onlineTime);
		
File file11 = new File("Data/Establishments/"+schoolId+"/Requests.txt");
		
		if(file11.exists()) {
					file11.delete();
				}
		
			try {
				file11.createNewFile();
				PrintWriter pw = new PrintWriter(file11);

				for(int j = 0;j<comp.toArray().length;j++) {
				pw.println((String)comp.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		    
	}
	

	public static void cancelRequest(String userId, String schoolId) {

		File file1 = new File("Data/Establishments/"+schoolId+"/Requests.txt");
		List<String> comp = new ArrayList();
		boolean exists = false;
		try {
			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = br1.lines().toArray();
			for(int i = 0; i<lines1.length; i++) {
			comp.add(lines1[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		for(int i = 0; i<comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).split("//"));
			if(l.get(0).equals(userId)) {
				comp.remove(i);
			}
			}
		
File file11 = new File("Data/Establishments/"+schoolId+"/Requests.txt");
		
		if(file11.exists()) {
					file11.delete();
				}
		
			try {
				file11.createNewFile();
				PrintWriter pw = new PrintWriter(file11);

				for(int j = 0;j<comp.toArray().length;j++) {
				pw.println((String)comp.get(j));
				};
				
				pw.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	
	public static boolean hasRoles(String user_id, String school_id) {
		boolean granted = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from users_in_schools "
				+ "WHERE user_id = '"+user_id+"' AND school_id = '"+school_id+"' LIMIT 1");
		
		int i = 0;
		while(rs.next())
		{
			i++;
		}
		if(i == 1) {
			granted = true;
		}else {
			granted = false;
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

		return granted;
	}
	public static boolean requestSent(String user_id, String school_id) {
		boolean granted = false;

	try {
		Statement stmt= mysql.con.createStatement();

		ResultSet rs= stmt.executeQuery("select * from requests "
				+ "WHERE user_id = '"+user_id+"' AND school_id = '"+school_id+"' LIMIT 1");
		
		int i = 0;
		while(rs.next())
		{
			i++;
		}
		if(i == 1) {
			granted = true;
		}else {
			granted = false;
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

		return granted;
	}
}