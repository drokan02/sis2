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
public class TextCustom extends JFXTextField {

    public TextCustom() {

    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.matches("[a-zA-Z]*")) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        if (replacement.matches("[a-zA-Z]*")) {
            super.replaceSelection(replacement);
        }
    }

}
