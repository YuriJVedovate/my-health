package com.example.myhealth.objetos;

public class FilaObj<T> {

    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        tamanho = 0;
        fila = (T[]) new Object[capacidade];
    }

    // Método isEmpty() - retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Método isFull() - retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho == fila.length;
    }

    // Método insert - recebe uma info para ser inserida na fila
    public void insert(T info) {
        if (isFull()) {                            // Se fila está cheia
            System.out.println("Fila cheia");    // exibe mensagem
        } else {
            fila[tamanho++] = info;
        }
    }

    // Método peek - retorna o primeiro da fila, sem removê-lo
    public T peek() {
        return fila[0];
    }

    // Método poll - retorna o primeiro da fila, removendo-o da fila
    public T poll() {
        T primeiro = peek();     // Salva o primeiro da fila numa variável

        if (!isEmpty()) {   // Se a fila não estiver vazia
            // Faz a "fila andar", deslocando todos os elementos para a esquerda
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            // "Anula" o último elemento da fila
            fila[tamanho - 1] = null;
            // Decrementa tamanho
            tamanho--;
        }
        return primeiro;
    }

    // Exibe os elementos da fila
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }
    public int getTamanho(){
        return fila.length;
    }

}