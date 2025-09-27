public class Algorithm {
    public static void main(String[] args) {
        // Array of different n values to test
        int[] nValues = {5,10, 50, 250, 500, 1000, 2500};

        // Warm-up phase to eliminate JVM startup overhead
        System.out.println("Warming up JVM...");
        for (int warmup = 0; warmup < 5; warmup++) {
            runAlgorithm(10); // Run a few warm-up iterations
        }
        System.out.println("Warm-up complete.\n");
        
        System.out.println("Algorithm Performance Analysis");
        System.out.println("==============================");
        System.out.printf("%-10s %-20s %-15s%n", "n", "Time (ns)", "Time (ms)");
        System.out.println("------------------------------------------");
        
        // Run algorithm for each n value
        for (int n : nValues) {
            long executionTime = runAlgorithm(n);
            double executionTimeMillis = executionTime / 1_000_000.0;
            
            System.out.printf("%-10d %-20d %-15.3f%n", 
                n, executionTime, executionTimeMillis);
        }
        
        System.out.println("\nNote: JVM warm-up eliminates first-run penalty caused by JIT compilation.");
    }
    
    // Method to initialize arrays 
    public static int[][] initializeArrays(int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        
        // Fill arrays with sample data
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
            b[i] = (i + 1) * 2;
        }
        
        return new int[][]{a, b};
    }
    
    // Method to run the algorithm and measure execution time
    public static long runAlgorithm(int n) {
        // Initialize arrays 
        int[][] arrays = initializeArrays(n);
        int[] a = arrays[0];
        int[] b = arrays[1];
        
        int Sum = 0;
        int j = 2; // Original algorithm starts with j = 2
        
        // Record start time
        long startTime = System.nanoTime();
        
        // Original algorithm logic 
        while (j < n) {
            int k = j;
            
            while (k < n) {
                Sum += a[k] * b[k];
                k = k * k; 
            }   
            j += (int) Math.log(k);
        }
        
        // Record end time
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }

}
