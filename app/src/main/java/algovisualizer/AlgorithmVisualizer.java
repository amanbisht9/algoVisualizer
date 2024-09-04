package algovisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AlgorithmVisualizer{
    
    //Declaration of JComponenets and JContainers
    private JFrame jFrame;
    private JLabel delayLabel;
    private JPanel visualizationPanel;
    private JSlider stepDelaySlider;
    private JSlider sizeSlider;
    private JComboBox<String> algorithmSelector;
    private JLabel sizeLabelHeader;
    private JLabel algorithmLabel;
    private JPanel topPanel;
    private JLabel visJLabel;
    private JButton visualizeButton;

    // Array to store the heights of the bars
    private int[] array; // <-- Here is the array declaration

    public AlgorithmVisualizer() {

        //Creating a JFrame and setting title, layout, size and default closing window.
        AlgorithmVisualizerFrame algorithmVisualizerFrame = new AlgorithmVisualizerFrame(new JFrame());
        jFrame = algorithmVisualizerFrame.setInformationOfFrame();


        // Top Panel for controls
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 4));

        //Setting delayLabel ""Step Delay (1 sec)""  and stepDelay slider(on moving stepDelay slider updateTimeLabel() function will be called).
        delayLabel = new JLabel("Step Delay (1 sec)", SwingConstants.CENTER);
        stepDelaySlider = new JSlider(0, 60, 1); // Adjust as necessary
        delayLabel.setForeground(Color.RED);
 
        stepDelaySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTimeLabel();
            }
        });


        //Setting algorithm label "Select Algorithm" and drop down for selection of algorithm.
        algorithmLabel = new JLabel("Select Algorithm", SwingConstants.CENTER);
        algorithmSelector = new JComboBox<>(new String[]{"Linear Search", "Bubble Sort", "Selection Sort", "Merge Sort", "Insertion Sort"}); // Add more algorithms here


        //Setting size means number of values to be sorted and size slider to select the size(calls updateSizeLabel() function).
        sizeLabelHeader = new JLabel("Size (50)", SwingConstants.CENTER);
        sizeSlider = new JSlider(1, 100, 50); // Adjust size range as necessary
        sizeLabelHeader.setForeground(Color.RED);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSizeLabel();
            }
        });

        //Setting visualization panel "Click To Visualize" and visualize button(call startVisualization() button on clicking)
        visJLabel = new JLabel("Click To Visualize",SwingConstants.CENTER);
        visualizeButton = new JButton("Visualize");
        visualizeButton.setHorizontalAlignment(SwingConstants.LEFT);
        visualizeButton.addActionListener(e -> startVisualization());


        // Adding components to top panel of JFrame
        topPanel.add(delayLabel);
        topPanel.add(algorithmLabel);
        topPanel.add(sizeLabelHeader);
        topPanel.add(visJLabel);
        topPanel.add(stepDelaySlider);
        topPanel.add(algorithmSelector);
        topPanel.add(sizeSlider);
        topPanel.add(visualizeButton);

        //Adding top panel to NORTH side JFrame BorderLayout.
        jFrame.add(topPanel, BorderLayout.NORTH);

        // Panel for visualization
        visualizationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBars(g);
            }
        };
        visualizationPanel.setBackground(new Color(154, 138, 224));
        jFrame.add(visualizationPanel, BorderLayout.CENTER);

        jFrame.setVisible(true);
    }

    private void startVisualization() {
        // TODO Auto-generated method stub

        int size = (int) sizeSlider.getValue();
        array = new int[size]; // <-- Initialize the array

        // Generate random heights for the bars
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * visualizationPanel.getHeight());
        }

        // Choose the algorithm to visualize
        String algorithm = (String) algorithmSelector.getSelectedItem();
        if ("Bubble Sort".equals(algorithm)) {
            new Thread(() -> new BubbleSort().bubbleSort(array, visualizationPanel, size)).start();
        }
        
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
        if (array == null) return;

        int panelWidth = visualizationPanel.getWidth();
        int panelHeight = visualizationPanel.getHeight();
        int barWidth = panelWidth / array.length;

        // Random heights for bars (for now)
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i];
            g.setColor(new Color(255, 255, 233));
            g.fillRect(i * barWidth, panelHeight - barHeight, barWidth - 2, barHeight); // Leave 2px space between bars
        }
    }

}
