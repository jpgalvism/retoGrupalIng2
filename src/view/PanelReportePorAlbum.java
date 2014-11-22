package view;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Album;


public class PanelReportePorAlbum extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	protected ArrayList<Album> lista;
	private static ControlPrincipal cp = new ControlPrincipal();
	private static JList list, list_1;

	/**
	 * Create the panel.
	 */
	public PanelReportePorAlbum() {
		setLayout(null);
		
		list = new JList();
		list.setBounds(12, 88, 504, 73);
		add(list);
		
		textField = new JTextField();
		
		textField.setColumns(10);
		textField.setBounds(13, 57, 208, 19);
		add(textField);
		
		JButton button = new JButton("Buscar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lista = cp.listAlbums(textField.getText());
				fillList(lista);
			}
		});
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
		btnGenerarReporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int id = -1;
				try {
					id = Integer.parseInt(textField_1.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en ID",
							"Error de Reporte", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Album album = cp.getAlbum(id);
				if (album == null) {
					JOptionPane.showMessageDialog(null, "El álbum no existe",
							"Error de Reporte", JOptionPane.ERROR_MESSAGE);
					return;
				}
				fillList2(cp.getReportAlbum(album));
			}
		});
		btnGenerarReporte.setBounds(12, 254, 161, 25);
		add(btnGenerarReporte);
		
		list_1 = new JList();
		list_1.setBounds(12, 291, 558, 397);
		add(list_1);

	}
	private void fillList(ArrayList<Album> lista) {
		
		if (lista.size() == 0)
		{
			JOptionPane.showMessageDialog(null,
					"No existe información para mostrar.",
					"Reporte", JOptionPane.INFORMATION_MESSAGE);
		}
		
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < lista.size(); i++) {
			model.addElement(lista.get(i).getId()+ " - "+lista.get(i).getName());
		}
		list.setModel(model);
	}
private void fillList2(ArrayList<String> arrayList) {
		
		if (arrayList.size() == 0)
		{
			JOptionPane.showMessageDialog(null,
					"No existe información para mostrar.",
					"Reporte", JOptionPane.INFORMATION_MESSAGE);
		}
		
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < arrayList.size(); i++) {
			model.addElement(arrayList.get(i));
		}
		list_1.setModel(model);
	}


}
