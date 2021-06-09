/*Tela principal para abrir as janelas, executar. 
 */
package br.com.cadastroCohab.telas;

import java.sql.*;
import br.com.cadastroCohab.dal.ModuloConexao;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Fabiana de Albuquerque Silva
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Método de verificação de usuário, se é admin, moderado ou user. 
    //Na tela de membros a opção de user só vai poder visualizar, e quem pode editar seria o perfil moderado e o administrador.
    private void verificarPerfil(){
        String sql = "select * from tbusuarios where usuario=?";
        try {
            //As linhas abaixo preparam a consulta ao banco em função do
            // que foi digitado nas caixas de texto. O interroga é substituído
            //pelo conteúdo das variáveis.
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeUsuario.getText());
            //A linha abaixo executa a query.
            rs = pst.executeQuery();
            //Se existir usuário e senha correspondente.
            if(rs.next()){
                //A linha abaixo contem o conteudo do campo perfil na tabela tbusuarios.
                String perfil=rs.getString(6);
                //System.out.println(perfil);
                // A estrutura abaixo faz o tratamento do perfil do usuário.
                if (perfil.equals("admin")){
                    TelaMembros membros = new TelaMembros();
                    membros.setVisible(true);
                    Desktop.add(membros);
                    TelaMembros.botaoSalvar.setEnabled(true);
                    TelaMembros.botaoEditar.setEnabled(true);
                    TelaMembros.botaoDeletar.setEnabled(true);
                    TelaMembros.imprimirMembros.setEnabled(true);
                    TelaMembros.btnImprimirClasse.setEnabled(true);
                }else if(perfil.equals("moderado")){
                    TelaMembros membros = new TelaMembros();
                    membros.setVisible(true);
                    Desktop.add(membros);
                    TelaMembros.botaoSalvar.setEnabled(true);
                    TelaMembros.botaoEditar.setEnabled(true);
                    TelaMembros.botaoDeletar.setEnabled(true);
                    TelaMembros.imprimirMembros.setEnabled(true);
                    TelaMembros.btnImprimirClasse.setEnabled(true);
                }else{
                    TelaMembros membros = new TelaMembros();
                    membros.setVisible(true);
                    Desktop.add(membros);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Não identificamos seu login no banco de dados! Por favor, tente mais tarde.");
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelAzul = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        logo = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JLabel();
        textoData = new javax.swing.JLabel();
        textoOla = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        itemCad = new javax.swing.JMenuItem();
        itemCad2 = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenu();
        itemPlan1 = new javax.swing.JMenuItem();
        itemPlan2 = new javax.swing.JMenuItem();
        itemPlan3 = new javax.swing.JMenuItem();
        menu4 = new javax.swing.JMenu();
        itemAjuda = new javax.swing.JMenuItem();
        ItemInstrucao = new javax.swing.JMenuItem();
        menu5 = new javax.swing.JMenu();
        itemOpc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro Cohab");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        painelAzul.setBackground(new java.awt.Color(102, 102, 102));
        painelAzul.setToolTipText("");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/logo_software.png"))); // NOI18N
        logo.setToolTipText("Autora e design: Fabiana de Albuquerque Silva");

        nomeUsuario.setFont(new java.awt.Font("Arial Narrow", 1, 26)); // NOI18N
        nomeUsuario.setForeground(new java.awt.Color(255, 255, 255));

        textoData.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        textoData.setForeground(new java.awt.Color(255, 204, 0));
        textoData.setText("Data");

        textoOla.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        textoOla.setForeground(new java.awt.Color(255, 255, 255));
        textoOla.setText("Olá,");

        texto1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        texto1.setForeground(new java.awt.Color(255, 255, 255));
        texto1.setText("Seja bem vindo(a) irmão(ã) ao Sistema SCAPEC.");

        texto2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        texto2.setForeground(new java.awt.Color(255, 255, 255));
        texto2.setText("Como posso te ajudar??");

        javax.swing.GroupLayout painelAzulLayout = new javax.swing.GroupLayout(painelAzul);
        painelAzul.setLayout(painelAzulLayout);
        painelAzulLayout.setHorizontalGroup(
            painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAzulLayout.createSequentialGroup()
                        .addGroup(painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAzulLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto1)
                                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelAzulLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(logo)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(painelAzulLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelAzulLayout.createSequentialGroup()
                                .addGroup(painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoData, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoOla, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        painelAzulLayout.setVerticalGroup(
            painelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAzulLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(textoData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textoOla, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(painelAzulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(92, 92, 172));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        menu1.setBackground(new java.awt.Color(92, 92, 172));
        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_cadastro_menu.png"))); // NOI18N
        menu1.setText("Cadastro");
        menu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });

        itemCad.setBackground(new java.awt.Color(92, 92, 172));
        itemCad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_membros_adicionar.png"))); // NOI18N
        itemCad.setText("Novos Membros");
        itemCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadActionPerformed(evt);
            }
        });
        menu1.add(itemCad);

        itemCad2.setBackground(new java.awt.Color(92, 92, 172));
        itemCad2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemCad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_usuarios_adicionar.png"))); // NOI18N
        itemCad2.setText("Usuários");
        itemCad2.setEnabled(false);
        itemCad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCad2ActionPerformed(evt);
            }
        });
        menu1.add(itemCad2);

        jMenuBar1.add(menu1);

        menu2.setBackground(new java.awt.Color(92, 92, 172));
        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_planilhas_menu.png"))); // NOI18N
        menu2.setText("Planilhas");
        menu2.setEnabled(false);
        menu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemPlan1.setBackground(new java.awt.Color(92, 92, 172));
        itemPlan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemPlan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_documento_adicionar.png"))); // NOI18N
        itemPlan1.setText("Criar Documento");
        itemPlan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPlan1ActionPerformed(evt);
            }
        });
        menu2.add(itemPlan1);

        itemPlan2.setBackground(new java.awt.Color(92, 92, 172));
        itemPlan2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemPlan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_informação_total.png"))); // NOI18N
        itemPlan2.setText("Informações de Total");
        itemPlan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPlan2ActionPerformed(evt);
            }
        });
        menu2.add(itemPlan2);

        itemPlan3.setBackground(new java.awt.Color(92, 92, 172));
        itemPlan3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemPlan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_grafico.png"))); // NOI18N
        itemPlan3.setText("Gráfico de Índice Mensal");
        itemPlan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPlan3ActionPerformed(evt);
            }
        });
        menu2.add(itemPlan3);

        jMenuBar1.add(menu2);

        menu4.setBackground(new java.awt.Color(92, 92, 172));
        menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_suporte.png"))); // NOI18N
        menu4.setText("Suporte SCAPEC");
        menu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemAjuda.setBackground(new java.awt.Color(92, 92, 172));
        itemAjuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_sobre.png"))); // NOI18N
        itemAjuda.setText("Sobre");
        itemAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAjudaActionPerformed(evt);
            }
        });
        menu4.add(itemAjuda);

        ItemInstrucao.setBackground(new java.awt.Color(92, 92, 172));
        ItemInstrucao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ItemInstrucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_instrucao.png"))); // NOI18N
        ItemInstrucao.setText("Instruçoes: Como se usa o programa?");
        ItemInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemInstrucaoActionPerformed(evt);
            }
        });
        menu4.add(ItemInstrucao);

        jMenuBar1.add(menu4);

        menu5.setBackground(new java.awt.Color(92, 92, 172));
        menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_configuraçao.png"))); // NOI18N
        menu5.setText("Opções");
        menu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemOpc.setBackground(new java.awt.Color(92, 92, 172));
        itemOpc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemOpc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroCohab/icones/img_sair.png"))); // NOI18N
        itemOpc.setText("Sair");
        itemOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOpcActionPerformed(evt);
            }
        });
        menu5.add(itemOpc);

        jMenuBar1.add(menu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1370, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOpcActionPerformed
        //Exibe uma caixa de diálogo.
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }//GEN-LAST:event_itemOpcActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // As linhas abaixo substituem a label pela data atual do sistema
        // ao inicializar o form.
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        textoData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void itemAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjudaActionPerformed
        // Chamando a tela Sobre.
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_itemAjudaActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu1ActionPerformed

    private void itemCad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCad2ActionPerformed
        // As linhas abaixo vão abrir o Form TelaUsuario dentro do desktop pane.
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
        Desktop.add(usuario);
    }//GEN-LAST:event_itemCad2ActionPerformed

    private void itemCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadActionPerformed
        // Chamando método verificarPerfil para entrar na TelaMembros.
        verificarPerfil();
    }//GEN-LAST:event_itemCadActionPerformed

    private void itemPlan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPlan1ActionPerformed
        // Chamando a tela Excel.
        TelaExcel excel = new TelaExcel();
        excel.setVisible(true);
        Desktop.add(excel);
        JOptionPane.showMessageDialog(null, "Lembrete: Nos valores de oferta e Oferta de Missões colocar o ponto no lugar da vírgula.");
    }//GEN-LAST:event_itemPlan1ActionPerformed

    private void itemPlan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPlan2ActionPerformed
        // Chamando a tela de informações do total no banco.
        TelaInformacao total = new TelaInformacao();
        total.setVisible(true);
        Desktop.add(total);
        
    }//GEN-LAST:event_itemPlan2ActionPerformed

    private void itemPlan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPlan3ActionPerformed
        // Chamando a tela de gráfico de índice trimestral para quando clicar ir para a área de trabalho.
        TelaGraficoTrimestral gfo = new TelaGraficoTrimestral();
        gfo.setVisible(true);
        Desktop.add(gfo);
    }//GEN-LAST:event_itemPlan3ActionPerformed

    private void ItemInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemInstrucaoActionPerformed
        // Chamando tela de instruções sobre o software.
        TelaInstrucoes instrucao = new TelaInstrucoes();
        instrucao.setVisible(true);
        Desktop.add(instrucao);
    }//GEN-LAST:event_ItemInstrucaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem ItemInstrucao;
    private javax.swing.JMenuItem itemAjuda;
    private javax.swing.JMenuItem itemCad;
    public static javax.swing.JMenuItem itemCad2;
    private javax.swing.JMenuItem itemOpc;
    private javax.swing.JMenuItem itemPlan1;
    private javax.swing.JMenuItem itemPlan2;
    private javax.swing.JMenuItem itemPlan3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel logo;
    private javax.swing.JMenu menu1;
    public static javax.swing.JMenu menu2;
    private javax.swing.JMenu menu4;
    private javax.swing.JMenu menu5;
    public static javax.swing.JLabel nomeUsuario;
    private javax.swing.JPanel painelAzul;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel textoData;
    private javax.swing.JLabel textoOla;
    // End of variables declaration//GEN-END:variables
}