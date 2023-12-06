import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaAtualizarKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtIdBuscar;
	private JTable tableComponentes;
	private JTextField txtQtd;

	public TelaAtualizarKit(List<Componente> listaComponente, List<Kit> listaKit, JFrame telaAtualizar, int idKit) {
		
		JFrame telaAtt = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAtt.setVisible(false);
				telaAtualizar.setVisible(true);
			}
		});
		
		JLabel lblMensagem1 = new JLabel("");
        lblMensagem1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblMensagem1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensagem1.setBounds(250, 327, 226, 13);
        
        
        contentPane.add(lblMensagem1);
		btnVoltar.setBounds(10, 10, 85, 21);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(146, 92, 69, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblID = new JLabel("");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		lblID.setBounds(250, 92, 105, 13);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(146, 116, 94, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDescricao = new JLabel("");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setBounds(250, 113, 105, 13);
		contentPane.add(lblDescricao);
		
		JLabel lblNewLabel_2 = new JLabel("Preço");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(146, 140, 69, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreco.setBounds(250, 137, 105, 13);
		contentPane.add(lblPreco);
		
		JLabel lbl = new JLabel("Componentes");
		lbl.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl.setBounds(146, 160, 106, 13);
		contentPane.add(lbl);
		
		JLabel lblComponentes = new JLabel("");
		lblComponentes.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponentes.setBounds(250, 160, 207, 13);
		contentPane.add(lblComponentes);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 275, 74, 13);
		contentPane.add(lblNewLabel_3);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(94, 273, 96, 19);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Preço");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 300, 74, 13);
		contentPane.add(lblNewLabel_4);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(94, 302, 96, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtIdBuscar = new JTextField();
		txtIdBuscar.setBounds(390, 248, 86, 19);
		contentPane.add(txtIdBuscar);
		txtIdBuscar.setColumns(10);
		
		txtQtd = new JTextField();
        txtQtd.setBounds(390, 272, 86, 20);
        contentPane.add(txtQtd);
        txtQtd.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Id componente");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(250, 251, 130, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblQuantidade = new JLabel();
	    lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
	    lblQuantidade.setBounds(250, 184, 185, 14);
	    contentPane.add(lblQuantidade);
	    
	    
	    /*Tabela pronta*/
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(247, 351, 229, 102);
        contentPane.add(scrollPane);

        
        String[] colunas = {"Id", "Descrição", "Preço", "Quantidade"};


        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Componente componente : listaComponente) {
            Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
            model.addRow(rowData);
        }


        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);

        /*Fim da tabela*/
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String idAdicionar = txtIdBuscar.getText();
		        int idAddComponente = 0;
		        String qtdAdd = txtQtd.getText();
		        int qtdAddConvert = 0;

		        try {
		            idAddComponente = Integer.parseInt(idAdicionar);
		            qtdAddConvert = Integer.parseInt(qtdAdd);

		        } catch (Exception e1) {
		            lblMensagem1.setText("Erro: " + e1);
		            return;
		        }
		        
		        for(Componente c1: listaComponente) {
		        	if(c1.getId() == idAddComponente) {
		        		if(c1.getQuantidade() >= qtdAddConvert) {
		        			int remover1 = c1.getQuantidade() - qtdAddConvert;
			        		c1.setQuantidade(remover1);for (Kit k : listaKit) {
					            if (idKit == k.getId()) {
					                boolean componenteExistente = false;
					                
					                
					                for (Componente c2 : k.getListaComponentes()) {
					                    if (idAddComponente == c2.getId()) {
					                        c2.setQuantidade(c2.getQuantidade() + qtdAddConvert);
					                        componenteExistente = true;
					                        break;
					                    }
					                }

					                if (!componenteExistente) {
					                    for (Componente c : listaComponente) {
					                        if (idAddComponente == c.getId()) {
					                            Componente addComp = new Componente(c.getId(), c.getDescricao(), c.getPrecoCusto(), qtdAddConvert);
					                            k.addComponente(addComp);
					                            lblMensagem1.setText("Componente " + idAddComponente + " Adicionado!");
					                            break;
					                        }
					                    }
					                }
					            }
					        }
		        		}
		        		else {
		        			lblMensagem1.setText("Quantidade invalida!");
		        		}
		        		
		        	}
		        }

		        
		        
		        
				for(Kit k : listaKit) {
					if(idKit == k.getId()) {
						lblID.setText(""+k.getId());
						lblDescricao.setText(k.getDescricao());
						lblPreco.setText(""+k.getPreco());
						StringBuilder componentesStr = new StringBuilder();
						StringBuilder qtdStr = new StringBuilder();
						for (Componente c : k.getListaComponentes()) {
						    componentesStr.append(c.getId()).append(", ");
						    qtdStr.append(c.getQuantidade()).append(", ");
						}
						if (componentesStr.length() > 0) {
						    componentesStr.setLength(componentesStr.length() - 2);
						    qtdStr.setLength(qtdStr.length() - 2);
						}

						lblComponentes.setText(componentesStr.toString());
						lblQuantidade.setText(qtdStr.toString());
						
					}
				}

				txtIdBuscar.setText("");
				txtQtd.setText("");
				refreshTable(model, tableComponentes, listaComponente);
			}
		});
		btnNewButton.setBounds(365, 296, 111, 20);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descNew = txtDescricao.getText();
				String precoNew = txtPreco.getText();
				float precoConvert = 0;
				
				try {
					precoConvert = Float.parseFloat(precoNew);
				} catch (Exception e1) {
					
				}
				for(Kit k: listaKit) {
					if(idKit == k.getId()) {
						k.setDescricao(descNew);
						k.setPreco(precoConvert);
					}
				}
				for(Kit k : listaKit) {
					if(idKit == k.getId()) {
						lblID.setText(""+k.getId());
						lblDescricao.setText(k.getDescricao());
						lblPreco.setText(""+k.getPreco());
						
						
					}
				}
			}
		});
		btnAtualizar.setBounds(10, 432, 211, 21);
		contentPane.add(btnAtualizar);
		
		
		
		for(Kit k : listaKit) {
			if(idKit == k.getId()) {
				lblID.setText(""+k.getId());
				lblDescricao.setText(k.getDescricao());
				lblPreco.setText(""+k.getPreco());
				StringBuilder componentesStr = new StringBuilder();
				StringBuilder qtdStr = new StringBuilder();
				for (Componente c : k.getListaComponentes()) {
				    componentesStr.append(c.getId()).append(", ");
				    qtdStr.append(c.getQuantidade()).append(", ");
				}
				if (componentesStr.length() > 0) {
				    componentesStr.setLength(componentesStr.length() - 2);
				    qtdStr.setLength(qtdStr.length() - 2);
				}

				lblComponentes.setText(componentesStr.toString());
				lblQuantidade.setText(qtdStr.toString());
				
			}
		}


		
			

        
        JLabel lblNewLabel_5 = new JLabel("Atualizar Preço e Descrição");
        lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_5.setBounds(21, 224, 194, 13);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_7 = new JLabel("Atualizar Conponentes do kit");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_7.setBounds(250, 224, 229, 13);
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Atualizar");
        lblNewLabel_8.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(10, 31, 466, 28);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Quantidades");
        lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_9.setBounds(146, 184, 94, 13);
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Quantidade");
        lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_10.setBounds(250, 275, 130, 14);
        contentPane.add(lblNewLabel_10);
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String idRemover = txtIdBuscar.getText();
                int idRemoveComponente = 0;
                String qtdRemove = txtQtd.getText();
                int qtdRemoveConvert = 0;

                try {
                    idRemoveComponente = Integer.parseInt(idRemover);
                    qtdRemoveConvert = Integer.parseInt(qtdRemove);

                } catch (Exception e1) {
                    lblMensagem1.setText("Erro: " + e1);
                    return;
                }

                for (Componente c1 : listaComponente) {
                    if (c1.getId() == idRemoveComponente) {
                            for (Kit k : listaKit) {
                                if (idKit == k.getId()) {
                                    for (Componente c2 : k.getListaComponentes()) {
                                    	if (c2.getQuantidade() >= qtdRemoveConvert) {
                                            int remover1 = c1.getQuantidade() + qtdRemoveConvert;
                                            c1.setQuantidade(remover1);
                                            }
                                    	else {
                                            lblMensagem1.setText("Quantidade inválida!");
                                        }
                                    	
                                    	if (idRemoveComponente == c2.getId()) {
                                            int novaQuantidade = c2.getQuantidade() - qtdRemoveConvert;
                                            if (novaQuantidade > 0) {
                                                c2.setQuantidade(novaQuantidade);
                                            } else {
                                                k.getListaComponentes().remove(c2);
                                            }

                                            lblMensagem1.setText("Componente " + idRemoveComponente + " Removido!");
                                            break;
                                        }
                                    }
                                }
                            }
                        } 
                    }
                

                for (Kit k : listaKit) {
                    if (idKit == k.getId()) {
                        lblID.setText("" + k.getId());
                        lblDescricao.setText(k.getDescricao());
                        lblPreco.setText("" + k.getPreco());
                        StringBuilder componentesStr = new StringBuilder();
                        StringBuilder qtdStr = new StringBuilder();
                        for (Componente c : k.getListaComponentes()) {
                            componentesStr.append(c.getId()).append(", ");
                            qtdStr.append(c.getQuantidade()).append(", ");
                        }
                        if (componentesStr.length() > 0) {
                            componentesStr.setLength(componentesStr.length() - 2);
                            qtdStr.setLength(qtdStr.length() - 2);
                        }

                        lblComponentes.setText(componentesStr.toString());
                        lblQuantidade.setText(qtdStr.toString());
                    }
                }

                txtIdBuscar.setText("");
                txtQtd.setText("");
                refreshTable(model, tableComponentes, listaComponente);
            }

        });
        btnRemover.setFont(new Font("Arial Black", Font.PLAIN, 12));
        btnRemover.setBounds(250, 296, 111, 20);
        contentPane.add(btnRemover);
        
        
        
       
		
	}
	
	
	public void refreshTable(DefaultTableModel model, JTable table, List<Componente> listaComponente) {
	    model.setRowCount(0);
	    for (Componente componente : listaComponente) {
	        Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
	        model.addRow(rowData);
	    table.setModel(model);
	}
}
}
