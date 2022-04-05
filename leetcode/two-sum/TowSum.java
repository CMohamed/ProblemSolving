import java.util.*;

class TowSum {

    public static void main(String[] args) {

    }

    static class ValueIndex<T extends Comparable<T>> implements Comparable<ValueIndex<T>> {
        ValueIndex(T value, int index) {
            this.value = value;
            this.index = index;
        }

        public T value;
        public int index;

        public T getT() {
            return value;
        }

        public int getIndex() {
            return index;
        }


        @Override
        public int compareTo(ValueIndex<T> o) {
            return getT().compareTo(o.getT());
        }

        @Override
        public String toString() {
            return "ValueIndex{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[0];
        AtomicInteger counter = new AtomicInteger();
        List<ValueIndex<Integer>> list = Arrays.stream(nums)
                .mapToObj(num -> new ValueIndex<>(num, counter.getAndIncrement()))
                .sorted(Comparator.comparingInt(a -> a.value)).collect(Collectors.toList());
        List<ValueIndex<Integer>> finalList = list.stream()
                .filter(valueIndex -> valueIndex.value <= target - list.get(0).value).collect(Collectors.toList());
        int j;
        for (int i = 0; i < finalList.size(); i++) {
            j = Arrays.binarySearch(finalList.toArray(),
                    new ValueIndex<>(9 - finalList.get(i).value, 2));
            if (j > 0 && j < finalList.size()) {
                return new int[]{finalList.get(i).index, finalList.get(j).index};
            }
        }
        return res;
    }
}
