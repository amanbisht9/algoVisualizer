package main.java.algovisualizer;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AlgorithmVisualizer extends JFrame {

    private JLabel delayLabel;
    private JPanel visualizationPanel;
    private JSlider stepDelaySlider;
    private JSlider sizeSlider;
    private JComboBox<String> algorithmSelector;
    private JLabel sizeLabelHeader;

    public AlgorithmVisualizer() {
        setTitle("Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());

        // Top Panel for controls
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 4));

        delayLabel = new JLabel("Step Delay (1 sec)", SwingConstants.CENTER);
        stepDelaySlider = new JSlider(0, 60, 1); // Adjust as necessary
        delayLabel.setForeground(Color.RED);
 
        stepDelaySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTimeLabel();
            }
        });

        JLabel algorithmLabel = new JLabel("Select Algorithm", SwingConstants.CENTER);
        algorithmSelector = new JComboBox<>(new String[]{"Linear Search", "Bubble Sort", "Selection Sort", "Merge Sort", "Insertion Sort"}); // Add more algorithms here


        sizeLabelHeader = new JLabel("Size (1)", SwingConstants.CENTER);
        sizeSlider = new JSlider(1, 100, 1); // Adjust size range as necessary
        sizeLabelHeader.setForeground(Color.RED);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSizeLabel();
            }
        });

        JLabel visJLabel = new JLabel("Click To Visualize",SwingConstants.CENTER);
        JButton visualizeButton = new JButton("Visualize");
        visualizeButton.setHorizontalAlignment(SwingConstants.LEFT);

        // Adding components to top panel
    
        topPanel.add(delayLabel);
        topPanel.add(algorithmLabel);
        topPanel.add(sizeLabelHeader);
        topPanel.add(visJLabel);
        topPanel.add(stepDelaySlider);
        topPanel.add(algorithmSelector);
        topPanel.add(sizeSlider);
        topPanel.add(visualizeButton);

        add(topPanel, BorderLayout.NORTH);

        // Panel for visualization
        visualizationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBars(g);
            }
        };
        visualizationPanel.setBackground(new Color(154, 138, 224));
        add(visualizationPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateTimeLabel() {
        double delay = stepDelaySlider.getValue();
        delayLabel.setText(String.format("Step Delay (%.0f sec)", delay));
        delayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        delayLabel.setForeground(Color.RED);
    }

    private void updateSizeLabel() {
        double size = sizeSlider.getValue();
        sizeLabelHeader.setText(String.format("Size (%.0f)", size));
        sizeLabelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        sizeLabelHeader.setForeground(Color.RED);
    }

    private void drawBars(Graphics g) {
        int panelWidth = visualizationPanel.getWidth();
        int panelHeight = visualizationPanel.getHeight();
        int barCount = sizeSlider.getValue();
        int barWidth = panelWidth / barCount;

        // Random heights for bars (for now)
        for (int i = 0; i < barCount; i++) {
            int barHeight = (int) (Math.random() * panelHeight);
            g.setColor(new Color(255, 255, 255));
            g.fillRect(i * barWidth, panelHeight - barHeight, barWidth - 2, barHeight); // Leave 2px space between bars
        }
    }

}
