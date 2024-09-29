package algovisualizer;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class MergeSort {

     // Merge Sort algorithm with visualization
    public void mergeSort(int[] array, JPanel visualizationPanel, int delay) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                sort(array, 0, array.length - 1, visualizationPanel, delay);
                return null;
            }

            private void sort(int[] array, int left, int right, JPanel visualizationPanel, int delay) {
                if (left < right) {
                    int mid = (left + right) / 2;
                    sort(array, left, mid, visualizationPanel, delay);
                    sort(array, mid + 1, right, visualizationPanel, delay);
                    merge(array, left, mid, right, visualizationPanel, delay);
                }
            }

            private void merge(int[] array, int left, int mid, int right, JPanel visualizationPanel, int delay) {
                int n1 = mid - left + 1;
                int n2 = right - mid;

                int[] leftArray = new int[n1];
                int[] rightArray = new int[n2];

                for (int i = 0; i < n1; i++)
                    leftArray[i] = array[left + i];
                for (int j = 0; j < n2; j++)
                    rightArray[j] = array[mid + 1 + j];

                int i = 0, j = 0;
                int k = left;
                while (i < n1 && j < n2) {
                    if (leftArray[i] <= rightArray[j]) {
                        array[k] = leftArray[i];
                        i++;
                    } else {
                        array[k] = rightArray[j];
                        j++;
                    }
                    k++;
                    visualizationPanel.repaint();
                    try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                }

                while (i < n1) {
                    array[k] = leftArray[i];
                    i++;
                    k++;
                    visualizationPanel.repaint();
                    try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                }

                while (j < n2) {
                    array[k] = rightArray[j];
                    j++;
                    k++;
                    visualizationPanel.repaint();
                    try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }.execute();
    }
    
}
