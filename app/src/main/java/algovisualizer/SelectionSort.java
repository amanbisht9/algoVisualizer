package algovisualizer;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class SelectionSort {
    // Selection Sort algorithm with visualization
    public void selectionSort(int[] array, JPanel visualizationPanel, int delay) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                int n = array.length;
                for (int i = 0; i < n - 1; i++) {
                    int minIdx = i;
                    
                    // Find the minimum element in unsorted array
                    for (int j = i + 1; j < n; j++) {
                        if (array[j] < array[minIdx]) {
                            minIdx = j;
                        }
                    }

                    // Swap the found minimum element with the first element
                    int temp = array[minIdx];
                    array[minIdx] = array[i];
                    array[i] = temp;

                    // Redraw the panel after every swap
                    visualizationPanel.repaint();

                    // Add delay for visualization
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

        }.execute();  // Run in background to avoid blocking the UI
    }
    
}
