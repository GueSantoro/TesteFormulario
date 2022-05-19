package inova.fromexterno;

import Conexao.Controle_Sinal;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author INOVA
 */
public class Form2 extends javax.swing.JFrame {

    Controle_Sinal ts = new Controle_Sinal();
    Modelo_Form modelo = new Modelo_Form();

    /**
     * Creates new form Form2
     */
    public Form2() {
        initComponents();
    }

    public void BuscarImagens() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecione uma foto ");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res = fc.showOpenDialog(this);

        if (res == JFileChooser.APPROVE_OPTION) {
            File file = new File("");
            file = fc.getSelectedFile();
            String fileName = file.getAbsolutePath();
            txtCaminho.setText(fileName);
            try {
                ImageIcon img = new ImageIcon(txtCaminho.getText());
                imagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_DEFAULT)));
            } catch (Exception ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }

    public void consultaTabela_Alimentacao() {
        DefaultTableModel modelo_AL = (DefaultTableModel) tabela1.getModel();
        modelo_AL.setNumRows(0);
        ts.consultaControleAlimentacao(txtConsulta.getText(), modelo_AL);
    }

    public void consultaTabela_Sensor() {
        DefaultTableModel modelo_S = (DefaultTableModel) tabela2.getModel();
        modelo_S.setNumRows(0);
        ts.consultaControleSensor(txtConsulta1.getText(), modelo_S);
    }

    public void consultaTabela_Atuador() {
        DefaultTableModel modelo_AT = (DefaultTableModel) tabela3.getModel();
        modelo_AT.setNumRows(0);
        ts.consultaControleAtuador(txtConsulta2.getText(), modelo_AT);
    }

    public void TransferirTabela() {

        Form1 f1 = new Form1();

        modelo.setMontadora(txtNome.getText());
        modelo.setModelo(cbModelo.getSelectedItem().toString());
        modelo.setImagem(txtCaminho.getText());
        Form1 form = new Form1();
        form.Exportar(modelo);

        TableModel modelo1 = tabela1.getModel();
        TableModel modelo2 = tabela2.getModel();
        TableModel modelo3 = tabela3.getModel();
        
//        int[] indexs = tabela1.getSelectedRows();
        
        modelo.setIndexs(tabela1.getSelectedRows());
        modelo.setIndexs1(tabela2.getSelectedRows());
        modelo.setIndexs2(tabela3.getSelectedRows());

        Object[] row = new Object[4];

        DefaultTableModel modelo_2 = (DefaultTableModel) f1.tabela1.getModel();// essa tabela é do outro formulario
        for (int i = 0; i < modelo.indexs.length; i++) {
            row[0] = modelo1.getValueAt(modelo.indexs[i], 0);
            row[1] = modelo1.getValueAt(modelo.indexs[i], 1);
            row[2] = modelo1.getValueAt(modelo.indexs[i], 2);
            row[3] = modelo1.getValueAt(modelo.indexs[i], 3);
            modelo_2.addRow(row);
        }
        DefaultTableModel modelo_3 = (DefaultTableModel) f1.tabela2.getModel();// essa tabela é do outro formulario
        for (int i = 0; i < modelo.indexs1.length; i++) {
            row[0] = modelo2.getValueAt(modelo.indexs[i], 0);
            row[1] = modelo2.getValueAt(modelo.indexs[i], 1);
            row[2] = modelo2.getValueAt(modelo.indexs[i], 2);
            row[3] = modelo2.getValueAt(modelo.indexs[i], 3);
            modelo_3.addRow(row);
        }

        DefaultTableModel modelo_4 = (DefaultTableModel) f1.tabela3.getModel();// essa tabela é do outro formulario
        for (int i = 0; i < modelo.indexs2.length; i++) {
            row[0] = modelo3.getValueAt(modelo.indexs[i], 0);
            row[1] = modelo3.getValueAt(modelo.indexs[i], 1);
            row[2] = modelo3.getValueAt(modelo.indexs[i], 2);
            row[3] = modelo3.getValueAt(modelo.indexs[i], 3);
            modelo_4.addRow(row);
        }
        form.setVisible(true);
    }

    public void CarregarTabela() {

        if (check1.isSelected()) {
            consultaTabela_Alimentacao();
        }

        if (check2.isSelected()) {
            consultaTabela_Sensor();
        }

        if (check3.isSelected()) {
            consultaTabela_Atuador();
        }
    }

    public void CheckTabela() {
        if (check1.isSelected()) {
            consultaTabela_Alimentacao();
        }

        if (check2.isSelected()) {
            consultaTabela_Sensor();
        }

        if (check3.isSelected()) {
            consultaTabela_Atuador();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cbModelo = new javax.swing.JComboBox<>();
        imagem = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        check1 = new javax.swing.JCheckBox();
        carregarTabela = new javax.swing.JButton();
        check2 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        carregarTabela2 = new javax.swing.JButton();
        jSConsultas1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        jSConsultas2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jSConsultas3 = new javax.swing.JScrollPane();
        tabela3 = new javax.swing.JTable();
        txtConsulta = new javax.swing.JTextField();
        txtConsulta1 = new javax.swing.JTextField();
        txtConsulta2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtCaminho = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("MANUAL INOVA ");

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Abrir Imagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        check1.setText("tabela1");

        carregarTabela.setText("Carregar Tabela");
        carregarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarTabelaActionPerformed(evt);
            }
        });

        check2.setText("tabela1");

        check3.setText("tabela1");

        carregarTabela2.setText("Carregar Tabela Outro Formulario");
        carregarTabela2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarTabela2ActionPerformed(evt);
            }
        });

        tabela1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FUNÇÃO", "PINOS DA CENTRAL", "REFERENCIA", "CONECTOR GT3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSConsultas1.setViewportView(tabela1);

        tabela2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FUNÇÃO", "PINOS DA CENTRAL", "REFERENCIA", "CONECTOR GT3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSConsultas2.setViewportView(tabela2);

        tabela3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabela3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FUNÇÃO", "PINOS DA CENTRAL", "REFERENCIA", "CONECTOR GT3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSConsultas3.setViewportView(tabela3);

        jButton2.setText("Enviar para outro Formulario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check1)
                                    .addComponent(jButton1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(check2)
                                        .addGap(18, 18, 18)
                                        .addComponent(carregarTabela))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(check3)
                                        .addGap(18, 18, 18)
                                        .addComponent(carregarTabela2))))
                            .addComponent(jSConsultas2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSConsultas1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSConsultas3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(253, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(check1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(check2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(carregarTabela)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check3)
                            .addComponent(carregarTabela2)))
                    .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSConsultas1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSConsultas2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtConsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSConsultas3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarImagens();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void carregarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarTabelaActionPerformed
        CarregarTabela();
    }//GEN-LAST:event_carregarTabelaActionPerformed

    private void carregarTabela2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarTabela2ActionPerformed

    }//GEN-LAST:event_carregarTabela2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TransferirTabela();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carregarTabela;
    private javax.swing.JButton carregarTabela2;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    public javax.swing.JLabel imagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jSConsultas1;
    public javax.swing.JScrollPane jSConsultas2;
    public javax.swing.JScrollPane jSConsultas3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabela1;
    public javax.swing.JTable tabela2;
    public javax.swing.JTable tabela3;
    public javax.swing.JTextField txtCaminho;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtConsulta1;
    private javax.swing.JTextField txtConsulta2;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
