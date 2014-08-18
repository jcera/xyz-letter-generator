package com.lettergenerator;

/**
 * Created by alex on 8/13/14.
 */
public class VerticalLetterGenerator extends LetterGenerator {

    public VerticalLetterGenerator(int scale, char[] letters) throws Exception {
        super(scale, letters);
    }

    @Override
    protected void processLetterBoard() {
        int charIndex = 0;
        char character = letters[charIndex];
        for (int y = 0; y < scale * letters.length; y++) {
            if (y % scale == 0 && y != 0) {
                character = letters[++charIndex];
                appendLetterSeparator();
            }
            for (int x = 0; x < scale; x++) {
                int offset = charIndex * scale;
                plotCharToLetterBoard(character, x, offset == 0 ? y : y - offset);
            }
            appendNextLine();
        }
    }

    @Override
    protected void appendLetterSeparator() {
        int counter = 0;
        while (counter < scale) {
            appendBlank();
            counter++;
        }
        appendNextLine();
    }
}
