package algovisualizer;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class QuickSort {

    // Quick Sort algorithm with visualization
    public void quickSort(int[] array, JPanel visualizationPanel, int delay) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                quickSort(array, 0, array.length - 1, visualizationPanel, delay);
                return null;
            }

            private void quickSort(int[] array, int low, int high, JPanel visualizationPanel, int delay) {
                if (low < high) {
                    int pi = partition(array, low, high, visualizationPanel, delay);

                    quickSort(array, low, pi - 1, visualizationPanel, delay);
                    quickSort(array, pi + 1, high, visualizationPanel, delay);
                }
            }

            private int partition(int[] array, int low, int high, JPanel visualizationPanel, int delay) {
                int pivot = array[high];
                int i = (low - 1);
                for (int j = low; j < high; j++) {
                    if (array[j] <= pivot) {
                        i++;

                        // Swap array[i] and array[j]
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        
                        visualizationPanel.repaint();
                        try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                    }
                }

                // Swap array[i + 1] and array[high] (or pivot)
                int temp = array[i + 1];
                array[i + 1] = array[high];
                array[high] = temp;

                visualizationPanel.repaint();
                try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }

                return i + 1;
            }
        }.execute();
    }
    
}
