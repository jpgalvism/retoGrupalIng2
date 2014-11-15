package view;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setLayout(null);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CardLayout cl = (CardLayout)(FachadaP.panel.getLayout());
			      cl.show(FachadaP.panel, "PanelCrear");
			}
		});
	
		btnCrear.setBounds(121, 141, 346, 25);
		add(btnCrear);
		
		JButton btnCargarVotosCanci = new JButton("Cargar Votos Canción");
	
		btnCargarVotosCanci.setBounds(121, 178, 346, 25);
		add(btnCargarVotosCanci);
		
		JButton btnCargarVotoslbum = new JButton("Cargar Votos \u00C1lbum");
		btnCargarVotoslbum.setBounds(121, 215, 346, 25);
		add(btnCargarVotoslbum);
		
		JButton btnReportePorIntrprete = new JButton("Reporte por Int\u00E9rprete");
		btnReportePorIntrprete.setBounds(121, 252, 346, 25);
		add(btnReportePorIntrprete);
		
		JButton btnReportePorlbum = new JButton("Reporte por \u00C1lbum");
		btnReportePorlbum.setBounds(121, 289, 346, 25);
		add(btnReportePorlbum);
		
		JButton btnReportePorCancin = new JButton("Reporte por Canci\u00F3n (Rango de Fechas)");
		btnReportePorCancin.setBounds(121, 326, 346, 25);
		add(btnReportePorCancin);
		
		JButton btnReportePorlbum_1 = new JButton("Reporte por \u00C1lbum (Rango de Fechas)");
	
		btnReportePorlbum_1.setBounds(121, 363, 346, 25);
		add(btnReportePorlbum_1);

	}
}
