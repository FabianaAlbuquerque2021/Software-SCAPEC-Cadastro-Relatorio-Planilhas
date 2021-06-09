/* Software para cadastro na igreja AD Cohab, tela de login. */
package br.com.cadastroCohab.telas;

import java.sql.*;
import br.com.cadastroCohab.dal.ModuloConexao;
import java.awt.Color;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabiana de Albuquerque
 */
public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar(){
        String sql = "select * from tbusuarios where login=? and senha=?";
        String senha = campoSenha.getText(); // Criando Hash para proteger senhas
        try {
            //Para ser criptografado usando o algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));
            //Array de Bytes para pegar todos os bytes e converter para string. Usando a classe string builder.
            StringBuilder sb = new StringBuilder();
            //Máscara de formatação para que não tenha números negativos.
            for(byte b : messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
            }
            //Essa variável senhaHex já vai pegar a senha com hash, convertida para string e concatenada.
            String senhaHex = sb.toString();
            //As linhas abaixo preparam a consulta ao banco em função do
            // que foi digitado nas caixas de texto. O interroga é substituído
            //pelo conteúdo das variáveis.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoNome.getText());
            pst.setString(2, senhaHex);
            //A linha abaixo executa a query.
            rs = pst.executeQuery();
            //Se existir usuário e senha correspondente.
            if(rs.next()){
                //A linha abaixo contem o conteudo do campo perfil na tabela tbusuarios.
                String perfil=rs.getString(6);
                //System.out.println(perfil);
                // A estrutura abaixo faz o tratamento do perfil do usuário.
                if (perfil.equals("admin")){
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.itemCad2.setEnabled(true);
                    TelaPrincipal.menu2.setEnabled(true);
                    TelaPrincipal.nomeUsuario.setText(rs.getString(2));
                    TelaPrincipal.nomeUsuario.setForeground(Color.yellow);
                    this.dispose();
                }else if(perfil.equals("moderado")){
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menu2.setEnabled(true);
                    TelaPrincipal.nomeUsuario.setText(rs.getString(2));
                    TelaPrincipal.nomeUsuario.setForeground(Color.red);
                    this.dispose();
                }else{
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.nomeUsuario.setText(rs.getString(2));
                    TelaPrincipal.nomeUsuario.setForeground(Color.blue);
                    this.dispose();
                }
                
                JOptionPane.showMessageDialog(null, "Bem vindo(a)! A paz do Senhor!");
            }else{
                JOptionPane.showMessageDialog(null,"Usuário e / ou Senha Inválido(s)!");
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        // a linha abaixo serve de apoio ao status da conexão.
        //System.out.println(conexao);
        if (conexao != null) {
            lblStatus.setText("Conectado");
        } else {
            lblStatus.setText("Não Conectado");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelCinza = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagem1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Login");
        setResizable(false);

        PainelCinza.setBackground(new java.awt.Color(92, 92, 172));
        PainelCinza.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelCinza.setToolTipText("");
        PainelCinza.setName(""); // NOI18N

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        imagem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_login.png"))); // NOI18N

        labelNome.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        labelNome.setForeground(new java.awt.Color(153, 153, 153));
        labelNome.setText("Usuário:");

        campoNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoNome.setForeground(new java.awt.Color(51, 153, 255));
        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNomeKeyPressed(evt);
            }
        });

        labelSenha.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(153, 153, 153));
        labelSenha.setText("Senha:");

        campoSenha.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        campoSenha.setForeground(new java.awt.Color(255, 51, 51));
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        botaoEntrar.setBackground(new java.awt.Color(51, 51, 51));
        botaoEntrar.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        botaoEntrar.setForeground(new java.awt.Color(255, 255, 255));
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        botaoEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(267, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagem1)
                .addGap(335, 335, 335))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(imagem1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PainelCinzaLayout = new javax.swing.GroupLayout(PainelCinza);
        PainelCinza.setLayout(PainelCinzaLayout);
        PainelCinzaLayout.setHorizontalGroup(
            PainelCinzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCinzaLayout.createSequentialGroup()
                .addGroup(PainelCinzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCinzaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelCinzaLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        PainelCinzaLayout.setVerticalGroup(
            PainelCinzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCinzaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCinza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCinza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PainelCinza.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        // Chamando o método logar.
        logar();
        
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void campoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeKeyPressed
        // Colocando atalho enter para passar para o próximo campo
        if(evt.getKeyCode() == evt.VK_ENTER){
            campoSenha.requestFocus();
        }
    }//GEN-LAST:event_campoNomeKeyPressed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
         // Colocando atalho enter para passar para o próximo campo
        if(evt.getKeyCode() == evt.VK_ENTER){
            botaoEntrar.requestFocus();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void botaoEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarKeyPressed
         // Colocando atalho enter para entrar e logar
        if(evt.getKeyCode() == evt.VK_ENTER){
             logar();
        }
    }//GEN-LAST:event_botaoEntrarKeyPressed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelCinza;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel imagem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}