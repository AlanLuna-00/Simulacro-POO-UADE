package mvc.view;

import mvc.controller.UserController;
import mvc.dto.UserDTO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListUsersUI extends JFrame {
    private final UserController userController;
    private JTable usuariosTable;
    private UsuariosTableModel tableModel;

    public ListUsersUI() {
        setTitle("Lista de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        userController = UserController.getInstance();
        initUI();
    }

    private void initUI() {
        tableModel = new UsuariosTableModel(userController.obtenerUsuarios());
        usuariosTable = new JTable(tableModel);

        // Agregar columna de acciones para eliminar usuario
        TableColumn actionColumn = usuariosTable.getColumnModel().getColumn(usuariosTable.getColumnCount() - 1);
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(usuariosTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private static class UsuariosTableModel extends AbstractTableModel {
        private final String[] columnNames = {"ID", "Tipo Usuario", "Calle", "Altura", "Localidad", "Acciones"};
        private List<UserDTO> usuarios;

        public UsuariosTableModel(List<UserDTO> usuarios) {
            this.usuarios = usuarios;
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            UserDTO usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0: return usuario.getId();
                case 1: return usuario.getTipoUsuario();
                case 2: return usuario.getCalle();
                case 3: return usuario.getAltura();
                case 4: return usuario.getLocalidad();
                case 5: return "Eliminar"; // Botón de acción
                default: return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 5;
        }

        public void removeUsuario(int rowIndex) {
            usuarios.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    private static class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private int row;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("Eliminar");
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eliminarUsuario(row);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            button.setText((value == null) ? "" : value.toString());
            return button;
        }

        private void eliminarUsuario(int row) {
            int id = (int) usuariosTable.getValueAt(row, 0);
            userController.eliminarUsuario(id);
            tableModel.removeUsuario(row);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListUsersUI ui = new ListUsersUI();
            ui.setVisible(true);
        });
    }
}
