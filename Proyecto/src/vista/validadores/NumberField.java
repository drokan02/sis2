/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.validadores;

import com.jfoenix.controls.JFXTextField;

/**
 *
 * @author Mauricio Rojas
 */
public class NumberField extends JFXTextField {

    public NumberField() {
        super();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.matches("[\\d]*")) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        if (replacement.matches("[\\d]*")) {
            super.replaceSelection(replacement);
        }

    }

}
