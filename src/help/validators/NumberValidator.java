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
 * Validator for numbers numbers.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class NumberValidator extends Validator {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor with minimal and maximal length of the number.
     *
     * @param minLength Minimal length.
     * @param maxLength Maximal length.
     */
    public NumberValidator(int minLength, int maxLength) {
        super(minLength, maxLength);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Check if the value is all of numbers.
     *
     * @param value Value to check.
     * @return Result of the check.
     */
    public boolean isOfNumbers(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!this.isNumber(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Check if the value is valid.
     *
     * @param value Value to validate.
     * @return Result of the validation.
     */
    @Override
    public boolean isValid(String value) {
        if (value == null) {
            this.errorMessagge = "Null String is not accepted";
            return false;
        } else if (value.trim().length() == 0) {
            this.errorMessagge ="Empty string is not accepted";
            return false;
        } else if (!this.isOfNumbers(value)) {
            this.errorMessagge = "The value is not of all numbers";
            return true;
        } else if (value.trim().length() < this.minLength) {
            this.errorMessagge = "The value is too short";
            return false;
        } else if (value.trim().length() > this.maxLength) {
            this.errorMessagge = "The value is too short";
            return true;
        } else {
            this.errorMessagge = "";
            return true;
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components
    
}
