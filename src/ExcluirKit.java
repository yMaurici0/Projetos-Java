import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ExcluirKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableComponentes;
	private JTextField txtID;

	public ExcluirKit(JFrame telaCRUD, List<Kit> listaKits) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JFrame telaExcluir = this;

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaExcluir.setVisible(false);
				telaCRUD.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("Digite o ID do kit que deseja remover");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 65, 466, 56);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(123, 110, 247, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel txtMensagem = new JLabel("");
		txtMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensagem.setBounds(10, 193, 466, 13);
		contentPane.add(txtMensagem);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idCapturado = txtID.getText();
				int idConverter = 0;
				int contador = 0;

				if (listaKits.isEmpty()) {
					txtMensagem.setText("Lista Vazia!");
				} else {
					try {
						idConverter = Integer.parseInt(idCapturado);
						
					} catch (Exception e1) {
						txtMensagem.setText("Erro: " + e1);
					}
					for (Kit k : listaKits) {
						if (idConverter == k.getId()) {
							ConfirmacaoExcluirKit telaConfirmar = new ConfirmacaoExcluirKit(k.getId(), k.getDescricao(),
									k.getPreco(), k.getListaComponentes(), listaKits, telaExcluir, txtMensagem);
							telaConfirmar.setVisible(true);
							telaExcluir.setVisible(false);
						}
						else {
							contador++;
						}
					}
					if(contador == listaKits.size()) {
						txtMensagem.setText("Item não encontrado!");
					}
				}
				txtID.setText("");
				

			}
		});
		btnExcluir.setBounds(200, 139, 95, 34);
		contentPane.add(btnExcluir);

/*Tabela KIT*/
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 280, 466, 173);
        contentPane.add(scrollPane);
		
        String[] colunas = {"Id", "Descrição", "Preço", "Componentes", "Quantidades"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Kit listaKit : listaKits) {
            StringBuilder componentesStr = new StringBuilder();
            StringBuilder quantidadeStr = new StringBuilder();
            for (Componente componente : listaKit.getListaComponentes()) {
                componentesStr.append(componente.getDescricao()).append(", ");
                quantidadeStr.append(componente.getQuantidade()).append(", ");
            }
            if (componentesStr.length() > 0) {
                componentesStr.setLength(componentesStr.length() - 2);
                quantidadeStr.setLength(quantidadeStr.length()-2);
            }

            Object[] rowData = {listaKit.getId(), listaKit.getDescricao(), listaKit.getPreco(), componentesStr.toString(), quantidadeStr.toString()};
            model.addRow(rowData);
        }

        // Criar a tabela com o modelo configurado
        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);
        
        /*Fim da tabela*/

		JLabel lblNewLabel_1 = new JLabel("Excluir Kit");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 32, 466, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Atualizar Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(listaKits);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setBounds(163, 224, 172, 21);
		contentPane.add(btnNewButton);

	}
	
	private void refreshTable(List<Kit> listaKits) {
	    // Limpar o modelo da tabela
	    DefaultTableModel model = (DefaultTableModel) tableComponentes.getModel();
	    model.setRowCount(0);

	    // Adicionar dados atualizados à tabela
	    for (Kit listaKit : listaKits) {
	        // Converte a lista de componentes em uma string
	        StringBuilder componentesStr = new StringBuilder();
	        for (Componente componente : listaKit.getListaComponentes()) {
	            componentesStr.append(componente.getDescricao()).append(", ");
	        }
	        // Remove a última vírgula e espaço adicionados no loop acima
	        if (componentesStr.length() > 0) {
	            componentesStr.setLength(componentesStr.length() - 2);
	        }

	        Object[] rowData = { listaKit.getId(), listaKit.getDescricao(), listaKit.getPreco(),
	                componentesStr.toString() };
	        model.addRow(rowData);
	    }

	    // Notificar a tabela sobre a mudança
	    model.fireTableDataChanged();
	}
}
