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
        System.out.println(String.format("Max Profit: %s", out));

        k = new BruteForceKnapsack(6, items);
        System.out.println(k.toString());
        out = k.solve();
        System.out.println(String.format("Max Profit: %s", out));
    }

    class BruteForceKnapsack extends Knapsack{

        public BruteForceKnapsack(int capacity, Item[] items) {
            super(capacity, items);
        }

        @Override
        public int solve() {
            return solve(getCapacity(), 0);
        }

        private int solve(int capacity, int currentIdx){
            Item[] items = getItems();
            if(capacity <= 0 || currentIdx >= items.length)
                return 0;
            int profit1 = 0;
            profit1 = items[currentIdx].profit + solve(capacity - items[currentIdx].weight, currentIdx + 1);
            int profit2 = solve(capacity, currentIdx + 1);
            return Math.max(profit1, profit2);
        }
    }
}