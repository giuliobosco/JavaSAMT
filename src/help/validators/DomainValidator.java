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
 * Validator For validate Internet Domains.
 *
 * @author giuliobosco
 * @version 0.1
 */
public class DomainValidator extends UsernameValidator {

    /**
     * Default Domain Max Length.
     * Value: 254.
     */
    public static final int DEFAULT_DOMAIN_MAX_LENGHT = 254;

    /**
     * Default Domain Min Length.
     * Value = 3.
     */
    public static final int DEFAULT_DOMAIN_MIN_LENGTH = 3;

    /**
     * Constructor with all default parameters.
     */
    public DomainValidator() {
        super(DEFAULT_DOMAIN_MIN_LENGTH, DEFAULT_DOMAIN_MAX_LENGHT);
    }

    /**
     * Constructor with all parameters.
     * @param minLength Minimal Domain Length.
     * @param maxLength Maximal Domain Length.
     */
    public DomainValidator(int minLength, int maxLength) {
        super(minLength, maxLength);
    }

    /**
     * Check if the value passed by parameter contains a point char or an underscore.
     * @param value Value to check.
     * @return True if the value contain a point char and not contain an underscore, else false.
     */
    public boolean checkPointUnderscore(String value) {
        boolean r = false;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '.') {
                r = true;
            } else if (value.charAt(i) == '_') {
                return false;
            }
        }

        return r;
    }

    /**
     * Validate Internet Domains.
     * @param value Domain to validate.
     * @return True if the domain is valid.
     */
    @Override
    public boolean isValid(String value){
        if(!(isContaining(value) &&
                value.trim().length() >= this.getMinLength() &&
                value.trim().length() < this.getMaxLength())) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!this.isValidForUsername(value.charAt(i))) {
                return false;
            }
        }

        if (!this.checkPointUnderscore(value)) {
            return false;
        }

        if (!this.isValidFirstLastChar(value)) {
            return false;
        }

        return true;
    }
}
