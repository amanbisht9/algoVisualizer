package algovisualizer;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AlgorithmVisualizerFrame {

    private JFrame jFrame;

    public AlgorithmVisualizerFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JFrame setInformationOfFrame(){
        jFrame.setTitle("Algorithm Visualizer");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1200, 800);
        jFrame.setLayout(new BorderLayout());

        return jFrame;
    }
}
