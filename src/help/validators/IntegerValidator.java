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
 * Validator for integer numbers.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class IntegerValidator extends Validator {

    /**
     * Minimal value.
     */
    private int minValue;

    /**
     * Maximal value.
     */
    private int maxValue;

    /**
     * Constructor with minimal and maximal values.
     *
     * @param minValue Minimal value.
     * @param maxValue Maximal value.
     */
    public IntegerValidator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Check if the value, if is valid returns true.
     * Check if the value si greater than minValue and smaller than maxValue.
     *
     * @param value Value to check.
     * @return True if the value is valid.
     */
    @Override
    public boolean isValid(String value) {
        if (value == null) {
            this.errorMessagge = "Null string is not accepted";
            return false;
        } else if (value.length() == 0) {
            this.errorMessagge = "Empty string is not accepted";
            return false;
        } else {
            try {
                int n = Integer.parseInt(value);
                return this.isValid(n);
            } catch (NumberFormatException nfe) {
                this.errorMessagge = "Value not valid: \n" + value + "\"";
                return false;
            }
        }
    }

    /**
     * Check if the value, if is valid returns true.
     * Check if the value si greater than minValue and smaller than maxValue.
     *
     * @param value Value to check.
     * @return True if the value is valid.
     */
    public boolean isValid(int value) {
        if (value < minValue) {
            this.errorMessagge = "Too small value: " + value;
            return false;
        } else if (value > maxValue) {
            this.errorMessagge = "Too large Value: " + value;
            return false;
        } else {
            return true;
        }
    }
}
