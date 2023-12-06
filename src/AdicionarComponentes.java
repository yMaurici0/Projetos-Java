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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdicionarComponentes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdComponente;
	private JTable tableComponentes;
	private ArrayList<Componente> componenteTemporario = new ArrayList<>();
	private JTextField txtQuantidade;


	public AdicionarComponentes(JFrame cadastrarKit, String descricao, List<Kit> kits, List<Componente> listaComponente, 
			int idKIT, float precoKIT, JFrame telaCRUD) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame adicionarComponente = this;
		
		
		txtQuantidade = new JTextField();
        txtQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
        txtQuantidade.setColumns(10);
        txtQuantidade.setBounds(246, 134, 98, 20);
        contentPane.add(txtQuantidade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarKit.setVisible(true);
				adicionarComponente.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMensagem.setBounds(10, 201, 466, 26);
		contentPane.add(lblMensagem);
		
		JButton btnAdicionar = new JButton("Adicionar componente");
		btnAdicionar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idComponente = textIdComponente.getText();
				String qtdComponente = txtQuantidade.getText();
				int numeroConvertido = 0;
				int qtdConvert = 0;
				
				if(listaComponente.isEmpty()) {
					lblMensagem.setText("Lista Vazia!");
					
				}
				else {
					try {
			            numeroConvertido = Integer.parseInt(idComponente);
			            qtdConvert = Integer.parseInt(qtdComponente);
			            
			        } catch (NumberFormatException e1) {
			        	lblMensagem.setText("Erro de conversão: " + e1.getMessage());
			        }
					for(Componente c1 : listaComponente) {
						if(numeroConvertido == c1.getId()) {
							if(qtdConvert > c1.getQuantidade()) {
								lblMensagem.setText("Quantidade invalida");
								
								
							}
						else {
							int remover = c1.getQuantidade();
							c1.setQuantidade(remover - qtdConvert);
							
							
							System.out.println(""+c1.getQuantidade());
							Componente c2 = new Componente(c1.getId(), c1.getDescricao(), c1.getPrecoCusto(), qtdConvert);
							
							componenteTemporario.add(c2);
							lblMensagem.setText("Componente: "+c1.getDescricao()+" Adicionado");
								
							}
							
						}
						
						
					}
				}
				textIdComponente.setText("");
				txtQuantidade.setText("");
				
				
				
			}
		});
		btnAdicionar.setBounds(158, 166, 187, 23);
		contentPane.add(btnAdicionar);
		
		textIdComponente = new JTextField();
		textIdComponente.setHorizontalAlignment(SwingConstants.LEFT);
		textIdComponente.setBounds(246, 103, 98, 20);
		contentPane.add(textIdComponente);
		textIdComponente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id ");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(163, 104, 32, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar kit");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarKit(idKIT, descricao, precoKIT, componenteTemporario, kits);
				adicionarComponente.setVisible(false);
				telaCRUD.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(159, 238, 187, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Digite o id dos componentes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 42, 466, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Que deseja adiciona ao kit");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 53, 466, 39);
		contentPane.add(lblNewLabel_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 283, 466, 170);
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


        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);
        
        JLabel lblNewLabel_3 = new JLabel("Quantidade");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_3.setBounds(158, 141, 89, 14);
        contentPane.add(lblNewLabel_3);
        
        
		
	}
	
	public void adicionarKit (int idKIT, String desc, float precoKIT, List<Componente> componenteTemporario,List<Kit> kits) {
		Kit k1 = new Kit(idKIT, desc, precoKIT, componenteTemporario);
		kits.add(k1);
	}
}
