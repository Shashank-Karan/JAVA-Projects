import java.awt.*;
import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;

    public DigitalClock() {
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setForeground(Color.BLACK);
        add(timeLabel, BorderLayout.CENTER);

        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        updateClock();
    }

    private void updateClock() {
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            String time = now.format(formatter);
            timeLabel.setText(time);

            try {
                Thread.sleep(1000); // update every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}