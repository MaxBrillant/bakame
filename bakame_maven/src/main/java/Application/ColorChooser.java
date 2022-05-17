package Application;
//Java program to implement JColorChooser
//class using ChangeListener
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooser extends JPanel

	implements ChangeListener {
	
	public static JFrame frame;
	public static JColorChooser Jcc;
	protected JLabel label;
	private JButton btnNewButton;

	public ColorChooser()
	{
		super(new BorderLayout());

		// Set up the Label at the top of the window
		label = new JLabel(ChooseColor.className.getText(),
									JLabel.CENTER);

		// set the foreground color of the text

		// set background color of the field
		label.setOpaque(true);

		// set font type and size of the text
		label.setFont(new Font("SansSerif", Font.BOLD, 30));
		label.setBackground(ChooseColor.backColor);
		label.setForeground(ChooseColor.foreColor);


		// create a Panel and set its layout
		JPanel bannerPanel = new JPanel(new BorderLayout());
		//bannerPanel.add(label, BorderLayout.CENTER);
		bannerPanel.setBorder(BorderFactory.createTitledBorder("Label"));


		// Set up color chooser for setting text color
		Jcc = new JColorChooser(label.getForeground());
		Jcc.getSelectionModel().addChangeListener(this);
		Jcc.setBorder(BorderFactory.createTitledBorder(
			"Choisissez votre couleur"));
		JLabel j = new JLabel();
	    Jcc.setPreviewPanel(j);
		add(Jcc, BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
		// set size of the label
		label.setPreferredSize(new Dimension(label.getParent().getPreferredSize().width, 100));
		
		btnNewButton = new JButton("Appliquer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ChooseColor.isBackground) {
					ChooseColor.backColor = Jcc.getColor();
					ChooseColor.previewPanel.setBackground(ChooseColor.backColor);
					ChooseColor.backPane.setBackground(ChooseColor.backColor);
					ChooseColor.backgroundisSelected = true;
					
					if(ChooseColor.backgroundisSelected && ChooseColor.foregroundisSelected) {
						ChooseColor.create.setEnabled(true);
					}else {
						ChooseColor.create.setEnabled(false);
					}
					}else {
						ChooseColor.foreColor = Jcc.getColor();
						ChooseColor.className.setForeground(ChooseColor.foreColor);
						ChooseColor.frontPane.setBackground(ChooseColor.foreColor);
						
						ChooseColor.foregroundisSelected = true;
						
						if(ChooseColor.backgroundisSelected && ChooseColor.foregroundisSelected) {
							ChooseColor.create.setEnabled(true);
						}else {
							ChooseColor.create.setEnabled(false);
						}
					}
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setPreferredSize(new Dimension(80, 35));
		add(btnNewButton, BorderLayout.SOUTH);
		
		AbstractColorChooserPanel[] panels=Jcc.getChooserPanels();
        for(AbstractColorChooserPanel p:panels){
            String displayName=p.getDisplayName();
            switch (displayName) {
                case "HSV":
                	Jcc.removeChooserPanel(p);
                    break;
                case "RGB":
                	Jcc.removeChooserPanel(p);
                    break;
                case "CMYK":
                	Jcc.removeChooserPanel(p);
                    break;
            }}
	}

	public void stateChanged(ChangeEvent e)
	{
		Color newColor = Jcc.getColor();
		
		if(ChooseColor.isBackground) {
		label.setBackground(newColor);
		}else {
			label.setForeground(newColor);
		}
	}

	// Create the GUI and show it. For thread safety,
	// this method should be invoked from the
	// event-dispatching thread.
	public static void createAndShowGUI()
	{

		// Create and set up the window.
		frame = new JFrame("ColorChooserDemo");
		frame.setResizable(false);

		// Create and set up the content pane.
		JComponent newContentPane = new ColorChooser();

		// content panes must be opaque
		newContentPane.setOpaque(true);

		// add content pane to the frame
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
		

		frame.setLocationRelativeTo(null);
	}

	// Main Method
	public static void main(String[] args)
	{

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run()
			{

				createAndShowGUI();
			}
		});
	}

}
