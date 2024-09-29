package algovisualizer;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class InsertionSort {

    // Insertion Sort algorithm with visualization
    public void insertionSort(int[] array, JPanel visualizationPanel, int delay) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                int n = array.length;
                for (int i = 1; i < n; i++) {
                    int key = array[i];
                    int j = i - 1;

                    while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j--;
                        visualizationPanel.repaint();
                        try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                    }
                    array[j + 1] = key;
                    visualizationPanel.repaint();
                    try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                }
                return null;
            }
        }.execute();
    }
    
}
