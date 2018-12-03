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

import java.util.Date;

/**
 * Validator for dates.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class DateValidator {
    /**
     * Default minimal Date.
     * Value: 1900.01.01
     */
    public static final Date DFL_MIN_DATE = new Date(1900,1,1);

    /**
     * Default maximal Date.
     * Value: Today
     */
    public static final Date DFL_MAX_DATE = new Date();

    /**
     * Minimal valid date.
     */
    private Date minDate;

    /**
     * Maximal valid date.
     */
    private Date maxDate;

    /**
     * Getter for the Minimal valid date.
     *
     * @return Minimal valid date.
     */
    public Date getMinDate() {
        return this.minDate;
    }

    /**
     * Setter for the minimal valid date.
     *
     * @param minDate Minimal valid date.
     */
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    /**
     * Getter for the Minimal valid date.
     *
     * @return Minimal valid date.
     */
    public Date getMaxDate() {
        return this.maxDate;
    }

    /**
     * Setter for Minimal valid date.
     *
     * @param maxDate Minimal valid date.
     */
    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    /**
     * Constructor with minimal and maximal date.
     *
     * @param minDate Minimal valid date.
     * @param maxDate Maximal valid date.
     */
    public DateValidator(Date minDate, Date maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    /**
     * Constructor with maximal date.
     *
     * @param maxDate Maximal date.
     */
    public DateValidator(Date maxDate) {
        this(DFL_MIN_DATE, maxDate);
    }

    /**
     * Constructor without parameters.
     */
    public DateValidator() {
        this(DFL_MAX_DATE);
    }

    /**
     * Check if the value passed as parameter is valid.
     *
     * @param date Date to check.
     * @return Result of the check.
     */
    public boolean isValid(Date date) {
        if (date.after(minDate) && date.before(maxDate)) {
            return true;
        } else {
            return false;
        }
    }
}
