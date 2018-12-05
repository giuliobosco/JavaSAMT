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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class StringAnalitycs {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    public static int[] compare(String string) {
        int[] statistic = new int[26];

        for (int i : statistic) {
            i = 0;
        }
/*
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < ALPHABETH.length; j++) {
                if (string.charAt(i) == ALPHABETH[j]) {
                    statistic[j]++;
                    j = ALPHABETH.length;
                }
            }
        }
*/
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) - 0x61 >= 0 && string.charAt(i) - 0x61 <= 26) {
                statistic[string.charAt(i) - 97]++;
            }
        }
        return statistic;
    }

    public static void sort(int[] statistics, char[] chars) {

        boolean fine = true;
        for (int i = 0; i < statistics.length; i++) {
            for (int l = 0; l < statistics.length - 1; l++) {
                if (statistics[l] < statistics[l + 1]) {
                    char c = chars[l];
                    chars[l] = chars[l+ 1];
                    chars[l + 1] = c;

                    int n = statistics[l];
                    statistics[l] = statistics[l + 1];
                    statistics[l + 1] = n;

                    fine = false;
                }
            }
            if (fine) {
                i = chars.length;
            }
        }

        //return chars;
    }

    public static List<String> getList(int[] statistics, char[] chars) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(Character.toString(chars[i]) + ": " + Integer.toString(statistics[i]));
        }

        return list;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        if (args.length > 0) {
            Path read = Paths.get(args[0]);
            if (Files.exists(read) && Files.isReadable(read)){
                try {
                    byte[] b = Files.readAllBytes(read);
                    String s = new String(b);
                    s = s.toLowerCase();

                    int[] statistic = compare(s);
                    char[] chars = StringTool.ALPHABETH;
                    //sort(statistic, chars);

                    List<String> list = getList(statistic, chars);

                    Path write = Paths.get("");

                    if (args.length > 1) {
                        write = Paths.get(args[1]);
                    }else {
                        write = Paths.get("frequenza.txt");
                    }

                    try {
                        Files.write(write, list);
                    }catch (IOException ioe) {
                        System.out.println("Error while writing the file");
                    }
                }catch (IOException ioe) {
                    System.out.println("Error while reading the text file.");
                }
            }else {
                System.out.println("Impossible to read the file.");
            }
        }else {
            System.out.println("Use: java WordsAnalytics <textFile>");
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
