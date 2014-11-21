package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Album;
import modelo.Cancion;
import view.ControlPrincipal;

public class PanelReporteCancionPorFecha extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	private static ControlPrincipal cp = new ControlPrincipal();
	private static ArrayList<Cancion> lista;
	private static JList list_1;

	/**
	 * Create the panel.
	 */
	public PanelReporteCancionPorFecha() {
		setLayout(null);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				GregorianCalendar cal = new GregorianCalendar();
				GregorianCalendar cal2 = new GregorianCalendar();

				try {
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
					Date date = df.parse(textField_2.getText());
					cal.setTime(date);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Error en Fecha Inicial", "Error de Reporte",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
					Date date = df.parse(textField_3.getText());
					cal2.setTime(date);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en Fecha Final",
							"Error de Reporte", JOptionPane.ERROR_MESSAGE);
					return;
				}

				fillList2(cp.getReportCancionByDate(cal, cal2));
			}
		});
		btnGenerarReporte.setBounds(12, 62, 161, 25);
		add(btnGenerarReporte);

		textField_2 = new JTextField();
		textField_2.setBounds(16, 35, 114, 19);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(145, 35, 114, 19);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblFechaInicial = new JLabel("Fecha Inicial: ");
		lblFechaInicial.setBounds(18, 18, 112, 15);
		add(lblFechaInicial);

		JLabel lblFechaFinal = new JLabel("Fecha Final: ");
		lblFechaFinal.setBounds(145, 18, 114, 15);
		add(lblFechaFinal);

		list_1 = new JList();
		list_1.setBounds(12, 99, 558, 397);
		add(list_1);

	}

	private void fillList2(ArrayList<String> reportAlbum) {
		
		if (reportAlbum.size() == 0)
		{
			JOptionPane.showMessageDialog(null,
					"No existe información para mostrar.",
					"Reporte", JOptionPane.INFORMATION_MESSAGE);
		}
		
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < reportAlbum.size(); i++) {
			model.addElement(reportAlbum.get(i));
		}
		list_1.setModel(model);
	}

}
