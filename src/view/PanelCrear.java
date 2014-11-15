package view;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class PanelCrear extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
			     
			  }
			});
		textField.setColumns(10);
		textField.setBounds(12, 39, 206, 19);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 85, 208, 19);
		add(textField_1);
		
		JLabel label_1 = new JLabel("Buscar ID");
		label_1.setBounds(12, 70, 95, 15);
		add(label_1);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(228, 82, 117, 25);
		add(button_1);
		
		JList list = new JList();
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
		
		JLabel label_6 = new JLabel("IntÃ©rpretes (separados por coma):");
		label_6.setBounds(252, 343, 258, 15);
		add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(252, 370, 258, 19);
		add(textField_4);
		
		JButton button_3 = new JButton("AÃ±adir");
		button_3.setBounds(11, 393, 117, 25);
		add(button_3);
		
		JList list_1 = new JList();
		list_1.setBounds(11, 457, 535, 142);
		add(list_1);
		
		JLabel label_7 = new JLabel("Canciones aÃ±adidas hasta el momento:");
		label_7.setBounds(11, 430, 387, 15);
		add(label_7);
		
		JButton button_4 = new JButton("Crear");
		button_4.setBounds(154, 605, 117, 25);
		add(button_4);
		
		JButton button_5 = new JButton("Cancelar");
		button_5.setBounds(270, 605, 117, 25);
		add(button_5);
		
		}

}
