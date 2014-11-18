package view;

import java.awt.Color;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import control.ControlPrincipal;

public class PanelCrear extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static ControlPrincipal cp = new ControlPrincipal();
	private static ArrayList<Cancion> lista = new ArrayList<Cancion>();
	private static ArrayList<Cancion> lista2 = new ArrayList<Cancion>();
	private static JList list;
	private static JList list2;
	private static JLabel label_check;
	private static Album album = new Album();

	/**
	 * Create the panel.
	 */
	public PanelCrear() {
		setLayout(null);

		JLabel label = new JLabel("Nombre del Álbum");
		label.setBounds(12, 12, 170, 15);
		add(label);

		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (cp.getAlbum(textField.getText()) != null) {
					label_check.setForeground(Color.RED);
					label_check.setText("Este nombre ya existe");
				} else {
					label_check.setForeground(Color.GREEN);
					label_check.setText("Este nombre esta disponible");
				}

			}
		});
		textField.setColumns(10);
		textField.setBounds(12, 39, 206, 19);
		add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 85, 208, 19);
		add(textField_1);

		JLabel lblBuscarIdDe = new JLabel(
				"Buscar ID de canci\u00F3n por nombre:");
		lblBuscarIdDe.setBounds(12, 70, 208, 15);
		add(lblBuscarIdDe);

		JButton button_1 = new JButton("Buscar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lista = cp.listSongs(textField_1.getText());
				fillList(lista);
			}
		});
		button_1.setBounds(228, 82, 117, 25);
		add(button_1);

		list = new JList();
		list.setBounds(11, 116, 345, 73);
		add(list);

		JLabel label_2 = new JLabel("Añadir canción existente (ID)");
		label_2.setBounds(11, 216, 235, 15);
		add(label_2);

		JLabel label_3 = new JLabel("ID:");
		label_3.setBounds(11, 238, 70, 15);
		add(label_3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(11, 255, 206, 19);
		add(textField_2);

		JButton button_2 = new JButton("Añadir");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int id = -1;
				try {
					id = Integer.parseInt(textField_2.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El ID de la canción es incorrecto",
							"Canción no Existe", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Cancion cancion = cp.getCancion(id);

				if (cancion == null) {
					JOptionPane.showMessageDialog(null,
							"El ID de la canción es incorrecto",
							"Canción no Existe", JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i = 0; i < album.getListCancion().size(); i++) {
						if (album.getListCancion().get(i).getId() == (cancion
								.getId())) {
							JOptionPane.showMessageDialog(null,
									"Ya ha agregado esta canción",
									"Error de Agregación",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					lista2.add(cancion);
					album.addCancion(cancion);
					fillList2(lista2);
				}
			}
		});
		button_2.setBounds(11, 279, 117, 25);
		add(button_2);

		JLabel label_4 = new JLabel("Añadir canción nueva");
		label_4.setBounds(11, 316, 206, 15);
		add(label_4);

		JLabel label_5 = new JLabel("Nombre:");
		label_5.setBounds(11, 343, 70, 15);
		add(label_5);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(11, 370, 218, 19);
		add(textField_3);

		JLabel label_6 = new JLabel("Intérpretes (separados por coma):");
		label_6.setBounds(252, 343, 258, 15);
		add(label_6);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(252, 370, 258, 19);
		add(textField_4);

		JButton button_3 = new JButton("Añadir");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Cancion cancion = new Cancion();
				String nombre = cp.normalizar(textField_3.getText());
				cancion.setName(nombre);
				String a[] = textField_4.getText().split(",");
				for (int i = 0; i < a.length; i++) {
					Interprete inter = new Interprete();
					inter.setName(a[i].trim());
					cancion.addInterpreteNuevo(inter);
				}
				for (int i = 0; i < album.getListCancion().size(); i++) {
					if (album.getListCancion().get(i).getName()
							.equals(cancion.getName())) {
						if (album.getListCancion().get(i)
								.getListInterpreteNuevo()
								.equals(cancion.getListInterpreteNuevo())) {
							JOptionPane.showMessageDialog(null,
									"Ya ha agregado esta canción",
									"Error de Agregación",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

					}
				}

				album.addCancion(cancion);
				lista2.add(cancion);
				fillList2(lista2);
			}
		});
		button_3.setBounds(11, 393, 117, 25);
		add(button_3);

		list2 = new JList();
		list2.setBounds(11, 457, 535, 142);
		add(list2);

		JLabel label_7 = new JLabel("Canciones añadidas hasta el momento:");
		label_7.setBounds(11, 430, 387, 15);
		add(label_7);

		JButton button_4 = new JButton("Crear");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Error en el Nombre del Álbum",
							"Error de Agregación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (label_check.getText().equals("Este nombre ya existe")) {
					JOptionPane.showMessageDialog(null,
							"Error en el Nombre del Álbum",
							"Error de Agregación", JOptionPane.ERROR_MESSAGE);
					return;
				}
				album.setName(textField.getText());
				String response = cp.addToDB(album);
				if (!response.equals("OK")) {
					JOptionPane.showMessageDialog(null,
							response, "Agregar Álbum",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Álbum agregado correctamente", "Perfecto",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_4.setBounds(154, 605, 117, 25);
		add(button_4);

		JButton button_5 = new JButton("Cancelar");
		button_5.setBounds(270, 605, 117, 25);
		add(button_5);

		label_check = new JLabel("");
		label_check.setBounds(225, 42, 206, 14);
		add(label_check);

	}

	private void fillList(ArrayList<Cancion> lista) {
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < lista.size(); i++) {
			model.addElement(lista.get(i).getId() + " - "
					+ lista.get(i).getName() + " - "
					+ lista.get(i).getNombreInterpretes());
		}
		list.setModel(model);
	}

	private void fillList2(ArrayList<Cancion> lista2) {
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < lista2.size(); i++) {
			model.addElement(lista2.get(i).getId() + " - "
					+ lista2.get(i).getName());
		}
		list2.setModel(model);
	}

}
