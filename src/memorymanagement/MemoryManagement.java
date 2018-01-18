package memorymanagement;

/**
 * @author ianpierre
 */
public class MemoryManagement {

    
    public static void main(String[] args) {
        Helper helper = new Helper();
        int blockSize[] = {200, 500, 200, 500, 650};
        int processSize[] = {212, 417, 112, 426};
         int m = blockSize.length;
        int n = processSize.length;
        System.out.println("Tamanhos dos blocos antes da primeira alocação");
        System.out.println("Nº do bloco");
        for(int i = 0; i < m; i++) {
            System.out.println((i+1) + "\t\t" + blockSize[i]);
        }
        
       
        blockSize[0] -= 100;
        blockSize[3] -= 200;
        blockSize[4] -= 50;
       
        System.out.println("Tamanhos dos blocos após a alocação");
        System.out.println("Nº do bloco");
        for(int i = 0; i < m; i++) {
            System.out.println(i + "\t\t" + blockSize[i]);
        }
        helper.firstFit(blockSize, m, processSize, n);
        helper.bestFit(blockSize, m, processSize, n);
        helper.worstFit(blockSize, m, processSize, n);
        helper.nextFit(blockSize, m, processSize, n);   
    }
}
