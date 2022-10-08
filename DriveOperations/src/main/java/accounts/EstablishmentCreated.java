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
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JPasswordField;

public class EstablishmentCreated extends JFrame {

	public static JPanel contentPane;
	public static boolean isEmpty = false;
	public static List<String> teacherList = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstablishmentCreated frame = new EstablishmentCreated("Max Brillant", "EIB");
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
	public EstablishmentCreated(String userName, String school) {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 398);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	JLabel lblNouveauCours = new JLabel("<html>Vous avez cree l'etablissement \""+school+"\" avec succes, vous etes l'administrateur general de cet etablissement. Vous pouvez donc commencer a utiliser le logiciel Bakame pour gerer l'ecole \""+school+"\"</html>");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNouveauCours.setBounds(12, 165, 400, 130);
	contentPane.add(lblNouveauCours);
	
	JButton btnSinscrire = new JButton("Continuer");
	btnSinscrire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserPanel l = new UserPanel(userName);
			l.setVisible(true);
			setVisible(false);
		}
	});
	btnSinscrire.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			btnSinscrire.setBackground(new Color(0, 171, 89).brighter());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnSinscrire.setBackground(new Color(0, 171, 89));
		}
	});
	btnSinscrire.setForeground(Color.WHITE);
	btnSinscrire.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnSinscrire.setFocusPainted(false);
	btnSinscrire.setBorderPainted(false);
	btnSinscrire.setBackground(new Color(0, 171, 89));
	btnSinscrire.setBounds(77, 317, 271, 31);
	contentPane.add(btnSinscrire);
	
	JLabel label = new JLabel("");
	label.setIcon(ResizeImages.resize(110, 110, "Icons\\cg_colored.png"));
	label.setBounds(157, 24, 110, 90);
	contentPane.add(label);
	
	JLabel lblHoorrraahh = new JLabel("HOORRRAAHH!");
	lblHoorrraahh.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblHoorrraahh.setIconTextGap(0);
	lblHoorrraahh.setHorizontalTextPosition(SwingConstants.CENTER);
	lblHoorrraahh.setHorizontalAlignment(SwingConstants.CENTER);
	lblHoorrraahh.setForeground(Color.WHITE);
	lblHoorrraahh.setFont(new Font("Futura Hv BT", Font.BOLD, 27));
	lblHoorrraahh.setBounds(0, 126, 424, 28);
	contentPane.add(lblHoorrraahh);

	setLocationRelativeTo(null);
	}
}