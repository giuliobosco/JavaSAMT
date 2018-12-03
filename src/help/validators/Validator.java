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
 * Validator for validate a string.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Validator {

    /**
     * Error message.
     */
    protected String errorMessagge;

    /**
     * Maximum Length of the String.
     */
    protected int maxLength;

    /**
     * Minimum Length of the String.
     */
    protected int minLength;

    /**
     * Getter for the Error message.
     * @return Error message.
     */
    public String getErrorMessagge() {
        return this.errorMessagge;
    }

    /**
     * Getter for the Maximum Length of the String.
     * @return Maximum Length of the String.
     */
    public int getMaxLength() {
        return this.maxLength;
    }

    /**
     * Getter for the Minimum Length of the String.
     * @return Minimum Length of the String.
     */
    public int getMinLength() {
        return this.minLength;
    }

    /**
     * Constructor with all default parameter.
     * Default parameters:
     * <ul>
     *     <li>maxLength: Integer MAX VALUE</li>
     *     <li>minLength: 0</li>
     * </ul>
     */
    public Validator() {
        this.maxLength = Integer.MAX_VALUE;
        this.minLength = 0;
    }

    /**
     * Constructor with default minimum length.
     * Default parameter:
     * <ul>
     *     <li>minLength: 0</li>
     * </ul>
     * @param maxLength Maximum Length of the String.
     */
    public Validator(int maxLength) {
        this.maxLength = maxLength;
        this.minLength = 0;
    }

    /**
     * Constructor with all parameters.
     * @param minLength Minimum Length of the String.
     * @param maxLength Maximum Length of the String.
     */
    public Validator(int minLength, int maxLength) {
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    public boolean isRightLength(String value) {
        if (value.trim().length() >= this.getMinLength() && value.trim().length() <= this.getMaxLength()) {
            return true;
        }

        this.errorMessagge = "The value must to be greater or equal at " +
                this.getMinLength() +
                " and lower or equal at " +
                this.getMaxLength() + ".";
        return false;
    }

    /**
     * Validate the value passed by parameter.
     * @param value Value to validate.
     * @return Result of the validation. If the validation is OK returns true, else false.
     */
    public boolean isValid(String value) {
        if (isContaining(value) && isRightLength(value)) {
            return true;
        }
        return false;
    }

    /**
     * Is the char passed by parameter a <b>Letter</b>.
     * True if the unicode code of the char is higher than 0x60 and lower or equal than 0x7a. Also is if the code is
     * higher than 0x40 and lower or equal than 0x5a.
     * @param c Char to check.
     * @return True if is a letter else false.
     */
    public boolean isLetter(char c) {
        c = Character.toLowerCase(c);
        if (c > 0x60 && c <= 0x7a) {
            return true;
        }

        this.errorMessagge = "The char have to be a letter.";
        return false;
    }

    /**
     * Is the char passed by parameter a <b>Secial Letter</b>, like &agrave;&eacute;
     * True if the unicode code of the char is higher or equal than 0xc0 and lower than 0x17F but not 0xD7 or 0xF7.
     * @param c Char to check.
     * @return True if is a letter else false.
     */
    public boolean isSpecialLetter(char c) {
        c = Character.toLowerCase(c);
        if (c >= 0xc0 && c < 0X17F && c != 0xD7 && c !=0xF7) {
            return true;
        }

        this.errorMessagge = "The char have to be a special char.";
        return false;
    }

    /**
     * Is the char passwd by parameter a <b>Vowel</b>.
     * The vowel are:
     * <ul>
     *     <li>a</li>
     *     <li>e</li>
     *     <li>i</li>
     *     <li>o</li>
     *     <li>u</li>
     * </ul>
     * @param c Char to check.
     * @return True if is a Vowel else false.
     */
    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        if (c == 0x61 || c == 0x65 || c == 0x69 || c == 0x6f || c == 0x75) {
            return true;
        }

        this.errorMessagge = "The char have to be a vowel.";
        return false;
    }

    /**
     * Is the char passed by parameter a <b>Basic Special Char</b>.
     * Basic Special Chars:
     * <ul>
     *     <li>-</li>
     *     <li>.</li>
     *     <li>_</li>
     * </ul>
     * @param c Char to check.
     * @return True if is a Basic Special Char else false.
     */
    public boolean isBasicSpecialChar(char c) {
        if (c == 0x2d || c == 0x2e || c == 0x5f) {
            return true;
        }

        this.errorMessagge = "The char have to be a special char.";
        return false;
    }

    /**
     * Is the char passed by parameter a <b>Special Char</b>.
     * True if the unicode code of the char passed by parameter is like one of those:
     * <ul>
     *     <li>Greater than 0x21 and lower than 0x30</li>
     *     <li>Greater than 0x3a and lower than 0x41</li>
     *     <li>Greater than 0x5b and lower than 0x61</li>
     *     <li>Greater than 0x7b and lower than 0x7f</li>
     * </ul>
     * @param c Char to check.
     * @return True if is a Basic Special Char else false.
     */
    public boolean isSpecialChar(char c) {
        if (c >= 0x21 && c < 0x30 ||
                c >= 0x3a && c < 0x41 ||
                c >= 0x5b && c < 0x61 ||
                c >= 0x7b && c < 0x7f) {
            return true;
        }

        this.errorMessagge = "The char have to be a number";
        return false;
    }

    /**
     * Is the char passed by parameter a <b>Number</b>.
     * @param c Char to check.
     * @return True if is a Number.
     */
    protected boolean isNumber(char c) {
        if (c >= 0x30 && c < 0x3A) {
            return true;
        }

        this.errorMessagge = "The value have to be a number.";
        return false;
    }

    /**
     * Check if the parameter string is containing something.
     * Is not null, and not empty.
     * @param value String to check.
     * @return True if the string containing something, else false.
     */
    protected boolean isContaining(String value) {
        if (value != null && value.trim().length() > 0) {
            return true;
        }
        this.errorMessagge = "The value cannot be null or empty.";
        return false;
    }
}
