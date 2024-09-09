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
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class EmotionTracker extends JFrame {

    private JPanel yearPanel;
    private JLabel yearLabel;
    private int currentYear;
    private final Map<String, String> emotions = new HashMap<>();

    public EmotionTracker() {
        setTitle("Emotion Tracker");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Get the current year from the system date
        currentYear = Year.now().getValue();

        // Create a label to display the year in the desired format
        yearLabel = new JLabel("Godina: " + currentYear + ".");
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Create buttons for navigating years
        JButton prevYearButton = new JButton("<");
        prevYearButton.addActionListener(e -> updateYear(currentYear - 1));
        
        JButton nextYearButton = new JButton(">");
        nextYearButton.addActionListener(e -> updateYear(currentYear + 1));

        // Create a panel for the year label with FlowLayout
        JPanel yearLabelPanel = new JPanel();
        yearLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        yearLabelPanel.add(prevYearButton);
        yearLabelPanel.add(yearLabel);
        yearLabelPanel.add(nextYearButton);

        // Add the year label panel to the top of the frame
        add(yearLabelPanel, BorderLayout.NORTH);

        // Initialize the main panel with an extra column for month names
        yearPanel = new JPanel();
        yearPanel.setLayout(new GridLayout(12, 32, 2, 2)); // 12 rows for months, 32 columns (1 for month name + 31 for days)
        add(yearPanel, BorderLayout.CENTER);

        // Create the legend panel
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel legendLabel = new JLabel("Legenda:");
        legendLabel.setFont(new Font("Arial", Font.BOLD, 14));
        legendPanel.add(legendLabel);

        JLabel srecanSquare = new JLabel();
        srecanSquare.setOpaque(true);
        srecanSquare.setBackground(Color.RED);
        srecanSquare.setPreferredSize(new Dimension(20, 20));
        legendPanel.add(srecanSquare);

        JLabel srecanLabel = new JLabel("SREĆAN");
        srecanLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        legendPanel.add(srecanLabel);

        JLabel tuzanSquare = new JLabel();
        tuzanSquare.setOpaque(true);
        tuzanSquare.setBackground(Color.BLUE);
        tuzanSquare.setPreferredSize(new Dimension(20, 20));
        legendPanel.add(tuzanSquare);

        JLabel tuzanLabel = new JLabel("TUŽAN");
        tuzanLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        legendPanel.add(tuzanLabel);

        add(legendPanel, BorderLayout.SOUTH);

        // Initial calendar display
        displayCalendar(currentYear);
    }

    private void updateYear(int newYear) {
        currentYear = newYear;
        yearLabel.setText("Godina: " + currentYear + ".");
        emotions.clear();  // Clear previous year emotions
        emotions.putAll(fetchEmotionsFromDatabase(currentYear));  // Fetch new year emotions
        displayCalendar(currentYear);
    }

    private void displayCalendar(int year) {
        yearPanel.removeAll();

        // Serbian month names (first 3 letters)
        String[] monthsSerbianShort = {"Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Avg", "Sep", "Okt", "Nov", "Dec"};

        // Create labels for each day in the grid, and add month names
        for (int month = 1; month <= 12; month++) {
            // Add the short month name label in the first column
            JLabel monthLabel = new JLabel(monthsSerbianShort[month - 1]);
            monthLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
            monthLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Adjust font size
            yearPanel.add(monthLabel);

            int daysInMonth = getDaysInMonth(year, month);
            for (int day = 1; day <= daysInMonth; day++) {
                String dateKey = String.format("%d-%02d-%02d", year, month, day);
                JLabel dayLabel = new JLabel(String.valueOf(day));
                dayLabel.setOpaque(true);  // Necessary to display the background color
                dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
                dayLabel.setFont(new Font("Arial", Font.PLAIN, 10));  // Smaller font size for days
                dayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Optional: Add a border

                // Set background color based on emotion
                if (emotions.containsKey(dateKey)) {
                    String emotion = emotions.get(dateKey);
                    if (emotion.equals("SRECAN")) {
                        dayLabel.setBackground(Color.RED);  // SRECAN -> Red
                    } else if (emotion.equals("TUZAN")) {
                        dayLabel.setBackground(Color.BLUE);  // TUZAN -> Blue
                    }
                } else {
                    dayLabel.setBackground(Color.LIGHT_GRAY);  // Default color for no emotion recorded
                }

                yearPanel.add(dayLabel);
            }

            // Add empty labels if month has fewer than 31 days
            for (int day = daysInMonth + 1; day <= 31; day++) {
                JLabel emptyLabel = new JLabel();
                emptyLabel.setOpaque(true);
                emptyLabel.setBackground(Color.WHITE);  // Color for unused days in the month
                yearPanel.add(emptyLabel);
            }
        }

        // Finalize the UI
        yearPanel.revalidate();
        yearPanel.repaint();
    }

    private int getDaysInMonth(int year, int month) {
        switch (month) {
            case 2:  // February
                return isLeapYear(year) ? 29 : 28;  // Handle leap years
            case 4: case 6: case 9: case 11:  // April, June, September, November
                return 30;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private Map<String, String> fetchEmotionsFromDatabase(int year) {
        // Simulated database data, keyed by date (YYYY-MM-DD)
        // Replace this with actual database fetching logic
        Map<String, String> emotions = new HashMap<>();
        emotions.put(year + "-11-27", "SRECAN");
        emotions.put(year + "-11-28", "TUZAN");
        // Add more dates and emotions as needed
        return emotions;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmotionTracker tracker = new EmotionTracker();
            tracker.setVisible(true);
        });
    }
}
