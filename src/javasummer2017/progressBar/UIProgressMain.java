package javasummer2017.progressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class UIProgressMain {
    public static final int DELTA = 3;

    private JProgressBar _jProgressBar;
    private Thread _backgroundThread;

    public UIProgressMain() {
        JFrame jFrame = new JFrame("Progress Bars");
        jFrame.setSize(400, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        _jProgressBar = new JProgressBar();
        jFrame.add(_jProgressBar, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton onButton = new JButton("Вкл.");
        onButton.addActionListener(e -> doTheJob());

        JButton offButton = new JButton("Выкл.");
        offButton.addActionListener(e -> {
            if (_backgroundThread != null) {
                _backgroundThread.interrupt();
            }
        });
        buttonPanel.add(onButton);
        buttonPanel.add(offButton);

        jFrame.add(buttonPanel, BorderLayout.SOUTH);

        jFrame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jFrame.setTitle(e.getX() + " " + e.getY());
            }
        });

        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new UIProgressMain());
    }


    private void doTheJob() {
        _backgroundThread = new Thread(() -> {
            while (true) {
                int currentPosition = _jProgressBar.getValue();
                if (currentPosition >= _jProgressBar.getMaximum()) {
                    currentPosition = 0;
                }
                _jProgressBar.setValue(currentPosition + DELTA);
                try {
                    Thread.sleep(100);

                } catch (InterruptedException ignored) {
                    break;
                }
            }
        });
        _backgroundThread.setName("Progress bar thread");
        _backgroundThread.start();
    }
}
