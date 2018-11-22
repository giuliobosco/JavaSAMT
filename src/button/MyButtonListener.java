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
package button;

import java.util.List;
import java.util.ArrayList;
/**
 * My Button Listener.
 * @author giuliobosco
 * @version 28.05.2018
 */
public interface MyButtonListener {
    /**
     * List of buttons with a listener.
     */
    public List<MyButton> listeners = new ArrayList();
    
    /**
     * Button clicked event.
     * @param source Clicked button.
     */
    public void buttonClicked(MyButton source);
    
    /**
     * Button pressed event.
     * @param source Pressed button.
     */
    public void buttonPressed(MyButton source);
    
    /**
     * Button released event.
     * @param source Released button.
     */
    public void buttonReleased(MyButton source);

    /**
     * Mouse over button event.
     * @param source Over button.
     */
    public void buttonOver(MyButton source);
}
