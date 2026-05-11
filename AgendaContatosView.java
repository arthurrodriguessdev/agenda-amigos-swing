// package AgendaAmigos;

import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class AgendaContatosView extends JFrame{
	private JPanel painelBotoes;
	private JPanel painelBusca;
	private JTextField inputBusca;
	private JButton btnExcluir;
	private JButton btnIncluir;
	private JButton btnBuscar;
	private JButton btnAlterar;
	private JTable tabelaAmigos;
	private DefaultTableModel modeloTabela;
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
		
		// Painel de Busca (superior)
		painelBusca = new JPanel(new BorderLayout(10, 10));
		painelBusca.setBackground(new Color(98, 160, 234));
		inputBusca = new JTextField();
		btnBuscar = new JButton("Buscar");
		painelBusca.add(inputBusca, BorderLayout.CENTER);
		painelBusca.add(btnBuscar, BorderLayout.EAST);
		getContentPane().add(painelBusca, BorderLayout.NORTH);

		// Painel de Botões (inferior)
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(98, 160, 234));
		
		btnExcluir = new JButton("Excluir");
		painelBotoes.add(btnExcluir);
		
		btnIncluir = new JButton("Incluir");
		painelBotoes.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		painelBotoes.add(btnAlterar);
		
		getContentPane().add(painelBotoes, BorderLayout.SOUTH);

		// Tabela
		modeloTabela = new DefaultTableModel();
		tabelaAmigos = new JTable(modeloTabela);
		tabelaAmigos.setColumnSelectionAllowed(true);
		tabelaAmigos.setRowSelectionAllowed(false);
		tabelaAmigos.setBorder(new LineBorder(new Color(53, 132, 228), 1, true));
		tabelaAmigos.setBackground(new Color(222, 221, 218));
		add(new JScrollPane(tabelaAmigos), BorderLayout.CENTER);
	}
	
	// Atualiza a tabela gráfica na inclusão
	public void atualizarIncluirLista(Amigo novoAmigo) {
		this.getModeloTabela().addRow(new Object[] {
				novoAmigo.getId(),
				novoAmigo.getNome(),
				novoAmigo.getApelido(),
				novoAmigo.getEmail(),
				novoAmigo.getCelular()	
		});
	}
	
	// Atualiza a tabela gráfica na exclusão
	public void atualizarExcluirLista(int idAmigo) {
		int indiceLinhaRemover = -1;
		int valorId = 0;
		
		for(int i = 0; i < this.getModeloTabela().getRowCount(); i++) {
			valorId = (int) this.getModeloTabela().getValueAt(i, 0);
			
			if(valorId == idAmigo) {
				indiceLinhaRemover = i;
				break;
			}
		}
		
		if(indiceLinhaRemover != -1) {
			this.getModeloTabela().removeRow(indiceLinhaRemover);
		}
	}
	
	// Atualiza a tabela com dados que batem com o filtro aplicado
	public void atualizarTabelaBusca(List<Amigo> listaRegistrosEquivalentes){
		limparTabela();
		
		for(int j = 0; j < listaRegistrosEquivalentes.size(); j++){
			this.getModeloTabela().addRow(new Object[]{
				listaRegistrosEquivalentes.get(j).getId(),
				listaRegistrosEquivalentes.get(j).getNome(),
				listaRegistrosEquivalentes.get(j).getApelido(),
				listaRegistrosEquivalentes.get(j).getEmail(),
				listaRegistrosEquivalentes.get(j).getCelular()
			});
		}
	}

	// Remove todas as linhas da tabela
	public void limparTabela(){
		this.getModeloTabela().setRowCount(0);
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

	public JTextField getInputBusca(){
		return this.inputBusca;
	}
}
