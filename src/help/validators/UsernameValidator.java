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
 * Validators for names, or string that must contain only letters.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class UsernameValidator extends Validator {

    /**
     * Username Default Max Length.
     * Value: 64.
     */
    public final static int DEFAULT_USERNAME_MAX_LENGTH = 64;

    /**
     * Username Default Min Length.
     */
    public final static int DEFAULT_USERNAME_MIN_LENGTH = 1;

    /**
     * Default Number Enable.
     * Value: true.
     */
    public final static boolean DEFAULT_NUMBER_OK = true;

    /**
     * Default Basic Special Char Enable.
     * Value: true.
     */
    public final static boolean DEFAULT_BASIC_SPECIAL_CHAR = true;

    /**
     * Attribute for number enabled.
     */
    protected boolean numberOK;

    /**
     * Attribute for basic special chars enabled.
     * Basic Specail chars:
     * <ul>
     *     <li>-</li>
     *     <li>.</li>
     *     <li>_</li>
     * </ul>
     */
    protected boolean basicSpecialCharOK;

    /**
     * Getter for number enabled.
     * @return Number enabled.
     */
    public boolean isNumberOK() {
        return numberOK;
    }

    /**
     * Getter for basic special chars enabled.
     * @return Basic Special Chars enabled.
     */
    public boolean isBasicSpecialCharOK() {
        return this.basicSpecialCharOK;
    }

    /**
     * Constructor with all default, minLength default value of the SuperClass.
     */
    public UsernameValidator() {
        super(DEFAULT_USERNAME_MIN_LENGTH, DEFAULT_USERNAME_MAX_LENGTH);
        this.numberOK = DEFAULT_NUMBER_OK;
        this.basicSpecialCharOK = DEFAULT_BASIC_SPECIAL_CHAR;
    }

    /**
     * Constructor with the minLength seated at the default value of the SuperClass, max value seated at default value.
     * @param numberOK Number are enabled.
     */
    public UsernameValidator(boolean numberOK, boolean basicSpecialCharOK) {
        super(DEFAULT_USERNAME_MIN_LENGTH, DEFAULT_USERNAME_MAX_LENGTH);
        this.numberOK = numberOK;
        this.basicSpecialCharOK = basicSpecialCharOK;
    }

    /**
     * Constructor with the minLength default value of the SuperClass and the numberOK and basicSpecialCharOK at default
     * value.
     * @param maxLength Maximum length of the string.
     */
    public UsernameValidator(int maxLength) {
        super(DEFAULT_USERNAME_MIN_LENGTH, maxLength);
        this.numberOK = DEFAULT_NUMBER_OK;
        this.basicSpecialCharOK = DEFAULT_BASIC_SPECIAL_CHAR;
    }

    /**
     * Constructor with the minLength default value of the SuperClass.
     * @param maxLength Maximum length of the string.
     * @param numberOK Number are enabled.
     * @param basicSpecialCharOK Basic Special Char Enabled.
     */
    public UsernameValidator(int maxLength, boolean numberOK, boolean basicSpecialCharOK) {
        super(DEFAULT_USERNAME_MIN_LENGTH, maxLength);
        this.numberOK = numberOK;
        this.basicSpecialCharOK = basicSpecialCharOK;
    }

    /**
     * Constructor with the numberOK and basicSpecialCharOK at default value.
     * @param maxLength Maximum length of the string.
     * @param minLength Minimum length of the string.
     */
    public UsernameValidator(int minLength, int maxLength) {
        super(minLength, maxLength);
        this.numberOK = DEFAULT_NUMBER_OK;
        this.basicSpecialCharOK = DEFAULT_BASIC_SPECIAL_CHAR;
    }

    /**
     * Constructor with all parameters.
     * @param maxLength Maximum length of the string.
     * @param minLength Minimum length of the string.
     * @param numberOK Number are enabled.
     * @param basicSpecialCharOK Basic Special Chars enabled.
     */
    public UsernameValidator(int minLength, int maxLength, boolean numberOK, boolean basicSpecialCharOK) {
        super(minLength, maxLength);
        this.numberOK = numberOK;
        this.basicSpecialCharOK = basicSpecialCharOK;
    }

    /**
     * Is the char passed by parameter valid.
     * @param c Char to check.
     * @return True if is a valid char.
     */
    public boolean isValidForUsername(char c) {
        if (!(this.isLetter(c) ||
                (this.basicSpecialCharOK && this.isBasicSpecialChar(c)) ||
                (this.numberOK && this.isNumber(c)))) {
            this.errorMessagge = "The char " + c + " is not accepted.";
            return false;
        }

        return true;
    }

    /**
     * Check if the first and the last character are not Basic Special Chars.
     * @param value
     * @return
     */
    protected boolean isValidFirstLastChar(String value) {
        if (!this.isContaining(value)) {
            return false;
        }

        if (
                value.charAt(0) == '.' &&
                value.charAt(0) == '-' &&
                value.charAt(0) == '_') {
            this.errorMessagge = "the char " + value.charAt(0) + " cannot be at the begin of the value.";
            return false;
        }

        if (
                value.charAt(value.length() - 1) == '.' &&
                value.charAt(value.length() - 1) == '-' &&
                value.charAt(value.length() - 1) == '-'){
            this.errorMessagge = "the char " +
                    value.charAt(value.length() - 1) +
                    "cannot be at the end of the value.";
            return false;
        }
        return true;
    }

    protected boolean areBasicSpecialCharsNear(String value) {
        for (int i = 1; i < value.length(); i++) {
            if (isBasicSpecialChar(value.charAt(i)) && value.charAt(i) == value.charAt(i - 1)) {
                this.errorMessagge = "They cannot be 2 special chars near.";
                return true;
            }
        }

        return false;
    }

    /**
     * Validate the value passed by parameter.
     * The value have to be like:
     * <ul>
     *     <li>longer than or equals to minLength</li>
     *     <li>shorter than or equals to maxLength</li>
     *     <li>not null</li>
     *     <li>a letter</li>
     * </ul>
     * @param value Value to validate.
     * @return The result of the validation.
     */
    @Override
    public boolean isValid(String value) {
        if (!this.isContaining(value)) {
            this.errorMessagge = "The value cannot be null or empty.";
            return false;
        }
        if (!this.isRightLength(value)) {
            this.errorMessagge = "The value have to be greater than or equal at " +
                    this.getMinLength() +
                    " and lower or equal at " +
                    this.getMaxLength();
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!this.isValidForUsername(value.charAt(i))) {
                return false;
            }
        }

        if (!this.isValidFirstLastChar(value)) {
            return false;
        }

        if (this.areBasicSpecialCharsNear(value)) {
            return false;
        }

        return true;
    }
}
