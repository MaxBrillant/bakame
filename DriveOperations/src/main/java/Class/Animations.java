package Class;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

	class scrollDown extends Thread{

		@Override
		public void run() {

			 SwingUtilities.invokeLater(() -> {
					for(int i = 0; i<NewExam.panel.getHeight();i++) {
				 JScrollBar bar = NewExam.scrollPane.getVerticalScrollBar();
		           bar.setValue(i*NewExam.displayedSerie/NewExam.panel.getComponentCount());

					try {
						sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				});
			 ((Component) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).requestFocus();
			 ((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2))
			 .setCaretPosition(((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).getText().length());
			
		}
	}
		class scrollUp extends Thread{
			@Override
			public void run() {

				 SwingUtilities.invokeLater(() -> {
						for(int i = NewExam.panel.getHeight(); i>=NewExam.panel.getHeight()*NewExam.displayedSerie/NewExam.panel.getComponentCount();i--) {
							JScrollBar bar = NewExam.scrollPane.getVerticalScrollBar();
							 bar.setValue(i);
								try {
									sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
			
				 });

				 ((Component) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).requestFocus();
				 ((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2))
				 .setCaretPosition(((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).getText().length());
				
			}
		}
			class scrollLeft extends Thread{
				@Override
				public void run() {

					NewExam.right.setEnabled(false);
					NewExam.left.setEnabled(false);
					
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int i = 0; i<NewExam.contentPane.getComponentCount();i++) {
						if(i ==2||i == 9|| i == 10 ) {
						run(NewExam.contentPane.getComponent(i));
						 ((Component) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).requestFocus();
						 ((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2))
						 .setCaretPosition(((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).getText().length());
						 
						 if(i <9) {
							NewExam.loadExamSeries(NewExam.cours.getText());
					}}
						if(i ==2) {
						NewExam.loadStudent(NewExam.n);
					}if(i ==9) {
						NewExam.loadData(NewExam.cours.getText());
						NewExam.total();
					}if(i ==10) {
						Animations.scrollUp();
						Animations.scrollDown();
					}
						}
					NewExam.right.setEnabled(true);
					NewExam.left.setEnabled(true);
				}
				
				public void run(Component c) {
					
					int k = c.getX();
							for(int i = k; i<NewExam.contentPane.getWidth();i++) {
								c.setBounds(i, c.getY(), c.getWidth()
										, c.getHeight());
								
								if(NewExam.contentPane.getWidth()/7>=i) {
								try {
									sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}}
							}for(int i = -NewExam.contentPane.getWidth(); i<=k;i++) {
								c.setBounds(i, c.getY(), c.getWidth()
										, c.getHeight());

								if(i>=-NewExam.contentPane.getWidth()/7) {
								try {
									sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
			
				}
							}
			}
			
			class scrollTestLeft extends Thread{
				@Override
				public void run() {

					NewTest.right.setEnabled(false);
					NewTest.left.setEnabled(false);
					for(int i = 0; i<NewTest.contentPane.getComponentCount();i++) {
						if(i ==2||i == 3) {
						run(NewTest.contentPane.getComponent(i));
					}
						if(i ==3) {
						}
						if(i == 2) {
							NewTest.loadTestInfo(NewTest.id);
						}
						}
					TestBox.loadAllTests();

					if(NewTest.points.getText().isBlank()) {
						NewTest.add.setEnabled(false);
					}else {

						NewTest.add.setEnabled(true);
					}
					NewTest.right.setEnabled(true);
					NewTest.left.setEnabled(true);
					NewCourse.load();
					NewStudent.load();
				}
				
				public void run(Component c) {
					
					int k = c.getX();
							for(int i = k; i<NewTest.contentPane.getWidth();i++) {
								c.setBounds(i, c.getY(), c.getWidth()
										, c.getHeight());
								
								if(NewTest.contentPane.getWidth()/7>=i) {
								try {
									sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}}
							}for(int i = -NewTest.contentPane.getWidth(); i<=k;i++) {
								c.setBounds(i, c.getY(), c.getWidth()
										, c.getHeight());

								if(i>=-NewTest.contentPane.getWidth()/7) {
								try {
									sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
			
				}
							}
			}
			
				class scrollRight extends Thread{
					@Override
					public void run() {

						NewExam.right.setEnabled(false);
						NewExam.left.setEnabled(false);
						
						try {
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						for(int i = 0; i<NewExam.contentPane.getComponentCount();i++) {
							if(i ==2||i == 9|| i == 10 ) {
							run(NewExam.contentPane.getComponent(i));
							 ((Component) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).requestFocus();
							 ((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2))
							 .setCaretPosition(((JTextField) ((Container) NewExam.panel.getComponent(NewExam.displayedSerie)).getComponent(2)).getText().length());
							 
							 if(i <9) {
								NewExam.loadExamSeries(NewExam.cours.getText());
						}}
							if(i ==2) {
							NewExam.loadStudent(NewExam.n);
						}if(i ==9) {
							NewExam.loadData(NewExam.cours.getText());
							NewExam.total();
						}if(i ==10) {
							Animations.scrollUp();
							Animations.scrollDown();
						}
							}
						NewExam.right.setEnabled(true);
						NewExam.left.setEnabled(true);
					}
					
					public void run(Component c) {
						
						int k = c.getX();
						for(int i = k; i>=-NewExam.contentPane.getWidth();i--) {
							c.setBounds(i, c.getY(), c.getWidth()
									, c.getHeight());

							if(-NewExam.contentPane.getWidth()/7<=i) {
							try {
								sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			}
								for(int i = NewExam.contentPane.getWidth(); i>=k;i--) {
									c.setBounds(i, c.getY(), c.getWidth()
											, c.getHeight());
									
									if(NewExam.contentPane.getWidth()/7>=i) {
									try {
										sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}}
								}
								}
				}
				class scrollTestRight extends Thread{
					@Override
					public void run() {

						NewTest.right.setEnabled(false);
						NewTest.left.setEnabled(false);
						for(int i = 0; i<NewTest.contentPane.getComponentCount();i++) {
							if(i ==2||i == 3) {
							run(NewTest.contentPane.getComponent(i));
						}
							if(i ==3) {
							}
							if(i == 2) {
								NewTest.loadTestInfo(NewTest.id);
							}
							}
						TestBox.loadAllTests();

						if(NewTest.points.getText().isBlank()) {
							NewTest.add.setEnabled(false);
						}else {

							NewTest.add.setEnabled(true);
						}
						NewTest.right.setEnabled(true);
						NewTest.left.setEnabled(true);
						NewCourse.load();
						NewStudent.load();
					}
					
					public void run(Component c) {

						int k = c.getX();
						for(int i = k; i>=-NewTest.contentPane.getWidth();i--) {
							c.setBounds(i, c.getY(), c.getWidth()
									, c.getHeight());

							if(-NewTest.contentPane.getWidth()/7<=i) {
							try {
								sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			}
								for(int i = NewTest.contentPane.getWidth(); i>=k;i--) {
									c.setBounds(i, c.getY(), c.getWidth()
											, c.getHeight());
									
									if(NewTest.contentPane.getWidth()/7>=i) {
									try {
										sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}}
								}
								}
				}
				

public class Animations {

	public static int i1 = 0;
	public static int k1 = 0;
	public static void scrollDown() {
		scrollDown l = new scrollDown();
		l.start();
		}

	public static void scrollUp() {
		scrollUp l = new scrollUp();
		l.start();
		}
	public static  void scrollLeft() {
		scrollLeft l = new scrollLeft();
		l.start();
		}
	public static  void scrollRight() {
		scrollRight l = new scrollRight();
		l.start();
		}
	public static  void scrollTestRight() {
		scrollTestRight l = new scrollTestRight();
		l.start();
		}
	public static  void scrollTestLeft() {
		scrollTestLeft l = new scrollTestLeft();
		l.start();
		}

public static void animateComponent(Component c, int x, int y, int speed) {
	Double initialX = c.getLocationOnScreen().getX();
	Double initialY = c.getLocationOnScreen().getY();
	
	if(x>initialX && y>initialY) {
        new SwingWorker<Void, Void>() {
            public Void doInBackground() throws Exception{
	for(Double i = initialX; i< x; i++) {

		Double i2 = i;
		System.out.println(i);
		i1 = (int) Math.round(i2);
		c.setLocation(i1, k1);
		c.getParent().revalidate();
		c.getParent().repaint();
		for(Double k = initialY; k< y; k++) {

			Double k2 = k;
			System.out.println(k);
	        new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
			k1 = (int) Math.round(k2);
			c.setLocation(i1, k1);
			c.getParent().revalidate();
			c.getParent().repaint();
			return null;
	            }
	        }.execute();
	}}
		return null;
    }
}.execute();}
		if(x<=initialX && y<=initialY) {
	        new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{
			for(Double i = initialX; i>= x; i--) {

				Double i2 = i;
				System.out.println(i);
				i1 = (int) Math.round(i2);
				c.setLocation(i1, k1);
				c.getParent().revalidate();
				c.getParent().repaint();
				for(Double k = initialY; k>= y; k--) {

					Double k2 = k;
					System.out.println(k);
			        new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{	
				
					k1 = (int) Math.round(k2);
					c.setLocation(i1, k1);
					c.getParent().revalidate();
					c.getParent().repaint();
			            
					return null;
			            }
			        }.execute();
			}}
		return null;
            }
        }.execute();}
		
		if(x>initialX && y<=initialY) {
	        new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{	
			for(Double i = initialX; i< x; i++) {

				Double i2 = i;
				System.out.println(i);
			
				i1 = (int) Math.round(i2);
				c.setLocation(i1, k1);
				c.getParent().revalidate();
				c.getParent().repaint();
				for(Double k = initialY; k>= y; k--) {

					Double k2 = k;
					System.out.println(k);
			        new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{
				
					k1 = (int) Math.round(k2);
					c.setLocation(i1, k1);
					c.getParent().revalidate();
					c.getParent().repaint();
					return null;
			            }
			        }.execute();
			}}
		return null;
            }
        }.execute();}
		if(x<=initialX && y>initialY) {
	        new SwingWorker<Void, Void>() {
	            public Void doInBackground() throws Exception{	
			for(Double i = initialX; i>= x; i--) {

				Double i2 = i;
				System.out.println(i);
			
				i1 = (int) Math.round(i2);
				c.setLocation(i1, k1);
				c.getParent().revalidate();
				c.getParent().repaint();
				for(Double k = initialY; k< y; k++) {

					Double k2 = k;
					System.out.println(k);
			        new SwingWorker<Void, Void>() {
			            public Void doInBackground() throws Exception{	
				
					k1 = (int) Math.round(k2);
					c.setLocation(i1, k1);
					c.getParent().revalidate();
					c.getParent().repaint();
					return null;
			            }
			        }.execute();
			}}
		return null;
            }
        }.execute();}
}

}
