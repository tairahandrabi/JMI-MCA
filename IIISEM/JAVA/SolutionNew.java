import java.util.*;
import java.io.*;

class KMERS
{
    private List<String> kmers = new ArrayList<>();//creating arraylist of string type
    private List<Integer> frequency = new ArrayList<>();//cresting arraylist of integertype

    public void permutations(String str, String prefix, int k) //no of permutations
    {         
        if (k == 0)
        { 
            if( !(kmers.contains(prefix)) )
                kmers.add(prefix);

            return; 
        } 
        for (int i = 0; i < str.length(); i++)
          permutations(str, prefix + str.charAt(i), k - 1);
    }

    public void setFrequency(String DNA, int k)//count 
    {
        int count;
        String kmr;

        for(int i = 0 ; i < kmers.size() ; i++)
        {
            count = 0;
            kmr = kmers.get(i);

            for(int j = 0 ; j < DNA.length() - kmr.length() + 1 ; j++) // count occurence of kmer in DNA
                if(kmr.equals(DNA.substring(j, j + kmr.length())) )
                    count++;

            frequency.add(count);
        }
    }
    public void get()
    {
        System.out.println();
        for(int i = 0 ; i < kmers.size() ; i++)
            System.out.print(kmers.get(i) + " ");//to print kmers
        
        System.out.println();
        for(int i = 0 ; i < frequency.size() ; i++)
            System.out.print(frequency.get(i) + " ");//to print count           
    }
}
public class SolutionNew
{
    public static void main(String []args)
    {
        int k;
        String DNA;    
        Scanner scan = new Scanner(System.in);
        KMERS obj = new KMERS();

        System.out.print("Enter DNA : ");
        DNA = scan.nextLine();
        System.out.print("Enter value of k : ");
        k = scan.nextInt();

        obj.permutations(DNA, "", k);
        obj.setFrequency(DNA, k);
        obj.get();
    }
}