import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<Integer> numbers;

    public Main() {
        numbers = new ArrayList<>();
    }

    public void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("No se pudo transformar la línea a número: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public double calculateAverage() {
        if (numbers.isEmpty()) return 0;

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public Integer findMax() {
        if (numbers.isEmpty()) return null;
        return numbers.stream().max(Integer::compareTo).orElse(null);
    }

    public Integer findMin() {
        if (numbers.isEmpty()) return null;
        return numbers.stream().min(Integer::compareTo).orElse(null);
    }

    public static void main(String[] args) {
        Main processor = new Main();

        String filePath = "D://CAPACITACIONES//FUNDAMENTOS DE PROGRAMACION//TALLERES//CLASE_FILE//test.txt//";

        processor.readFile(filePath);

        System.out.println("Promedio: " + processor.calculateAverage());
        System.out.println("Número mayor: " + processor.findMax());
        System.out.println("Número menor: " + processor.findMin());
    }
}