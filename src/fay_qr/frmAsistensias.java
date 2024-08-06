/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fay_qr;

import javax.swing.ImageIcon;

/**
 *
 * @author Harlen
 */
public class frmAsistensias extends javax.swing.JFrame {

    /**
     * Creates new form frmAsistensias
     */
    public frmAsistensias() {
        initComponents();
        
         //icono
        setIconImage(new ImageIcon(getClass().getResource("/img/icono_fayqr.png")).getImage());
        
        //poner la ventana en el centro
        this.setLocationRelativeTo(null);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBienvenida = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAlumno = new javax.swing.JMenu();
        mnEvento = new javax.swing.JMenu();
        mnAsistencias = new javax.swing.JMenu();
        mnOrganizador = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        mnAcercade = new javax.swing.JMenu();
        mnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBienvenida.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(71, 181, 244));

        lblLogo.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBienvenidaLayout = new javax.swing.GroupLayout(pnlBienvenida);
        pnlBienvenida.setLayout(pnlBienvenidaLayout);
        pnlBienvenidaLayout.setHorizontalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                .addContainerGap(649, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBienvenidaLayout.setVerticalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setToolTipText("");
        jMenuBar1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 50));

        mnAlumno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnAlumno.setText("Alumno");
        mnAlumno.setBorderPainted(false);
        mnAlumno.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnAlumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnAlumno.setMinimumSize(new java.awt.Dimension(120, 30));
        mnAlumno.setPreferredSize(new java.awt.Dimension(75, 27));
        mnAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAlumnoMouseClicked(evt);
            }
        });
        mnAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAlumnoActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnAlumno);

        mnEvento.setText("Evento");
        mnEvento.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnEvento.setMinimumSize(new java.awt.Dimension(120, 30));
        mnEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnEventoMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnEvento);

        mnAsistencias.setText("Asistencias");
        mnAsistencias.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnAsistencias.setMinimumSize(new java.awt.Dimension(120, 30));
        mnAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAsistenciasMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnAsistencias);

        mnOrganizador.setText("Organizador");
        mnOrganizador.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnOrganizador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnOrganizador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnOrganizador.setPreferredSize(new java.awt.Dimension(120, 30));
        mnOrganizador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnOrganizadorMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnOrganizador);

        jMenu6.setText("|                                                                                                                          |");
        jMenu6.setEnabled(false);
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        mnAcercade.setText("Acerca de ...");
        mnAcercade.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnAcercade.setHideActionText(true);
        mnAcercade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mnAcercade.setMinimumSize(new java.awt.Dimension(120, 30));
        mnAcercade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnAcercadeMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnAcercade);

        mnSalir.setText("Salir");
        mnSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        mnSalir.setHideActionText(true);
        mnSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mnSalir.setMinimumSize(new java.awt.Dimension(120, 30));
        mnSalir.setPreferredSize(new java.awt.Dimension(50, 50));
        mnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnSalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnAlumnoActionPerformed

    private void mnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSalirMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mnSalirMouseClicked

    private void mnAcercadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAcercadeMouseClicked
        // TODO add your handling code here:
        frmCreadores cr =new  frmCreadores();
        cr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnAcercadeMouseClicked

    private void mnOrganizadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnOrganizadorMouseClicked
        // TODO add your handling code here:
        frmOrganizador org =new  frmOrganizador();
        org.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnOrganizadorMouseClicked

    private void mnAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAsistenciasMouseClicked
        // TODO add your handling code here:
        frmAsistensias asis =new  frmAsistensias();
        asis.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnAsistenciasMouseClicked

    private void mnEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnEventoMouseClicked
        // TODO add your handling code here:
        frmEvento re =new  frmEvento();
        re.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnEventoMouseClicked

    private void mnAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAlumnoMouseClicked
        // TODO add your handling code here:
        frmAlumno a =new  frmAlumno();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnAlumnoMouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        frmCreadores cr =new  frmCreadores();
        cr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu6MouseClicked

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
            java.util.logging.Logger.getLogger(frmAsistensias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsistensias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsistensias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsistensias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsistensias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JMenu mnAcercade;
    private javax.swing.JMenu mnAlumno;
    private javax.swing.JMenu mnAsistencias;
    private javax.swing.JMenu mnEvento;
    private javax.swing.JMenu mnOrganizador;
    private javax.swing.JMenu mnSalir;
    private javax.swing.JPanel pnlBienvenida;
    // End of variables declaration//GEN-END:variables
}
