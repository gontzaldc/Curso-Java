package com.gontzal.ipartek.uf1844;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class SwingWindowBuilder {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JButton btnNewButton;

	public ArrayList<Persona> personas = new ArrayList<>();
	private JButton btnAdd;
	private JPanel panelForm;

	private DefaultTableModel tableModel;
	private JPanel panelVista;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingWindowBuilder window = new SwingWindowBuilder();
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
	public SwingWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 0, 414, 22);
		frame.getContentPane().add(menuBar);

		btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelVista.setVisible(false);
				panelForm.setVisible(true);
			}
		});
		menuBar.add(btnAdd);

		JButton btnNewButton_1 = new JButton("Ver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelForm.setVisible(false);
				panelVista.setVisible(true);
				System.out.println(personas);

				tableModel.addColumn("Languages");
				tableModel.insertRow(0, new Object[] { "CSS" });
				tableModel.insertRow(0, new Object[] { "HTML5" });
				tableModel.insertRow(0, new Object[] { "JavaScript" });
				tableModel.insertRow(0, new Object[] { "jQuery" });
				tableModel.insertRow(0, new Object[] { "AngularJS" });
				// adding a new row
				tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });

			}
		});
		menuBar.add(btnNewButton_1);

		panelForm = new JPanel();
		panelForm.setVisible(false);
		panelForm.setBounds(30, 33, 404, 110);
		frame.getContentPane().add(panelForm);
		panelForm.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(37, 9, 79, 14);
		panelForm.add(lblNewLabel);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(126, 6, 211, 20);
		panelForm.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(37, 34, 79, 14);
		panelForm.add(lblNewLabel_1);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(126, 31, 211, 20);
		panelForm.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(37, 77, 63, 23);
		panelForm.add(btnNewButton);

		panelVista = new JPanel();
		panelVista.setVisible(false);
		panelVista.setBounds(20, 152, 404, 98);
		frame.getContentPane().add(panelVista);
		panelVista.setLayout(null);

		table = new JTable();
		table.setBounds(202, 5, 0, 0);
		panelVista.add(table);

		table_1 = new JTable();
		table_1.setForeground(Color.DARK_GRAY);
		table_1.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Apellido", "Nombre" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table_1.setBounds(27, 5, 340, 82);
		panelVista.add(table_1);

		DefaultTableModel tableModel = new DefaultTableModel();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Persona p = new Persona();

				p.setNombre(textFieldNombre.getText());
				p.setApellido(textFieldApellido.getText());

				personas.add(p);

			}
		});
	}
}
