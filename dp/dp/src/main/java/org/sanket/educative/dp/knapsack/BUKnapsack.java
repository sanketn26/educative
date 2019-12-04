package org.sanket.educative.dp.knapsack;

import org.sanket.educative.dp.common.*;

public class BUKnapsack implements Algorithm{

    @Override
    public String getName() {
        return "BasicBUKnapsack";
    }

    @Override
    public void execute() {
        Item[] items = new Item[]{new Item(1,1), new Item(6,2), new Item(10,3),new Item(16,5)};
        Knapsack k = new BasicBUKnapsack(7, items);
        System.out.println(k.toString());
        int out = k.solve();
        System.out.println(String.format("Max Profit: %s", out));

        k = new BasicBUKnapsack(6, items);
        System.out.println(k.toString());
        out = k.solve();
        System.out.println(String.format("Max Profit: %s", out));
    }

    class BasicBUKnapsack extends Knapsack{

        private int[][] _memoizedProfits;

        public BasicBUKnapsack(int capacity, Item[] items) {
            super(capacity, items);
            _memoizedProfits = new int[items.length][capacity + 1];
        }

        @Override
        public int solve() {
            if(getCapacity() <= 0 || getItems().length == 0){
                return 0;
            }
            Item[] items = getItems();
            // handle capacity 0 
            for(int i = 0; i < items.length; i++){
                _memoizedProfits[i][0] = 0;
            }
            
            for(int i = 0; i < items.length; i++){
                for(int c = 0; c < getCapacity() + 1; c++){
                    if(i == 0){
                        if(items[i].weight <= c){
                            _memoizedProfits[i][c] = items[i].profit;
                        }
                    }
                    else{
                        int profit1 = 0, profit2 = 0;
                        if(items[i].weight <= c)
                            profit1 = items[i].profit + _memoizedProfits[i-1][c - items[i].weight];
                        profit2 = _memoizedProfits[i - 1][c];
                        _memoizedProfits[i][c] = Math.max(profit1, profit2);
                    }
                }
            }
            return _memoizedProfits[getItems().length - 1][getCapacity()];
        }

    }
}