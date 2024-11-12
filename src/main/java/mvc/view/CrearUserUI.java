package mvc.view;

import mvc.controller.UserController;
import mvc.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CrearUserUI extends JFrame {

    private final UserController userController;
    private JTextField calleField;
    private JTextField alturaField;
    private JTextField pisoField;
    private JTextField dptoField;
    private JTextField codigoPostalField;
    private JTextField localidadField;
    private JTextField provinciaField;
    private JTextField razonSocialField;
    private JTextField cuitField;
    private JTextField iibbField;
    private JTextField condicionFiscalField;
    private JTextField nombreField;
    private JTextField dniField;
    private JComboBox<String> tipoUsuarioComboBox;

    public CrearUserUI() {
        setTitle("Crear Usuario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        userController = UserController.getInstance();
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 10, 10));

        JLabel tipoUsuarioLabel = new JLabel("Tipo de Usuario:");
        tipoUsuarioComboBox = new JComboBox<>(new String[]{"Industrial", "Residencial"});

        tipoUsuarioComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    toggleFields();
                }
            }
        });

        JLabel calleLabel = new JLabel("Calle:");
        calleField = new JTextField();

        JLabel alturaLabel = new JLabel("Altura:");
        alturaField = new JTextField();

        JLabel pisoLabel = new JLabel("Piso:");
        pisoField = new JTextField();

        JLabel dptoLabel = new JLabel("Departamento:");
        dptoField = new JTextField();

        JLabel codigoPostalLabel = new JLabel("Código Postal:");
        codigoPostalField = new JTextField();

        JLabel localidadLabel = new JLabel("Localidad:");
        localidadField = new JTextField();

        JLabel provinciaLabel = new JLabel("Provincia:");
        provinciaField = new JTextField();

        // Campos específicos de Usuario Industrial
        JLabel razonSocialLabel = new JLabel("Razón Social:");
        razonSocialField = new JTextField();

        JLabel cuitLabel = new JLabel("CUIT:");
        cuitField = new JTextField();

        JLabel iibbLabel = new JLabel("IIBB:");
        iibbField = new JTextField();

        JLabel condicionFiscalLabel = new JLabel("Condición Fiscal:");
        condicionFiscalField = new JTextField();

        // Campos específicos de Usuario Residencial
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel dniLabel = new JLabel("DNI:");
        dniField = new JTextField();

        JButton aceptarButton = new JButton("Aceptar");
        JButton cancelarButton = new JButton("Cancelar");

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarAction();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarAction();
            }
        });

        panel.add(tipoUsuarioLabel);
        panel.add(tipoUsuarioComboBox);
        panel.add(calleLabel);
        panel.add(calleField);
        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(pisoLabel);
        panel.add(pisoField);
        panel.add(dptoLabel);
        panel.add(dptoField);
        panel.add(codigoPostalLabel);
        panel.add(codigoPostalField);
        panel.add(localidadLabel);
        panel.add(localidadField);
        panel.add(provinciaLabel);
        panel.add(provinciaField);

        // Añadimos todos los campos pero controlamos su visibilidad
        panel.add(razonSocialLabel);
        panel.add(razonSocialField);
        panel.add(cuitLabel);
        panel.add(cuitField);
        panel.add(iibbLabel);
        panel.add(iibbField);
        panel.add(condicionFiscalLabel);
        panel.add(condicionFiscalField);
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(dniLabel);
        panel.add(dniField);

        panel.add(aceptarButton);
        panel.add(cancelarButton);

        add(panel);

        // Configuración inicial de visibilidad
        toggleFields();
    }

    private void toggleFields() {
        String tipoUsuario = (String) tipoUsuarioComboBox.getSelectedItem();

        boolean isIndustrial = "Industrial".equals(tipoUsuario);

        // Campos específicos de Usuario Industrial
        razonSocialField.setVisible(isIndustrial);
        cuitField.setVisible(isIndustrial);
        iibbField.setVisible(isIndustrial);
        condicionFiscalField.setVisible(isIndustrial);

        // Campos específicos de Usuario Residencial
        nombreField.setVisible(!isIndustrial);
        dniField.setVisible(!isIndustrial);

        // Revalida el diseño de la ventana
        this.revalidate();
        this.repaint();
    }

    private void aceptarAction() {
        try {
            int id = (int) (System.currentTimeMillis() / 1000);
            String tipoUsuario = (String) tipoUsuarioComboBox.getSelectedItem();

            UserDTO userDto = new UserDTO(
                    id,
                    tipoUsuario,
                    calleField.getText(),
                    Integer.parseInt(alturaField.getText()),
                    Integer.parseInt(pisoField.getText()),
                    dptoField.getText(),
                    Integer.parseInt(codigoPostalField.getText()),
                    localidadField.getText(),
                    provinciaField.getText(),
                    tipoUsuario.equals("Industrial") ? razonSocialField.getText() : null,
                    tipoUsuario.equals("Industrial") ? cuitField.getText() : null,
                    tipoUsuario.equals("Industrial") ? iibbField.getText() : null,
                    tipoUsuario.equals("Industrial") ? condicionFiscalField.getText() : null,
                    tipoUsuario.equals("Residencial") ? nombreField.getText() : null,
                    tipoUsuario.equals("Residencial") ? Integer.parseInt(dniField.getText()) : 0
            );

            userController.registrarUsuario(userDto);
            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarAction() {
        calleField.setText("");
        alturaField.setText("");
        pisoField.setText("");
        dptoField.setText("");
        codigoPostalField.setText("");
        localidadField.setText("");
        provinciaField.setText("");
        razonSocialField.setText("");
        cuitField.setText("");
        iibbField.setText("");
        condicionFiscalField.setText("");
        nombreField.setText("");
        dniField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CrearUserUI ui = new CrearUserUI();
            ui.setVisible(true);
        });
    }
}
