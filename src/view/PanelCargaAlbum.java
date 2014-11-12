package view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class PanelCargaAlbum extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelCargaAlbum() {
		setLayout(null);
		
		JLabel lblSeleccioneElArchivo = new JLabel("Seleccione el archivo a cargar:");
		lblSeleccioneElArchivo.setBounds(49, 45, 342, 15);
		add(lblSeleccioneElArchivo);
		
		textField = new JTextField();
		textField.setBounds(49, 74, 351, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnExaminar = new JButton("Examinar");
		btnExaminar.setBounds(401, 71, 117, 25);
		add(btnExaminar);
		
		JButton btnCargarVotos = new JButton("Cargar Votos");
		btnCargarVotos.setBounds(49, 244, 138, 25);
		add(btnCargarVotos);

	}

}
