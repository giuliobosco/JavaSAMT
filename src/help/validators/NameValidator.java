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
package help.validators;

/**
 * Validator for names.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class NameValidator extends Validator {

    /**
     * Constructor with minimum and maximum length.
     * @param minLength Minimum Length.
     * @param maxLength Maximum Length.
     */
    public NameValidator(int minLength, int maxLength) {
        super(minLength, maxLength);
    }

    /**
     * Check if all the chars in the string are letters, they can be also special letter, as &egrave;
     * @param value Value to check.
     * @return True if is of letters, else false.
     */
    public boolean isOfLetters(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!(this.isLetter(value.charAt(i)) || this.isSpecialLetter(value.charAt(i)) || value.charAt(i) == ' ')) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if the firstname is valid.
     * @param value Value to validate.
     * @return True if contains something, is of letters and is of the right length, else false.
     */
    @Override
    public boolean isValid(String value) {
        if (!isContaining(value)) {
            return false;
        }

        if (!isRightLength(value)) {
            return false;
        }

        if (!isOfLetters(value)) {
            return false;
        }

        return true;
    }
}
