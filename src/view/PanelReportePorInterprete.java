package view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;


public class PanelReportePorInterprete extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelReportePorInterprete() {
		setLayout(null);
		
		JLabel lblNombreDelIntrprete = new JLabel("Nombre del Intérprete: ");
		lblNombreDelIntrprete.setBounds(12, 28, 279, 15);
		add(lblNombreDelIntrprete);
		
		JButton button = new JButton("Generar Reporte");
		button.setBounds(12, 98, 161, 25);
		add(button);
		
		JList list = new JList();
		list.setBounds(12, 135, 558, 397);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(12, 53, 279, 19);
		add(textField);
		textField.setColumns(10);

	}

}
