public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(100);
        //arr.fillFromKeyboard();
        arr.fillRandomInt(1, 1000);
        arr.print();
        int arrMin = arr.getMin();
        int arrMax = arr.getMax();
        double average = arr.avg();
        System.out.println("Min: " + arrMin + " Max: " + arrMax + " Average: " + average);

        arr.sortAscending();
        arr.print();

        arr.sortDescending();
        arr.print();

        System.out.println(arr.searchElement(3));

        arr.replaceElement(3, 500);
        arr.print();
    }
}