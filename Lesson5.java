import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Кристина Белова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Светлова");
        employees.add("Мария Савина");
        employees.add("Мария Рыкова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Петр Петин");
        employees.add("Иван Ежов");

        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String employee : employees) {
            nameCountMap.put(employee, nameCountMap.getOrDefault(employee, 0) + 1);
        }

        nameCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;
      
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

          
        heapify(array, n, largest);
    }
}

public static void main(String[] args) {
    int[] array = {5, 3, 8, 4, 2, 1, 6, 9, 7};
    System.out.println("Original array: ");
    printArray(array);

    sort(array);

    System.out.println("Sorted array: ");
    printArray(array);
}

private static void printArray(int[] array) {
    for (int value : array) {
        System.out.print(value + " ");
    }
    System.out.println();
}
public class QueensProblem {
    private static final int BOARD_SIZE = 8;
    private static final char QUEEN_SYMBOL = 'Q';
    private static final char EMPTY_SYMBOL = '-';

    private static char[][] board;

    public static void main(String[] args) {
        board = new char[BOARD_SIZE][BOARD_SIZE];

        initializeBoard();

        if (solveQueensProblem(0)) {
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveQueensProblem(int column) {
        if (column >= BOARD_SIZE) {
            return true;
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafe(row, column)) {
                placeQueen(row, column);

                if (solveQueensProblem(column + 1)) {
                    return true;
                }

                removeQueen(row, column);
            }
        }

        return false;
    }

    private static boolean isSafe(int row, int column) {
        // Check if no queen exists in the same row
        for (int c = 0; c < column; c++) {
            if (board[row][c] == QUEEN_SYMBOL) {
                return false;
            }
        }

        for (int r = row, c = column; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == QUEEN_SYMBOL) {
                return false;
            }
        }

        for (int r = row, c = column; r < BOARD_SIZE && c >= 0; r++, c--) {
            if (board[r][c] == QUEEN_SYMBOL) {
                return false;
            }
        }

        return true; 
    }

    private static void placeQueen(int row, int column) {
        board[row][column] = QUEEN_SYMBOL;
    }

    private static void removeQueen(int row, int column) {
        board[row][column] = EMPTY_SYMBOL;
    }

    private static void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = EMPTY_SYMBOL;
            }
        }
    }

    private static void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    System.out.println();
    }
}
}
