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
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class ChooseColor extends JFrame {

	public static JPanel contentPane;
	public static JButton actualiser;
	private JButton button;
	public static boolean isEmpty = false;
	public static JPanel previewPanel;
	public static JLabel className;
	public static JPanel panel;
	public static JPanel panelColors;
	public static Color backColor = new Color(240, 240, 240);
	public static Color foreColor = new Color(0, 0, 0);
	public static boolean isBackground;
	public static boolean backgroundisSelected = false;
	public static boolean foregroundisSelected = false;
	public static JButton create;
	public static JPanel backPane;
	public static JPanel frontPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseColor frame = new ChooseColor();
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
	public ChooseColor() {
		setResizable(false);
		setPreferredSize(new Dimension(400, 400));
	setTitle("");
	setBounds(100, 100, 440, 550);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(60, 60, 60));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	create = new JButton("Creer");
	create.setEnabled(false);
	create.setBorderPainted(false);
	create.setFocusPainted(false);
	create.setBackground(new Color(0, 171, 89));
	create.setForeground(Color.WHITE);
	create.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			addClassToList();
			createClassFiles(className.getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			setVisible(false);
			Class.loadClasses();
			Schedule sc = new Schedule(className.getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			sc.setVisible(true);
			
			if( Home.panelClasses.getComponentCount()!=0) {
			Home.collapseAll();
			for(int i = 0; i< Home.panelClasses.getComponentCount(); i++) {
			Group.resizeGroup(Home.panelClasses.getComponent(i));
			}
		}
		}
	});
	create.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	create.setBounds(58, 469, 120, 31);
	contentPane.add(create);
	
	actualiser = new JButton("Actualiser");
	actualiser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			changeClassColor(className.getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
			setVisible(false);
    		Class.loadClasses();
		}
	});
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
	button.setBounds(244, 469, 129, 31);
	contentPane.add(button);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(Color.WHITE);
	separator.setBounds(0, 97, 424, 12);
	contentPane.add(separator);
	
	JLabel lblPaletteDeCouleur = new JLabel("Choix des couleurs");
	lblPaletteDeCouleur.setHorizontalAlignment(SwingConstants.CENTER);
	lblPaletteDeCouleur.setForeground(Color.WHITE);
	lblPaletteDeCouleur.setFont(new Font("Roboto", Font.BOLD, 25));
	lblPaletteDeCouleur.setBounds(10, 5, 404, 31);
	contentPane.add(lblPaletteDeCouleur);
	
	JLabel lblNewLabel = new JLabel("<html>Choisissez les couleurs qui representeront cette classe, ceci est important dans l'utilisation de Bakame. Choisissez des couleurs qui se distinguent pour eviter une future confusion</html>");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setBounds(10, 39, 404, 57);
	contentPane.add(lblNewLabel);
	
	panelColors = new JPanel();
	panelColors.setBackground(new Color(60, 60, 60));
	panelColors.setBounds(10, 129, 404, 83);
	contentPane.add(panelColors);
	panelColors.setLayout(new WrapLayout(WrapLayout.LEFT, 2, 2));
	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(3, 4, 94));
	panel_2.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_2);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBackground(new Color(2, 62, 138));
	panel_3.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_3);
	
	JPanel panel_4 = new JPanel();
	panel_4.setBackground(new Color(0, 119, 182));
	panel_4.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_4);
	
	JPanel panel_5 = new JPanel();
	panel_5.setBackground(new Color(0, 150, 199));
	panel_5.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_5);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(new Color(0, 180, 216));
	panel_6.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_6);
	
	JPanel panel_7 = new JPanel();
	panel_7.setBackground(new Color(72, 202, 228));
	panel_7.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_7);
	
	JPanel panel_8 = new JPanel();
	panel_8.setBackground(new Color(144, 224, 239));
	panel_8.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_8);
	
	JPanel panel_9 = new JPanel();
	panel_9.setBackground(new Color(173, 232, 244));
	panel_9.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_9);
	
	JPanel panel_10 = new JPanel();
	panel_10.setBackground(new Color(202, 240, 248));
	panel_10.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_10);
	
	JPanel panel_11 = new JPanel();
	panel_11.setBackground(new Color(78, 168, 222));
	panel_11.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_11);
	
	JPanel panel_12 = new JPanel();
	panel_12.setBackground(new Color(83, 144, 217));
	panel_12.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_12);
	
	JPanel panel_13 = new JPanel();
	panel_13.setBackground(new Color(94, 96, 206));
	panel_13.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_13);
	
	JPanel panel_14 = new JPanel();
	panel_14.setBackground(new Color(105, 48, 195));
	panel_14.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_14);
	
	JPanel panel_15 = new JPanel();
	panel_15.setBackground(new Color(116, 0, 184));
	panel_15.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_15);
	
	JPanel panel_30 = new JPanel();
	panel_30.setBackground(new Color(8, 28, 21));
	panel_30.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_30);
	
	JPanel panel_31 = new JPanel();
	panel_31.setBackground(new Color(27, 67, 50));
	panel_31.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_31);
	
	JPanel panel_32 = new JPanel();
	panel_32.setBackground(new Color(45, 106, 79));
	panel_32.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_32);
	
	JPanel panel_33 = new JPanel();
	panel_33.setBackground(new Color(64, 145, 108));
	panel_33.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_33);
	
	JPanel panel_34 = new JPanel();
	panel_34.setBackground(new Color(82, 183, 136));
	panel_34.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_34);
	
	JPanel panel_35 = new JPanel();
	panel_35.setBackground(new Color(116, 198, 157));
	panel_35.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_35);
	
	JPanel panel_36 = new JPanel();
	panel_36.setBackground(new Color(149, 213, 178));
	panel_36.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_36);
	
	JPanel panel_37 = new JPanel();
	panel_37.setBackground(new Color(183, 228, 199));
	panel_37.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_37);
	
	JPanel panel_38 = new JPanel();
	panel_38.setBackground(new Color(216, 243, 220));
	panel_38.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_38);
	
	JPanel panel_39 = new JPanel();
	panel_39.setBackground(new Color(255, 255, 63));
	panel_39.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_39);
	
	JPanel panel_40 = new JPanel();
	panel_40.setBackground(new Color(238, 239, 32));
	panel_40.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_40);
	
	JPanel panel_41 = new JPanel();
	panel_41.setBackground(new Color(221, 223, 0));
	panel_41.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_41);
	
	JPanel panel_42 = new JPanel();
	panel_42.setBackground(new Color(212, 215, 0));
	panel_42.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_42);
	
	JPanel panel_43 = new JPanel();
	panel_43.setBackground(new Color(191, 210, 0));
	panel_43.setPreferredSize(new Dimension(25, 25));
	panelColors.add(panel_43);
	
	JPanel panel_17 = new JPanel();
	panel_17.setPreferredSize(new Dimension(25, 25));
	panel_17.setBackground(new Color(55, 6, 23));
	panelColors.add(panel_17);
	
	JPanel panel_16 = new JPanel();
	panel_16.setPreferredSize(new Dimension(25, 25));
	panel_16.setBackground(new Color(89, 13, 34));
	panelColors.add(panel_16);
	
	JPanel panel_18 = new JPanel();
	panel_18.setPreferredSize(new Dimension(25, 25));
	panel_18.setBackground(new Color(106, 4, 15));
	panelColors.add(panel_18);
	
	JPanel panel_19 = new JPanel();
	panel_19.setPreferredSize(new Dimension(25, 25));
	panel_19.setBackground(new Color(157, 2, 8));
	panelColors.add(panel_19);
	
	JPanel panel_20 = new JPanel();
	panel_20.setPreferredSize(new Dimension(25, 25));
	panel_20.setBackground(new Color(208, 0, 0));
	panelColors.add(panel_20);
	
	JPanel panel_21 = new JPanel();
	panel_21.setPreferredSize(new Dimension(25, 25));
	panel_21.setBackground(new Color(220, 47, 2));
	panelColors.add(panel_21);
	
	JPanel panel_22 = new JPanel();
	panel_22.setPreferredSize(new Dimension(25, 25));
	panel_22.setBackground(new Color(232, 93, 4));
	panelColors.add(panel_22);
	
	JPanel panel_23 = new JPanel();
	panel_23.setPreferredSize(new Dimension(25, 25));
	panel_23.setBackground(new Color(244, 140, 6));
	panelColors.add(panel_23);
	
	JPanel panel_24 = new JPanel();
	panel_24.setPreferredSize(new Dimension(25, 25));
	panel_24.setBackground(new Color(250, 163, 7));
	panelColors.add(panel_24);
	
	JPanel panel_25 = new JPanel();
	panel_25.setPreferredSize(new Dimension(25, 25));
	panel_25.setBackground(new Color(255, 186, 8));
	panelColors.add(panel_25);
	
	JPanel panel_26 = new JPanel();
	panel_26.setPreferredSize(new Dimension(25, 25));
	panel_26.setBackground(new Color(255, 205, 178));
	panelColors.add(panel_26);
	
	JPanel panel_29 = new JPanel();
	panel_29.setPreferredSize(new Dimension(25, 25));
	panel_29.setBackground(new Color(255, 204, 213));
	panelColors.add(panel_29);
	
	JPanel panel_28 = new JPanel();
	panel_28.setPreferredSize(new Dimension(25, 25));
	panel_28.setBackground(new Color(255, 179, 193));
	panelColors.add(panel_28);
	
	JPanel panel_27 = new JPanel();
	panel_27.setPreferredSize(new Dimension(25, 25));
	panel_27.setBackground(new Color(255, 143, 163));
	panelColors.add(panel_27);
	
	JLabel lblNewLabel_1 = new JLabel("Couleur de fonds (d'arriere plan)");
	lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setBounds(10, 107, 274, 18);
	contentPane.add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("Autre couleur");
	
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.setBorderPainted(false);
	btnNewButton.setFocusPainted(false);
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewButton.setBounds(140, 215, 144, 23);
	contentPane.add(btnNewButton);
	
	JLabel lblCouleurDePolice = new JLabel("Couleur de police");
	lblCouleurDePolice.setForeground(Color.WHITE);
	lblCouleurDePolice.setFont(new Font("Roboto", Font.PLAIN, 15));
	lblCouleurDePolice.setBounds(10, 249, 182, 18);
	contentPane.add(lblCouleurDePolice);
	
	panel = new JPanel();
	panel.setBackground(new Color(60, 60, 60));
	panel.setBounds(10, 269, 404, 57);
	contentPane.add(panel);
	panel.setLayout(new WrapLayout(0, 2, 2));
	
	JPanel panel_1 = new JPanel();
	panel_1.setPreferredSize(new Dimension(25, 25));
	panel_1.setBackground(new Color(33, 37, 41));
	panel.add(panel_1);
	
	JPanel panel_44 = new JPanel();
	panel_44.setPreferredSize(new Dimension(25, 25));
	panel_44.setBackground(new Color(52, 58, 64));
	panel.add(panel_44);
	
	JPanel panel_45 = new JPanel();
	panel_45.setPreferredSize(new Dimension(25, 25));
	panel_45.setBackground(new Color(60, 58, 62));
	panel.add(panel_45);
	
	JPanel panel_46 = new JPanel();
	panel_46.setPreferredSize(new Dimension(25, 25));
	panel_46.setBackground(new Color(73, 80, 87));
	panel.add(panel_46);
	
	JPanel panel_47 = new JPanel();
	panel_47.setPreferredSize(new Dimension(25, 25));
	panel_47.setBackground(new Color(108, 117, 125));
	panel.add(panel_47);
	
	JPanel panel_48 = new JPanel();
	panel_48.setPreferredSize(new Dimension(25, 25));
	panel_48.setBackground(new Color(173, 181, 189));
	panel.add(panel_48);
	
	JPanel panel_49 = new JPanel();
	panel_49.setPreferredSize(new Dimension(25, 25));
	panel_49.setBackground(new Color(206, 212, 218));
	panel.add(panel_49);
	
	JPanel panel_50 = new JPanel();
	panel_50.setPreferredSize(new Dimension(25, 25));
	panel_50.setBackground(new Color(222, 226, 230));
	panel.add(panel_50);
	
	JPanel panel_51 = new JPanel();
	panel_51.setPreferredSize(new Dimension(25, 25));
	panel_51.setBackground(new Color(233, 236, 239));
	panel.add(panel_51);
	
	JPanel panel_52 = new JPanel();
	panel_52.setPreferredSize(new Dimension(25, 25));
	panel_52.setBackground(new Color(248, 249, 250));
	panel.add(panel_52);
	
	JPanel panel_53 = new JPanel();
	panel_53.setPreferredSize(new Dimension(25, 25));
	panel_53.setBackground(new Color(234, 244, 244));
	panel.add(panel_53);
	
	JPanel panel_54 = new JPanel();
	panel_54.setPreferredSize(new Dimension(25, 25));
	panel_54.setBackground(new Color(204, 227, 222));
	panel.add(panel_54);
	
	JPanel panel_55 = new JPanel();
	panel_55.setPreferredSize(new Dimension(25, 25));
	panel_55.setBackground(new Color(164, 195, 178));
	panel.add(panel_55);
	
	JPanel panel_56 = new JPanel();
	panel_56.setPreferredSize(new Dimension(25, 25));
	panel_56.setBackground(new Color(107, 144, 128));
	panel.add(panel_56);
	
	JPanel panel_57 = new JPanel();
	panel_57.setPreferredSize(new Dimension(25, 25));
	panel_57.setBackground(new Color(102, 7, 8));
	panel.add(panel_57);
	
	JPanel panel_58 = new JPanel();
	panel_58.setPreferredSize(new Dimension(25, 25));
	panel_58.setBackground(new Color(164, 22, 26));
	panel.add(panel_58);
	
	JPanel panel_59 = new JPanel();
	panel_59.setPreferredSize(new Dimension(25, 25));
	panel_59.setBackground(new Color(186, 24, 27));
	panel.add(panel_59);
	
	JPanel panel_60 = new JPanel();
	panel_60.setPreferredSize(new Dimension(25, 25));
	panel_60.setBackground(new Color(229, 56, 59));
	panel.add(panel_60);
	
	JPanel panel_61 = new JPanel();
	panel_61.setPreferredSize(new Dimension(25, 25));
	panel_61.setBackground(new Color(255, 186, 8));
	panel.add(panel_61);
	
	JPanel panel_62 = new JPanel();
	panel_62.setPreferredSize(new Dimension(25, 25));
	panel_62.setBackground(new Color(250, 163, 7));
	panel.add(panel_62);
	
	JPanel panel_63 = new JPanel();
	panel_63.setPreferredSize(new Dimension(25, 25));
	panel_63.setBackground(new Color(244, 140, 6));
	panel.add(panel_63);
	
	JPanel panel_64 = new JPanel();
	panel_64.setPreferredSize(new Dimension(25, 25));
	panel_64.setBackground(new Color(232, 93, 4));
	panel.add(panel_64);
	
	JPanel panel_65 = new JPanel();
	panel_65.setPreferredSize(new Dimension(25, 25));
	panel_65.setBackground(new Color(0, 180, 216));
	panel.add(panel_65);
	
	JPanel panel_66 = new JPanel();
	panel_66.setPreferredSize(new Dimension(25, 25));
	panel_66.setBackground(new Color(0, 150, 199));
	panel.add(panel_66);
	
	JPanel panel_67 = new JPanel();
	panel_67.setPreferredSize(new Dimension(25, 25));
	panel_67.setBackground(new Color(0, 119, 182));
	panel.add(panel_67);
	
	JPanel panel_68 = new JPanel();
	panel_68.setPreferredSize(new Dimension(25, 25));
	panel_68.setBackground(new Color(2, 62, 138));
	panel.add(panel_68);
	
	JPanel panel_69 = new JPanel();
	panel_69.setPreferredSize(new Dimension(25, 25));
	panel_69.setBackground(new Color(3, 4, 94));
	panel.add(panel_69);
	
	JPanel panel_70 = new JPanel();
	panel_70.setPreferredSize(new Dimension(25, 25));
	panel_70.setBackground(new Color(0, 0, 0));
	panel.add(panel_70);
	
	JButton button_1 = new JButton("Autre couleur");
	button_1.setForeground(Color.BLACK);
	button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	button_1.setFocusPainted(false);
	button_1.setBorderPainted(false);
	button_1.setBackground(Color.WHITE);
	button_1.setBounds(140, 328, 144, 23);
	contentPane.add(button_1);
	
	previewPanel = new JPanel();
	previewPanel.setBounds(58, 365, 315, 86);
	contentPane.add(previewPanel);
	previewPanel.setLayout(new BorderLayout(0, 0));
	previewPanel.setBackground(backColor);
	
	className = new JLabel("<html><div style='text-align: center;'>"+NewClass.className.getText()+"</div></html>");
	className.setHorizontalAlignment(SwingConstants.CENTER);
	className.setForeground(Color.BLACK);
	className.setFont(new Font("Roboto", Font.BOLD, 20));
	className.setBorder(null);
	className.setBackground(Color.GREEN);
	className.setForeground(foreColor);
	previewPanel.add(className, BorderLayout.CENTER);
	
	backPane = new JPanel();
	backPane.setBorder(new LineBorder(Color.WHITE, 1, true));
	backPane.setPreferredSize(new Dimension(25, 25));
	backPane.setBackground(backColor);
	backPane.setBounds(350, 103, 25, 25);
	contentPane.add(backPane);
	
	frontPane = new JPanel();
	frontPane.setBorder(new LineBorder(Color.WHITE, 1, true));
	frontPane.setPreferredSize(new Dimension(25, 25));
	frontPane.setBackground(foreColor);
	frontPane.setBounds(350, 243, 25, 25);
	contentPane.add(frontPane);

	setLocationRelativeTo(null);
	
	
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			isBackground = true;
			ColorChooser.createAndShowGUI();
			ColorChooser.Jcc.setColor(previewPanel.getBackground());
		}
	});
	

	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			isBackground = false;
			ColorChooser.createAndShowGUI();
			ColorChooser.Jcc.setColor(className.getForeground());
		}
	});
	
	
	

for(int i = 0; i<panelColors.getComponentCount(); i++) {
	int k = i;
	
	panelColors.getComponent(i).addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			for(int i = 0; i<panelColors.getComponentCount(); i++) {
				((JComponent) panelColors.getComponent(i)).setBorder(null);
			}
			
			backgroundisSelected = true;
			
			if(backgroundisSelected && foregroundisSelected) {
				create.setEnabled(true);
			}else {
				create.setEnabled(false);
			}
			
			
			backColor = panelColors.getComponent(k).getBackground();
			backPane.setBackground(backColor);
			previewPanel.setBackground(backColor);
			
			List<String> colors = new ArrayList();
			colors.add(String.valueOf(panelColors.getComponent(k).getBackground().getRed()));
			colors.add(String.valueOf(panelColors.getComponent(k).getBackground().getGreen()));
			colors.add(String.valueOf(panelColors.getComponent(k).getBackground().getBlue()));
			
			int r = 0;
			int g = 0;
			int b = 0;
			
			
			if(Integer.parseInt(colors.get(0))<37) {
				r = Integer.parseInt(colors.get(0))*7;
			}else {
				r = Integer.parseInt(colors.get(0))/7;
			}if(Integer.parseInt(colors.get(1))<37) {
				g = Integer.parseInt(colors.get(1))*7;
			}else {
				g = Integer.parseInt(colors.get(1))/7;
			}if(Integer.parseInt(colors.get(2))<37) {
				b = Integer.parseInt(colors.get(2))*7;
			}else {
				b = Integer.parseInt(colors.get(2))/7;
			}
			
			if(Integer.parseInt(colors.get(0))==0 && Integer.parseInt(colors.get(1))==0||Integer.parseInt(colors.get(1))==0 &&Integer.parseInt(colors.get(2))==0
					||Integer.parseInt(colors.get(0))==0 && Integer.parseInt(colors.get(2))==0) {

			r = 255;
			g = 255;
			b = 255;
			}
			
			
			((JComponent) panelColors.getComponent(k)).setBorder(new LineBorder(new Color(r, g, b), 3));
			
		}});
	}
	

for(int i = 0; i<panel.getComponentCount(); i++) {
	int k = i;
	
	panel.getComponent(i).addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			for(int i = 0; i<panel.getComponentCount(); i++) {
				((JComponent) panel.getComponent(i)).setBorder(null);
			}
			
			
			foregroundisSelected = true;
			
			if(backgroundisSelected && foregroundisSelected) {
				create.setEnabled(true);
			}else {
				create.setEnabled(false);
			}
			
			foreColor = panel.getComponent(k).getBackground();
			frontPane.setBackground(foreColor);
			className.setForeground(foreColor);
			
			List<String> colors = new ArrayList();
			colors.add(String.valueOf(panel.getComponent(k).getBackground().getRed()));
			colors.add(String.valueOf(panel.getComponent(k).getBackground().getGreen()));
			colors.add(String.valueOf(panel.getComponent(k).getBackground().getBlue()));
			
			int r = 0;
			int g = 0;
			int b = 0;
			
			
			if(Integer.parseInt(colors.get(0))<37) {
				r = Integer.parseInt(colors.get(0))*7;
			}else {
				r = Integer.parseInt(colors.get(0))/7;
			}if(Integer.parseInt(colors.get(1))<37) {
				g = Integer.parseInt(colors.get(1))*7;
			}else {
				g = Integer.parseInt(colors.get(1))/7;
			}if(Integer.parseInt(colors.get(2))<37) {
				b = Integer.parseInt(colors.get(2))*7;
			}else {
				b = Integer.parseInt(colors.get(2))/7;
			}
			
			if(Integer.parseInt(colors.get(0))==0 && Integer.parseInt(colors.get(1))==0||Integer.parseInt(colors.get(1))==0 &&Integer.parseInt(colors.get(2))==0
					||Integer.parseInt(colors.get(0))==0 && Integer.parseInt(colors.get(2))==0) {

			r = 255;
			g = 255;
			b = 255;
			}

			((JComponent) panel.getComponent(k)).setBorder(new LineBorder(new Color(r, g, b), 3));
			
		}
	});
	}
	
	
}
	
	

	public static void changeClassColor(String className) {

		List<String> comp = new ArrayList();
		
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
	
	try {
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		Object[] lines = br.lines().toArray();

		for(int i = 0; i< lines.length; i++) {
				comp.add(lines[i].toString());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	for(int i = 0; i< comp.toArray().length; i++) {
		List l = Arrays.asList(comp.get(i).split("//"));
		String s = className.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")+"//"+backColor.getRed()+","+backColor.getGreen()+","+backColor.getBlue()
		+"//"+foreColor.getRed()+","+foreColor.getGreen()+","+foreColor.getBlue()+"//"+l.get(3).toString()+"//"+l.get(4).toString()+"//"+l.get(5).toString();
		if(l.get(0).toString().equals(className)) {
			comp.add(i, s);
			comp.remove(i+1);
		}
	}
	
	
	if(file.exists()) {
				file.delete();
			}
	
		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);

			for(int j = 0;j<comp.toArray().length;j++) {
			pw.println((String)comp.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file.getPath());
		
	
		
	}
	
	public static void addClassToList() {
		
		String ed;
		if(NewClass.checkBox.isSelected()) {
			ed = NewClass.textField.getText();
		}else {
			ed = "none";
		}
		Class.classList.add(className.getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")+"//"+backColor.getRed()+","+backColor.getGreen()+","+backColor.getBlue()
		+"//"+foreColor.getRed()+","+foreColor.getGreen()+","+foreColor.getBlue()+"//"+ed+"//none//active");
		
	File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
	
	if(file.exists()) {
				file.delete();
			}
	
		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);

			for(int j = 0;j<Class.classList.toArray().length;j++) {
			pw.println((String)Class.classList.get(j));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file.getPath());
		
	}
}