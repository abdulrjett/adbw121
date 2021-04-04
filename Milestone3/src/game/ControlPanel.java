package game;
import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton restartButton;
    private JButton quitButton;
    private JButton unpauseButton;
    private JButton level1Button;
    private JButton level2Button;
    private JButton level3Button;
    private JButton level4Button;
    private JButton stopMusicButton;
    private JButton playMusicButton;
    private Game game;

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public ControlPanel(Game g) {
        this.game = g;

        pauseButton.addActionListener(e -> game.pause());
        unpauseButton.addActionListener(e -> game.unpause());

        stopMusicButton.addActionListener(e -> game.getLevel().gameMusic.pause());
        playMusicButton.addActionListener(e -> game.getLevel().gameMusic.play());

        quitButton.addActionListener(e -> System.exit(0));
        restartButton.addActionListener(e -> game.restartLevel());

        level1Button.addActionListener(e -> game.setLevel(1));
        level2Button.addActionListener(e -> game.setLevel(2));
        level3Button.addActionListener(e -> game.setLevel(3));
        level3Button.addActionListener(e -> game.setLevel(4));

        mainPanel.addComponentListener(new ComponentAdapter() {
        });
    }

}
