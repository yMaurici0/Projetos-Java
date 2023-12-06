import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AtualizarComponente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTable table;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTable table_1;
	private JTable tableComponentes;
	private int idAtualizar = 0;
	private JTextField txtQuantidade;

	public AtualizarComponente(List<Componente> listaComponentes, JFrame telaCRUD) {
		setTitle("Atualizar");

		JFrame telaAtualizar = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* txt */
		txtID = new JTextField();
		txtID.setBounds(164, 137, 145, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(349, 320, 96, 19);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setBounds(349, 359, 96, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		/* Jlabel */
		JLabel lblEncontrar = new JLabel("");
		lblEncontrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncontrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEncontrar.setBounds(10, 204, 466, 13);
		contentPane.add(lblEncontrar);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblID.setBounds(230, 286, 143, 13);
		contentPane.add(lblID);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMensagem.setBounds(33, 437, 145, 13);
		contentPane.add(lblMensagem);

		/* btn */
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idRecebido = txtID.getText();
				int idConvertido;
				int contador = 0;
				if (listaComponentes.isEmpty()) {
					lblEncontrar.setText("Lista Vazia!");
				} else {
					try {
						idConvertido = Integer.parseInt(idRecebido);
						for (Componente c : listaComponentes) {
							if (idConvertido == c.getId()) {
								idAtualizar = c.getId();
								lblEncontrar.setText("Id encontrado!");
								lblID.setText("ID: " + idAtualizar);
							}else {
								contador++;
							}
						}
						if(contador == listaComponentes.size()) {
							lblEncontrar.setText("Item não encontrado!");
						}

					} catch (Exception e1) {
						lblEncontrar.setText("Erro: " + e1.getMessage());
					}
					txtID.setText("");
					
				}

			}
		});
		btnBuscar.setBounds(197, 162, 85, 21);
		contentPane.add(btnBuscar);

		JButton btnDescricao = new JButton("Enviar");
		btnDescricao.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descModify = txtDescricao.getText();
		        String precoModify = txtPreco.getText();
		        String qtdComp = txtQuantidade.getText();
		        float precoConvertido = 0;
		        int qtdConvert = 0;
		        
		        if (descModify.isEmpty()) {
		            lblMensagem.setText("Descrição vazia");
		        } else {
		            try {
		            	precoConvertido = Float.parseFloat(precoModify);
		            	qtdConvert = Integer.parseInt(qtdComp);
		            	
		                for (Componente c : listaComponentes) {
		                	
		                    if (idAtualizar == c.getId()) {
		                        c.setDescricao(descModify);
		                        c.setPrecoCusto(precoConvertido);
		                        c.setQuantidade(qtdConvert);
		                        lblMensagem.setText("Atualizado!");
		                    }
		                }
		                
		                DefaultTableModel model = (DefaultTableModel) tableComponentes.getModel();
		           
		                model.setRowCount(0);
		              
		                for (Componente componente : listaComponentes) {
		                    Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
		                    model.addRow(rowData);
		                }
		                
		                model.fireTableDataChanged();
		                
		            } catch (Exception e1) {
		                lblMensagem.setText("Erro: " + e1);
		            }
		            
		            txtDescricao.setText("");
		            txtPreco.setText("");
		            txtQuantidade.setText("");
		        }

			}
		});
		btnDescricao.setBounds(360, 429, 85, 21);
		contentPane.add(btnDescricao);

		JLabel lblNewLabel = new JLabel("Digite o id que deseja atualizar");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(134, 114, 209, 13);
		contentPane.add(lblNewLabel);
		
		
		/*Tabela*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 210, 131);
		contentPane.add(scrollPane);

		String[] colunas = { "Id", "Descrição", "Preço", "Quantidade" };

		DefaultTableModel model = new DefaultTableModel(colunas, 0);

		for (Componente componente : listaComponentes) {
			Object[] rowData = { componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade() };
			model.addRow(rowData);
		}


		tableComponentes = new JTable(model);
		tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
		scrollPane.setViewportView(tableComponentes);

		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(230, 322, 85, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Preço de custo:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(230, 361, 126, 13);
		contentPane.add(lblNewLabel_2);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(true);
				telaAtualizar.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 10, 85, 21);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel_3 = new JLabel("Atualizar Componente");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 53, 466, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblQuantidade.setBounds(230, 396, 126, 13);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(349, 389, 96, 19);
		contentPane.add(txtQuantidade);

	}
}
