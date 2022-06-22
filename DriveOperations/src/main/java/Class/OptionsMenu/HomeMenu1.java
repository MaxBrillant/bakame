package Class.OptionsMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Application.Class;
import Application.Home;
import Application.NewClass;
import Application.NewGroup;
import Application.ResizeImages;
import Class.Application;
import Class.NewPane;
import Class.NewStudent;
import Class.Student;
import CloudOperations.aws;
import Publishing.NewPublication;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HomeMenu1 extends JPanel {
	public static JPanel panel;

	/**
	 * Create the panel.
	 */
	public HomeMenu1(String ay_id) {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(1366, 70));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 70));
		add(scrollPane, BorderLayout.CENTER);

		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUI(new CustomHorizontalScrollBarUI());
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40).darker());
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		

		scrollPane.getHorizontalScrollBar().setBackground(panel.getBackground());
		
		JButton add = new JButton("") {
			public Point getToolTipLocation(MouseEvent e) {
				return new Point(getWidth() /2, getHeight());
				
			}
			public Point getToolTipSize(MouseEvent e) {
				return new Point(100, 70);
				
			}
		};
		add.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\AddIcon.png"));
		add.setPreferredSize(new Dimension(50, 50));
		add.setVerticalTextPosition(SwingConstants.BOTTOM);
		add.setIconTextGap(0);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("Roboto", Font.PLAIN, 12));
		add.setFocusPainted(false);
		add.setBorder(null);
		add.setBackground(panel.getBackground());
		panel.add(add);
		Home.addToolTip(add, "Ajouter");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClass nc = new NewClass();
				nc.setVisible(true);
				nc.create.setVisible(true);
				nc.actualiser.setVisible(false);
			}
		});
		
		JButton edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Class.selectedClasses.toArray().length==1) {
				NewClass nc = new NewClass();
				nc.className.setText(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
						.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				nc.setVisible(true);
				String s = NewClass.loadClassEducation(((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText()
						.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				if(s.equals("none")) {
					nc.checkBox.setSelected(false);
					nc.textField.setText("");
					nc.textField.setEnabled(false);
				}else {
					nc.checkBox.setSelected(true);
					nc.textField.setText(s);
					nc.textField.setEnabled(true);
				}
				nc.create.setVisible(false);
				nc.actualiser.setVisible(true);
				}}
		});
		edit.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\iconedit.png"));
		edit.setPreferredSize(new Dimension(50, 50));
		edit.setVerticalTextPosition(SwingConstants.BOTTOM);
		edit.setIconTextGap(0);
		edit.setHorizontalTextPosition(SwingConstants.CENTER);
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Roboto", Font.PLAIN, 12));
		edit.setFocusPainted(false);
		edit.setBorder(null);
		edit.setBackground(panel.getBackground());
		panel.add(edit);
		Home.addToolTip(edit, "Modifier");
		
		JButton delete = new JButton("");
		delete.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\icondelete.png"));
		delete.setPreferredSize(new Dimension(50, 50));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setIconTextGap(0);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Roboto", Font.PLAIN, 12));
		delete.setFocusPainted(false);
		delete.setBorder(null);
		delete.setBackground(panel.getBackground());
		panel.add(delete);
		Home.addToolTip(delete, "Supprimer");
		
		JButton publish = new JButton("");
		publish.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\regroup.png"));
		publish.setVerticalTextPosition(SwingConstants.BOTTOM);
		publish.setHorizontalTextPosition(SwingConstants.CENTER);
		publish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGroup ng = new NewGroup();
				ng.setVisible(true);
				ng.actualiser.setVisible(false);

				ng.create.setVisible(true);
			}
		});
		Home.addToolTip(publish, "Grouper");
		
		JButton btnPublier = new JButton("");
		btnPublier.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\Send.png"));
		btnPublier.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPublier.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPublier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPublication np = new NewPublication();
				np.setVisible(true);
			}
		});
		btnPublier.setPreferredSize(new Dimension(50, 50));
		btnPublier.setIconTextGap(0);
		btnPublier.setForeground(Color.WHITE);
		btnPublier.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnPublier.setFocusPainted(false);
		btnPublier.setBorderPainted(false);
		btnPublier.setBackground(panel.getBackground());
		panel.add(btnPublier);

		Home.addToolTip(btnPublier, "Publier");
		
		publish.setIconTextGap(0);
		publish.setForeground(new Color(255, 255, 255));
		publish.setPreferredSize(new Dimension(50, 50));
		publish.setFont(new Font("Roboto", Font.PLAIN, 12));
		publish.setFocusPainted(false);
		publish.setBorderPainted(false);
		publish.setBackground(panel.getBackground());
		panel.add(publish);
		
		JButton btnMonter = new JButton("");
		btnMonter.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_up.png"));
		btnMonter.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMonter.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMonter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
				goUp (((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				Class.loadClasses(Home.periodText.get(Home.selectedPeriod), ay_id);
				System.out.println(i);
				((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(i);}
		});
		btnMonter.setPreferredSize(new Dimension(50, 50));
		btnMonter.setIconTextGap(0);
		btnMonter.setForeground(Color.WHITE);
		btnMonter.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnMonter.setFocusPainted(false);
		btnMonter.setBorderPainted(false);
		btnMonter.setBackground(panel.getBackground());
		panel.add(btnMonter);
		Home.addToolTip(btnMonter, "Monter");
		
		JButton btnMonter_1 = new JButton("");
		btnMonter_1.setIcon(ResizeImages.resize(37, 37, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\go_down.png"));
		btnMonter_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMonter_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMonter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
				goDown (((JLabel) ((Container) ((Container) Class.selectedClasses.get(0)).getComponent(0)).getComponent(0)).getText().replace("<html><div style='text-align: center;'>", "").replace("</div></html>", ""));
				Class.loadClasses(Home.periodText.get(Home.selectedPeriod), ay_id);
				((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(i);
			
			}
		});
		btnMonter_1.setPreferredSize(new Dimension(50, 50));
		btnMonter_1.setIconTextGap(0);
		btnMonter_1.setForeground(Color.WHITE);
		btnMonter_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnMonter_1.setFocusPainted(false);
		btnMonter_1.setBorderPainted(false);
		btnMonter_1.setBackground(panel.getBackground());
		panel.add(btnMonter_1);
		Home.addToolTip(btnMonter_1, "Descendre");
		
		deselect();
		
		for(int i = 0;i<panel.getComponentCount(); i++) {
			int j = i;
			panel.getComponent(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					panel.getComponent(j).setBackground(new Color(60, 60, 60));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panel.getComponent(j).setBackground(panel.getBackground());
				}
				
			});
		}
	}
	
	

	public static void goUp (String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
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
		
		boolean done = false;
		for(int i = 0; i< comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(className)) {
				String group = l.get(4).toString();
				List l2 = Arrays.asList(comp.get(i-1).toString().split("//"));
				if(l2.get(4).equals(group)) {
					comp.add(i-1, comp.get(i));
					comp.remove(i+1);
					break;
				}else {
					if(!group.equals("none")) {
				for(int j = i-1; j>= 0; j--) {
					List l1 = Arrays.asList(comp.get(j).toString().split("//"));
					if(l1.get(4).toString().equals(group)) {
						comp.add(j, comp.get(i));
						comp.remove(i+1);
						break;
					}
				}}else {
					String group1 = l2.get(4).toString();
					for(int j = i-2; j>= 0; j--) {
						List l1 = Arrays.asList(comp.get(j).toString().split("//"));
						if(!l1.get(4).toString().equals(group1)) {
							if(!l1.get(4).toString().equals(group)){
							comp.add(j+1, comp.get(i));
							comp.remove(i+1);
							done = true;
							break;
						}else{
							comp.add(j+1, comp.get(i));
							comp.remove(i+1);
							done = true;
							break;
						}}
					}
					if(!done) {
						comp.add(0, comp.get(i));
						comp.remove(i+1);
						break;
					}
				}
				}
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
	
	
	
	
	public static void goDown (String className) {

		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		aws.downloadContent(file.getPath());
		List<String> comp = new ArrayList();
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
		boolean done = false;
		
		for(int i = 0; i< comp.toArray().length; i++) {
			List l = Arrays.asList(comp.get(i).toString().split("//"));
			if(l.get(0).toString().equals(className)) {
				String group = l.get(4).toString();
				List l2 = Arrays.asList(comp.get(i+1).toString().split("//"));
				if(l2.get(4).equals(group)) {
					comp.add(i+2, comp.get(i));
					comp.remove(i);
					break;
				}else {
					if(!group.equals("none")) {
				for(int j = i+2; j< comp.toArray().length; j++) {
					List l1 = Arrays.asList(comp.get(j).toString().split("//"));
					if(l1.get(4).toString().equals(group)) {
						comp.add(j, comp.get(i));
						comp.remove(i);
						break;
					}
				}}else {

					if(!done) {
					String group1 = l2.get(4).toString();
					for(int j = i+2 ; j< comp.toArray().length; j++) {
						List l1 = Arrays.asList(comp.get(j).toString().split("//"));
						if(!l1.get(4).toString().equals(group1)) {
							String s = comp.get(i);
							comp.add(j, s);

							System.out.println("+++++++++++++++++++++++++++++");
							for(int k = 0; k< comp.toArray().length; k++) {
								System.out.println(comp.get(k));
							}
							comp.remove(i);
							

							System.out.println("+++++++++++++++++++++++++++++");
							for(int k = 0; k< comp.toArray().length; k++) {
								System.out.println(comp.get(k));
							}
							done = true;
							
							if(file.exists()) {
								file.delete();
							}

						try {
							file.createNewFile();
							PrintWriter pw = new PrintWriter(file);

							for(int j1 = 0;j1<comp.toArray().length;j1++) {
							pw.println((String)comp.get(j1));
							};
							
							pw.close();
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
						aws.upload(file.getPath());
						
						break;
						}}
					
					
				}
					if(!done) {
						String s = comp.get(i);
						comp.add(s);

						System.out.println("+++++++++++++++++++++++++++++");
						for(int k = 0; k< comp.toArray().length; k++) {
							System.out.println(comp.get(k));
						}
						comp.remove(i);
						

						System.out.println("+++++++++++++++++++++++++++++");
						for(int k = 0; k< comp.toArray().length; k++) {
							System.out.println(comp.get(k));
						}
						done = true;
						
						if(file.exists()) {
							file.delete();
						}

					try {
						file.createNewFile();
						PrintWriter pw = new PrintWriter(file);

						for(int j1 = 0;j1<comp.toArray().length;j1++) {
						pw.println((String)comp.get(j1));
						};
						
						pw.close();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
					aws.upload(file.getPath());
					
					break;
					
					}
				}}
			}
		}
		
		if(!done) {
			if(file.exists()) {
				file.delete();
			}

		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);

			for(int j1 = 0;j1<comp.toArray().length;j1++) {
			pw.println((String)comp.get(j1));
			};
			
			pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		aws.upload(file.getPath());
		
		}
}
	
	public static void deselect() {
		HomeMenu1.panel.getComponent(1).setVisible(false);
		HomeMenu1.panel.getComponent(2).setVisible(false);
		HomeMenu1.panel.getComponent(4).setVisible(false);
		HomeMenu1.panel.getComponent(5).setVisible(false);
		HomeMenu1.panel.getComponent(6).setVisible(false);
		
	}
}
