package AgendaAmigos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DialogAlterarPessoa extends JDialog {

	private static final long serialVersionUID = 1L;
	private AgendaContatosController controller;
	private JTextField inputId;
	private JTextField inputNovoNome;
	private JTextField inputNovoEmail;
	private JTextField inputNovoApelido;
	private JTextField inputNovoCelular;
	private JButton okButton;
	private JButton cancelButton;
	
	public DialogAlterarPessoa(AgendaContatosController controller) {
		this.controller= controller;
		
		estilizar();
		configurarEventos();
	}
	
	void estilizar() {
		setTitle("Alterar Amigo");
		setBounds(100, 100, 755, 400);
		getContentPane().setLayout(new BorderLayout());

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("Confirmar");
		okButton.setActionCommand("OK");
		okButton.setBackground(new Color(46, 204, 113));
		okButton.setForeground(new Color(255, 255, 255));
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	
	
		cancelButton = new JButton("Cancelar");
		cancelButton.setBackground(new Color(231, 76, 60));
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel labelId = new JLabel("ID:");
		labelId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(labelId);
		
		inputId = new JTextField();
		inputId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(inputId);
		inputId.setColumns(10);
		
		JLabel labelNovoNome = new JLabel("Nome:");
		labelNovoNome.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(labelNovoNome);
		
		inputNovoNome = new JTextField();
		inputNovoNome.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNovoNome.setColumns(10);
		panel.add(inputNovoNome);
		
		JLabel labelNovoEmail = new JLabel("E-mail:");
		labelNovoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(labelNovoEmail);
		
		inputNovoEmail = new JTextField();
		inputNovoEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNovoEmail.setColumns(10);
		panel.add(inputNovoEmail);
		
		JLabel labelNovoApelido = new JLabel("Apelido:");
		labelNovoApelido.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(labelNovoApelido);
		
		inputNovoApelido = new JTextField();
		inputNovoApelido.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNovoApelido.setColumns(10);
		panel.add(inputNovoApelido);
		
		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(labelCelular);
		
		inputNovoCelular = new JTextField();
		inputNovoCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNovoCelular.setColumns(10);
		panel.add(inputNovoCelular);
	}
	
	void configurarEventos() {
		this.getOkButton().addActionListener(e -> confirmarAlteracao());
		this.getCancelButton().addActionListener(e -> cancelarAlteracao());
	}
	
	void confirmarAlteracao() {
		String novoNome = this.getInputNovoNome().getText();
		String novoEmail = this.getInputNovoEmail().getText();
		String novoCelular = this.getInputNovoCelular().getText();
		String novoApelido = this.getInputNovoApelido().getText();
		boolean podeAlterar = !novoNome.isEmpty() && !novoEmail.isEmpty() && !novoApelido.isEmpty() && !novoCelular.isEmpty();
		int id = -1;

		try{
			id = Integer.parseInt(this.getInputId().getText());
		} catch(NumberFormatException e){
			System.out.println("\nErro na conversão: " + e.getMessage());
		}

		if(id != -1 && podeAlterar){
			this.controller.alterar(
					Integer.parseInt(this.getInputId().getText()),
					this.getInputNovoNome().getText(),
					this.getInputNovoEmail().getText(),
					this.getInputNovoCelular().getText(),
					this.getInputNovoApelido().getText()
			);

			dispose();
		}
	}
	
	void cancelarAlteracao() {
		this.setVisible(false);
	}

	public AgendaContatosController getController() {
		return controller;
	}

	public void setController(AgendaContatosController controller) {
		this.controller = controller;
	}

	public JTextField getInputId() {
		return inputId;
	}

	public void setInputId(JTextField inputId) {
		this.inputId = inputId;
	}

	public JTextField getInputNovoNome() {
		return inputNovoNome;
	}

	public void setInputNovoNome(JTextField inputNovoNome) {
		this.inputNovoNome = inputNovoNome;
	}

	public JTextField getInputNovoEmail() {
		return inputNovoEmail;
	}

	public void setInputNovoEmail(JTextField inputNovoEmail) {
		this.inputNovoEmail = inputNovoEmail;
	}

	public JTextField getInputNovoApelido() {
		return inputNovoApelido;
	}

	public void setInputNovoApelido(JTextField inputNovoApelido) {
		this.inputNovoApelido = inputNovoApelido;
	}

	public JTextField getInputNovoCelular() {
		return inputNovoCelular;
	}

	public void setInputNovoCelular(JTextField inputNovoCelular) {
		this.inputNovoCelular = inputNovoCelular;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

}
