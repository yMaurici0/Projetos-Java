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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VisualizarKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableComponentes;

	public VisualizarKit(JFrame telaCRUD, List<Kit> kits) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame telaVisualizar = this;
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaVisualizar.setVisible(false);
				telaCRUD.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		/*Tabela KIT*/
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 124, 466, 329);
        contentPane.add(scrollPane);
		
        String[] colunas = {"Id", "Descrição", "Preço", "Componentes", "Quantidades"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Kit listaKit : kits) {
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
        
        JLabel lblNewLabel = new JLabel("Visualizar Kit");
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 84, 466, 30);
        contentPane.add(lblNewLabel);
	}

}
