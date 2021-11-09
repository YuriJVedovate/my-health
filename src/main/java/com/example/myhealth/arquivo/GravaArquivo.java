package com.example.myhealth.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravaArquivo {

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException var5) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", var5.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException var4) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", var4.getMessage());
        }

    }

}