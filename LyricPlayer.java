import java.awt.*;
import javax.swing.*; // This fixes the JFrame/JLabel error
import java.util.Timer;
import java.util.TimerTask;

public class LyricPlayer extends JFrame {
    private String[] lyrics = {
            "Mamamatay akong nakangiti",
            "Kapag Ikaw ang nasa aking tabi",
            "Mabubuhay akong nagsisisi",
            "Kapag 'sang araw hindi Kita mapapangiti",
            "",
            "Kalapastangan ang 'di Ka ibigin",
            "Kalokohan ang 'di Ka isipin",
            "Kung ang mundo ay biglang gugunawin",
            "Ikaw ang una kong hahanapin"
    };

    private JLabel lyricLabel;
    private int currentChar = 0;
    private int currentLine = 0;
    private final int CHAR_DELAY = 100; // Speed of typing
    private final int LINE_DELAY = 1500; // Pause between lines

    // Constructor: This sets up the window and starts the song
    public LyricPlayer() {
        // Setup the Window (JFrame)
        setTitle("Lyric Player");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Centers the text
        getContentPane().setBackground(Color.BLACK); // Black background like the video

        // Setup the Text (JLabel)
        lyricLabel = new JLabel("");
        lyricLabel.setFont(new Font("Consolas", Font.BOLD, 24)); // Code-style font
        lyricLabel.setForeground(Color.CYAN); // Cyan color text
        add(lyricLabel);

        setVisible(true);

        // Start the animation
        animateLyrics();
    }

    private void animateLyrics() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // If we have finished all lines, stop the timer
                if (currentLine >= lyrics.length) {
                    timer.cancel();
                    return;
                }

                String line = lyrics[currentLine];

                // If we are currently typing a line
                if (currentChar < line.length()) {
                    lyricLabel.setText(line.substring(0, currentChar + 1) + "_"); // Add cursor effect
                    currentChar++;
                }
                // Line is finished, pause before next line
                else {
                    try {
                        Thread.sleep(LINE_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentChar = 0;
                    currentLine++;
                    lyricLabel.setText(""); // Clear text for next line
                }
            }
        };

        // Run the task repeatedly
        timer.scheduleAtFixedRate(task, 0, CHAR_DELAY);
    }

    public static void main(String[] args) {
        new LyricPlayer();
    }
} // This is the closing bracket you were missing