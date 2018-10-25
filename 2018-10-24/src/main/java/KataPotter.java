import java.util.*;

public class KataPotter {

    private final List<Integer> books;
//    private final int[] bookCounts = new int[] {1, 0, 3, 0, 1};

    public KataPotter(int... books) {
        this.books = new ArrayList<>();
        for (int book : books) {
            this.books.add(book);
        }
    }

    public double price() {
        for (int i = books.size(); i > 0 ; i--) {
            if (areNBooksDifferent(i))
                return i * 8 * getDiscount(i) + (books.size() - i) * 8.0;
        }
        return 0.0;
    }

    private double getDiscount(int i) {
        switch (i){
            case 2:
                return 0.95;
            case 3:
                return 0.90;
            case 4:
                return 0.80;
            case 5:
                return 0.75;
        }
        return 1.0;
    }

    private boolean areNBooksDifferent(int n){
        Set<Integer> different = new HashSet<>();
        for (int book : books) {
            different.add(book);
        }
        return different.size() >= n;
    }

    private double minimalPriceOf(List<Integer> remainingBooks){
        if (remainingBooks.isEmpty()) {
            return 0.0;
        }

        Set<Integer> unique = uniqueBooks(remainingBooks);
        Collection<Set<Integer>> possibleDiscountedSets = possibleDiscountedSets(unique);

        double currentMin = -1.0;
        for (Set<Integer> discountedSet : possibleDiscountedSets) {
            double discountedSetPrice = discountedSetPrice(discountedSet.size());
            List<Integer> remainingBooksMinusDiscountedSet = remainingBooksMinusDiscountedSet(remainingBooks, discountedSet);
            double price = discountedSetPrice + minimalPriceOf(remainingBooksMinusDiscountedSet);
            if (currentMin == -1.0 || price < currentMin) {
                currentMin = price;
            }
        }

        return currentMin;
    }

    private double discountedSetPrice(int size) {
        return 8 * getDiscount(size) * size;
     }

    private Collection<Set<Integer>> possibleDiscountedSets(Set<Integer> books) {
        Collection<Set<Integer>> collector = new ArrayList<>();
        addCombination(collector, Collections.EMPTY_SET, books);
        return collector;
    }

    private void addCombination(Collection<Set<Integer>> collector, Set<Integer> partialCombination, Set<Integer> remainingElements) {
        if(remainingElements.isEmpty()) collector.add(partialCombination);
        else {
            Set<Integer> combination0 = partialCombination;
            Integer firstRemaining = remainingElements.iterator().next();
            remainingElements.remove(firstRemaining);

            Set<Integer> combination1 = new HashSet<>(partialCombination);
            combination1.add(firstRemaining);

            addCombination(collector, combination0, remainingElements);
            addCombination(collector, combination1, remainingElements);
        }

    }

    private Set<Integer> uniqueBooks(List<Integer> books){
        Set<Integer> unique = new HashSet<>();
        for (int book : books) {
            unique.add(book);
        }
        return unique;
    }
}


