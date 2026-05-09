package AgendaAmigos;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class AgendaContatosView extends JFrame{
	private JPanel painelBotoes;
	private JButton btnExcluir;
	private JButton btnIncluir;
	private JButton btnBuscar;
	private JButton btnAlterar;
	private JTable tabelaAmigos;
	private DefaultTableModel modeloTabela;
	private JDialog dialogAdicionar;
	private static final String[] colunasTabela = {
			"ID", "Nome", "Apelido", "E-mail", "Celular"
	};

	public AgendaContatosView() {
		initialize();
		montarColunas();
	}

	private void initialize() {
		setBounds(100, 100, 540, 474);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(98, 160, 234));
		getContentPane().add(painelBotoes, BorderLayout.SOUTH);
		
		btnExcluir = new JButton("Excluir");
		painelBotoes.add(btnExcluir);
		
		btnIncluir = new JButton("Incluir");
		painelBotoes.add(btnIncluir);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		painelBotoes.add(btnBuscar);
		
		btnAlterar = new JButton("Alterar");
		painelBotoes.add(btnAlterar);
		
		// Tabela
		modeloTabela = new DefaultTableModel();
		tabelaAmigos = new JTable(modeloTabela);
		tabelaAmigos.setColumnSelectionAllowed(true);
		tabelaAmigos.setRowSelectionAllowed(false);
		tabelaAmigos.setBorder(new LineBorder(new Color(53, 132, 228), 1, true));
		tabelaAmigos.setBackground(new Color(222, 221, 218));
		add(new JScrollPane(tabelaAmigos), BorderLayout.CENTER);
	}
	
	public void atualizarIncluirLista(Amigo novoAmigo) {
		this.getModeloTabela().addRow(new Object[] {
				novoAmigo.getId(),
				novoAmigo.getNome(),
				novoAmigo.getApelido(),
				novoAmigo.getEmail(),
				novoAmigo.getCelular()	
		});
	}
	
	public void montarColunas() {
		for(int i = 0; i < colunasTabela.length; i++) {
			this.getModeloTabela().addColumn(colunasTabela[i]);
		}
	}
	
	// Getters e Setters
	public JPanel getPainelBotoes() {
		return painelBotoes;
	}

	public void setPainelBotoes(JPanel painelBotoes) {
		this.painelBotoes = painelBotoes;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnIncluir() {
		return btnIncluir;
	}

	public void setBtnIncluir(JButton btnIncluir) {
		this.btnIncluir = btnIncluir;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public JTable getTabelaAmigos() {
		return tabelaAmigos;
	}

	public void setTabelaAmigos(JTable tabelaAmigos) {
		this.tabelaAmigos = tabelaAmigos;
	}

	public DefaultTableModel getModeloTabela() {
		return modeloTabela;
	}

	public void setModeloTabela(DefaultTableModel modeloTabela) {
		this.modeloTabela = modeloTabela;
	}

	public static String[] getColunastabela() {
		return colunasTabela;
	}
}
