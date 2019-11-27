package org.sanket.educative.dp.knapsack;

public class Item{

        public Item(int profit, int weight){
            this.profit = profit;
            this.weight = weight;
        }

        public int profit;
        public int weight;

        @Override
        public String toString(){
            return String.format("{0} : {1}", profit, weight );
        }
    }