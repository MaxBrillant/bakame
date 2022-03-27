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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Container;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import Application.Home;
import Application.ResizeImages;
import Class.NewCourse;
import Publishing.getInternetDateAndTime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class InputCode extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static JTextField name1;
	public static JButton create;
	public static List<String> teacherList = new ArrayList<String>();
	public static JLabel notice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputCode frame = new InputCode("44878bff-9645-4b70-b6a3-996905cb9402");
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
	public InputCode(String schoolID) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 530);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Activer");
	create.setEnabled(false);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				checkForKey(name1.getText(), schoolID);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	create.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			create.setBackground(new Color(0, 171, 89).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {

			create.setBackground(new Color(0, 171, 89));
		}
	});
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(29, 359, 182, 31);
	contentPane.add(create);
	
	JLabel lblNouveauCours = new JLabel("<html>Pour renouveller votre droit d'utilisation du logiciel CiGi Bakame, veuillez contacter la societ\u00E9 CiGicom pour qu'elle vous donne une nouvelle cl\u00E9 de produit, afin de regagner le controle de l'\u00E9tablissement.</html>");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNouveauCours.setBounds(12, 188, 400, 72);
	contentPane.add(lblNouveauCours);
	
	JLabel lblNomDutilisateur = new JLabel("Cl\u00E9 de produit:");
	lblNomDutilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDutilisateur.setForeground(Color.WHITE);
	lblNomDutilisateur.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDutilisateur.setBounds(12, 292, 132, 31);
	contentPane.add(lblNomDutilisateur);
	
	name1 = new JTextField();
	name1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!name1.getText().replace(" ", "").isBlank()) {
				create.setEnabled(true);
			}else {
				create.setEnabled(false);
			}
		}
	});
	name1.setHorizontalAlignment(SwingConstants.CENTER);
	name1.setForeground(Color.WHITE);
	name1.setFont(new Font("Arial", Font.PLAIN, 20));
	name1.setColumns(10);
	name1.setCaretColor(new Color(0, 204, 255));
	name1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	name1.setBackground(new Color(40, 40, 40));
	name1.setBounds(161, 292, 230, 28);
	contentPane.add(name1);
	
	JButton btnSinscrire = new JButton("Retour");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			UserPanel u = new UserPanel(Login.getUserId(Login.selectedUserName));
			u.setVisible(true);
			setVisible(false);
		}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255,102, 102).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(255,102, 102));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(255,102, 102));
	btnSinscrire.setBounds(255, 359, 136, 31);
	contentPane.add(btnSinscrire);
	
	JSeparator separator = new JSeparator();
	separator.setBackground(Color.WHITE);
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 264, 424, 5);
	contentPane.add(separator);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Bakame.png"));
	label.setBounds(157, 20, 110, 90);
	contentPane.add(label);
	
	notice = new JLabel("La cl\u00E9 que vous avez saisie est invalide ou a d\u00E9j\u00E0 \u00E9t\u00E9 utilis\u00E9e");
	notice.setVisible(false);
	notice.setHorizontalAlignment(SwingConstants.CENTER);
	notice.setForeground(new Color(255, 102, 102));
	notice.setFont(new Font("Tahoma", Font.PLAIN, 15));
	notice.setBounds(12, 334, 400, 19);
	contentPane.add(notice);
	
	JLabel lblVotreLicenceDutilisation = new JLabel("Votre licence d'utilisation est expir\u00E9e");
	lblVotreLicenceDutilisation.setHorizontalAlignment(SwingConstants.CENTER);
	lblVotreLicenceDutilisation.setForeground(Color.WHITE);
	lblVotreLicenceDutilisation.setFont(new Font("Roboto", Font.BOLD, 23));
	lblVotreLicenceDutilisation.setBounds(12, 116, 400, 40);
	contentPane.add(lblVotreLicenceDutilisation);
	
	JLabel lblNumeroDeTelephone = new JLabel("Telephone: 62898788");
	lblNumeroDeTelephone.setHorizontalAlignment(SwingConstants.LEFT);
	lblNumeroDeTelephone.setForeground(Color.WHITE);
	lblNumeroDeTelephone.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNumeroDeTelephone.setBounds(12, 430, 271, 31);
	contentPane.add(lblNumeroDeTelephone);
	
	JLabel lblEmailNdashimaxgmailcom = new JLabel("E-Mail: ndashimax37@gmail.com");
	lblEmailNdashimaxgmailcom.setHorizontalAlignment(SwingConstants.LEFT);
	lblEmailNdashimaxgmailcom.setForeground(Color.WHITE);
	lblEmailNdashimaxgmailcom.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblEmailNdashimaxgmailcom.setBounds(12, 460, 271, 31);
	contentPane.add(lblEmailNdashimaxgmailcom);
	
	JLabel lblEtablissementEcoleInternationale = new JLabel(NewEstablishment.getSchoolName(schoolID));
	lblEtablissementEcoleInternationale.setHorizontalAlignment(SwingConstants.CENTER);
	lblEtablissementEcoleInternationale.setForeground(Color.WHITE);
	lblEtablissementEcoleInternationale.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblEtablissementEcoleInternationale.setBounds(12, 152, 400, 25);
	contentPane.add(lblEtablissementEcoleInternationale);

	setLocationRelativeTo(null);
	}
	
	public static void checkForKey(String key, String schoolID) throws Exception {

		List<String> files = new ArrayList();
		
		files.add("Keys/Basic.txt");
		files.add("Keys/Standard.txt");
		files.add("Keys/Premium.txt");

		List<String> content = new ArrayList();

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIATCPCBRZ572L66UD7", "rInnepuleetF0etEnZseelyDdsrSAx20hSsptmKw");
		AmazonS3 s3Client;
		s3Client = AmazonS3ClientBuilder.standard().withRegion("us-east-2").withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.build();
		for(int i = 0; i< files.toArray().length; i++) {
		System.out.println("Downloading...");
	S3Object fullObject;
	fullObject = s3Client.getObject(new GetObjectRequest("bakamedata", files.get(i)));
	System.out.println("--File "+files.get(i)+" downloaded successfully");
	// Print file content line by line
	InputStream is = fullObject.getObjectContent();
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	String line;
	try {
		while ((line = reader.readLine()) != null) {
			content.add(line+"//"+files.get(i));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		boolean isValid = false;
		int index = 0;
	for(int i = 0; i< content.toArray().length; i++) {
		if(!content.get(i).isBlank()) {
		List l = Arrays.asList(content.get(i).split("//"));
		if(l.get(0).equals(key)) {
			isValid = true;
			index = i;
			break;
		}
	}	}
	
	if(isValid) {
		List l = Arrays.asList(content.get(index).split("//"));
		String days = l.get(1).toString();
		String path = l.get(3).toString();
		String students = l.get(2).toString();
		content.remove(index);
		String newKey = generateKey(path, days);
		content.add(newKey+"//"+days+"//"+students+"//"+path);
		List<String> refreshed = new ArrayList();
		for(int i = 0; i< content.toArray().length; i++) {
			List l1 = Arrays.asList(content.get(i).split("//"));
			if(l1.get(3).toString().equals(path)) {
			refreshed.add(l1.get(0).toString()+"//"+l1.get(1).toString()+"//0");
		}}
		String listString = String.join("\n", refreshed);
		s3Client.putObject("bakamedata", path, listString);
		allowAccess(schoolID,days, path, students);
	}else {
		notice.setVisible(true);
	}
	}
	
	public static void allowAccess(String schoolID, String days, String path, String students) throws Exception {
		

		File file1 = new File("Data/Establishments/"+schoolID+"/Licence.txt");
		List<String> comp = new ArrayList(); 
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
		String time = getInternetDateAndTime.onlineTime;
		comp.add(0, time+"//"+days+"//"+path+"//"+students);
		
		List l = Arrays.asList(time.split("::"));
		

		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 Date d;
		try {
			d = df.parse(l.get(0).toString());
		 Calendar c = Calendar.getInstance();
		 c.setTime(d);
		 c.add(Calendar.DATE, Integer.parseInt(days));

		AccessGranted ac = new AccessGranted(schoolID, days, df.format(c.getTime()));
		ac.setVisible(true);
		SwingUtilities.getRoot(contentPane).setVisible(false);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File file11 = new File("Data/Establishments/"+schoolID+"/Licence.txt");
				
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
	public static String generateKey(String path, String days) {
		Random rand = new Random();
		Random r = new Random();
		String newKey = "";
		if(path.equals("Keys/Basic.txt")) {
			newKey = rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
			}
		if(path.equals("Keys/Standard.txt")) {
			newKey = rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
			}
		if(path.equals("Keys/Premium.txt")) {
			newKey = rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+(char)(r.nextInt(26) + 'a')+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
			}
		return newKey;
	}
}