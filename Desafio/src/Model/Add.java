package Model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MainController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar nova Tarefa");
		lblNewLabel.setBounds(110, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(10, 31, 46, 14);
		contentPane.add(lblTtulo);
		
		textField = new JTextField();
		textField.setBounds(10, 56, 314, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescrisso = new JLabel("Descriss\u00E3o");
		lblDescrisso.setBounds(10, 87, 93, 14);
		contentPane.add(lblDescrisso);
		
		btnSave = new JButton("add");
		btnSave.setBounds(235, 277, 89, 23);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(130, 277, 89, 23);
		contentPane.add(btnCancel);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 112, 314, 155);
		contentPane.add(textArea);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().add(textField.getText().toString(), textArea.getText().toString());
				dispose();
			}
		});
	}
}
