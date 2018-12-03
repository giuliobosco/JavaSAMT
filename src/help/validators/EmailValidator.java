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
 * Validator for validate email address.
 *
 * @author giuliobosco
 * @version 1.1
 */
public class EmailValidator extends Validator {

    /**
     * Default Email Max Length.
     * Value: 254.
     */
    public static final int DEFAULT_EMAIL_MAX_LENGTH = 254;

    /**
     * Default Email Min Value.
     * Value: 5.
     */
    public static final int DEFAULT_EMAIL_MIN_LENGTH = 5;

    /**
     * Validator for username part of the email..
     */
    private UsernameValidator usernameValidator;

    /**
     * Validator for domain part of the email.
     */
    private DomainValidator domainValidator;

    /**
     * Constructor, set default email min and max length, username and domain validator.
     */
    public EmailValidator() {
        super(DEFAULT_EMAIL_MIN_LENGTH, DEFAULT_EMAIL_MAX_LENGTH);

        this.usernameValidator = new UsernameValidator();
        this.domainValidator = new DomainValidator();
    }

    /**
     * Email Validator.
     *
     * @param value Email Address to validate.
     * @return True if it can be an email address, else false.
     */
    @Override
    public boolean isValid(String value) {
        if (!(this.isContaining(value))) {
            return false;
        }
        if (!isRightLength(value)) {
            return false;
        }

        String[] strings = value.split("@");

        if (!(strings.length == 2)) {
            this.errorMessagge = "The email address is not valid";
            return false;
        }

        if (!(usernameValidator.isValid(strings[0]) && domainValidator.isValid(strings[1]))) {
            return false;
        }

        return true;
    }

    /**
     * Email validator.
     *
     * @param value Email address to validate.
     * @throws NotValidDataException The email address is not valid.
     */
    public void check(String value) throws NotValidDataException {
        if (!this.isValid(value)) {
            throw new NotValidDataException(this.errorMessagge);
        }
    }
}
