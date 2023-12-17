import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UnovsUno extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton[][] opponentGrid;
    private boolean[][] shipsLocation; // Para rastrear la ubicación de los barcos de la IA
    private int remainingShipsPlayer = 4; // El jugador tiene que encontrar 4 barcos

    public static void main(String[] args) {
        try {
            UnovsUno dialog = new UnovsUno();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UnovsUno() {
        setBounds(100, 100, 300, 150); // Tamaño reducido
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 1)); // Cambiado a un único panel

        opponentGrid = createGrid(5, 5);
        shipsLocation = new boolean[5][5];

        contentPane.add(createGridPanel(opponentGrid, "Tablero de la IA"));

        initializeGame();
    }

    private JButton[][] createGrid(int rows, int cols) {
        JButton[][] grid = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new JButton();
                final int row = i;
                final int col = j;
                grid[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        gridButtonClicked(row, col);
                    }
                });
            }
        }
        return grid;
    }

    private JPanel createGridPanel(JButton[][] grid, String title) {
        JPanel panel = new JPanel(new GridLayout(grid.length, grid[0].length));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Espaciado reducido

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                panel.add(grid[i][j]);
            }
        }

        return panel;
    }

    private void initializeGame() {
        // Lógica para que la IA coloque barcos aleatoriamente
        placeRandomShips();
        // Muestra los barcos de la IA visualmente
        displayShips();

        // Lógica para que el jugador encuentre los barcos
        JOptionPane.showMessageDialog(this, "Encuentra los barcos de la IA.");
    }

    private void placeRandomShips() {
        // Lógica para que la IA coloque barcos aleatoriamente
        // Puedes personalizar esta lógica según tus necesidades
        // En este ejemplo, simplemente coloca 4 barcos de 1 casilla en posiciones aleatorias

        for (int i = 0; i < 4; i++) {
            int row, col;
            do {
                row = (int) (Math.random() * 5);
                col = (int) (Math.random() * 5);
            } while (shipsLocation[row][col]); // Verifica si la posición está ocupada

            shipsLocation[row][col] = true;
        }
    }

    private void displayShips() {
        // Muestra visualmente los barcos de la IA
        for (int i = 0; i < shipsLocation.length; i++) {
            for (int j = 0; j < shipsLocation[0].length; j++) {
                if (shipsLocation[i][j]) {
                    opponentGrid[i][j].setText("B");
                }
            }
        }
    }

    private void gridButtonClicked(int row, int col) {
        // Lógica para manejar el clic en el tablero durante el juego
        // Puedes implementar esta parte según tus necesidades
        // ...

        // Ejemplo: Verifica si el jugador ha encontrado un barco de la IA
        if (shipsLocation[row][col]) {
            opponentGrid[row][col].setText("X"); // Marca como encontrado
            remainingShipsPlayer--;

            if (remainingShipsPlayer == 0) {
                // El jugador ha encontrado todos los barcos
                JOptionPane.showMessageDialog(this, "¡Has encontrado todos los barcos de la IA! ¡Ganaste!");
                // Puedes implementar lógica adicional para reiniciar el juego, salir, etc.
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "¡Encontraste un barco! Sigue buscando.");
            }
        } else {
            opponentGrid[row][col].setText("O"); // Marca como agua
            JOptionPane.showMessageDialog(this, "Agua. Sigue intentando.");
        }
    }
}