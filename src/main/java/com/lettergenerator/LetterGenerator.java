package com.lettergenerator;

/**
 * Created by alex on 8/13/14.
 */
public abstract class LetterGenerator {

    /**
     * Default scale is 3, also the minimum scale.
     */
    protected int scale = 3;

    /**
     * Default letters
     */
    protected char[] letters = new char[]{'X', 'Y', 'Z'};

    /**
     *
     */
    protected StringBuilder letterBoard = new StringBuilder();

    private LetterGenerator() {
    }

    /**
     * The only exposed constructor.
     * @param scale - should be an odd int, if the passed argument is an even number,
     *              it will fallback to the default minimum value which is 3.
     * @param letters - an array of characters, if the passed argument is 0 length,
     *                it will fallback to the default letters
     */
    public LetterGenerator(int scale, char[] letters) {
        if (scale > 3 && scale % 2 != 0) {
            this.scale = scale;
        }
        if (letters.length > 0) {
            this.letters = letters;
        }
        processLetterBoard();
    }

    /**
     * Implementation on how to process the letterBoard depending on the orientation.
     */
    protected abstract void processLetterBoard();

    /**
     * Implementation of the letter spacing depending on the orientation.
     */
    protected abstract void appendLetterSeparator();

    public void printLetterBoard() {
        System.out.println(letterBoard.toString());
    }

    protected void appendAsterisk() {
        letterBoard.append("*");
    }

    protected void appendBlank() {
        letterBoard.append(" ");
    }

    protected void appendNextLine() {
        letterBoard.append("\n");
    }

    protected void plotCharToLetterBoard(char letter, int xOffset, int yOffset) {
        switch (Character.toUpperCase(letter)) {
            case 'X':
                plotX(xOffset, yOffset);
                break;
            case 'Y':
                plotY(xOffset, yOffset);
                break;
            case 'Z':
                plotZ(xOffset, yOffset);
                break;
            default:
                break;
        }
    }

    private void plotX(int xOffset, int yOffset) {
        if (xOffset == yOffset || scale - 1 - xOffset == yOffset) {
            appendAsterisk();
        } else {
            appendBlank();
        }
    }

    private void plotY(int xOffset, int yOffset) {
        if ((xOffset == yOffset || scale - 1 - xOffset == yOffset) && yOffset < scale / 2) {
            appendAsterisk();
        } else if (yOffset >= scale / 2 && xOffset == scale / 2) {
            appendAsterisk();
        } else {
            appendBlank();
        }
    }

    private void plotZ(int xOffset, int yOffset) {
        if (yOffset == 0 || yOffset == scale - 1) {
            appendAsterisk();
        } else if ((yOffset > 0 || yOffset < scale - 1) && yOffset == scale - 1 - xOffset) {
            appendAsterisk();
        } else {
            appendBlank();
        }
    }

}
