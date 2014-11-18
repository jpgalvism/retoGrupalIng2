package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControlPrincipal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FachadaP {

	public static JFrame frame;
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FachadaP window = new FachadaP();
					window.frame.setVisible(true);
					window.isConnected();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void isConnected() {
		ControlPrincipal cp = new ControlPrincipal();
		String response = cp.isConnected();
		if (!response.equals("OK")) {
			JOptionPane.showMessageDialog(null, "ERROR: No se puede abrir conexiÃƒÂ³n a la base de datos, por favor verifique los parametros de conexiÃƒÂ³n. \n" + response, "ConexiÃƒÂ³n BD",
					JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}

	}

	/**
	 * Create the application.
	 */
	public FachadaP() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panel = new JPanel(new CardLayout());
		frame.getContentPane().add(panel, "name_30760566072360");

		JPanel panel_0 = new PanelPrincipal();
		panel.add(panel_0, "PanelPrincipal");

		JPanel panel_1 = new PanelCrear();
		panel.add(panel_1, "PanelCrear");

		JPanel panel_2 = new PanelReporteCancionPorFecha();
		panel.add(panel_2, "PanelReporteCancionPorFecha");

		JPanel panel_3 = new PanelReportePorInterprete();
		panel.add(panel_3, "PanelReportePorInterprete");

		JPanel panel_4 = new PanelCargaCancion();
		panel.add(panel_4, "PanelCargaCancion");

		JPanel panel_5 = new PanelCargaAlbum();
		panel.add(panel_5, "PanelCargaAlbum");

		JPanel panel_6 = new PanelReportePorAlbum();
		panel.add(panel_6, "PanelReportePorAlbum");

		JPanel panel_7 = new PanelReporteAlbumPorFecha();
		panel.add(panel_7, "PanelReporteAlbumPorFecha");

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnPrincipal = new JMenu("Principal");
		mnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelPrincipal");
			}
		});
		menuBar.add(mnPrincipal);

		JMenu mnCrear = new JMenu("Crear");
		mnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelCrear");
			}
		});
		menuBar.add(mnCrear);

		JMenu mnCargaDeVotos = new JMenu("Carga de Votos");
		menuBar.add(mnCargaDeVotos);

		JMenuItem mntmCargaDeVotos_1 = new JMenuItem("Carga de Votos Álbum");
		mntmCargaDeVotos_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelCargaAlbum");
			}
		});
		mnCargaDeVotos.add(mntmCargaDeVotos_1);

		JMenuItem mntmCargaDeVotos = new JMenuItem("Carga de Votos Canción");
		mntmCargaDeVotos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelCargaCancion");
			}
		});
		mnCargaDeVotos.add(mntmCargaDeVotos);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmReportePorIntrprete = new JMenuItem(
				"Reporte por IntÃƒÂ©rprete");
		mntmReportePorIntrprete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelReportePorInterprete");
			}
		});
		mnReportes.add(mntmReportePorIntrprete);

		JMenuItem mntmReportePorCancin = new JMenuItem(
				"Reporte por Canción (Rango de Fechas)");
		mntmReportePorCancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelReporteCancionPorFecha");
			}
		});

		JMenuItem mntmReporteDeSencillos = new JMenuItem(
				"Reporte de Sencillos de un Álbum");
		mntmReporteDeSencillos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelReportePorAlbum");
			}
		});
		mnReportes.add(mntmReporteDeSencillos);
		mnReportes.add(mntmReportePorCancin);

		JMenuItem mntmReportePorlbum = new JMenuItem(
				"Reporte por Ã�lbum (Rango de Fechas)");
		mntmReportePorlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, "PanelReporteAlbumPorFecha");
			}
		});
		mnReportes.add(mntmReportePorlbum);

	}

}
