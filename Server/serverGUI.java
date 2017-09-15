
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AsusPC
 */
public class serverGUI extends javax.swing.JFrame {

    DBconnect busconnect = new DBconnect();
    ResultSet rs;
    ResultSet rs1;
    Route route;
    Socket socket;
    DefaultListModel aaa = new DefaultListModel();
    HandleThreadTask task;
    thread Thread;
    //HandleThreadTask1 task1;

    /**
     * Creates new form serverGUI
     */
    public serverGUI() {
        initComponents();
        setVisible(true);
        setResizable(false);
        //xyz.append("route\tfare\tarrive time\n");
        ArrayList<String> routes = new ArrayList<String>();
        routeinfo.setModel(aaa);
        busconnect.connect();
        rs = busconnect.viewAllRouteNo();
        try {
            while (rs.next()) {

                routenobox.addItem(new StringBuilder(rs.getString(1)).toString());
                routes.add(new StringBuilder(rs.getString(1)).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        conect();
    }

    public void conect() {
        try {
            ServerSocket serverSocket = new ServerSocket(8009);
            abc.append("Bus server started at " + new Date());
            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();
                task = new HandleThreadTask(socket);
                Thread = new thread(socket);
                

            }
        } catch (IOException e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        abc = new javax.swing.JTextArea();
        route1 = new javax.swing.JLabel();
        routenobox = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        txtfare = new javax.swing.JTextField();
        btnclose = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        hour = new javax.swing.JSpinner();
        minute = new javax.swing.JSpinner();
        second = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        routeinfo = new javax.swing.JList<String>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        abc.setEditable(false);
        abc.setColumns(20);
        abc.setRows(1);
        jScrollPane1.setViewportView(abc);

        route1.setText("route number : ");

        routenobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routenoboxActionPerformed(evt);
            }
        });

        jLabel1.setText("fare : $ ");

        txtfare.setEditable(false);
        txtfare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfareActionPerformed(evt);
            }
        });

        btnclose.setText("close server");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        btnadd.setText("add route");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel2.setText("time remaining  (hh/mm/ss) :  ");

        hour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        minute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        second.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jScrollPane3.setViewportView(routeinfo);

        jLabel3.setText("routeno / fare / time remaining");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                        .addComponent(btnclose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(route1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(routenobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfare, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(route1)
                    .addComponent(routenobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtfare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclose)
                            .addComponent(btnadd)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void routenoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routenoboxActionPerformed
        // TODO add your handling code here:
        rs1 = busconnect.viewRouteFare((String) routenobox.getSelectedItem());
        try {
            while (rs1.next()) {
                txtfare.setText(new StringBuilder(rs1.getString(1)).toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_routenoboxActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        //busconnect.disconnect();
        //System.exit(0);
        new Thread(Thread).start();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        hour.getValue();
        minute.getValue();
        second.getValue();
        String timeString = (hour.getValue() + ":" + minute.getValue() + ":" + second.getValue());
        route = new Route((String) routenobox.getSelectedItem(), "11:22:23", Double.valueOf(txtfare.getText()));
        route.setTime(timeString);
        //xyz.append((String)routenobox.getSelectedItem()+"\t"+txtfare.getText()+"\t"+timeString+"\n");
        String b = (String) routenobox.getSelectedItem() + "     " + txtfare.getText() + "     " + timeString;
        aaa.addElement(b);
        new Thread(task).start();
    }//GEN-LAST:event_btnaddActionPerformed

    private void txtfareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfareActionPerformed

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
            java.util.logging.Logger.getLogger(serverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(serverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(serverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(serverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        serverGUI a = new serverGUI();
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new serverGUI().setVisible(true);
                
         }
         });*/
    }

    private class HandleThreadTask implements Runnable {

        private Socket socket;

        public HandleThreadTask(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();
                out.writeObject(route);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class thread implements Runnable {
        int close;
        private Socket socket;

        public thread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                close=0;
                System.out.println(close);
                //DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                close = in.readInt();
                System.out.println(close);
                //aaa.remove(close);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea abc;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclose;
    private javax.swing.JSpinner hour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner minute;
    private javax.swing.JLabel route1;
    private javax.swing.JList<String> routeinfo;
    private javax.swing.JComboBox<String> routenobox;
    private javax.swing.JSpinner second;
    private javax.swing.JTextField txtfare;
    // End of variables declaration//GEN-END:variables
}
