package view;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlPrincipal;
import modelo.Cancion;
import modelo.Interprete;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelReportePorInterprete extends JPanel {
	private JTextField textField;
	private static ControlPrincipal cp = new ControlPrincipal();
	private JList list, list_1;

	/**
	 * Create the panel.
	 */
	public PanelReportePorInterprete() {
		setLayout(null);
		
		JLabel lblNombreDelIntrprete = new JLabel("Nombre del Intérprete: ");
		lblNombreDelIntrprete.setBounds(12, 28, 279, 15);
		add(lblNombreDelIntrprete);
		
		JButton button = new JButton("Generar Reporte");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Interprete interprete = cp.getInterprete(textField.getText());
				if (interprete==null) {
					JOptionPane.showMessageDialog(null,
							"El intérprete no existe",
							"Error de Reporte",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				fillAlbum(cp.getReportInterpreteAlbum(interprete));
				fillCancion(cp.getReportInterpreteCancion(interprete));
			}

			
		});
		button.setBounds(12, 98, 161, 25);
		add(button);
		
		list = new JList();
		list.setBounds(12, 135, 558, 252);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(12, 53, 279, 19);
		add(textField);
		textField.setColumns(10);
		
		list_1 = new JList();
		list_1.setBounds(12, 408, 558, 252);
		add(list_1);

	}
	private void fillCancion(ArrayList<String> reportInterpreteCancion) {
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < reportInterpreteCancion.size(); i++) {
			model.addElement(reportInterpreteCancion.get(i));
		}
		list_1.setModel(model);
		
	}

	private void fillAlbum(ArrayList<String> reportInterpreteAlbum) {
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < reportInterpreteAlbum.size(); i++) {
			model.addElement(reportInterpreteAlbum.get(i));
		}
		list.setModel(model);
		
	}
}
