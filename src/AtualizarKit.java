import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AtualizarKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableComponentes;
	private JLabel lblNewLabel;
	private JTextField txtID;
	private JLabel lblMensagem;
	private JButton btnBuscar;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	
	public AtualizarKit(JFrame telaCRUD , List<Kit> listaKits, List<Componente> listaComponente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JFrame telaAtualizar = this;
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 11, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(true);
				telaAtualizar.setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
		
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 308, 466, 145);
        contentPane.add(scrollPane);
		
        String[] colunas = {"Id", "Descrição", "Preço"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Kit listaKit : listaKits) {
      
            Object[] rowData = {listaKit.getId(), listaKit.getDescricao(), listaKit.getPreco()};
            model.addRow(rowData);
        }
        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);
        
        /*Fim da tabela*/
        
        lblNewLabel = new JLabel("Digite o id do kit");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 99, 466, 35);
        contentPane.add(lblNewLabel);
        
        txtID = new JTextField();
        txtID.setBounds(179, 144, 136, 19);
        contentPane.add(txtID);
        txtID.setColumns(10);
        
        lblMensagem = new JLabel("");
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblMensagem.setBounds(10, 231, 466, 23);
        contentPane.add(lblMensagem);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String idBuscar = txtID.getText();
        		int idComp = 0;
        		int contador = 0;
        		
        		if(listaKits.isEmpty()) {
        			lblMensagem.setText("Lista Vazia!");
        		}
        		else {
        			try {
            			idComp = Integer.parseInt(idBuscar);
            			for(Kit k: listaKits) {
                			if(idComp == k.getId()) {
                				TelaAtualizarKit telaAtt = new TelaAtualizarKit(listaComponente,listaKits,telaAtualizar, idComp);
                        		telaAtt.setVisible(true);
                        		telaAtualizar.setVisible(false);
                			}
                			else {
                				contador++;
                			}
                		}
            		} catch(Exception e1) {
            			lblMensagem.setText("Erro: "+e1);
            		}
            		if(contador == listaKits.size()) {
            			lblMensagem.setText("Item não encontrado!");
            		}
        		}
        		txtID.setText("");
        		
        		
        		
        	}
        });
        btnBuscar.setBounds(189, 173, 109, 48);
        contentPane.add(btnBuscar);
        
        lblNewLabel_1 = new JLabel("Atualizar Kit");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(10, 49, 466, 23);
        contentPane.add(lblNewLabel_1);
        
        btnNewButton = new JButton("Atualizar Tabela");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		atualizarTabela(listaKits);
        	}
        });
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        btnNewButton.setBounds(152, 276, 171, 21);
        contentPane.add(btnNewButton);
	}
	
	
	private void atualizarTabela(List<Kit> listaKits) {
        DefaultTableModel model = (DefaultTableModel) tableComponentes.getModel();
        model.setRowCount(0); 

 
        for (Kit listaKit : listaKits) {
            StringBuilder componentesStr = new StringBuilder();
            for (Componente componente : listaKit.getListaComponentes()) {
                componentesStr.append(componente.getDescricao()).append(", ");
            }
            if (componentesStr.length() > 0) {
                componentesStr.setLength(componentesStr.length() - 2);
            }

            Object[] rowData = {listaKit.getId(), listaKit.getDescricao(), listaKit.getPreco(), componentesStr.toString()};
            model.addRow(rowData);
        }
    }

}
