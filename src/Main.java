import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] vetor = {"Johnny", "Ariella", "Lilah", "Mia", "Dani", "Elsa", "Vinicius"};
        String busca = "Vinicius";

        // Ordenação do vetor
        mergeSort(vetor, 0, vetor.length - 1);
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));

        // Busca binária
        int resultado = buscaBinaria(vetor, busca);
        if (resultado == -1) {
            System.out.println("A string '" + busca + "' não foi encontrada.");
        } else {
            System.out.println("A string '" + busca + "' foi encontrada na posição " + resultado);
        }
    }

    public static void mergeSort(String[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    public static void merge(String[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] vetorEsquerda = new String[n1];
        String[] vetorDireita = new String[n2];

        for (int i = 0; i < n1; ++i) {
            vetorEsquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < n2; ++j) {
            vetorDireita[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (vetorEsquerda[i].compareTo(vetorDireita[j]) <= 0) {
                vetor[k] = vetorEsquerda[i];
                i++;
            } else {
                vetor[k] = vetorDireita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = vetorEsquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = vetorDireita[j];
            j++;
            k++;
        }
    }

    public static int buscaBinaria(String[] vetor, String busca) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int resultado = busca.compareTo(vetor[meio]);

            if (resultado == 0) {
                return meio; // Elemento encontrado
            } else if (resultado < 0) {
                fim = meio - 1; // Busca na metade esquerda
            } else {
                inicio = meio + 1; // Busca na metade direita
            }
        }

        return -1; // Elemento não encontrado
    }
}
