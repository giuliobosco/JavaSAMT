/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package string;
/**
 * Tools for strings, works with UTF-8 vowels and consonant mostly.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class StringTool {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Is the char letter.
     *
     * @param c Char to check.
     * @return true if is letter.
     */
    public static boolean isLetter(char c) {
        int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

        if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
            return true;
        }
        else {
            return false;
        }


    }

    /**
     * Check if the char is consonant.
     *
     * @param c Char to check..
     * @return True if is consonant.
     */
    public static boolean isConsonant(char c) {
        int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

        if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
            if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                return false;
            }
            else {
                return true;
            }

        }
        else {
            return false;
        }
    }

    /**
     * Check if the char is a vowel.
     *
     * @param c Char to check.
     * @return True if is vowel.
     */
    public static boolean isVowel(char c) {
        int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

        if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
            if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }
    }

    /**
     * Count the vowel in the string.
     *
     * @param text String where count the vowels.
     * @return Number of vowel in the string.
     */
    public static int countVowels(String text) {
        int stringN = text.length();
        int vowelCount = 0;

        for (int i = stringN; i > 0; i--) {
            char c = text.charAt(i - 1);
            int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

            if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                    vowelCount++;
                }
            }
        }
        return vowelCount;
    }

    /**
     * Count the consonant in the string.
     *
     * @param text String where count the consonants.
     * @return Number of consonant in the string.
     */
    public static int countConsonants(String text) {
        int stringN = text.length();
        int consCount = 0;

        for (int i = stringN; i > 0; i--) {
            char c = text.charAt(i -1);
            int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

            boolean voc = true;

            if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                    voc = false;
                }
            }
            if (voc == true) {
                consCount++;
            }
        }

        return consCount;
    }

    /**
     * Get just the vowels of the string.
     *
     * @param text String to analyze.
     * @return Vowels of the string.
     */
    public static String vowelize(String text) {
        int stringN = text.length();
        String ret = "";

        for (int i = stringN; i > 0; i--) {
            char c = text.charAt(i - 1);
            int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

            if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                    ret += c;
                }
            }
        }

        return ret;
    }

    /**
     * Check if vowel and consonant are alternate.
     *
     * @param s String to check.
     * @return True if vowel and consonant are alternate.
     */
    public static boolean isAlternative(String s) {
        int stringN = s.length();
        boolean ret = true;

        for (int i = stringN; i > 0; i--) {
            char c = s.charAt(i - 1);
            int charN = Integer.parseInt(Integer.toHexString((int) c), 16);

            if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                    ret = true;

                    i--;
                    c = s.charAt(i -1 );
                    charN = Integer.parseInt(Integer.toHexString((int) c), 16);

                    if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                        if (!(charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117)) {
                            ret = true;
                        }
                        else {
                            ret = false;
                            i = 0;
                        }
                    }
                    else {
                        ret = false;
                        i = 0;
                    }
                }
                else if (!(charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117)) {
                    ret = true;

                    i--;
                    c = s.charAt(i - 1);
                    charN = Integer.parseInt(Integer.toHexString((int) c), 16);

                    if ((charN > 64 && charN < 91) || (charN > 96 && charN < 123)) {
                        if (charN == 65 || charN == 69 || charN == 73 || charN == 79 || charN == 85 || charN == 97 || charN == 101 || charN == 105 || charN == 111 || charN == 117) {
                            ret = true;
                        }
                        else {
                            ret = false;
                            i = 0;
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Check if the two string are anagrams one of the other.
     *
     * @param firstWord First word.
     * @param secondWord Word to check if it's anagram of the first.
     * @return True if the two words are anagrams on of the other.
     */
    public static boolean isAnagram(String firstWord, String secondWord) {
        boolean anagramma;
        int firstWordN = firstWord.length();
        int secondWordN = secondWord.length();

        if (firstWordN != secondWordN) {
            anagramma = false;
        }

        else {
            for (int i = 0; i < firstWordN; i++) {
                char c = firstWord.charAt(i);
                int pos = secondWord.indexOf(c);

                if (pos >= 0) {
                    int secondWordN2 = secondWord.length();

                    secondWord = secondWord.substring(0, pos) + secondWord.substring(pos + 1, secondWordN2);
                }
            }

            if (secondWord.equals("")) {
                anagramma = true;
            }
            else {
                anagramma = false;
            }
        }
        return anagramma;
    }

    /**
     * Count char in string.
     *
     * @param text String where to count the char.
     * @param c Char to count.
     * @return Count of the char in the string.
     */
    public static int countInString(String text, char c) {
        int textN = text.length();
        int counter = 0;

        for (int i = 0; i < textN; i++) {
            char ct = text.charAt(i);
            if (ct == c) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Main method of the class, used for test all the methods.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        if (args.length > 2) {

            System.out.println("isLetter: " + isLetter(args[0].charAt(0)));
            System.out.println("isConsonant: " + isConsonant(args[0].charAt(0)));
            System.out.println("isVowel: " + isVowel(args[0].charAt(0)));
            System.out.println("countVowels: " + countVowels(args[1]));
            System.out.println("countConsonants: " + countConsonants(args[1]));
            System.out.println("vowolize: " + vowelize(args[1]));
            System.out.println("isAlternative: " + isAlternative(args[1]));
            System.out.println("isAnagram: " + isAnagram(args[1], args[2]));
            System.out.println("countInString: " + countInString(args[1], args[0].charAt(0)));
        }
        else {
            System.out.println("Inserisci degli argomenti");
        }
    }
}
