package com.example.myhealth.objetos;

public class PilhaObj<T> {
    private int topo;
    private T[] pilha;

    public PilhaObj(int capacidade) {
        topo = -1;
        pilha = (T[]) new Object[capacidade];
    }

    /* Método isEmpty() - devolve true se a pilha está vazia
     * e false caso contrário
     */
    public boolean isEmpty() {
        return topo == -1;
    }

    /* Método isFull() - devolve true se a pilha está cheia
     * e false caso contrário
     */
    public boolean isFull() {
        return topo == pilha.length - 1;
    }


    /* Método push - Recebe a info a ser empilhada
     * Se a pilha não estiver cheia, incrementa topo, e coloca
     * info em pilha[topo]
     */
    public void push(T info) {
        if (!isFull()) {
            pilha[++topo] = info;
        } else {
            System.out.println("Pilha cheia");
        }
    }

    /* Método pop - se a pilha não estiver vazia, desempilha
     * e retorna o elemento do topo da pilha.
     * Se a pilha estiver vazia, retorna -1
     */
    public T pop() {
        if (!isEmpty()) {
            return pilha[topo--];
        }
        return null;
    }

    /* Método peek - Retorna o elemento do topo da pilha */
    public T peek() {
        if (!isEmpty()) {
            return pilha[topo];
        }
        return null;
    }

    /* Método exibe - Exibe os elementos da pilha */
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = 0; i <= topo; i++) {
                System.out.println(pilha[i]);
            }
        }
    }

    public int getTamanho(){
        return pilha.length;
    }

}
