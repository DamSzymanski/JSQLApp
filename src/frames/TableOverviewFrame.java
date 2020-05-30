/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import classes.MSSQLTransactions;
import static classes.AppInit.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import models.EnginesEnum;

import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jsarnowski
 */
public class TableOverviewFrame extends javax.swing.JFrame {

    private String currentDb;
    private String currentTable;
    private ResultSet res;
    private DefaultTableModel tableData;
    private ArrayList<JTextField> transactionFields;
    private ArrayList<String> columnNames;
    /**
     * Creates new form TableOverviewFrame
     */
    public TableOverviewFrame(String dbName, String tableName) {
        initComponents();
        this.currentDb = dbName;
        this.currentTable = tableName;
        this.TableName.setText(currentTable);
        this.DatabaseName.setText(currentDb);
        setLocationRelativeTo(null);
        this.setTitle("Universal Database Manager");
        
        DrawTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        TableListPane = new javax.swing.JPanel();
        TableListScrollPane = new javax.swing.JScrollPane();
        dataOverviewTable = new javax.swing.JTable();
        RecordDetailsPane = new javax.swing.JPanel();
        DatabaseLabel = new javax.swing.JLabel();
        TableLabel = new javax.swing.JLabel();
        CreatedByLabel = new javax.swing.JLabel();
        CreatedBy = new javax.swing.JLabel();
        CreateDateLabel = new javax.swing.JLabel();
        CreateDate = new javax.swing.JLabel();
        TableName = new javax.swing.JLabel();
        DatabaseName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LogoutMenuButton = new javax.swing.JMenuItem();
        ExitMenuButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        SwitchTableMenuButton = new javax.swing.JMenuItem();
        addNewRow = new javax.swing.JMenuItem();

        setLocation(new java.awt.Point(1, 1));
        setMinimumSize(new java.awt.Dimension(1280, 1024));
        setName("TableOverviewFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 1024));
        setSize(new java.awt.Dimension(1280, 1024));

        TableListPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TableListScrollPane.setBorder(null);

        dataOverviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        dataOverviewTable.setCellSelectionEnabled(true);
        dataOverviewTable.getTableHeader().setReorderingAllowed(false);
        dataOverviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataOverviewTableMouseClicked(evt);
            }
        });
        TableListScrollPane.setViewportView(dataOverviewTable);

        javax.swing.GroupLayout TableListPaneLayout = new javax.swing.GroupLayout(TableListPane);
        TableListPane.setLayout(TableListPaneLayout);
        TableListPaneLayout.setHorizontalGroup(
            TableListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TableListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        TableListPaneLayout.setVerticalGroup(
            TableListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TableListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        TableListScrollPane.getAccessibleContext().setAccessibleName("TableListScrollPane");
        TableListScrollPane.getAccessibleContext().setAccessibleDescription("");

        RecordDetailsPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout RecordDetailsPaneLayout = new javax.swing.GroupLayout(RecordDetailsPane);
        RecordDetailsPane.setLayout(RecordDetailsPaneLayout);
        RecordDetailsPaneLayout.setHorizontalGroup(
            RecordDetailsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );
        RecordDetailsPaneLayout.setVerticalGroup(
            RecordDetailsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        DatabaseLabel.setText("Database:");
        DatabaseLabel.setFocusable(false);

        TableLabel.setText("Table:");
        TableLabel.setFocusable(false);

        CreatedByLabel.setText("Created by:");
        CreatedByLabel.setFocusable(false);

        CreatedBy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CreatedBy.setText("N/A");
        CreatedBy.setFocusable(false);

        CreateDateLabel.setText("Date of creation:");
        CreateDateLabel.setFocusable(false);

        CreateDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CreateDate.setText("N/A");
        CreateDate.setFocusable(false);

        TableName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TableName.setText("-");
        TableName.setFocusable(false);

        DatabaseName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DatabaseName.setText("-");
        DatabaseName.setFocusable(false);

        jMenu1.setText("File");

        LogoutMenuButton.setText("Logout");
        LogoutMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuButtonActionPerformed(evt);
            }
        });
        jMenu1.add(LogoutMenuButton);

        ExitMenuButton.setText("Exit");
        ExitMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuButtonActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenuButton);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Actions");

        SwitchTableMenuButton.setText("Switch table");
        SwitchTableMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwitchTableMenuButtonActionPerformed(evt);
            }
        });
        jMenu2.add(SwitchTableMenuButton);

        addNewRow.setText("Add new row");
        addNewRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRowActionPerformed(evt);
            }
        });
        jMenu2.add(addNewRow);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TableListPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RecordDetailsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DatabaseLabel)
                    .addComponent(TableLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatabaseName)
                    .addComponent(TableName))
                .addGap(91, 91, 91)
                .addComponent(CreatedByLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreatedBy)
                .addGap(51, 51, 51)
                .addComponent(CreateDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TableListPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreatedByLabel)
                            .addComponent(CreatedBy)
                            .addComponent(CreateDateLabel)
                            .addComponent(CreateDate))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DatabaseName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TableName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DatabaseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TableLabel)))
                        .addGap(18, 18, 18)))
                .addComponent(RecordDetailsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuButtonActionPerformed
        try {
            if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
                if (appInit.mssqlConnection.connection.isClosed() != true) {
                    appInit.mssqlConnection.connection.close();
                }
            } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
                if (appInit.mysqlConnection.connection.isClosed() != true) {
                    appInit.mysqlConnection.connection.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableOverviewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitMenuButtonActionPerformed

    private void LogoutMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuButtonActionPerformed
        try {
            if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
                if (appInit.mssqlConnection.connection.isClosed() != true) {
                    appInit.mssqlConnection.connection.close();
                }
            } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
                if (appInit.mysqlConnection.connection.isClosed() != true) {
                    appInit.mysqlConnection.connection.close();
                }
            }
            this.setVisible(false);
            appInit.loginFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TableOverviewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogoutMenuButtonActionPerformed

    private void SwitchTableMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwitchTableMenuButtonActionPerformed
        this.setVisible(false);
        appInit.tableSelectFrame.setVisible(true);
    }//GEN-LAST:event_SwitchTableMenuButtonActionPerformed

    private void dataOverviewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataOverviewTableMouseClicked
        appInit.tableOverviewFrame.dataOverviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appInit.tableOverviewFrame.RecordDetailsPane.removeAll();
                
                //JTextField textfield1;
                JLabel label;
                JButton updateButton;
                JButton deleteButton;        
                transactionFields = new ArrayList<JTextField>();
                columnNames = new ArrayList<String>();
                
                appInit.tableOverviewFrame.RecordDetailsPane.setLayout(new FlowLayout());

                int row = dataOverviewTable.getSelectedRow();
                int columnCount = appInit.tableOverviewFrame.dataOverviewTable.getColumnCount();
                //int rowCount = appInit.tableOverviewFrame.dataOverviewTable.getRowCount();
                DefaultTableModel model = (DefaultTableModel) dataOverviewTable.getModel();

                for (int iCol = 1; iCol <= columnCount; iCol++) {
                    columnNames.add(dataOverviewTable.getColumnName(iCol - 1));
                    String value = (model.getValueAt(row, iCol - 1) == null) ? null : model.getValueAt(row, iCol - 1).toString();
                    //textfield1 = new JTextField(value, 10);
                    transactionFields.add(new JTextField(value, 10));
                    label = new JLabel(columnNames.get(iCol - 1));
                    appInit.tableOverviewFrame.RecordDetailsPane.add(label);
                    //appInit.dbTransactionFrame.getContentPane().add(label);
                    appInit.tableOverviewFrame.RecordDetailsPane.add(transactionFields.get(iCol - 1));
                    //appInit.dbTransactionFrame.getContentPane().add(textfield1);
                }

                updateButton = new JButton("Update");
                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (row >= 0) {
                            int res = 0;
                            int header = 0;
                            String headerValue = dataOverviewTable.getColumnName(header);
                            String value = model.getValueAt(row, header).toString();
                            //podjęcie działania w zależności od serwera bazodanowego
                            try {
                                String updateString = "";
                                //updateString build
                                for (int iCol = 2; iCol <= columnCount; iCol++) {
                                    String columnValue = (transactionFields.get(iCol - 1) == null) ? null : transactionFields.get(iCol - 1).getText();
                                    String valueQueryString = testParse(columnValue);
                                    if (iCol == columnCount) {
                                        updateString += columnNames.get(iCol - 1) + "=" + valueQueryString+" ";
                                    } else {
                                        updateString += columnNames.get(iCol - 1) + "=" + valueQueryString + ", ";
                                    }
                                }
                                if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
                                    if (appInit.mssqlConnection.connection.isClosed() != true) {
                                        res = appInit.mssqlTransactions.Update(updateString, appInit.tableOverviewFrame.currentTable, headerValue, value);
                                    }
                                } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
                                    if (appInit.mysqlConnection.connection.isClosed() != true) {
                                        res = appInit.mssqlTransactions.Update(updateString, appInit.tableOverviewFrame.currentTable, headerValue, value);
                                    }
                                }
                                //zwrotka w zależności od resulta
                                if (res == 1) {
                                    JOptionPane.showMessageDialog(rootPane, "Update successfull!");
                                    appInit.tableOverviewFrame.RecordDetailsPane.removeAll();
                                    transactionFields.clear();
                                    columnNames.clear();
                                    DrawTable();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Error during record update");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(TableOverviewFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Row not selected");
                        }
                    } 
                });

                deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (row >= 0) {
                            int header = 0;
                            String headerValue = dataOverviewTable.getColumnName(header);
                            String value = dataOverviewTable.getModel().getValueAt(row, header).toString();
                            try {
                                if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
                                    if (appInit.mssqlConnection.connection.isClosed() != true) {
                                        int res = appInit.mssqlTransactions.Delete(appInit.tableOverviewFrame.currentDb, appInit.tableOverviewFrame.currentTable, headerValue, value);
                                        if (res == 1) {
                                            model.removeRow(row);
                                            JOptionPane.showMessageDialog(rootPane, "Successfully deleted");
                                            appInit.tableOverviewFrame.RecordDetailsPane.removeAll();

                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Delete error");
                                        }

                                    }
                                } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
                                    if (appInit.mysqlConnection.connection.isClosed() != true) {
                                        int res = appInit.mysqlTransactions.Delete(appInit.tableOverviewFrame.currentDb, appInit.tableOverviewFrame.currentTable, headerValue, value);
                                        System.out.println(res);
                                        if (res == 1) {
                                            model.removeRow(row);
                                            JOptionPane.showMessageDialog(rootPane, "Successfully deleted");
                                            appInit.tableOverviewFrame.RecordDetailsPane.removeAll();

                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Delete error");
                                        }
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(TableOverviewFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Row not selected");
                        }
                    }
                });
                appInit.tableOverviewFrame.RecordDetailsPane.add(updateButton);
                appInit.tableOverviewFrame.RecordDetailsPane.add(deleteButton);
                appInit.tableOverviewFrame.pack();
            }
        });
    }//GEN-LAST:event_dataOverviewTableMouseClicked

    private void addNewRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewRowActionPerformed
        appInit.tableOverviewFrame.RecordDetailsPane.removeAll();
        
        JLabel label;
        JButton addNewRowButton = new JButton("Insert row");   
        
        ArrayList<String> values = new ArrayList<String>();
        
        transactionFields = new ArrayList<JTextField>();
        columnNames = new ArrayList<String>();     
        
        appInit.tableOverviewFrame.RecordDetailsPane.setLayout(new FlowLayout());
        
        int columnCount = appInit.tableOverviewFrame.dataOverviewTable.getColumnCount();
        
        for (int iCol = 1; iCol <= columnCount; iCol++) {
            columnNames.add(dataOverviewTable.getColumnName(iCol - 1));
            //String value = (model.getValueAt(row, iCol - 1) == null) ? null : model.getValueAt(row, iCol - 1).toString();
            transactionFields.add(new JTextField(null, 10));
            label = new JLabel(columnNames.get(iCol - 1));
            appInit.tableOverviewFrame.RecordDetailsPane.add(label);
            appInit.tableOverviewFrame.RecordDetailsPane.add(transactionFields.get(iCol - 1));
        }
        
        addNewRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = 0;
                try {            
                    for (int i = 0; i < transactionFields.size(); i++) {
                        values.add(transactionFields.get(i).getText());
                    }
                    if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
                        if (appInit.mssqlConnection.connection.isClosed() != true) {
                            res = appInit.mssqlTransactions.Insert(currentDb, currentTable, values);
                        }
                    } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
                        if (appInit.mysqlConnection.connection.isClosed() != true) {
                            res = appInit.mysqlTransactions.Insert(currentDb, currentTable, columnNames, values);
                        }
                    }
                    if (res == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Row inserted!");
                        appInit.tableOverviewFrame.RecordDetailsPane.removeAll();
                        transactionFields.clear();
                        columnNames.clear();
                        values.clear();
                        DrawTable();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error during inserting row");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TableOverviewFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
        
        appInit.tableOverviewFrame.RecordDetailsPane.add(addNewRowButton);
        appInit.tableOverviewFrame.pack();
    }//GEN-LAST:event_addNewRowActionPerformed
    private String testParse(String value) {
        try {
            Integer.parseInt(value);
            return value;

        } catch (NumberFormatException e) {
            if (value == null) {
                return null;
            } else {
                value = "'" + value + "'";
                return value;
            }
        }
    }
    
    private void DrawTable() {
        if (appInit.engine.equals(EnginesEnum.Engines.MSSQL.toString())) {
            res = appInit.mssqlTransactions.SelectAll(currentDb, currentTable);
        } else if (appInit.engine.equals(EnginesEnum.Engines.MySQL.toString())) {
            res = appInit.mysqlTransactions.SelectAll(currentDb, currentTable);
        }
        try {
            tableData = new DefaultTableModel();

            //liczenie kolumn
            ResultSetMetaData md = res.getMetaData();
            int columnCount = md.getColumnCount();

            //nagłówki kolumn
            List<Object> tableHeaders = new ArrayList<Object>();
            for (int i = 1; i <= columnCount; i++) {
                tableHeaders.add(md.getColumnName(i));
            }
            columnCount++;
            //test data
            Object[][] data = new Object[][]{};

            List<Object[]> table = new ArrayList<>();
            while (res.next()) {
                Object[] row = new Object[columnCount];
                for (int iCol = 1; iCol < columnCount; iCol++) {
                    Object obj = res.getObject(iCol);

                    row[iCol - 1] = (obj == null) ? null : obj.toString();

                    //System.out.println(obj.toString());
                }
                table.add(row);
            }

            data = new Object[columnCount][];
            table.toArray(data);
            dataOverviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            dataOverviewTable.setModel(new DefaultTableModel(table.toArray(data), tableHeaders.toArray()) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(TableSelectFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
    
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
            java.util.logging.Logger.getLogger(TableOverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableOverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableOverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableOverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreateDate;
    private javax.swing.JLabel CreateDateLabel;
    private javax.swing.JLabel CreatedBy;
    private javax.swing.JLabel CreatedByLabel;
    private javax.swing.JLabel DatabaseLabel;
    private javax.swing.JLabel DatabaseName;
    private javax.swing.JMenuItem ExitMenuButton;
    private javax.swing.JMenuItem LogoutMenuButton;
    private javax.swing.JPanel RecordDetailsPane;
    private javax.swing.JMenuItem SwitchTableMenuButton;
    private javax.swing.JLabel TableLabel;
    private javax.swing.JPanel TableListPane;
    private javax.swing.JScrollPane TableListScrollPane;
    private javax.swing.JLabel TableName;
    private javax.swing.JMenuItem addNewRow;
    private javax.swing.JTable dataOverviewTable;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

}
