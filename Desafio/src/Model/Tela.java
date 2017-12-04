package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.MainController;

import javax.swing.JTabbedPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela extends JFrame {
	
	private JScrollPane scrollPane;
	private static JList<String> list, list_1, list_2;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 534, 361);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Todas as Atividades", null, panel_1, null);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 52, 500, 270);
		panel_1.add(scrollPane);
		
		list = new JList();
	
		scrollPane.setViewportView(list);
		
		JButton btnNovaTarefa = new JButton("nova");
		btnNovaTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add().setVisible(true);;
			}
		});
		btnNovaTarefa.setBounds(10, 11, 89, 23);
		panel_1.add(btnNovaTarefa);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atividades Pendentes", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 509, 311);
		panel.add(scrollPane_1);
		
		list_2 = new JList();
		scrollPane_1.setViewportView(list_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Atividades Finalizadas", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 509, 311);
		panel_3.add(scrollPane_2);
		
		list_1 = new JList();
		scrollPane_2.setViewportView(list_1);
		
		list_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
		        JList list_aux = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
		            int index = list_aux.locationToIndex(evt.getPoint());
		            String[] buttons = { "Finalizar", "Excluir", "Cancel"};    
		            int returnValue = JOptionPane.showOptionDialog(null, "Narrative", "Narrative",
		            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons);
		            switch (returnValue) {
					case 0:
						MainController.getInstance().finalize(index);
						break;
					case 1:
						MainController.getInstance().delete(index);
						break;

					default:
						break;
					}
		        }
		    }
		});
		
	}
	
	public  static void atualiza(DefaultListModel<String> model){
		list.setModel(model);
	}

	public static void atualiza2(DefaultListModel<String> model) {
		list_1.setModel(model);
	}
	
	public static void atualiza3(DefaultListModel<String> model) {
		list_2.setModel(model);
	}
	
}
