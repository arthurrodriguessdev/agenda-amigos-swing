package AgendaAmigos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
	private JPanel painelTitulo;
	private JLabel titulo;
	private AgendaContatosController controller;

	public DialogExcluirPessoa(AgendaContatosController controller) {
		this.controller = controller;

		estilizar();
		configurarEventos();
	}
	
	public void estilizar(){
		setTitle("Excluir Amigo");
		setModal(true);
		setLocationRelativeTo(null);

		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(javax.swing.JRootPane.FRAME);

		setBounds(100, 100, 500, 250);
		getContentPane().setLayout(new BorderLayout());

		// Painel dos botões
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		// Botão confirmar
		okButton = new JButton("Confirmar");
		okButton.setActionCommand("OK");
		okButton.setBackground(new Color(46, 204, 113));
		okButton.setForeground(Color.WHITE);
		buttonPane.add(okButton);

		getRootPane().setDefaultButton(okButton);

		// Botão cancelar
		cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBackground(new Color(231, 76, 60));
		cancelButton.setForeground(Color.WHITE);
		buttonPane.add(cancelButton);

		// Título
		titulo = new JLabel("EXCLUSÃO DE AMIGOS");
		titulo.setForeground(new Color(255, 255, 255));

		// Painel do Título
		painelTitulo = new JPanel();
		painelTitulo.setBackground(new Color(98, 160, 234));
		painelTitulo.add(titulo);

		// Painel principal
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(painelTitulo, BorderLayout.NORTH);

		// Label
		JLabel labelId = new JLabel("ID do Amigo:");
		labelId.setFont(new Font("Arial", Font.PLAIN, 18));

		// Input
		inputId = new JTextField();
		inputId.setFont(new Font("Arial", Font.PLAIN, 14));
		inputId.setColumns(15);
		panel.add(labelId);
		panel.add(inputId);
	}
	
	public void configurarEventos() {
		this.getOkButton().addActionListener(e -> confirmarExclusao());
		this.getCancelButton().addActionListener(e -> cancelarExclusao());
	}
	
	public void confirmarExclusao() {
		int idExcluir = Integer.parseInt(this.getInputId().getText());
		this.getController().excluir(idExcluir);
		dispose();
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
