
package br.com.ifba.usuario.view;

import br.com.ifba.usuario.entity.Usuario;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import br.com.ifba.usuario.exception.UsuarioNaoEncontradoException;
import br.com.ifba.usuario.repositorio.RepositorioUsuarioEmMemoria;
import br.com.ifba.infrastructure.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author guest
 */
public class TelaUsuarios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaUsuarios.class.getName());

    /**
     * Creates new form TelaUsuarios
     */

        public TelaUsuarios() {
            initComponents();
            
            DefaultTableModel modelo =
                (DefaultTableModel) tblUsuarios.getModel();

            modelo.setColumnIdentifiers(new Object[]{
                "Login", "CPF", "Data de Nascimento", "Remover", "Editar"
            });

            configurarBotoesTabela();

            carregarUsuarios();
        }
        
        private void carregarUsuarios() {
            DefaultTableModel modelo
                    = (DefaultTableModel) tblUsuarios.getModel();

            modelo.setRowCount(0);

            EntityManager em = JPAUtil.getEntityManager();

            try {
                List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

                for (Usuario usuario : usuarios) {
                    modelo.addRow(new Object[]{
                        usuario.getLogin(),
                        usuario.getCpf(),
                        usuario.getDataNascimento(),
                        "Remover",
                        "Editar"
                    });
                }

            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao carregar usuários: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            } finally {
                em.close();
            }
        }

        private void configurarBotoesTabela() {

            // Coluna 3: Remover
            tblUsuarios.getColumnModel().getColumn(3)
                .setCellRenderer(new BotaoRenderer());

            tblUsuarios.getColumnModel().getColumn(3)
                .setCellEditor(new BotaoEditor(tblUsuarios, "Remover"));

            // Coluna 4: Editar
            tblUsuarios.getColumnModel().getColumn(4)
                .setCellRenderer(new BotaoRenderer());

            tblUsuarios.getColumnModel().getColumn(4)
                .setCellEditor(new BotaoEditor(tblUsuarios, "Editar"));
        }
        
    private final RepositorioUsuarioEmMemoria repositorioUsuarioEmMemoria = new RepositorioUsuarioEmMemoria();
    
    class BotaoRenderer extends JButton implements TableCellRenderer {

        public BotaoRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable tabela, Object valor,
                boolean selecionado, boolean foco,
                int linha, int coluna) {

            setText(valor == null ? "" : valor.toString());
            return this;
        }
    }

    class BotaoEditor extends AbstractCellEditor
            implements TableCellEditor {

        private final JButton botao;
        private final JTable tabela;
        private final String acao;
        private int linha;

        public BotaoEditor(JTable tabela, String acao) {
            this.tabela = tabela;
            this.acao = acao;
            this.botao = new JButton(acao);

            botao.addActionListener(e -> {
                int linhaModelo = tabela.convertRowIndexToModel(linha);

                if (acao.equals("Remover")) {
                    int resposta = JOptionPane.showConfirmDialog(
                            tabela,
                            "Deseja realmente remover este usuário?",
                            "Confirmar remoção",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (resposta == JOptionPane.YES_OPTION) {
                        // Obtém o CPF da linha selecionada
                        String cpf = tabela.getModel()
                                .getValueAt(linhaModelo, 1).toString();

                        EntityManager em = JPAUtil.getEntityManager();

                        try {
                            em.getTransaction().begin();

                            Usuario usuario = em.find(Usuario.class, cpf);

                            if (usuario != null) {
                                em.remove(usuario);
                                em.getTransaction().commit();

                                ((DefaultTableModel) tabela.getModel())
                                        .removeRow(linhaModelo);

                                JOptionPane.showMessageDialog(
                                        tabela,
                                        "Usuário removido com sucesso!"
                                );
                            } else {
                                em.getTransaction().rollback();

                                JOptionPane.showMessageDialog(
                                        tabela,
                                        "Usuário não encontrado no banco de dados.",
                                        "Aviso",
                                        JOptionPane.WARNING_MESSAGE
                                );
                            }

                        } catch (RuntimeException ex) {
                            if (em.getTransaction().isActive()) {
                                em.getTransaction().rollback();
                            }

                            JOptionPane.showMessageDialog(
                                    tabela,
                                    "Erro ao remover usuário: " + ex.getMessage(),
                                    "Erro",
                                    JOptionPane.ERROR_MESSAGE
                            );

                        } finally {
                            em.close();
                        }
                    }

                        }else if (acao.equals("Editar")) {
                            String cpf = tabela.getModel()
                                    .getValueAt(linhaModelo, 1).toString();

                            TelaEditarUsuario telaEdicao = new TelaEditarUsuario(cpf);

                            telaEdicao.setLocationRelativeTo(null);
                            telaEdicao.setVisible(true);
                        }

                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable tabela, Object valor,
                boolean selecionado, int linha, int coluna) {

            this.linha = linha;
            botao.setText(acao);
            return botao;
        }

        @Override
        public Object getCellEditorValue() {
            return acao;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(84, 195, 236));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Login", "Nome", "Data de Nascimento", "Remover", "Editar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        txtBuscar.setBackground(new java.awt.Color(187, 233, 250));
        txtBuscar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtBuscar.setText("Procurar");
        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        jButton1.setBackground(new java.awt.Color(187, 233, 250));
        jButton1.setText("+");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        btnBuscar.setBackground(new java.awt.Color(187, 233, 250));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String login = txtBuscar.getText().trim();

        if (login.isEmpty() || login.equals("Procurar")) {
            JOptionPane.showMessageDialog(
                this,
                "Digite o login do usuário.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            Usuario usuario =
                    repositorioUsuarioEmMemoria.buscarPorLogin(login);

            JOptionPane.showMessageDialog(
                this,
                "Usuário encontrado!\n"
                + "Login: " + usuario.getLogin() + "\n"
                + "CPF: " + usuario.getCpf() + "\n"
                + "E-mail: " + usuario.getEmail(),
                "Resultado da busca",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (UsuarioNaoEncontradoException e) {
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Usuário não encontrado",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaUsuarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}