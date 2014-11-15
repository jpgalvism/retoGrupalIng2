package view;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		btnExaminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FileDialog dialogoArchivo;

				Frame frame = null;
				dialogoArchivo = new FileDialog(frame,
						"Seleccione el archivo de votos para Álbum", FileDialog.LOAD);
				dialogoArchivo.show();
				textField.setText(dialogoArchivo.getFile());
			}
		});
		btnExaminar.setBounds(401, 71, 117, 25);
		add(btnExaminar);
		
		JButton btnCargarVotos = new JButton("Cargar Votos");
		btnCargarVotos.setBounds(49, 244, 138, 25);
		add(btnCargarVotos);

	}

}
