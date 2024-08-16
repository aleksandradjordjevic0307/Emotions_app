/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author Aleksandra
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class YearInPixels extends JFrame {

    enum Mood {
        HAPPY, SAD
    }

    private JPanel[][] cells;

    public YearInPixels() {
        setTitle("Year in Pixels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 31)); // Assuming a month view for simplicity

        int daysInYear = 365;
        cells = new JPanel[12][31]; // Create a grid for 12 months, 31 days each
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                if (i * 31 + j < daysInYear) {
                    cells[i][j] = createCell();
                    add(cells[i][j]);
                } else {
                    add(new JLabel()); // Fill remaining cells with empty labels
                }
            }
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createCell() {
        JPanel cell = new JPanel();
        cell.setPreferredSize(new Dimension(25, 25));
        cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cell.setBackground(Color.WHITE);
        cell.addMouseListener(new CellMouseListener());
        return cell;
    }

    private class CellMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JPanel cell = (JPanel) e.getSource();
            showPopupMenu(cell, e.getX(), e.getY());
        }
    }

    private void showPopupMenu(JPanel cell, int x, int y) {
        JPopupMenu menu = new JPopupMenu();
        for (Mood mood : Mood.values()) {
            JMenuItem menuItem = new JMenuItem(mood.name());
            menuItem.addActionListener(new MoodSelectionListener(cell, mood));
            menu.add(menuItem);
        }
        menu.show(cell, x, y);
    }

    private class MoodSelectionListener implements ActionListener {
        private JPanel cell;
        private Mood mood;

        public MoodSelectionListener(JPanel cell, Mood mood) {
            this.cell = cell;
            this.mood = mood;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mood == Mood.HAPPY) {
                cell.setBackground(Color.PINK);
            } else if (mood == Mood.SAD) {
                cell.setBackground(Color.GREEN);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(YearInPixels::new);
    }
}
