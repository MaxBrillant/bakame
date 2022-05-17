package Application;

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

import Class.NewCourse;
import CloudOperations.aws;
import Publishing.PersonalMessage;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NewGroup extends JFrame {

	public static JPanel contentPane;
	private JLabel lblNewLabel_1;
	public static JTextField className;
	private JPanel panel;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JButton create;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGroup frame = new NewGroup();
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
	public NewGroup() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 264);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Continuer");
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i< Class.selectedClasses.toArray().length; i++) {
			AddToGroup.changeGroup(((JLabel) ((Container) ((Container) Class.selectedClasses.get(i)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")
					, className.getText());
		}
			setVisible(false);
			Class.loadClasses();
			}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(40, 182, 120, 31);
	contentPane.add(create);
	
	JLabel lblNomDuCours = new JLabel("Nom du groupe:");
	lblNomDuCours.setForeground(new Color(255, 255, 255));
	lblNomDuCours.setHorizontalAlignment(SwingConstants.TRAILING);
	lblNomDuCours.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblNomDuCours.setBounds(40, 122, 155, 31);
	contentPane.add(lblNomDuCours);
	
	className = new JTextField();
	className.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(!className.getText().equals("")) {
				create.setEnabled(true);
				actualiser.setEnabled(true);
			}else {
				create.setEnabled(false);
				actualiser.setEnabled(false);
				}
		}
	});
	className.setBorder(new LineBorder(new Color(128, 128, 128)));
	className.setHorizontalAlignment(SwingConstants.CENTER);
	className.setForeground(new Color(255, 255, 255));
	className.setCaretColor(new Color(0, 204, 255));
	className.setBackground(new Color(40, 40, 40));
	className.setFont(new Font("Roboto", Font.BOLD, 18));
	className.setColumns(10);
	className.setBounds(205, 122, 188, 28);
	contentPane.add(className);
	
	panel = new JPanel();
	panel.setBackground(new Color(20, 148, 198));
	panel.setForeground(new Color(0, 139, 139));
	panel.setBounds(0, 0, 424, 59);
	contentPane.add(panel);
	panel.setLayout(null);
	
	lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>Ajoutez une nouveau groupe de classes dans l'etablissement scolaire en tapant son nom</html>");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setBounds(7, 5, 409, 48);
	panel.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	actualiser = new JButton("Actualiser");
	actualiser.setVisible(false);
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	actualiser.setBounds(create.bounds());
	contentPane.add(actualiser);
	
	button = new JButton("Annuler");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	button.setForeground(Color.WHITE);
	button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	button.setFocusPainted(false);
	button.setBorderPainted(false);
	button.setBackground(new Color(171, 0, 0));
	button.setBounds(226, 182, 129, 31);
	contentPane.add(button);
	
	JLabel lblNouveauCours = new JLabel("Nouveau Groupe");
	lblNouveauCours.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblNouveauCours.setIconTextGap(0);
	lblNouveauCours.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNouveauCours.setHorizontalAlignment(SwingConstants.CENTER);
	lblNouveauCours.setForeground(Color.WHITE);
	lblNouveauCours.setFont(new Font("Futura Hv BT", Font.BOLD, 23));
	lblNouveauCours.setBounds(0, 70, 424, 28);
	contentPane.add(lblNouveauCours);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 97, 424, 12);
	contentPane.add(separator);
	
	setLocationRelativeTo(null);
	
	}
}