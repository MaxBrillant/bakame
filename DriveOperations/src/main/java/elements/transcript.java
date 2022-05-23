package elements;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.io.File;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CloudOperations.Mongo;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class transcript extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transcript frame = new transcript();
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
	public transcript() {
		setPreferredSize(new Dimension(1920, 1080));
		setPreferredSize(new Dimension(1200, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 700);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1000, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ECOLE INTERNATIONALE DE BUJUMBURA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 17));
		lblNewLabel.setBounds(395, 11, 393, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOM ET PRENOM: NDASHIMYE Max BrIllant");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 39, 297, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNo = new JLabel("No  18");
		lblNo.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNo.setBounds(550, 39, 69, 22);
		contentPane.add(lblNo);
		
		JLabel lblAnneeScolaire = new JLabel("ANNEE SCOLAIRE: 2019-2020");
		lblAnneeScolaire.setFont(new Font("Roboto", Font.BOLD, 14));
		lblAnneeScolaire.setBounds(780, 39, 210, 22);
		contentPane.add(lblAnneeScolaire);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 72, 1146, 580);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK, 2));
		panel_1.setBackground(Color.ORANGE);
		panel_1.setPreferredSize(new Dimension(210, 300));
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setPreferredSize(new Dimension(210, 70));
		panel_1.add(panel_6);
		
		JLabel lblFormationPatriotiqueEt = new JLabel("<html>14. Comptabilite Generale</html>");
		lblFormationPatriotiqueEt.setPreferredSize(new Dimension(210, 30));
		lblFormationPatriotiqueEt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormationPatriotiqueEt.setFont(new Font("Roboto", Font.BOLD, 12));
		lblFormationPatriotiqueEt.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(lblFormationPatriotiqueEt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLACK, 2));
		panel_2.setPreferredSize(new Dimension(180, 300));
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(180, 70));
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Maxima");
		lblNewLabel_2.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setPreferredSize(new Dimension(46, 30));
		panel_7.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("TJ.");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_3.setPreferredSize(new Dimension(41, 0));
		panel_7.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("TOT.");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4.setPreferredSize(new Dimension(45, 0));
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_7.add(lblNewLabel_4, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("EX.");
		lblNewLabel_5.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_5.setPreferredSize(new Dimension(46, 20));
		panel_8.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("COM.");
		lblNewLabel_6.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_6.setPreferredSize(new Dimension(38, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_8.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("RES.");
		lblNewLabel_7.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_7.setPreferredSize(new Dimension(47, 58));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_8.add(lblNewLabel_7, BorderLayout.EAST);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_14.setPreferredSize(new Dimension(41, 230));
		panel_2.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("241,5");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setPreferredSize(new Dimension(41, 30));
		lblNewLabel_9.setFont(new Font("Handlee", Font.BOLD, 15));
		panel_14.add(lblNewLabel_9);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_15.setPreferredSize(new Dimension(47, 230));
		panel_2.add(panel_15);
		panel_15.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_1 = new JLabel("247,5");
		label_1.setPreferredSize(new Dimension(47, 30));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Handlee", Font.BOLD, 15));
		label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_15.add(label_1);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_16.setPreferredSize(new Dimension(47, 230));
		panel_2.add(panel_16);
		panel_16.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_5 = new JLabel("241,5");
		label_5.setPreferredSize(new Dimension(47, 30));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Handlee", Font.BOLD, 15));
		label_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_16.add(label_5);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_17.setPreferredSize(new Dimension(41, 230));
		panel_2.add(panel_17);
		panel_17.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_6 = new JLabel("241,5");
		label_6.setPreferredSize(new Dimension(41, 30));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Handlee", Font.BOLD, 15));
		label_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_17.add(label_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLACK, 2));
		panel_3.setPreferredSize(new Dimension(180, 300));
		panel_3.setBackground(Color.ORANGE);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_71 = new JPanel();
		panel_71.setPreferredSize(new Dimension(180, 70));
		panel_3.add(panel_71);
		panel_71.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_21 = new JLabel("1er Trimestre");
		lblNewLabel_21.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_21.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_21.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setPreferredSize(new Dimension(46, 30));
		panel_71.add(lblNewLabel_21, BorderLayout.NORTH);
		
		JLabel lblNewLabel_31 = new JLabel("TJ.");
		lblNewLabel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_31.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_31.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_31.setPreferredSize(new Dimension(41, 0));
		panel_71.add(lblNewLabel_31, BorderLayout.WEST);
		
		JLabel lblNewLabel_41 = new JLabel("TOT.");
		lblNewLabel_41.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_41.setPreferredSize(new Dimension(45, 0));
		lblNewLabel_41.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_41.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_71.add(lblNewLabel_41, BorderLayout.EAST);
		
		JPanel panel_81 = new JPanel();
		panel_71.add(panel_81, BorderLayout.CENTER);
		panel_81.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_51 = new JLabel("EX.");
		lblNewLabel_51.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_51.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_51.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_51.setPreferredSize(new Dimension(46, 20));
		panel_81.add(lblNewLabel_51, BorderLayout.NORTH);
		
		JLabel lblNewLabel_61 = new JLabel("COM.");
		lblNewLabel_61.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_61.setPreferredSize(new Dimension(38, 14));
		lblNewLabel_61.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_61.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_81.add(lblNewLabel_61, BorderLayout.CENTER);
		
		JLabel lblNewLabel_71 = new JLabel("RES.");
		lblNewLabel_71.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_71.setPreferredSize(new Dimension(47, 58));
		lblNewLabel_71.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_71.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_81.add(lblNewLabel_71, BorderLayout.EAST);
		
		JPanel panel_18 = new JPanel();
		panel_18.setPreferredSize(new Dimension(41, 230));
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_18);
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_7 = new JLabel("241,5");
		label_7.setPreferredSize(new Dimension(41, 30));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Handlee", Font.BOLD, 15));
		label_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_18.add(label_7);
		
		JPanel panel_19 = new JPanel();
		panel_19.setPreferredSize(new Dimension(47, 230));
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_8 = new JLabel("241,5");
		label_8.setPreferredSize(new Dimension(47, 30));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Handlee", Font.BOLD, 15));
		label_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_19.add(label_8);
		
		JPanel panel_20 = new JPanel();
		panel_20.setPreferredSize(new Dimension(47, 230));
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_20);
		panel_20.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_9 = new JLabel("241,5");
		label_9.setPreferredSize(new Dimension(47, 30));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Handlee", Font.BOLD, 15));
		label_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_20.add(label_9);
		
		JPanel panel_21 = new JPanel();
		panel_21.setPreferredSize(new Dimension(41, 230));
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_21);
		panel_21.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_10 = new JLabel("241,5");
		label_10.setPreferredSize(new Dimension(41, 30));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Handlee", Font.BOLD, 15));
		label_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_21.add(label_10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.BLACK, 2));
		panel_4.setPreferredSize(new Dimension(180, 300));
		panel_4.setBackground(Color.ORANGE);
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		
		JPanel panel_711 = new JPanel();
		panel_711.setPreferredSize(new Dimension(180, 70));
		panel_4.add(panel_711);
		panel_711.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_211 = new JLabel("2eme Trimestre");
		lblNewLabel_211.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_211.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_211.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_211.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_211.setPreferredSize(new Dimension(46, 30));
		panel_711.add(lblNewLabel_211, BorderLayout.NORTH);
		
		JLabel lblNewLabel_311 = new JLabel("TJ.");
		lblNewLabel_311.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_311.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_311.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_311.setPreferredSize(new Dimension(41, 0));
		panel_711.add(lblNewLabel_311, BorderLayout.WEST);
		
		JLabel lblNewLabel_411 = new JLabel("TOT.");
		lblNewLabel_411.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_411.setPreferredSize(new Dimension(45, 0));
		lblNewLabel_411.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_411.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_711.add(lblNewLabel_411, BorderLayout.EAST);
		
		JPanel panel_811 = new JPanel();
		panel_711.add(panel_811, BorderLayout.CENTER);
		panel_811.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_511 = new JLabel("EX.");
		lblNewLabel_511.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_511.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_511.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_511.setPreferredSize(new Dimension(46, 20));
		panel_811.add(lblNewLabel_511, BorderLayout.NORTH);
		
		JLabel lblNewLabel_611 = new JLabel("COM.");
		lblNewLabel_611.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_611.setPreferredSize(new Dimension(38, 14));
		lblNewLabel_611.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_611.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_811.add(lblNewLabel_611, BorderLayout.CENTER);
		
		JLabel lblNewLabel_711 = new JLabel("RES.");
		lblNewLabel_711.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_711.setPreferredSize(new Dimension(47, 58));
		lblNewLabel_711.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_711.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_811.add(lblNewLabel_711, BorderLayout.EAST);
		
		JPanel panel_22 = new JPanel();
		panel_22.setPreferredSize(new Dimension(41, 230));
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_22);
		panel_22.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_11 = new JLabel("241,5");
		label_11.setPreferredSize(new Dimension(41, 30));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Handlee", Font.BOLD, 15));
		label_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_22.add(label_11);
		
		JPanel panel_23 = new JPanel();
		panel_23.setPreferredSize(new Dimension(47, 230));
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_23);
		panel_23.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_12 = new JLabel("241,5");
		label_12.setPreferredSize(new Dimension(47, 30));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Handlee", Font.BOLD, 15));
		label_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_23.add(label_12);
		
		JPanel panel_24 = new JPanel();
		panel_24.setPreferredSize(new Dimension(47, 230));
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_24);
		panel_24.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_13 = new JLabel("241,5");
		label_13.setPreferredSize(new Dimension(47, 30));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Handlee", Font.BOLD, 15));
		label_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_24.add(label_13);
		
		JPanel panel_25 = new JPanel();
		panel_25.setPreferredSize(new Dimension(41, 230));
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_25);
		panel_25.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_14 = new JLabel("241,5");
		label_14.setPreferredSize(new Dimension(41, 30));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Handlee", Font.BOLD, 15));
		label_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_25.add(label_14);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.BLACK, 2));
		panel_5.setPreferredSize(new Dimension(180, 300));
		panel_5.setBackground(Color.ORANGE);
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		
		JPanel panel_7111 = new JPanel();
		panel_7111.setPreferredSize(new Dimension(180, 70));
		panel_5.add(panel_7111);
		panel_7111.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2111 = new JLabel("3eme Trimestre");
		lblNewLabel_2111.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_2111.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_2111.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2111.setPreferredSize(new Dimension(46, 30));
		panel_7111.add(lblNewLabel_2111, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3111 = new JLabel("TJ.");
		lblNewLabel_3111.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3111.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3111.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_3111.setPreferredSize(new Dimension(41, 0));
		panel_7111.add(lblNewLabel_3111, BorderLayout.WEST);
		
		JLabel lblNewLabel_4111 = new JLabel("TOT.");
		lblNewLabel_4111.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4111.setPreferredSize(new Dimension(45, 0));
		lblNewLabel_4111.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4111.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_7111.add(lblNewLabel_4111, BorderLayout.EAST);
		
		JPanel panel_8111 = new JPanel();
		panel_7111.add(panel_8111, BorderLayout.CENTER);
		panel_8111.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5111 = new JLabel("EX.");
		lblNewLabel_5111.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_5111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5111.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_5111.setPreferredSize(new Dimension(46, 20));
		panel_8111.add(lblNewLabel_5111, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6111 = new JLabel("COM.");
		lblNewLabel_6111.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_6111.setPreferredSize(new Dimension(38, 14));
		lblNewLabel_6111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6111.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_8111.add(lblNewLabel_6111, BorderLayout.CENTER);
		
		JLabel lblNewLabel_7111 = new JLabel("RES.");
		lblNewLabel_7111.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel_7111.setPreferredSize(new Dimension(47, 50));
		lblNewLabel_7111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7111.setFont(new Font("Roboto", Font.BOLD, 14));
		panel_8111.add(lblNewLabel_7111, BorderLayout.EAST);
		
		JPanel panel_26 = new JPanel();
		panel_26.setPreferredSize(new Dimension(41, 230));
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_26);
		panel_26.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_15 = new JLabel("241,5");
		label_15.setPreferredSize(new Dimension(41, 30));
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Handlee", Font.BOLD, 15));
		label_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_26.add(label_15);
		
		JPanel panel_27 = new JPanel();
		panel_27.setPreferredSize(new Dimension(47, 230));
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_27);
		panel_27.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_16 = new JLabel("241,5");
		label_16.setPreferredSize(new Dimension(47, 30));
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Handlee", Font.BOLD, 15));
		label_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_27.add(label_16);
		
		JPanel panel_28 = new JPanel();
		panel_28.setPreferredSize(new Dimension(47, 230));
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_28);
		panel_28.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_17 = new JLabel("241,5");
		label_17.setPreferredSize(new Dimension(47, 30));
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Handlee", Font.BOLD, 15));
		label_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_28.add(label_17);
		
		JPanel panel_29 = new JPanel();
		panel_29.setPreferredSize(new Dimension(41, 230));
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_29);
		panel_29.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_18 = new JLabel("241,5");
		label_18.setPreferredSize(new Dimension(41, 30));
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Handlee", Font.BOLD, 15));
		label_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_29.add(label_18);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(200, 300));
		panel_9.setBorder(new LineBorder(Color.BLACK, 2));
		panel_9.setBackground(Color.ORANGE);
		panel.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(198, 70));
		panel_9.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTotauxAnnuels = new JLabel("Totaux annuels");
		lblTotauxAnnuels.setVerticalAlignment(SwingConstants.TOP);
		lblTotauxAnnuels.setPreferredSize(new Dimension(46, 30));
		lblTotauxAnnuels.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotauxAnnuels.setFont(new Font("Roboto", Font.BOLD, 14));
		lblTotauxAnnuels.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.add(lblTotauxAnnuels, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setPreferredSize(new Dimension(10, 20));
		panel_11.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("Max AN.");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setPreferredSize(new Dimension(66, 14));
		panel_12.add(lblNewLabel_8, BorderLayout.WEST);
		
		JLabel label = new JLabel("%");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto", Font.BOLD, 14));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(66, 14));
		panel_12.add(label, BorderLayout.EAST);
		
		JLabel lblTotGen = new JLabel("TOT.GEN.");
		lblTotGen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotGen.setFont(new Font("Roboto", Font.BOLD, 14));
		lblTotGen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.add(lblTotGen, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_2.setPreferredSize(new Dimension(66, 0));
		panel_13.add(label_2, BorderLayout.EAST);
		
		JLabel label_3 = new JLabel("");
		label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_3.setPreferredSize(new Dimension(66, 0));
		panel_13.add(label_3, BorderLayout.WEST);
		
		JLabel label_4 = new JLabel("");
		label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.add(label_4, BorderLayout.CENTER);
		
		JPanel panel_30 = new JPanel();
		panel_30.setPreferredSize(new Dimension(66, 230));
		panel_30.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.add(panel_30);
		panel_30.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_19 = new JLabel("241,5");
		label_19.setPreferredSize(new Dimension(66, 30));
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Handlee", Font.BOLD, 15));
		label_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_30.add(label_19);
		
		JPanel panel_31 = new JPanel();
		panel_31.setPreferredSize(new Dimension(66, 230));
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.add(panel_31);
		panel_31.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_20 = new JLabel("241,5");
		label_20.setPreferredSize(new Dimension(66, 30));
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("Handlee", Font.BOLD, 15));
		label_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_31.add(label_20);
		
		JPanel panel_32 = new JPanel();
		panel_32.setPreferredSize(new Dimension(64, 230));
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.add(panel_32);
		panel_32.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel label_21 = new JLabel("241,5");
		label_21.setPreferredSize(new Dimension(66, 30));
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Handlee", Font.BOLD, 15));
		label_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_32.add(label_21);
		

		//Mongo.PrintFrameToPDF(getComponent(0).getParent(), new File("C:/Users/User/Desktop/test.pdf"));
	}
}
