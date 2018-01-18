package memorymanagement;

import java.util.Arrays;

/**
 *
 * @author ianpierre
 */
public class Helper {
  
    public void worstFit(int blockSizeCopy[], int m, int processSizeCopy[], int n) {
       
        int[] blockSize = Arrays.copyOf(blockSizeCopy, m);
        int[] processSize = Arrays.copyOf(processSizeCopy, m);
        int allocation[] = new int[n];
      
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
        for (int i=0; i<n; i++)
        {
            int wstIdx = -1;
            for (int j=0; j<m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    if (wstIdx == -1)
                        wstIdx = j;
                    else if (blockSize[wstIdx] < blockSize[j])
                        wstIdx = j;
                }
            }
      
            if (wstIdx != -1)
            {
                allocation[i] = wstIdx;
      
                blockSize[wstIdx] -= processSize[i];
            }
        }
      
        outputMessage(allocation, processSize, blockSize, "Worst Fit", n);
    }
    
    public void nextFit(int blockSizeCopy[], int m, int processSizeCopy[], int n) {

        int[] blockSize = Arrays.copyOf(blockSizeCopy, m);
        int[] processSize = Arrays.copyOf(processSizeCopy, m);
        int allocation[] = new int[n];
        int process_position = 0;
      
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
        for (int i=0; i<n; i++) {
            for (int j= process_position; j<m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
      
                    blockSize[j] -= processSize[i];
                    process_position = j+1;
                    break;
                }
            }
        }
      
        outputMessage(allocation, processSize, blockSize, "Next Fit", n);
    }
        
    public void firstFit(int blockSizeCopy[], int m, int processSizeCopy[], int n) {
        
        int[] blockSize = Arrays.copyOf(blockSizeCopy, m);
        int[] processSize = Arrays.copyOf(processSizeCopy, m);
        int allocation[] = new int[n];
      
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    allocation[i] = j;
      
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }
      
        outputMessage(allocation, processSize, blockSize, "First Fit", n);
    }
    
    public void bestFit(int blockSizeCopy[], int m, int processSizeCopy[], int n) {

        int[] blockSize = Arrays.copyOf(blockSizeCopy, m);
        int[] processSize = Arrays.copyOf(processSizeCopy, m);
        int allocation[] = new int[n];

        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
        for (int i=0; i<n; i++)
        {
            int bestIdx = -1;
            for (int j=0; j<m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }
      
            if (bestIdx != -1)
            {
                allocation[i] = bestIdx;
      
                blockSize[bestIdx] -= processSize[i];
            }
        }
      
        outputMessage(allocation, processSize, blockSize, "Best Fit", n);
        
    }
    
    private void outputMessage(int allocation[], int processSize[], int blockSize[], String algorithm_name,int n) {
       System.out.println("\n "+algorithm_name);
        System.out.println("\nNº do processo\tTamanho do processo\tNº do bloco");
        for (int i = 0; i < n; i++)
        {
            System.out.print("   " + (i+1) + "\t\t\t" + processSize[i] + "\t");
            if (allocation[i] != -1)
                System.out.print("\t\t"+(allocation[i] + 1) +"\t\t");
            else
                System.out.print("\t"+"Não alocado"+"\t\t");
            
            System.out.println();
        } 
    }
}
