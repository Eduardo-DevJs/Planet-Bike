/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.validarcpf;

public class ValidadorCPF {

    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais (caso contrário, é considerado inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular e verificar os dígitos verificadores
        try {
            int[] numeros = new int[11];
            for (int i = 0; i < 11; i++) {
                numeros[i] = Integer.parseInt(cpf.substring(i, i + 1));
            }

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += numeros[i] * (10 - i);
            }

            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : (11 - resto);

            if (numeros[9] != digito1) {
                return false;
            }

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += numeros[i] * (11 - i);
            }

            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : (11 - resto);

            return numeros[10] == digito2;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}