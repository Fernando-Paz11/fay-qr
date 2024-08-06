/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fay_qr;

import clases.Alumnos;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author Harlen
 */
public class frmAlumno extends javax.swing.JFrame {

    /**
     * Creates new form frmAlumno
     */
    public frmAlumno() {
        initComponents();
         //icono
        setIconImage(new ImageIcon(getClass().getResource("/img/icono_fayqr.png")).getImage());
        //poner la ventana en el centro
        this.setLocationRelativeTo(null);  
    }
    
    Alumnos st=new Alumnos();
    FileInputStream foto;
    DefaultTableModel modelo= new DefaultTableModel();
    public void cargarTabla(){
          try {
            tblalumno.setModel(modelo);
            ResultSet rs = null;
            rs = st.consultarAlumnosRS();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
           
            // SE AGREAN LOS NOMBRES DE COLUMNAS O ENCABEZADOS
            modelo.addColumn("MATRICULA");
            modelo.addColumn("NOMBRE COMPLETO");
           
            //SE DEFINE EL ANCHO DE CADA COLUMNA
            int[] anchos = {50, 200};
           
            //ESTE FOR ASIGNA EL ANCHO A CADA COLUMNA
            for (int i = 0; i < tblalumno.getColumnCount(); i++) {
                tblalumno.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 1; i < 2; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
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

        pnlBienvenida = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmatricula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblalumno = new javax.swing.JTable();
        cbocarrera = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAlumno = new javax.swing.JMenu();
        mnEvento = new javax.swing.JMenu();
        mnAsistencias = new javax.swing.JMenu();
        mnOrganizador = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        mnAcercade = new javax.swing.JMenu();
        mnSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBienvenida.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(71, 181, 244));

        btnRegistrar.setBackground(new java.awt.Color(65, 109, 214));
        btnRegistrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(65, 109, 214));
        btnActualizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(65, 109, 214));
        btnEliminar.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 21, 20));
        jLabel2.setText("Nombre completo :");

        txtnombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(51, 51, 51));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(28, 21, 20));
        jLabel6.setText("Teléfono :");

        txttelefono.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(51, 51, 51));

        txtcorreo.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        txtcorreo.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(28, 21, 20));
        jLabel7.setText("Correo:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 21, 20));
        jLabel3.setText("Matricula:");

        txtmatricula.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        txtmatricula.setForeground(new java.awt.Color(51, 51, 51));
        txtmatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmatriculaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(28, 21, 20));
        jLabel8.setText("Carrera:");

        tblalumno.setFont(new java.awt.Font("Berlin Sans FB", 0, 19)); // NOI18N
        tblalumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumnos", "Actualizar", "Eliminar"
            }
        ));
        tblalumno.getTableHeader().setReorderingAllowed(false);
        tblalumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblalumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblalumno);
        if (tblalumno.getColumnModel().getColumnCount() > 0) {
            tblalumno.getColumnModel().getColumn(0).setMaxWidth(500);
            tblalumno.getColumnModel().getColumn(1).setMaxWidth(100);
            tblalumno.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        cbocarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistemas computacionales", "Administración de empresas", "Contaduría pública", "Derecho", "Diseño gráfico", "Mercadotecnia y publicidad", "Psicología", "Arquitectura", "Educación", "Comunicación gráfica y publicidad" }));
        cbocarrera.setSelectedIndex(-1);

        javax.swing.GroupLayout pnlBienvenidaLayout = new javax.swing.GroupLayout(pnlBienvenida);
        pnlBienvenida.setLayout(pnlBienvenidaLayout);
        pnlBienvenidaLayout.setHorizontalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbocarrera, 0, 247, Short.MAX_VALUE))
                            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(txtnombre))
                            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcorreo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBienvenidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBienvenidaLayout.setVerticalGroup(
            pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBienvenidaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cbocarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 500));

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

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtmatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmatriculaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        st=new Alumnos(0,txtmatricula.getText(),txtnombre.getText(),txtcorreo.getText(),txttelefono.getText(),cbocarrera.getSelectedItem().toString(),foto);
        try {
            st.insertarAlumno();
            JOptionPane.showMessageDialog(null, "El alumno se ha guardado correctamente.","WARNINESSAGE", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            //Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void mnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnSalirMouseClicked
        // TODO add your handling code here:
        frmLogin login =new  frmLogin();
        login.setVisible(true);
        this.setVisible(false);
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

    private void tblalumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblalumnoMouseClicked
        // TODO add your handling code here:
        try {
            int Fila = tblalumno.getSelectedRow();
            int id_alumno = Integer.parseInt(tblalumno.getValueAt(Fila, 0).toString());
            ResultSet rs=null;
            rs=st.buscarAlumnoRS(id_alumno);
           
            while (rs.next()) {
                txtmatricula.setText(rs.getString("matricula"));
                txtnombre.setText(rs.getString("nombre_completo"));
                txtcorreo.setText(rs.getString("correo"));
                txttelefono.setText(rs.getString("telefono"));
                cbocarrera.setSelectedItem(rs.getString("carrera"));
                
                //System.out.println(rs.getString("tipo_usuario"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tblalumnoMouseClicked

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
            java.util.logging.Logger.getLogger(frmAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbocarrera;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mnAcercade;
    private javax.swing.JMenu mnAlumno;
    private javax.swing.JMenu mnAsistencias;
    private javax.swing.JMenu mnEvento;
    private javax.swing.JMenu mnOrganizador;
    private javax.swing.JMenu mnSalir;
    private javax.swing.JPanel pnlBienvenida;
    private javax.swing.JTable tblalumno;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtmatricula;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
