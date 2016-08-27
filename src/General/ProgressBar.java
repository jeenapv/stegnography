/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import javax.swing.JProgressBar;

/**
 *
 * @author kakes
 */
public class ProgressBar implements Runnable {

    public boolean complete = false;
    JProgressBar progress_bar;

    public void init_progress(JProgressBar progress_bar) {
        this.progress_bar = progress_bar;
        System.out.println("Thread initialized");
    }

    public void run() {
        complete = false;
        progress_bar.setValue(0);
        int value = 0;
        System.out.println("Thread stareted");
        while (value < 100 && !complete) {
            value++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            progress_bar.setValue(value);
        }
        progress_bar.setValue(100);
    }
}
