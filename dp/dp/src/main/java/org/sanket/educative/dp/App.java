package org.sanket.educative.dp;

import java.util.Scanner;
import org.sanket.educative.dp.common.AlgorithmContainer;
import org.sanket.educative.dp.knapsack.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlgorithmContainer container = new AlgorithmContainer();
        
        container.registerAlgorithm(new BruteForce());
        container.registerAlgorithm(new TopDownMemoizationKnapsack());
        container.registerAlgorithm(new BUKnapsack());

        System.out.println("Algorithms available:");
        for (String algoName : container.getAlgoNames()) {
            System.out.println(algoName);
        }
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Please enter the algorithm name:");
            String algoName = in.nextLine();
            System.out.println("Executing: " + algoName);
            container.getAlgorithm(algoName).execute();
        }
    }
}
