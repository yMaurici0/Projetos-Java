import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ExcluirComponente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTable tableComponentes;
	private int verificador = 0;

	public ExcluirComponente(JFrame telaCRUD, List<Componente> listaComponentes)  {
		
		JFrame telaExcluir = this;
		
		setTitle("Exlcuir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(198, 82, 96, 19);
		contentPane.add(textID);
		textID.setColumns(10);
		
		
		
		/*Tabela pronta*/
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 210, 466, 187);
        contentPane.add(scrollPane);

        
        String[] colunas = {"Id", "Descrição", "Preço", "Quantidade"};


        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Componente componente : listaComponentes) {
            Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
            model.addRow(rowData);
        }


        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);

        /*Fim da tabela*/	
		
		
		
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMensagem.setBounds(10, 160, 466, 39);
		contentPane.add(lblMensagem);
		
		JLabel lblNewLabel = new JLabel("Id do componente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 59, 466, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaExcluir.setVisible(false);
				telaCRUD.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int contador = 0;
					String idConferir = textID.getText();
					int converterInt = Integer.parseInt(idConferir);
					if(listaComponentes.isEmpty()) {
						lblMensagem.setText("Lista Vazia!");
					}
					else{
						for(Componente c: listaComponentes) {
						if(c.getId() == converterInt) {
							ConfirmacaoExcluir confirmar = new ConfirmacaoExcluir(c.getId(), c.getDescricao(), c.getPrecoCusto(), c.getQuantidade(), listaComponentes,converterInt, telaExcluir, lblMensagem);
							telaExcluir.setVisible(false);
							confirmar.setVisible(true);
							textID.setText("");
							
						}else {
							contador ++;
						}
					}
						int comparar = listaComponentes.size();
						if(contador == comparar) {
							lblMensagem.setText("Item não encontrado na lista!");
						}
					}
					
						
					}
					
				catch (Exception e1) {
					lblMensagem.setText("Erro: "+ e1.getMessage());
				}
				textID.setText("");
				}
		});
		btnEnviar.setBounds(198, 111, 96, 39);
		contentPane.add(btnEnviar);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Excluir Componente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 10, 466, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Atualizar Tabela");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable(listaComponentes);
			}
		});
		btnNewButton_1.setBounds(171, 414, 148, 23);
		contentPane.add(btnNewButton_1);
	}
	
	private void refreshTable(List<Componente> listaComponentes) {
	   
	    DefaultTableModel model = (DefaultTableModel) tableComponentes.getModel();
	    model.setRowCount(0);

	   
	    for (Componente componente : listaComponentes) {
	        Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
	        model.addRow(rowData);
	    }

	    
	    model.fireTableDataChanged();
	}
}
