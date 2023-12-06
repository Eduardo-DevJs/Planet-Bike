/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planetbike.validadoremail;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dudu
 */
public class ValidadorEmail {
    // Método para validar o formato do e-mail
    public static boolean validarEmail(String email) {
        // Definir a expressão regular para validar o e-mail
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";

        // Compilar a expressão regular
        Pattern pattern = Pattern.compile(regex);

        // Criar um objeto Matcher com o e-mail fornecido
        Matcher matcher = pattern.matcher(email);

        // Verificar se o e-mail corresponde à expressão regular
        return matcher.matches();
    }
}