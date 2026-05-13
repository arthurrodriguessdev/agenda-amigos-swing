package AgendaAmigos;

import javax.swing.*;

public class AgendaContatosApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			AgendaContatosModel model = new AgendaContatosModel();
			AgendaContatosView view = new AgendaContatosView();
			new AgendaContatosController(view, model);
			view.setVisible(true);
		});
	}
}