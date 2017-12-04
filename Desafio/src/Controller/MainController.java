package Controller;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;

import Model.Tela;
import body.Tarefa;

public class MainController {
	
	private static MainController instance;
	
	private ArrayList<Tarefa> list = new ArrayList<>();
	private ArrayList<Tarefa> list_1 = new ArrayList<>();
	private ArrayList<Tarefa> list_2 = new ArrayList<>();
	
	private MainController() {
		
	}
	
	public static MainController getInstance() {
		if(instance == null)
			instance = new MainController();
		
		return instance;
	}
	
	public void init() {
	 new Tela().setVisible(true);
	}

	public void add(String title, String description) {
		Tarefa tarefa = new Tarefa();
		tarefa.setTitle(title);
		tarefa.setDescription(description);
		tarefa.setDate(new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(new Date()));
		list.add(tarefa);
		list_2.add(tarefa);
		atualizaTela(list_2, 0);
		atualizaTela(list, 3);
	}
	
	public void atualizaTela(ArrayList<Tarefa> list, int number) {		
		DefaultListModel<String> model = new DefaultListModel<>();
		for(int i = 0; i < list.size(); i++) {
			model.addElement("Título: "+list.get(i).getTitle()+"  Descrissão:  "+list.get(i).getDescription()+"  Data:  "+list.get(i).getDate());
			
		}
		switch (number) {
		case 0:
			Tela.atualiza(model);
			break;
		case 1:
			Tela.atualiza2(model);
			break;
		case 3:
			Tela.atualiza3(model);
		default:
			break;
		}
	}

	public void finalize(int index) {
		list_1.add(list.get(index));
		list.remove(index);
		atualizaTela(list, 3);
		atualizaTela(list_1, 1);
	}

	public void delete(int index) {
		list.remove(index);
		atualizaTela(list_1, 3);
	}

}
