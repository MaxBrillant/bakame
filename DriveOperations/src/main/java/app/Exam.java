package app;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Toolkit;
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

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.metal.MetalProgressBarUI;

import Application.Home;
import Application.ResizeImages;
import Class.ExamBox;
import Class.NewExam;
import Class.TestBox;
import CloudOperations.aws;
import accounts.NewEstablishment;
import accounts.ScholarYears;
import accounts.UserPanel;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Exam extends JPanel {
	public static JLabel number;
	public static JProgressBar progress;
	public static JLabel percent;
	public static boolean isSelected;

	public static int selected;

	/**
	 * Create the panel.
	 */
	public Exam() {
		setBackground(new Color(80, 80, 80));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(new Dimension((int) screensize.getWidth()*31/100,(int) (screensize.getHeight()*82/100*7/100))));
		setLayout(null);
		
		progress = new JProgressBar();
		progress.setBounds(42, 4, 300, 35);
		progress.setBackground(new Color(25, 25, 25));
		UIManager.put("progress.selectionBackground", Color.black);
		progress.setStringPainted(true);
		progress.setForeground(new Color(46, 139, 87));
		progress.setValue(58);
		progress.setFont(new Font("Roboto", Font.PLAIN, 23));
		progress.setString("58/100");
		
		
		Color color ;
		//NewTest nt = new NewTest();
		//if(nt.isVisible()) {
		//if(100*Double.parseDouble(NewTest.PO.getText().replace(",", "."))/Double.parseDouble(NewTest.TP.getSelectedItem().toString().replace(",", "."))>=50) {
			//color = new Color(0, 168, 96);
		//}else {
			//color = new Color(204, 0, 0);
		//}
		
		//progress.setUI(new BasicProgressBarUI() {
			//protected Color getSelectionBackground() { return color;}
			//protected Color getSelectionForeground() { return Color.white;}
		//});
		//}
		
		add(progress);
		
		
		
		
		number = new JLabel();
		number.setForeground(new Color(255, 255, 255));
		number.setText("22");
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setFont(new Font("Roboto", Font.PLAIN, 23));
		number.setBounds(0, 7, 37, 30);
		add(number);
		
		percent = new JLabel("100%");
		percent.setForeground(new Color(255, 255, 255));
		percent.setFont(new Font("Roboto", Font.PLAIN, 23));
		percent.setBounds(352, 6, 61, 30);
		//add(percent);
		
		JLabel pasfait = new JLabel("N'as pas encore fait l'examen");
		pasfait.setVisible(false);
		pasfait.setIconTextGap(15);
		pasfait.setIcon(ResizeImages.resize(46, 26, "C:\\Users\\User\\Desktop\\Programmes\\Java\\Workspace\\DriveOperations\\Icons\\missing.png"));
		pasfait.setHorizontalTextPosition(SwingConstants.RIGHT);
		pasfait.setForeground(new Color(255, 255, 255));
		pasfait.setHorizontalAlignment(SwingConstants.CENTER);
		pasfait.setFont(new Font("Roboto", Font.BOLD, 23));
		pasfait.setBounds(10, 0, 412, 44);
		add(pasfait);
		
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				


				//setBorder(new LineBorder(Color.white, 2));
				Test.deselect();

				isSelected = true;
				String str = ((JProgressBar)getComponent(0)).getString().replaceAll("[^0.00-9.00]+", "/");
				List note = Arrays.asList(str.trim().split("/"));
				LPane.points.setText(note.get(0)+"/"+note.get(1));
				
				
				LPane.points.setForeground(new Color(255, 33, 94));
				LPane.mention.setForeground(new Color(255, 33, 94));
				LPane.mention();
				
				LPane.average.setVisible(false);
				LPane.comboBox.setVisible(false);
				
				setBackground(new Color(20, 148, 198));
				getComponent(1).setForeground(Color.WHITE);
				getComponent(2).setForeground(Color.WHITE);
				LPane.no.setText("Serie No "+((JLabel) getComponent(1)).getText());//this will give the number of tests
				LPane.supprimer.setVisible(true);
				LPane.modifier.setVisible(true);
				
				selected = Integer.parseInt(((JLabel) getComponent(1)).getText())-1;

				if(App.panel_5.getComponentCount()>0) {
				int num = Integer.parseInt(LPane.no.getText().replaceAll("[^0.00-9.00]", ""));
				LPane.panel_2.getComponent(num-1).setPreferredSize(new Dimension((int) ((screensize.getWidth()*31/100)*103)/100,(int) (((screensize.getHeight()*82/100*7/100)*105)/100)));
				}
				
				LPane.panel_2.revalidate();
				LPane.panel_2.repaint();
				
				if(e.getClickCount()==2){
					int j = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""));
					String str1 = ((JProgressBar) ((Container) LPane.panel_2.getComponent(j-1)).getComponent(0)).getString().replaceAll("[^0.00-9.00]+", "/");
					List note1 = Arrays.asList(str1.trim().split("/"));
					
					NewTest nt = new NewTest();
				nt.setVisible(true);
					NewTest.update.setVisible(false);
					NewTest.upExam.setVisible(true);
					
					
					
					File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/Exam List/3eme Trimestre/ExamList.txt");
					aws.downloadContent(file.getPath());
							try {

								
								FileReader fr = new FileReader(file);
								
								BufferedReader br = new BufferedReader(fr);
								Object[] lines = br.lines().toArray();
								int index = 0;
								
								for(int i = 0;i<lines.length;i++) {
								List parts = Arrays.asList(lines[i].toString().split("//"));
								if(parts.get(0).equals(TestBox.getShortName(nt.cours.getText(), Home.className))) {
									index = i;
								}
								}
								
								List parts = Arrays.asList(lines[index].toString().split("//"));
								List parts1 = Arrays.asList(parts.get(3+Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""))).toString().split("::"));
								
					
					
					NewTest.PO.setText((String) note1.get(0));
					NewTest.TP.setText(String.valueOf(Integer.parseInt(parts1.get(1).toString())*Integer.parseInt(parts.get(1).toString())/100));
					int i = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""));
					NewTest.interro.setText(parts1.get(0).toString());
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								
						}
					
					
				}
				
				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
		}
			public void mouseEntered(MouseEvent e) {
				
				
				setBorder(null);
				setBackground(new Color(120, 120, 120));
				setForeground(Color.white);
				if(!getComponent(0).isVisible()) {
					
				}

				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
			}public void mouseExited(MouseEvent e) {
				if(!getComponent(0).isVisible()) {
					setBackground(LPane.panel_3.getBackground());
					setForeground(Color.white);
					setBorder(new LineBorder(Color.white, 2));
					getComponent(1).setForeground(Color.white);
				}else {
			setBackground(new Color(80, 80, 80));
			setBorder(null);
				}
				if(isSelected) {
					LPane.panel_2.getComponent(selected).setBackground(new Color(20, 148, 198));
					((Container) LPane.panel_2.getComponent(selected)).getComponent(1).setForeground(Color.white);
				}
			}
		});

	}
	
	
	public static void color() {

		for (int k = 0; k< LPane.panel_2.getComponentCount();k++) {
			String str = ((JProgressBar) ((Container) LPane.panel_2.getComponent(k)).getComponent(0)).getString();
			List note = Arrays.asList(str.trim().split("/"));
			
			Color color;
			if(Double.parseDouble((String)note.get(0))/Double.parseDouble((String)note.get(1))*100 >=50) {
				color = new Color(0, 168, 96);
			}else {
				color = new Color(255, 33, 94);
			}
			
			Exam.progress.setUI(new BasicProgressBarUI() {
				protected Color getSelectionBackground() { return color;}
				protected Color getSelectionForeground() { return Color.white;
				}
			});
			
			
		}
		
	}
	
	public static void deselect() {
		
		Exam.loadExams();
		
		Double sum = (double) 0;
		Double sum1 = (double) 0;
		int ev = 0;
		for(int i = 0; i < LPane.panel_2.getComponents().length;i++) {
			
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			
			LPane.panel_2.getComponent(i).setPreferredSize(new Dimension((int) screensize.getWidth()*31/100,(int) (screensize.getHeight()*82/100*7/100)));
			
			if(!((JComponent) LPane.panel_2.getComponent(i)).getComponent(0).isVisible()) {
				((JComponent) LPane.panel_2.getComponent(i)).setBackground(LPane.panel_2.getBackground());
				((Container) LPane.panel_2.getComponent(i)).getComponent(1).setForeground(Color.white);
				((JComponent) LPane.panel_2.getComponent(i)).setBorder(new LineBorder(Color.white, 2));
			}else {
		((JComponent) LPane.panel_2.getComponent(i)).setBackground(new Color(60, 60, 60));
		((Container) LPane.panel_2.getComponent(i)).getComponent(1).setForeground(Color.white);
		((Container) LPane.panel_2.getComponent(i)).getComponent(2).setForeground(Color.white);
			}
		
		String str = ((JProgressBar) ((Container)LPane.panel_2.getComponent(i)).getComponent(0)).getString().replaceAll("[^0.00-9.00]+", "/");
		List note = Arrays.asList(str.trim().split("/"));
		Double d = Double.parseDouble((String) note.get(0));
		Double e = Double.parseDouble((String) note.get(1));
		
		sum = sum+ d;
		sum1 = sum1+e;
		
		
	}
		LPane.average.setVisible(true);
		LPane.comboBox.setVisible(true);
		

		LPane.supprimer.setVisible(false);
		LPane.modifier.setVisible(false);
		LPane.no.setText(String.valueOf(LPane.panel_2.getComponentCount())+" Series effectuees");
		
		if(sum==0 && sum1==0) {

			LPane.points.setText("0/0");
		}else {
			
			int j = Integer.parseInt(App.number.getText());
			LPane.points.setText(new DecimalFormat("##.##").format(sum)+"/"+new DecimalFormat("##.##").format(sum1));
			((JLabel) ((Container) ((Container) App.panel_5.getComponent(j-1)).getComponent(1)).getComponent(1)).setText("Points: "+new DecimalFormat("##.##").format(sum)+"/"+new DecimalFormat("##.##").format(sum1));
			if(LPane.panel_2.getComponentCount()<=0) {
				LPane.points.setText("Points: 0/10");
				((JLabel) ((Container) ((Container) App.panel_5.getComponent(j-1)).getComponent(1)).getComponent(1)).setText("Points:");
				

			}
			LPane.points.setForeground(Color.white);
			LPane.mention.setForeground(Color.white);
			if(String.valueOf(LPane.points.getText()).contains(",")) {
				String s = LPane.points.getText().replace(",", ".");
				LPane.points.setText(s);
			}
			

			LPane.panel_2.revalidate();
			LPane.panel_2.repaint();
			
			LPane.mention();
			LPane.average();

			
			String str = LPane.points.getText().replaceAll("[^0.00-9.00]+", " ");
			List note = Arrays.asList(str.trim().split(" "));
			Double i =   Double.parseDouble((String) note.get(0))/Double.parseDouble((String) note.get(1))*100;
			
			
			if(App.panel_5.getComponentCount()>0) {
			int j1 = Integer.parseInt(App.number.getText());
			((JLabel) ((Container) ((Container) App.panel_5.getComponent(j1-1)).getComponent(1)).getComponent(2)).setText(LPane.average.getText()+LPane.comboBox.getSelectedItem());
			((JLabel) ((Container) ((Container) App.panel_5.getComponent(j1-1)).getComponent(1)).getComponent(0)).setText("Pourcentage: "+new DecimalFormat("##.##").format(i)+"%");
			((JLabel) ((Container) ((Container) App.panel_5.getComponent(j1-1)).getComponent(1)).getComponent(3)).setText(LPane.echec.getText().replace("Augmentation", "Augm. "));

		}
		}

	}
	
	
	public static void saveExistingExam() {

		int i = Integer.parseInt(App.number.getText().replace(" ", ""));
			String name = ((JLabel) (((Container) ((Container) App.panel_5.getComponent(i-1)).getComponent(0)).getComponent(0))).getText();
		
			File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+App.name.getText()+"/3eme Trimestre/"+name.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")+".txt");
			aws.downloadContent(file.getPath());
	
			try {

				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = br.lines().toArray();
				
				List<String> info = new ArrayList();
				for(i = 0; i<lines.length; i++) {
					info.add(lines[i].toString());
				}
				
				int index = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""))-1;
				for(int j = 0; j<LPane.panel_2.getComponentCount();j++) {
					

					
					if(index == j) {
						
						if(j==0) {
							((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).setString(NewTest.PO.getText()+"/"+NewTest.TP.getText());
							info.remove(0);
							info.add(0, ((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
						}else {
							String s = info.get(0);
							info.remove(0);
							((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).setString(NewTest.PO.getText()+"/"+NewTest.TP.getText());
							info.add(0, s+"//"+((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
						}
					}else {
					
					if(j==0) {
						info.remove(0);
						info.add(0, ((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
					}else {
						String s = info.get(0);
						info.remove(0);
						info.add(0, s+"//"+((JProgressBar) ((Container) LPane.panel_2.getComponent(j)).getComponent(0)).getString());
					}}
				}
				
				
				if(file.exists()) {
					file.delete();
				}
				

				try {
					file.createNewFile();
					
					PrintWriter pw = new PrintWriter(file);
					for(int k = 0; k<info.toArray().length;k++) {
						pw.println(info.get(k));
					}
					
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
			aws.upload(file.getPath());
	
	}
	
	
	public static void loadExams() {
		
		if(App.panel_5.getComponentCount()>0) {
		int i = Integer.parseInt(App.number.getText().replace(" ", ""));
		
		LPane.panel_2.removeAll();
		LPane.no.setText("0");
		
		String name = ((JLabel) (((Container) ((Container) App.panel_5.getComponent(i-1)).getComponent(0)).getComponent(0))).getText();


		File file = new File("Data/Establishments/"+NewEstablishment.getSchoolID(UserPanel.selectedSchool)+"/"+ScholarYears.selectedScholarYear+"/"+Home.className+"/"+App.name.getText()+"/3eme Trimestre/"+name.replace("<html><div style='text-align: center;'>", "").replace("</div></html>", "")+".txt");
		aws.downloadContent(file.getPath());
			try {
				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				Object[] lines = br.lines().toArray();
				
				if(lines[0].toString().contains("//") && !lines[0].toString().equals("0")) {
					List note = Arrays.asList(lines[0].toString().split("//"));
					
					for(int j = 0;j<note.toArray().length;j++) {
						List note2 = Arrays.asList(note.get(j).toString().split("/"));
						
						create((String) note2.get(1),(String) note2.get(0));

						LPane.panel_2.revalidate();
						LPane.panel_2.repaint();
					}
					
				}else if(!lines[0].toString().contains("//") && !lines[0].toString().equals("0")) {
					List note2 = Arrays.asList(lines[0].toString().split("/"));
					create((String) note2.get(1),(String) note2.get(0));

					LPane.panel_2.revalidate();
					LPane.panel_2.repaint();
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ExamBox.loadExams();
	}
	
	

	public static void create(String s,String g) {
		
		Exam t = new Exam();
		
		t.progress.setString(g+"/"+ s);
		
		//t.getComponent(4).setVisible(false);
		int i = Integer.parseInt(LPane.no.getText().replaceAll("[^0-9]", ""));
		LPane.panel_2.add(t, i);
		
		number.setText(String.valueOf(LPane.panel_2.getComponentCount()));
		
		if(t.progress.getString().equals("0/0")) {
			t.setBackground(LPane.panel_3.getBackground());
			t.setBorder(new LineBorder(Color.white, 2));
			for(int j = 0;j<3;j++) {
				t.getComponent(j).setVisible(false);
			}
			//t.getComponent(4).setVisible(true);
			t.number.setVisible(true);
		}
		else {
		t.progress.setValue((int) (100*Double.parseDouble(g)/Double.parseDouble(s)));
		if(100*Double.parseDouble(g)/Double.parseDouble(s)<50) {
			t.progress.setForeground(new Color(255, 33, 94));
			color();
		}else {
			t.progress.setForeground(new Color(0, 168, 96));
			color();
		}
		}
		
		LPane.no.setText(((JLabel) t.getComponent(1)).getText());

		//LPane.percent();
	
		//LPane.ranking();
		//LPane.progression();

		LPane.scrollPane2.revalidate();
		LPane.scrollPane2.repaint();
		LPane.panel_2.revalidate();
		LPane.panel_2.repaint();
		
		//Exam.deselect();
		
		
		 SwingUtilities.invokeLater(() -> {
	            JScrollBar bar = LPane.scrollPane2.getVerticalScrollBar();
	            bar.setValue(bar.getMaximum());
	    });
	}
}
