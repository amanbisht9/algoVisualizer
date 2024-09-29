# Sorting Algorithm Visualizer
Algorithm Visualizer is a Java-based application that allows you to visualize popular sorting algorithms in real-time. The application provides an interactive GUI where users can adjust the number of elements, control the speed of the visualization, and choose from various sorting algorithms to see how they work.

## Features

- **Sorting Algorithms**: Visualize multiple sorting algorithms, including:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort

- **Interactive Sliders**: 
  - Control the size of the array being sorted.
  - Adjust the delay between sorting steps to control visualization speed.

- **Responsive GUI**: The application uses `SwingWorker` to ensure smooth and responsive animations while visualizing the algorithms.

## Technologies Used

- **Java**: The core programming language used for the application logic and GUI components.
- **Swing**: A GUI toolkit for Java used to create the application's interface.
- **SwingWorker**: Used to perform long-running sorting tasks without freezing the GUI.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/amanbisht9/algoVisualizer.git
   cd algoVisualizer
   ```

2. **Run Application**:
   ```bash
   ./gradlew run
   ```