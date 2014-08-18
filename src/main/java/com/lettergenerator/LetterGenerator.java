package com.lettergenerator;

/**
 * Created by alex on 8/13/14.
 */
public abstract class LetterGenerator {

    protected int scale = 3;
    protected char[] letters = new char[]{'X', 'Y', 'Z'};

    protected StringBuilder letterBoard = new StringBuilder();

    private LetterGenerator() {
    }

    public LetterGenerator(int scale, char[] letters) throws Exception {
        if (scale > 3 && scale % 2 != 0) {
            this.scale = scale;
        }
        if (letters.length > 0) {
            this.letters = letters;
        }

        processLetterBoard();
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

    protected abstract void processLetterBoard();

    protected abstract void appendLetterSeparator();

    public void printLetterBoard() {
        System.out.println(letterBoard.toString());
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
}
