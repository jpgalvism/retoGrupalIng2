package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FachadaP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FachadaP window = new FachadaP();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		final JPanel panel = new JPanel(new CardLayout());
		frame.getContentPane().add(panel, "name_30760566072360");
		
		JPanel panel_1 = new PanelCrear();
		panel.add(panel_1, "PanelCrear");
		
		JPanel panel_2 = new PanelReporteCancionPorFecha();
		panel.add(panel_2,"PanelReporteCancionPorFecha");
		
		JPanel panel_3 = new PanelReportePorInterprete();
		panel.add(panel_3,"PanelReportePorInterprete");
		
		JPanel panel_4 = new PanelCargaCancion();
		panel.add(panel_4,"PanelCargaCancion");
		
		JPanel panel_5 = new PanelCargaAlbum();
		panel.add(panel_5,"PanelCargaAlbum");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCrear = new JMenu("Crear");
		menuBar.add(mnCrear);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "PanelCrear");
			}
		});
		mnCrear.add(mntmCrear);
		
		JMenu mnCargaDeVotos = new JMenu("Carga de Votos");
		menuBar.add(mnCargaDeVotos);
		
		JMenuItem mntmCargaDeVotos_1 = new JMenuItem("Carga de Votos Álbum");
		mntmCargaDeVotos_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "PanelCargaAlbum");
			}
		});
		mnCargaDeVotos.add(mntmCargaDeVotos_1);
		
		JMenuItem mntmCargaDeVotos = new JMenuItem("Carga de Votos Canción");
		mntmCargaDeVotos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "PanelCargaCancion");
			}
		});
		mnCargaDeVotos.add(mntmCargaDeVotos);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmReportePorIntrprete = new JMenuItem("Reporte por Intérprete");
		mntmReportePorIntrprete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "PanelReportePorInterprete");
			}
		});
		mnReportes.add(mntmReportePorIntrprete);
		
		JMenuItem mntmReportePorCancin = new JMenuItem("Reporte por Canción (Rango de Fechas)");
		mntmReportePorCancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
			      cl.show(panel, "PanelReporteCancionPorFecha");
			}
		});
		
		JMenuItem mntmReporteDeSencillos = new JMenuItem("Reporte de Sencillos de un Álbum");
		mnReportes.add(mntmReporteDeSencillos);
		mnReportes.add(mntmReportePorCancin);
		
		JMenuItem mntmReportePorlbum = new JMenuItem("Reporte por Álbum (Rango de Fechas)");
		mnReportes.add(mntmReportePorlbum);
	}

}
