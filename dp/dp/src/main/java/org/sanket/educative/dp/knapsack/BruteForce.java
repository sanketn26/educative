package org.sanket.educative.dp.knapsack;

import org.sanket.educative.dp.common.*;

public class BruteForce implements Algorithm{

    @Override
    public String getName() {
        return "BruteForceKnapsack";
    }

    @Override
    public void execute() {
        Item[] items = new Item[]{new Item(1,1), new Item(6,2), new Item(10,3),new Item(16,5)};
        Knapsack k = new BruteForceKnapsack(7, items);
        System.out.println(k.toString());
        int out = k.solve();
        System.out.println(String.format("Max Profit: {0}", out));

        k = new BruteForceKnapsack(6, items);
        System.out.println(k.toString());
        out = k.solve();
        System.out.println(String.format("Max Profit: {0}", out));
    }

    class BruteForceKnapsack extends Knapsack{

        public BruteForceKnapsack(int capacity, Item[] items) {
            super(capacity, items);
        }

        @Override
        public int solve() {
            if(getCapacity() <= 0)
                return 0;
            return solve(0);
        }

        private int solve(int currentIdx){
            Item[] items = getItems();
            if(currentIdx >= items.length)
                return 0;

            int profit1 = 0;
            
            int profit2 = solve(currentIdx + 1);
            return Math.max(profit1, profit2);
        }
    }

}