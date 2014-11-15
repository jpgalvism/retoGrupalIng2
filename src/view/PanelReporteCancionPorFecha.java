package view;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelo.Cancion;
import control.ControlPrincipal;

public class PanelReporteCancionPorFecha extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static ControlPrincipal cp = new ControlPrincipal();
	private static ArrayList<Cancion> lista;
	private static JList list;

	/**
	 * Create the panel.
	 */
	public PanelReporteCancionPorFecha() {
		setLayout(null);

		list = new JList();
		list.setBounds(12, 88, 504, 73);
		add(list);

		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				list();
			}

			public void removeUpdate(DocumentEvent e) {
				list();
			}

			public void insertUpdate(DocumentEvent e) {
				list();
			}

			public void list() {
				lista = cp.listacanciones(textField.getText());
				fillList(lista);
			}

			
		});
		textField.setColumns(10);
		textField.setBounds(13, 57, 208, 19);
		add(textField);

		JButton button = new JButton("Buscar");
		button.setBounds(229, 54, 117, 25);
		add(button);

		JLabel label = new JLabel("ID:");
		label.setBounds(12, 210, 70, 15);
		add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 227, 206, 19);
		add(textField_1);

		JLabel lblBuscarId = new JLabel("Buscar ID:");
		lblBuscarId.setBounds(12, 30, 89, 15);
		add(lblBuscarId);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBounds(12, 254, 161, 25);
		add(btnGenerarReporte);

		textField_2 = new JTextField();
		textField_2.setBounds(232, 227, 114, 19);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(361, 227, 114, 19);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblFechaInicial = new JLabel("Fecha Inicial: ");
		lblFechaInicial.setBounds(234, 210, 112, 15);
		add(lblFechaInicial);

		JLabel lblFechaFinal = new JLabel("Fecha Final: ");
		lblFechaFinal.setBounds(361, 210, 114, 15);
		add(lblFechaFinal);

		JList list_1 = new JList();
		list_1.setBounds(12, 291, 558, 397);
		add(list_1);

	}
	private void fillList(ArrayList<Cancion> lista) {
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < lista.size(); i++) {
			model.addElement(lista.get(i).getId() + " - "+lista.get(i).getName());
		}
		list.setModel(model);
	}

}
