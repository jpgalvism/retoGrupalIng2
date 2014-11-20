package view;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Cancion;
import modelo.VotoCancion;
import view.ControlPrincipal;

public class PanelCargaCancion extends JPanel {
	private JTextField textField;
	private static ControlPrincipal cp = new ControlPrincipal();

	/**
	 * Create the panel.
	 */
	public PanelCargaCancion() {
		setLayout(null);

		JLabel lblSeleccioneElArchivo = new JLabel(
				"Seleccione el archivo a cargar:");
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
				String path = promptForFile();
				textField.setText(path);
			}
		});
		btnExaminar.setBounds(401, 71, 117, 25);
		add(btnExaminar);

		JButton btnCargarVotos = new JButton("Cargar Votos");
		btnCargarVotos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ArrayList<VotoCancion> array = new ArrayList<VotoCancion>();
				try {
				    FileInputStream fis = new FileInputStream(textField.getText());
				    DataInputStream dis = new DataInputStream(fis);
				    BufferedReader buffer = new BufferedReader(new InputStreamReader(
					    dis));
				    String str;
				    

				    while ((str = buffer.readLine()) != null) {
				    		String[] a = str.split("\\:@:");
				    		if (a.length!=3) {
				    			JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		int id = -1;
				    		try {
								id = Integer.parseInt(a[0]);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		int votos = -1;
				    		try {
								votos = Integer.parseInt(a[1]);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		GregorianCalendar fecha = new GregorianCalendar();
				    		try {
								DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
								Date date = df.parse(a[2]);
								
								fecha.setTime(date);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		VotoCancion vc = new VotoCancion();
				    		Cancion cancion = new Cancion();
				    		cancion = cp.getCancion(id);
				    		if (cancion == null) {
				    			JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		if (votos<1) {
				    			JOptionPane.showMessageDialog(null,
										"Error en el archivo",
										"Error de Carga", JOptionPane.ERROR_MESSAGE);
								return;
							}
				    		vc.setCancion(cancion);
				    		vc.setCantidad(votos);
				    		vc.setFecha(fecha);
				    		array.add(vc);
				    }

				    dis.close();
				    
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Error en el archivo",
							"Error de Carga", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cp.registrarVotosCancion(array);
			}
		});
		btnCargarVotos.setBounds(49, 244, 138, 25);
		add(btnCargarVotos);

	}

	private String promptForFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}

}
