package AgendaAmigos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


public class DialogIncluirPessoa extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField inputCelular;
	private JTextField inputEmail;
	private JTextField inputApelido;
	private JTextField inputNome;
	private JButton okButton;
	private JButton cancelButton;
	private AgendaContatosModel model;
	private AgendaContatosController controller;
	
	
	public DialogIncluirPessoa(AgendaContatosModel model, AgendaContatosController controller) {
		this.model = model;
		this.controller = controller;
		
		estilizar();
		configurarEventos();
	}
	
	public void estilizar() {
		setUndecorated(true); 
	    getRootPane().setWindowDecorationStyle(javax.swing.JRootPane.FRAME);
	    
		setBounds(100, 100, 953, 510);
		getContentPane().setLayout(new BorderLayout());

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("Confirmar");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);



		JPanel painelInputs = new JPanel();
		painelInputs.setBackground(new Color(192, 192, 192));
		getContentPane().add(painelInputs, BorderLayout.CENTER);

		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Arial", Font.PLAIN, 18));
		painelInputs.add(labelCelular);
		
		
		inputCelular = new JTextField();
		inputCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		painelInputs.add(inputCelular);
		inputCelular.setColumns(10);
		
		
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		painelInputs.add(labelEmail);
		
		inputEmail = new JTextField();
		inputEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		inputEmail.setColumns(10);
		painelInputs.add(inputEmail);

		JLabel labelApelido = new JLabel("Apelido:");
		labelApelido.setFont(new Font("Arial", Font.PLAIN, 18));
		painelInputs.add(labelApelido);
		
		inputApelido = new JTextField();
		inputApelido.setFont(new Font("Arial", Font.PLAIN, 14));
		inputApelido.setColumns(10);
		painelInputs.add(inputApelido);

		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Arial", Font.PLAIN, 18));
		painelInputs.add(labelNome);
	
	
		inputNome = new JTextField();
		inputNome.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNome.setColumns(10);
		painelInputs.add(inputNome);
	}
	
	public void configurarEventos() {
		this.getOkButton().addActionListener(e -> confirmarInclusao());
		this.getCancelButton().addActionListener(e -> cancelarInclusao());
	}
	
	// Métodos de Eventos
	public void confirmarInclusao() {
		controller.incluir(
				this.getInputNome().getText(),
				this.getInputEmail().getText(),
				this.getInputCelular().getText(),
				this.getInputApelido().getText()
		);
	}
	
	public void cancelarInclusao() {
		this.setVisible(false);
	}
	
	
	// Getters e Setters
	public JTextField getInputCelular() {
		return inputCelular;
	}

	public void setInputCelular(JTextField inputCelular) {
		this.inputCelular = inputCelular;
	}

	public JTextField getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(JTextField inputEmail) {
		this.inputEmail = inputEmail;
	}

	public JTextField getInputApelido() {
		return inputApelido;
	}

	public void setInputApelido(JTextField inputApelido) {
		this.inputApelido = inputApelido;
	}

	public JTextField getInputNome() {
		return inputNome;
	}

	public void setInputNome(JTextField inputNome) {
		this.inputNome = inputNome;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AgendaContatosModel getModel() {
		return model;
	}

	public void setModel(AgendaContatosModel model) {
		this.model = model;
	}

}
