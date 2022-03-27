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
import javax.swing.SwingUtilities;
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
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class EducationFrame extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton btnFermer;
	public static boolean isEmpty = false;
	private JLabel lblajoutezLesClasses;
	public static JPanel panel;
	public static int selectedClass;
	public static boolean isSelectable =false;
	private JLabel lblajouterModifierouSupprimer;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EducationFrame frame = new EducationFrame();
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
	public EducationFrame() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 600);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	actualiser.setFocusPainted(false);
	actualiser.setForeground(Color.WHITE);
	actualiser.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	actualiser.setBackground(new Color(171, 145, 0));
	contentPane.add(actualiser);
	
	btnFermer = new JButton("Fermer");
	btnFermer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	});
	btnFermer.setForeground(Color.WHITE);
	btnFermer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnFermer.setFocusPainted(false);
	btnFermer.setBorderPainted(false);
	btnFermer.setBackground(new Color(171, 0, 0));
	btnFermer.setBounds(272, 520, 129, 31);
	contentPane.add(btnFermer);
	
	lblajoutezLesClasses = new JLabel("<html><div style='text-align: center;'>Education et punitions</html>");
	lblajoutezLesClasses.setHorizontalAlignment(SwingConstants.CENTER);
	lblajoutezLesClasses.setForeground(Color.WHITE);
	lblajoutezLesClasses.setFont(new Font("Roboto", Font.BOLD, 25));
	lblajoutezLesClasses.setBounds(10, 0, 404, 31);
	contentPane.add(lblajoutezLesClasses);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 32, 424, 12);
	contentPane.add(separator);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(10, 146, 404, 362);
	contentPane.add(scrollPane);
	
	panel = new JPanel();
	panel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			isSelectable =false;
			for(int i = 0; i<panel.getComponentCount(); i++) {
				panel.getComponent(i).setBackground(new Color(80, 80, 80));
				((Container) panel.getComponent(i)).getComponent(2).setVisible(false);
			}
		}
	});
	panel.setBackground(new Color(40, 40, 40));
	scrollPane.setViewportView(panel);
	panel.setLayout(new WrapLayout(WrapLayout.CENTER, 3, 3));
	
	JLabel lblNewLabel_1 = new JLabel("Punitions");
	lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 18));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(10, 121, 209, 23);
	contentPane.add(lblNewLabel_1);
	
	lblajouterModifierouSupprimer = new JLabel("<html><div style='text-align: center;'>Ajoutez, modifiez ou supprimez les punitions appliquees par cet etablissement.</div></html>");
	lblajouterModifierouSupprimer.setForeground(Color.WHITE);
	lblajouterModifierouSupprimer.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblajouterModifierouSupprimer.setBounds(10, 34, 404, 51);
	contentPane.add(lblajouterModifierouSupprimer);
	
	JButton btnAjouter = new JButton("Ajouter");
	btnAjouter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			NewPunishment np = new NewPunishment("", "");
			np.setVisible(true);
			np.create.setVisible(true);
			np.actualiser.setVisible(false);
		}
	});
	btnAjouter.setForeground(Color.WHITE);
	btnAjouter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	btnAjouter.setFocusPainted(false);
	btnAjouter.setBorderPainted(false);
	btnAjouter.setBackground(new Color(0, 171, 89));
	btnAjouter.setBounds(281, 110, 120, 31);
	contentPane.add(btnAjouter);
	
	setLocationRelativeTo(null);
	loadPunishments();
	}
	
	
	

	public static void loadPunishments() {
		panel.removeAll();
		File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Punishments.txt");
		aws.downloadContent(file1.getPath());
		FileReader fr1;
		try {
			fr1 = new FileReader(file1);
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines = br1.lines().toArray();
		
		
		for(int i = 0; i< lines.length; i++) {
			List l = Arrays.asList(lines[i].toString().split("//"));
			JPanel panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(390, 25));
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(80, 80, 80));;
			
			JLabel lblNewLabel = new JLabel(l.get(1).toString());
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 2, 252, 20);
			lblNewLabel.setForeground(Color.white);
			
			JLabel lblCours = new JLabel(l.get(2).toString()+" points");
			lblCours.setHorizontalAlignment(SwingConstants.CENTER);
			lblCours.setFont(new Font("Roboto", Font.PLAIN, 15));
			lblCours.setForeground(Color.white);
			lblCours.setBounds(259, 2, 88, 20);
			
					panel.add(panel_1);
					panel_1.add(lblNewLabel);
					panel_1.add(lblCours);
					
					JButton button = new JButton("");
					button.setIcon(ResizeImages.resize(20, 20, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\delete.png"));
					button.setVerticalTextPosition(SwingConstants.BOTTOM);
					button.setIconTextGap(0);
					button.setHorizontalTextPosition(SwingConstants.CENTER);
					button.setForeground(Color.WHITE);
					button.setFont(new Font("Tahoma", Font.PLAIN, 15));
					button.setFocusPainted(false);
					button.setBorder(new LineBorder(new Color(255, 255, 255)));
					button.setBounds(354, 0, 36, 25);
					panel_1.add(button);
					button.setBackground(button.getParent().getBackground());
					button.setVisible(false);
					

					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							button.setBackground(new Color(255, 102, 102));
						}
						@Override
						public void mouseExited(MouseEvent e) {

							button.setBackground(new Color(80, 80, 80));
						}
					});
					

					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							NewPunishment.deletePunishment(((JLabel) button.getParent().getComponent(0)).getText());
							EducationFrame.loadPunishments();
						}
					});
					panel_1.addMouseListener(new MouseAdapter() {@Override
						public void mouseClicked(MouseEvent e) {
						for(int i = 0; i< panel_1.getParent().getComponentCount(); i++) {
							panel_1.getParent().getComponent(i).setBackground(new Color(80, 80, 80));
							((Container) panel_1.getParent().getComponent(i)).getComponent(2).setVisible(false);
						}
						panel_1.setBackground(new Color(20, 142, 192));
						panel_1.getComponent(2).setVisible(true);
						
						if(e.getClickCount()==2) {
							NewPunishment nc = new NewPunishment(((JLabel) panel_1.getComponent(0)).getText(), ((JLabel) panel_1.getComponent(1)).getText().replaceAll("[^0-9]", ""));
							nc.setVisible(true);
							nc.create.setVisible(false);
							nc.actualiser.setVisible(true);
						}
					}
						@Override
						public void mouseEntered(MouseEvent e) {
							panel_1.setBorder(new LineBorder(Color.white, 1));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panel_1.setBorder(null);
						}
					});

		}
		panel.revalidate();
		panel.repaint();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(panel.getComponentCount() == 0) {

			JLabel lblNewLabel_2 = new JLabel("Il n'ya actuellement aucune punition dans cet etablissement");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel.add(lblNewLabel_2);
		}
	}
}