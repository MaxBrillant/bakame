package Publishing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class post extends JPanel {

	/**
	 * Create the panel.
	 */
	public post() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Publication hebdomadaire");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 316, 28);
		add(lblNewLabel);
		
		JLabel lblPublieeLe = new JLabel("13/07/2021");
		lblPublieeLe.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblPublieeLe.setBounds(10, 22, 76, 28);
		add(lblPublieeLe);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(32);
		progressBar.setBounds(206, 25, 154, 21);
		add(progressBar);
		
		JLabel lbleleves = new JLabel("1943 eleves");
		lbleleves.setHorizontalAlignment(SwingConstants.CENTER);
		lbleleves.setFont(new Font("Arial", Font.BOLD, 15));
		lbleleves.setBounds(96, 22, 100, 28);
		add(lbleleves);

	}
}
