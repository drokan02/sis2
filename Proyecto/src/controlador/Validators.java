/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Mauricio Rojas
 */
public class Validators {

    private static final String PATTERN_LETTERS = "[a-zA-Z]*";
    private static final String PATTERN_NUMBERS = "[\\d]*";
    private static final String PATTERN_EMAIL = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";

    public static boolean validateLetters(String toValidate) {
        return toValidate.matches(PATTERN_LETTERS);
    }

    public static boolean validateNumbers(String toValidate) {
        return toValidate.matches(PATTERN_NUMBERS);
    }

    public static boolean validateEmail(String toValidate) {
        return toValidate.matches(PATTERN_EMAIL);
    }

}
