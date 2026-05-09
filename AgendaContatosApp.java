package AgendaAmigos;

import javax.swing.*;

public class AgendaContatosApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			AgendaContatosModel model = new AgendaContatosModel();
			AgendaContatosView view = new AgendaContatosView();
			AgendaContatosController controller = new AgendaContatosController(view, model);
			DialogIncluirPessoa dialog = new DialogIncluirPessoa(model, controller);
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			view.setVisible(true);
		});
	}
}