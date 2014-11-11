package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class JPPrincipal extends JPanel {

	
	
	
	public JPPrincipal()
	{
		
		setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		
	}
}
