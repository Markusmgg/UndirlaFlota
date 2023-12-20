import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndirlaFlota extends JFrame {
	/**
	 * La clase UndirlaFlota representa la ventana principal de la aplicación,
	 * que sirve como menú para seleccionar el modo de juego.
	 * Extiende la clase JFrame y utiliza la biblioteca Swing para la interfaz gráfica.
	 *
	 * @author Marcos Martín
	 */
    private JFrame frame;
    /**
     * Método principal que inicia la aplicación y muestra la ventana principal.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UndirlaFlota window = new UndirlaFlota();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Constructor de la clase UndirlaFlota. Inicializa la interfaz gráfica llamando al método initialize().
     */
    public UndirlaFlota() {
        initialize();
    }
    /**
     * Inicializa la interfaz gráfica de la ventana principal con etiquetas, botones y diseños.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(look.BACKGROUND_COLOR);
        JLabel lblNewLabel = new JLabel("Undir la flota");
        lblNewLabel.setFont(look.TITLE_FONT);
        lblNewLabel.setForeground(look.LABEL_TEXT_COLOR);

        JButton btnUnjugador = new JButton("Un jugador");
        btnUnjugador.setFont(look.BUTTON_FONT);
        btnUnjugador.setBackground(look.BUTTON_COLOR);
        btnUnjugador.setForeground(look.LABEL_TEXT_COLOR);
        btnUnjugador.addActionListener(e -> {
            UnovsUno uno = new UnovsUno();
            uno.setVisible(true);
            frame.dispose();
        });

        JButton btnNewButton_1 = new JButton("Dos jugadores");
        btnNewButton_1.setFont(look.BUTTON_FONT);
        btnNewButton_1.setBackground(look.BUTTON_COLOR);
        btnNewButton_1.setForeground(look.LABEL_TEXT_COLOR);

        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(122)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(96, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(41)
                                .addComponent(btnUnjugador, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addGap(46)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addGap(356))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addGap(33)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUnjugador, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addGap(125))
        );
        frame.getContentPane().setLayout(groupLayout);
    }
}