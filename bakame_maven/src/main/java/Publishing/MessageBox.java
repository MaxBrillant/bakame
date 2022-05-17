package Publishing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MessageBox extends JPanel {

	/**
	 * Create the panel.
	 */
	public MessageBox() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Publication des performances de Ndashimye Max Brillant");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 316, 28);
		add(lblNewLabel);
		
		JLabel lblPublieeLe = new JLabel("13/07/2021    13:30");
		lblPublieeLe.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblPublieeLe.setBounds(10, 22, 172, 28);
		add(lblPublieeLe);
		
		JLabel lblNewLabel_1 = new JLabel("Envoye");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(275, 27, 95, 21);
		add(lblNewLabel_1);

	}

}
