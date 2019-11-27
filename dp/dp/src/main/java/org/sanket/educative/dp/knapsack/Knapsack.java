package org.sanket.educative.dp.knapsack;

public abstract class Knapsack {

        private int _capacity;
        private Item[] _items;

        public Knapsack(int capacity, Item[] items){
            _capacity = capacity;
            _items = items;
        }

        public abstract int solve();

        @Override
        public String toString(){
            String[] items = new String[_items.length];
            int idx = 0;
            for (Item it : _items) {
                items[idx] = it.toString();
            }

            return String.format("Capacity: {0} \n Input: {1}", _capacity, String.join(",", items));
        }
    }