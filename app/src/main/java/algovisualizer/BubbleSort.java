package algovisualizer;

import javax.swing.JPanel;

public class BubbleSort {

    // Bubble Sort algorithm with visualization
    public void bubbleSort(int[] array, JPanel visualizationPanel, int delay) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // Redraw the panel after every swap
                    visualizationPanel.repaint();

                    // Add delay for visualization
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    
}
