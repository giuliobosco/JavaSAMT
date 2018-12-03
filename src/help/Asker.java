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
package help;

import help.validators.Validator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class Asker {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Default quit command.
     */
    public static final String DEFAULT_QUIT_CMD = "quit";

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Quit command.
     */
    private String quitCommand;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Asker with quit command parameter.
     *
     * @param quitCommand Quit command.
     */
    public Asker(String quitCommand) {
        if (quitCommand != null && quitCommand.trim().length() > 0) {
            this.quitCommand = quitCommand;
        } else {
            this.quitCommand = DEFAULT_QUIT_CMD;
        }
    }

    /**
     * Asker with default quit command.
     */
    public Asker() {
        this(DEFAULT_QUIT_CMD);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Method for ask the value.
     *
     * @param message Message to print, without the ":".
     * @param validator Validator to check the value.
     * @return The answer.
     * @throws FormInterruptedException Form interruption.
     * @throws IOException Input/Output Exception.
     */
    public String ask(String message, Validator validator) throws FormInterruptedException, IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);

        String value = "";

        while (true) {
            System.out.printf("%s:", message, quitCommand);

            value = keyboard.readLine().trim();

            if (value.equalsIgnoreCase(quitCommand)) {
                throw new FormInterruptedException("Interrupted compilation");
            } else if (validator.isValid(value)) {
                return value;
            } else {
            }
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components
}
