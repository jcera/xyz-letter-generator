package com.lettergenerator;

/**
 * Created by alex on 8/13/14.
 */
public class HorizontalLetterGenerator extends LetterGenerator {

    public HorizontalLetterGenerator(int scale, char[] letters) throws Exception {
        super(scale, letters);
    }

    @Override
    protected void processLetterBoard() {
        for (int y = 0; y < scale; y++) {
            int charIndex = 0;
            char character = letters[charIndex];
            for (int x = 0; x < scale * letters.length; x++) {
                if (x % scale == 0 && x != 0) {
                    character = letters[++charIndex];
                    appendLetterSeparator();
                }
                int offset = charIndex * scale;
                plotCharToLetterBoard(character, offset == 0 ? x : x - offset, y);
            }
            appendNextLine();
        }
    }

    @Override
    protected void appendLetterSeparator() {
        appendBlank();
    }
}
