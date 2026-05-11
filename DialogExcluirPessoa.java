// package AgendaAmigos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DialogExcluirPessoa extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField inputId;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel buttonPane;
	private AgendaContatosController controller;

	public DialogExcluirPessoa(AgendaContatosController controller) {
		this.controller = controller;

		estilizar();
		configurarEventos();
	}
	
	public void estilizar(){
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel labelId = new JLabel("ID do Amigo:");
		labelId.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(labelId);
		
		inputId = new JTextField();
		inputId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(inputId);
		inputId.setColumns(10);
	}
	
	public void configurarEventos() {
		this.getOkButton().addActionListener(e -> confirmarExclusao());
		this.getCancelButton().addActionListener(e -> cancelarExclusao());
	}
	
	public void confirmarExclusao() {
		int idExcluir = Integer.parseInt(this.getInputId().getText());
		this.getController().excluir(idExcluir);
	}
	
	public void cancelarExclusao() {
		this.setVisible(false);
	}

	public JTextField getInputId() {
		return inputId;
	}

	public void setInputId(JTextField inputId) {
		this.inputId = inputId;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JPanel getButtonPane() {
		return buttonPane;
	}

	public void setButtonPane(JPanel buttonPane) {
		this.buttonPane = buttonPane;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AgendaContatosController getController() {
		return controller;
	}

	public void setController(AgendaContatosController controller) {
		this.controller = controller;
	}
}
