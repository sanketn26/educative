package org.sanket.educative.dp.knapsack;

public abstract class Knapsack {

        private int _capacity;
        private Item[] _items;

        public Knapsack(int capacity, Item[] items){
            _capacity = capacity;
            _items = items;
        }

        public int getCapacity(){
            return _capacity;
        }

        public Item[] getItems(){
            return _items;
        }

        public abstract int solve();

        @Override
        public String toString(){
            String[] items = new String[_items.length];
            int idx = 0;
            for (Item it : _items) {
                items[idx] = it.toString();
                idx+=1;
            }
            return String.format("Capacity: %d \n Input: %s", _capacity, String.join(",", items));
        }
    }