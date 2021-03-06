/**
 * Clase Principal donde se encuentra el GUI
 * @author Andres Urizar
 * @author Rodrigo Samayoa
 * @author Guillermo Sandoval
 * @version 29/09/17
 */

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;


public class Main {

	private JFrame frmProgramaDeOrganizacin;
	private JTextField[][] t = new JTextField[7][11];
	private JLabel[] l = new JLabel[11];
	private JLabel[] d = new JLabel[7];
	private int opcion = 0;
	private Horario horario = new Horario(7,11);
	private Agenda agenda = new Agenda(8);
	private Database database = new Database();
	private Recordatorio recordatorio = new Recordatorio(0);
	private JButton btnGuardar;
	private JButton btnMostrar;
	private JButton btnModificar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel Nombre;
	private JLabel Carrera;
	private JLabel Carnet;
	private JLabel Semestre;
	private JLabel lblAoEnCurso;
	private JLabel lblCarrera;
	private JLabel lblCarnet;
	private JLabel lblNombre; 
	private JComboBox comboBox;
	private JTextField textField_4;
	private JEditorPane editorPane;
	private JComboBox comboBox_1;
	private JTextField textField_5;
	private JLabel opnumero;
	private JToggleButton modo;
	private JEditorPane editorPane2;
	private JButton btnRedes;
	private JComboBox comboBoxTiempo;
	private JRadioButton rdbtnFacebook;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JTextField textField_6;
	private JButton btnInicio;
	

	public void salir()
	{
		System.exit(0);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmProgramaDeOrganizacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * M�todo para instanciar textfields para el horario
	 */
	public void crearText()
	{
		int columna = 230;
		int fila = 90;
		for(int i=0;i<7;i++)
		{
			fila = 90;
			for(int j=0;j<11;j++)
			{
				t[i][j] = new JTextField();
				t[i][j].setBounds(new Rectangle(columna,fila,80,20));
				t[i][j].setVisible(false);
				t[i][j].setText("");
				frmProgramaDeOrganizacin.getContentPane().add(t[i][j],null);
				fila += 20;
			}
			columna +=80;
		}
	}
	/**
	 * M�todo para instanciar los labels para escribir el dia y la hora
	 */
	public void crearLabel()
	{
		int y = 130;
		int x = 90;
		int hora=7;
		String minutos;
		int minuto=0;
		String tiempo;
		for(int i=0;i<11;i++)
		{
			tiempo = "";
			l[i] = new JLabel();
			l[i].setBounds(new Rectangle(y,x,80,20));
			if(minuto == 0)
			{
				minutos = minuto+"0";
			}else
			{
				minutos = Integer.toString(minuto);
			}
			tiempo = hora+":"+minutos;
			frmProgramaDeOrganizacin.getContentPane().add(l[i],null);
			l[i].setVisible(false);
			minuto += 45;
			if(minuto>=60)
			{
				minuto -= 60;
				hora+=1;
				if(minuto == 0)
				{
					minutos = minuto+"0";
				}else
				{
					minutos = Integer.toString(minuto);
				}
			}
			tiempo += " - "+hora+":"+minutos;
			l[i].setText(tiempo);
			x+=20;
		}
		y = 230;
		x = 70;
		for(int j=0;j<7;j++)
		{
			d[j] = new JLabel();
			d[j].setBounds(new Rectangle(y,x,80,20));
			frmProgramaDeOrganizacin.getContentPane().add(d[j], null);
			d[j].setVisible(false);
			y += 80;
		}
		d[0].setText("Lunes");
		d[1].setText("Martes");
		d[2].setText("Miercoles");
		d[3].setText("Jueves");
		d[4].setText("Viernes");
		d[5].setText("Sabado");
		d[6].setText("Domingo");
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProgramaDeOrganizacin = new JFrame();
		frmProgramaDeOrganizacin.setTitle("Programa de organizaci\u00F3n de estudiantes");
		frmProgramaDeOrganizacin.getContentPane().setBackground(new Color(255, 255, 153));
		frmProgramaDeOrganizacin.setBounds(100, 100, 844, 470);
		frmProgramaDeOrganizacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearText();
		crearLabel();
		frmProgramaDeOrganizacin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 819, 50);
		panel.setBackground(new Color(0, 128, 0));
		frmProgramaDeOrganizacin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UVG");
		lblNewLabel.setBounds(10, 11, 52, 27);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		Nombre = new JLabel("");
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Arial", Font.PLAIN, 17));
		Nombre.setBounds(124, 11, 306, 14);
		panel.add(Nombre);
		
		Carrera = new JLabel("");
		Carrera.setForeground(Color.WHITE);
		Carrera.setFont(new Font("Arial", Font.PLAIN, 17));
		Carrera.setBounds(124, 36, 355, 14);
		panel.add(Carrera);
		
		Carnet = new JLabel("");
		Carnet.setFont(new Font("Arial", Font.PLAIN, 17));
		Carnet.setForeground(Color.WHITE);
		Carnet.setBounds(531, 11, 144, 14);
		panel.add(Carnet);
		
		Semestre = new JLabel("");
		Semestre.setFont(new Font("Arial", Font.PLAIN, 17));
		Semestre.setForeground(Color.WHITE);
		Semestre.setBounds(531, 36, 171, 14);
		panel.add(Semestre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 126, 363);
		panel_1.setBackground(new Color(50, 205, 50));
		panel_1.setForeground(new Color(0, 0, 0));
		frmProgramaDeOrganizacin.getContentPane().add(panel_1);
		JButton btnIngresar = new JButton("Menu principal");
		btnIngresar.setBounds(-5, 5, 137, 29);
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnIngresar.setBorderPainted(false);
		btnIngresar.setDefaultCapable(false);
		btnIngresar.setContentAreaFilled(false);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcion = 1;
				comboBox_1.setVisible(false);
				opnumero.setVisible(false);
				btnModificar.setVisible(false);
				btnMostrar.setText("Reiniciar");
				modo.setVisible(false);
				btnMostrar.setVisible(false);
				btnGuardar.setVisible(false);
				comboBox.setVisible(false);
				textField_4.setVisible(false);
				textField_5.setVisible(false);
				editorPane.setVisible(true);
				editorPane.setText("Recordatorios secundarios"+"\n"+recordatorio.mostrarRecordatorio(2));
				editorPane2.setVisible(true);
				editorPane2.setText("Recordatorios de prioridad"+"\n"+recordatorio.mostrarRecordatorio(1));
				lblCarrera.setVisible(false);
				rdbtnFacebook.setVisible(false);
				for(int i=0;i<7;i++)
				{
					for(int j=0;j<11;j++)
					{
						t[i][j].setVisible(false);
					}
				}
				for(int i=0;i<11;i++)
				{
					l[i].setVisible(false);
				}
				for(int i=0;i<7;i++)
				{
					d[i].setVisible(false);
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnIngresar);
		
		JButton btnHorario = new JButton("Horario"); //Boton de horario
		btnHorario.setBounds(17, 39, 91, 29);
		btnHorario.setFont(new Font("Arial", Font.PLAIN, 14));
		btnHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
				}else {
				opcion = 1;
				comboBox_1.setVisible(false);
				opnumero.setVisible(false);
				textField_5.setVisible(false);
				modo.setVisible(false);
				btnModificar.setVisible(true);
				btnMostrar.setText("Mostrar");
				btnMostrar.setVisible(true);
				btnGuardar.setVisible(true);
				comboBox.setVisible(false);
				textField_4.setVisible(false);
				editorPane.setVisible(false);
				editorPane2.setVisible(false);
				lblCarrera.setVisible(false);
				rdbtnFacebook.setVisible(false);
				for(int i=0;i<7;i++)
				{
					for(int j=0;j<11;j++)
					{
						t[i][j].setVisible(true);
					}
				}
				for(int i=0;i<11;i++)
				{
					l[i].setVisible(true);
				}
				for(int i=0;i<7;i++)
				{
					d[i].setVisible(true);
				}
			}
			}
		});
		btnHorario.setBorderPainted(false);
		btnHorario.setDefaultCapable(false);
		btnHorario.setContentAreaFilled(false);
		panel_1.add(btnHorario);
		
		JButton btnRecordatorios = new JButton("Recordatorios");
		btnRecordatorios.setBounds(-3, 73, 133, 29);
		btnRecordatorios.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRecordatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
				}else {
					comboBox_1.setVisible(true);
					opcion = 3;
					modo.setVisible(true);
					btnModificar.setVisible(false);
					btnMostrar.setText("Remover");
					btnMostrar.setVisible(false);
					btnGuardar.setVisible(true);
					comboBox.setVisible(false);
					textField_4.setVisible(true);
					editorPane.setVisible(false);
					editorPane2.setVisible(false);
					lblCarrera.setVisible(false);
					rdbtnFacebook.setVisible(false);
					for(int i=0;i<7;i++)
					{
						for(int j=0;j<11;j++)
						{
							t[i][j].setVisible(false);
						}
					}
					for(int i=0;i<11;i++)
					{
						l[i].setVisible(false);
					}
					for(int i=0;i<7;i++)
					{
						d[i].setVisible(false);
					}
				}
			}
		});
		btnRecordatorios.setContentAreaFilled(false);
		btnRecordatorios.setBorderPainted(false);
		panel_1.add(btnRecordatorios);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(16, 107, 93, 29);
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
				}else {
				opcion = 2;
				comboBox_1.setVisible(false);
				modo.setVisible(false);
				btnModificar.setVisible(false);
				opnumero.setVisible(false);
				textField_5.setVisible(false);
				btnGuardar.setVisible(true);
				btnMostrar.setVisible(true);
				btnMostrar.setText("Reiniciar");
				comboBox.setVisible(true);
				textField_4.setVisible(true);
				editorPane.setVisible(true);
				editorPane.setText("");
				editorPane2.setVisible(false);
				lblCarrera.setText("Ingrese un evento");
				lblCarrera.setVisible(true);
				
				
				rdbtnFacebook.setVisible(false);
				rdbtnFacebook_1.setVisible(false);
				rdbtnInstagram.setVisible(false);
				rdbtnTwitter.setVisible(false);
				
				for(int i=0;i<7;i++)
				{
					for(int j=0;j<11;j++)
					{
						t[i][j].setVisible(false);
					}
				}
				for(int i=0;i<11;i++)
				{
					l[i].setVisible(false);
				}
				for(int i=0;i<7;i++)
				{
					d[i].setVisible(false);
				}
			 }
			}
		});
		btnAgenda.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAgenda.setBorderPainted(false);
		btnAgenda.setContentAreaFilled(false);
		btnAgenda.setDefaultCapable(false);
		panel_1.add(btnAgenda);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBorderPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setDefaultCapable(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(-5, 318, 133, 29);
		panel_1.add(btnSalir);
		
		btnRedes = new JButton("Redes Sociales");
		btnRedes.setBounds(6, 141, 126, 42);
		panel_1.add(btnRedes);
		btnRedes.setBackground(new Color(240, 240, 240));
		btnRedes.setBorderPainted(false);
		btnRedes.setContentAreaFilled(false);
		btnRedes.setDefaultCapable(false);
		btnRedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setVisible(true);
				opcion = 3;
				modo.setVisible(false);
				btnModificar.setVisible(false);
				btnMostrar.setVisible(false);
				btnGuardar.setVisible(false);
				comboBox.setVisible(false);
				textField_4.setVisible(false);
				editorPane.setVisible(false);
				editorPane2.setVisible(false);
				lblCarrera.setVisible(false);
				rdbtnFacebook.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNombre.setVisible(false);
				lblCarnet.setVisible(false);
				lblAoEnCurso.setVisible(false);
				lblCarrera.setVisible(false);
				
				
				comboBox_2.setVisible(true);
				comboBox_3.setVisible(true);
				btnInicio.setVisible(true);
				textField_6.setVisible(true);
				
				
				
			}
		});	
		btnRedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(720, 368, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion == 0)
				{
					if(textField.getText().equals("") || textField_2.getText().equals("") || textField_1.getText().equals("") || textField_3.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
					}else
					{
					Nombre.setText(textField.getText());
					Carrera.setText(textField_2.getText());
					Carnet.setText("Carnet #"+textField_1.getText());
					Semestre.setText("Semestre: "+textField_3.getText());	
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					textField_3.setVisible(false);
					lblAoEnCurso.setVisible(false);
					lblCarrera.setVisible(false);
					lblCarnet.setVisible(false);
					lblNombre.setVisible(false);
					btnGuardar.setVisible(false);
					opcion = 4;
					editorPane.setVisible(true);
					editorPane2.setVisible(true);
					editorPane.setText("Aun no hay recordatorios");
					editorPane2.setText("Aun no hay recordatorios");
					}
				}else
				if(opcion == 1)
				{
					String clase;
					for(int i=0;i<7;i++)
					{
						for(int j=0;j<11;j++)
						{
							clase = t[i][j].getText();
							horario.ingresarClase(i, j, clase);
							database.guardarHorario(horario);
						}
					}
					for(int i=0;i<7;i++)
					{
						for(int j=0;j<11;j++)
						{
							t[i][j].setText("");
						}
					}
					JOptionPane.showMessageDialog(null, "Ha sido guardado con exito");
				}else
				if(opcion == 2)
				{
					if(comboBox.getSelectedIndex() == 0 || textField_4.getText()== null)
					{
						JOptionPane.showMessageDialog(null, "Tiene que marcar una dia para poder guardar el evento, o no ha ingresado un evento");
					}else
					{
					String texto = textField_4.getText();
					agenda.ingresarEvento(comboBox.getSelectedIndex(), texto);
					database.guardarAgenda(agenda);
					JOptionPane.showMessageDialog(null, "Ha sido guardado con exito");
					editorPane.setText(agenda.mostrarEvento(comboBox.getSelectedIndex()));
					textField_4.setText("");
					}
				}else
				if(opcion == 3)
				{
					if(comboBox_1.getSelectedIndex() == 0 || textField_4.getText() == null)
					{
						JOptionPane.showMessageDialog(null, "Debe marcar la importancia del recordatorio, o ingresar alg�n recordatorio");
					}else
					{
						String texto = textField_4.getText();
						recordatorio.ingresarRecordatorio(texto, comboBox_1.getSelectedIndex());
						database.guardarRecordatorio(recordatorio);
						JOptionPane.showMessageDialog(null, "Ha sido guardado con exito");
						textField_4.setText("");
					}
				}
			}
		});
		frmProgramaDeOrganizacin.getContentPane().add(btnGuardar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(621, 368, 89, 23);
		btnMostrar.setVisible(false);
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion==1)
				{
					for(int i=0;i<7;i++)
					{
						for(int j=0;j<11;j++)
						{
							t[i][j].setEditable(false);
							t[i][j].setText(horario.mostrarClase(i, j));
						}
					}
				}
				if(opcion == 2)
				{
					agenda.reiniciardia(comboBox.getSelectedIndex());
					if(comboBox.getSelectedIndex() == 1)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia lunes han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 2)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia martes han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 3)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia miercoles han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 4)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia jueves han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 5)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia viernes han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 6)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia sabado han sido marcadas como realizadas");
						editorPane.setText("");
					}else
					if(comboBox.getSelectedIndex() == 7)
					{
						JOptionPane.showMessageDialog(null, "Las actividades del dia domingo han sido marcadas como realizadas");
						editorPane.setText("");
					}
				}
				if(opcion == 5)
				{	
					try {
					int Numero = Integer.parseInt(textField_5.getText());
					recordatorio.marcarRecordatorio(comboBox_1.getSelectedIndex(), Numero);
					editorPane.setText(recordatorio.mostrarTodo());
					}
					catch(Exception exception) {
						JOptionPane.showMessageDialog(null, "Debe ingresar un n�mero para escoger opci�n");
					}
					
				}
			}
		});
		frmProgramaDeOrganizacin.getContentPane().add(btnMostrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(522, 368, 89, 23);
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion==1)
				{
					for(int i=0;i<7;i++)
					{
						for(int j=0;j<11;j++)
						{
							t[i][j].setEditable(true);
							t[i][j].setText(horario.mostrarClase(i, j));
						}
					}
				}
			}
		});
		frmProgramaDeOrganizacin.getContentPane().add(btnModificar);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(144, 61, 51, 15);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		frmProgramaDeOrganizacin.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(194, 59, 224, 20);
		frmProgramaDeOrganizacin.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblCarnet = new JLabel("Carnet:");
		lblCarnet.setBounds(504, 61, 46, 14);
		lblCarnet.setFont(new Font("Arial", Font.PLAIN, 12));
		frmProgramaDeOrganizacin.getContentPane().add(lblCarnet);
		
		textField_1 = new JTextField();
		textField_1.setBounds(560, 59, 111, 20);
		frmProgramaDeOrganizacin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(144, 87, 118, 14);
		lblCarrera.setFont(new Font("Arial", Font.PLAIN, 12));
		frmProgramaDeOrganizacin.getContentPane().add(lblCarrera);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 85, 224, 20);
		frmProgramaDeOrganizacin.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblAoEnCurso = new JLabel("Semestre:");
		lblAoEnCurso.setBounds(504, 88, 75, 14);
		lblAoEnCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		frmProgramaDeOrganizacin.getContentPane().add(lblAoEnCurso);
		
		textField_3 = new JTextField();
		textField_3.setBounds(570, 86, 32, 18);
		frmProgramaDeOrganizacin.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(136, 61, 151, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 1)
				{
					editorPane.setText(agenda.mostrarEvento(1));
				}else
				if(comboBox.getSelectedIndex() == 2)
				{
					editorPane.setText(agenda.mostrarEvento(2));
				}else
				if(comboBox.getSelectedIndex() == 3)
				{
					editorPane.setText(agenda.mostrarEvento(3));
				}else
				if(comboBox.getSelectedIndex() == 4)
				{
					editorPane.setText(agenda.mostrarEvento(4));
				}else
				if(comboBox.getSelectedIndex() == 5)
				{
					editorPane.setText(agenda.mostrarEvento(5));
				}
				else
				if(comboBox.getSelectedIndex() == 6)
				{
					editorPane.setText(agenda.mostrarEvento(6));
				}
				else
				if(comboBox.getSelectedIndex() == 7)
				{
					editorPane.setText(agenda.mostrarEvento(7));
				}
			}
		});
		comboBox.setVisible(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia de la semana", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		comboBox.setToolTipText("");
		frmProgramaDeOrganizacin.getContentPane().add(comboBox);
		
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(136, 112, 282, 20);
		textField_4.setVisible(false);
		frmProgramaDeOrganizacin.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(136, 143, 164, 20);
		comboBox_1.setVisible(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Nivel de importancia", "Prioridad", "Secundario"}));
		frmProgramaDeOrganizacin.getContentPane().add(comboBox_1);
		
		modo = new JToggleButton("Modo Agregar");
		modo.setBounds(333, 142, 121, 23);
		modo.setForeground(Color.BLACK);
		modo.setBackground(Color.GREEN);
		modo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modo.isSelected())
				{
					modo.setBackground(Color.red);
					modo.setText("Modo Borrar");
					opnumero.setVisible(true);
					textField_4.setVisible(false);
					textField_5.setVisible(true);
					editorPane.setVisible(true);
					editorPane.setText(recordatorio.mostrarTodo());
					btnGuardar.setVisible(false);
					btnMostrar.setVisible(true);
					opcion = 5;
				}else
				{
					modo.setBackground(Color.green);
					modo.setText("Modo Agregar");
					opnumero.setVisible(false);
					textField_4.setVisible(true);
					textField_5.setVisible(false);
					editorPane.setVisible(false);
					btnGuardar.setVisible(true);
					btnMostrar.setVisible(false);
					opcion = 3;
				}
			}
		});
		modo.setVisible(false);
		frmProgramaDeOrganizacin.getContentPane().add(modo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(179, 174, 32, 20);
		textField_5.setVisible(false);
		frmProgramaDeOrganizacin.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		opnumero = new JLabel("Opcion:");
		opnumero.setBounds(136, 177, 46, 14);
		opnumero.setVisible(false);
		frmProgramaDeOrganizacin.getContentPane().add(opnumero);
		
		editorPane2 = new JEditorPane();
		editorPane2.setBounds(154, 71, 259, 275);
		editorPane2.setEditable(false);
		editorPane2.setBackground(new Color(255, 140, 0));
		editorPane2.setVisible(false);
		editorPane2.setForeground(new Color(0, 0, 0));
		frmProgramaDeOrganizacin.getContentPane().add(editorPane2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tiempo para asignar", "5 minutos", "10 minutos", "15 minutos"}));
		comboBox_2.setBounds(622, 140, 187, 26);
		comboBox_2.setVisible(true);
		frmProgramaDeOrganizacin.getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Red social", "Facebook", "Twitter", "Instagram"}));
		comboBox_3.setBounds(650, 188, 159, 26);
		comboBox_3.setVisible(true);
		frmProgramaDeOrganizacin.getContentPane().add(comboBox_3);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(683, 240, 126, 26);
		textField_6.setVisible(true);
		frmProgramaDeOrganizacin.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setVisible(true);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(btnInicio.getText() == "Inicio")
				{
					btnInicio.setText("Parar");
					RedesSociales tiempo = new RedesSociales();
					tiempo.timerFB();
					textField_6.setText(""+tiempo);
				}
				if(btnInicio.getText() == "Parar")
				{
					btnInicio.setText("Inicio");
				}
					
				
			}
		});
		btnInicio.setBounds(694, 282, 115, 29);
		frmProgramaDeOrganizacin.getContentPane().add(btnInicio);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(451, 71, 259, 275);
		editorPane.setBackground(new Color(0, 191, 255));
		editorPane.setVisible(false);
		editorPane.setEditable(false);
		frmProgramaDeOrganizacin.getContentPane().add(editorPane);
	}
}
