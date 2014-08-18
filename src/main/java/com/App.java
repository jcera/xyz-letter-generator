package com;

import com.lettergenerator.HorizontalLetterGenerator;
import com.lettergenerator.LetterGenerator;
import com.lettergenerator.VerticalLetterGenerator;

import java.lang.String;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        char[] letters = new char[]{'X', 'Y', 'Z'};
        int scale = 7;

        LetterGenerator verticalLetterGenerator = new VerticalLetterGenerator(scale, letters);
        verticalLetterGenerator.printLetterBoard();

        LetterGenerator horizontalLetterGenerator = new HorizontalLetterGenerator(9, new char[] {});
        horizontalLetterGenerator.printLetterBoard();
    }
}
