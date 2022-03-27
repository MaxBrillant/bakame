package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Stats.StatsPane;
import Stats.StudentStats;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;
import app.WrapLayout;

import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;

import Application.Home;
import Class.TestBox;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class AddToGroup extends JFrame {

	private JPanel contentPane;
	public static List<String> classes = new ArrayList();
	public static List<String> selectedClass = new ArrayList();
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddToGroup frame = new AddToGroup("3eme PF Economique");
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
	public AddToGroup(String groupId) {
		setResizable(false);
		setBounds(100, 100, 385, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 60, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		JButton btnOk = new JButton("Ajouter");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = ((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().getValue();
				for(int i = 0; i< selectedClass.toArray().length; i++) {
					changeGroup(selectedClass.get(i), groupName);
				}


				Class.loadClasses();

				if( Home.panelClasses.getComponentCount()!=0) {
				Home.collapseAll();
				for(int i1 = 0; i1< Home.panelClasses.getComponentCount(); i1++) {
				Group.resizeGroup(Home.panelClasses.getComponent(i1));
				}
				}
				((JScrollPane) Home.panelClasses.getParent().getParent()).getVerticalScrollBar().setValue(j); 
				setVisible(false);
			}
		});
		btnOk.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setBounds(33, 518, 135, 32);
		contentPane.add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setBorderPainted(false);
		btnAnnuler.setBounds(200, 518, 135, 32);
		contentPane.add(btnAnnuler);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 15));
		tabbedPane.setBounds(5, 94, 359, 413);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Classes existantes", null, scrollPane, null);
		scrollPane.setBorder(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(40, 40, 40));
		scrollPane.setViewportView(panel);
		panel.setLayout(new WrapLayout(WrapLayout.CENTER, 1, 1));
		
		JLabel lblNdashimyeMaxBrillant = new JLabel();
		lblNdashimyeMaxBrillant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNdashimyeMaxBrillant.setForeground(Color.WHITE);
		lblNdashimyeMaxBrillant.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNdashimyeMaxBrillant.setBounds(5, 11, 359, 32);
		contentPane.add(lblNdashimyeMaxBrillant);
		
		JLabel lblsele = new JLabel("<html><div style='text-align: center;'>Selectionnez les classes que vous voulez ajouter dans ce groupe de classes.</div></html>");
		lblsele.setHorizontalAlignment(SwingConstants.CENTER);
		lblsele.setForeground(Color.WHITE);
		lblsele.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblsele.setBounds(10, 31, 349, 65);
		contentPane.add(lblsele);
		
		JLabel lblemeEconoique = new JLabel(Class.getParentName(groupId));
		lblemeEconoique.setHorizontalAlignment(SwingConstants.CENTER);
		lblemeEconoique.setForeground(Color.WHITE);
		lblemeEconoique.setFont(new Font("Roboto", Font.BOLD, 23));
		lblemeEconoique.setBounds(10, 0, 349, 39);
		contentPane.add(lblemeEconoique);
		
		populateCourseList();
	}
	

public static void populateCourseList() {
	panel.removeAll();
	selectedClass.clear();
		JCheckBox checkBox = new JCheckBox("All");
		checkBox.setPreferredSize(new Dimension(350, 23));
		checkBox.setMargin(new Insets(10, 10, 2, 2));
		checkBox.setFont(new Font("Roboto", Font.PLAIN, 18));
		checkBox.setBackground(new Color(60, 60, 60));
		checkBox.setForeground(Color.white);
		checkBox.setFocusPainted(false);
		checkBox.setBorder(null);
		panel.add(checkBox);
		
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					selectAll();
				}	else {
					deselectAll();
				}
				
			}
		});
		
	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
	
	FileReader fr1;
	try {
		fr1 = new FileReader(file1);
	
	
	BufferedReader br1 = new BufferedReader(fr1);
	Object[] lines1 = Home.loadActiveClasses(file1.getPath());
	
	for(int i = 0; i< lines1.length; i++) {
		List parts = Arrays.asList(lines1[i].toString().split("//"));
		if(parts.get(4).equals("none")) {

		JCheckBox checkBox1 = new JCheckBox(parts.get(0).toString());
		checkBox1.setPreferredSize(new Dimension(350, 23));
		checkBox1.setMargin(new Insets(10, 10, 2, 2));
		checkBox1.setFont(new Font("Roboto", Font.PLAIN, 18));
		checkBox1.setBackground(new Color(60, 60, 60));
		checkBox1.setForeground(Color.white);
		checkBox1.setFocusPainted(false);
		checkBox1.setBorder(null);
		panel.add(checkBox1);
	}}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		if(selectedClass.contains(((JCheckBox) panel.getComponent(i)).getText())) {
			((JCheckBox) panel.getComponent(i)).setSelected(true);
		}
	}
	
	
	
	for(int i = 0; i< panel.getComponentCount(); i++) {
		int k = i;
	((JCheckBox) panel.getComponent(i)).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if( k > 0) {
			if(((JCheckBox) panel.getComponent(k)).isSelected()) {
				selectedClass.add(((JCheckBox) panel.getComponent(k)).getText());
			}else {
				for(int j = 0; j< selectedClass.toArray().length; j++) {
					if(selectedClass.get(j).equals(((JCheckBox) panel.getComponent(k)).getText())) {
						selectedClass.remove(j);
					}
				}
			}
			}
			else {
				if(((JCheckBox) panel.getComponent(0)).isSelected()) {

					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedClass.contains(((JCheckBox) panel.getComponent(i)).getText())) {
							selectedClass.remove(((JCheckBox) panel.getComponent(i)).getText());
				}}
				for(int i = 1; i< panel.getComponentCount(); i++) {
					selectedClass.add(((JCheckBox) panel.getComponent(i)).getText());
				}
				}else {
					for(int i = 1; i< panel.getComponentCount(); i++) {
						if(selectedClass.contains(((JCheckBox) panel.getComponent(i)).getText())) {
							selectedClass.remove(((JCheckBox) panel.getComponent(i)).getText());
				}}
				}
			}
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			//PersonalMessage.loadStudents(selectedStudents);
			
			for(int j = 0; j< selectedClass.toArray().length; j++) {
				System.out.println(selectedClass.get(j));
				}
		}
	});
	}
	panel.revalidate();
	panel.repaint();

	}


public static void selectAll() {
	for(int i =1; i< panel.getComponentCount(); i++) {
		((JCheckBox) panel.getComponent(i)).setSelected(true);
	}
}public static void deselectAll() {
	for(int i =1; i< panel.getComponentCount(); i++) {
		((JCheckBox) panel.getComponent(i)).setSelected(false);
	}
}


public static void changeGroup(String className, String groupName) {

File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
	List <String> comp = new ArrayList();
	try {
		
		FileReader fr1 = new FileReader(file1);
		
		BufferedReader br1 = new BufferedReader(fr1);
		Object[] lines1 = Home.loadActiveClasses(file1.getPath());
		for(int i = 0; i<lines1.length; i++) {
			comp.add(lines1[i].toString());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	
	int index = 0;
	String group = null;
	boolean exists = false;
			for(int i1 = 0; i1< comp.toArray().length; i1++) {
				List l1 = Arrays.asList(comp.get(i1).toString().split("//")); 
				if(l1.get(4).toString().equals(groupName)) {
					index = i1;
					if(!groupName.equals("none")) {
					exists = true;
				}}
}
	for(int i = 0; i<comp.toArray().length; i++) {
	List l = Arrays.asList(comp.get(i).toString().split("//")); 
	if(l.get(0).toString().equals(className)) {
		group = l.get(4).toString();
		String s = l.get(0).toString()+"//"+l.get(1).toString()+"//"+l.get(2).toString()+"//"+l.get(3).toString()+"//"+groupName+"//"+l.get(5).toString();
		if(exists) {
		comp.add(index+1, s);
		break;
	}else{
		comp.add(i+1, s);
		break;
	}}
}
	for(int i = 0; i<comp.toArray().length; i++) {
		List l = Arrays.asList(comp.get(i).toString().split("//")); 
		if(l.get(0).toString().equals(className)) {
			if(l.get(4).toString().equals(group)) {
				comp.remove(i);
				break;
			}
		}
	}



if(file1.exists()) {
			file1.delete();
		}

	try {
		file1.createNewFile();
		PrintWriter pw = new PrintWriter(file1);

		for(int j = 0;j<comp.toArray().length;j++) {
		pw.println((String)comp.get(j));
		};
		
		pw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
}


public static void replaceGroup(String groupName, String newGroup) {

	File file1 = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/Classes.txt");
		List <String> comp = new ArrayList();
		try {
			
			FileReader fr1 = new FileReader(file1);
			
			BufferedReader br1 = new BufferedReader(fr1);
			Object[] lines1 = Home.loadActiveClasses(file1.getPath());
			for(int i = 0; i<lines1.length; i++) {
				comp.add(lines1[i].toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		for(int i = 0; i<comp.toArray().length; i++) {
		List l = Arrays.asList(comp.get(i).toString().split("//")); 
		if(l.get(4).toString().equals(groupName)) {
			String s = l.get(0).toString()+"//"+l.get(1).toString()+"//"+l.get(2).toString()+"//"+l.get(3).toString()+"//"+newGroup+"//"+l.get(5).toString();
			comp.add(i+1, s);
			comp.remove(i);
		}
	}



if(file1.exists()) {
		file1.delete();
	}

try {
	file1.createNewFile();
	PrintWriter pw = new PrintWriter(file1);

	for(int j = 0;j<comp.toArray().length;j++) {
	pw.println((String)comp.get(j));
	};
	
	pw.close();

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}
}
}
