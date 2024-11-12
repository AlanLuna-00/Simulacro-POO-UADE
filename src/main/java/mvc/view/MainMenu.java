package mvc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();

        JButton crearUsuarioButton = new JButton("Crear Usuario");

        JButton listarUsuariosButton = new JButton("Listar Usuarios");

        // Listener para abrir CrearUserUI cuando se presiona el botón
        crearUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUserUI crearUserUI = new CrearUserUI();
                crearUserUI.setVisible(true);
            }
        });

        listarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListUsersUI buscarUserUI = new ListUsersUI();
                buscarUserUI.setVisible(true);
            }
        });

        panel.add(crearUsuarioButton);
        panel.add(listarUsuariosButton);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}
