package com.company;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javax.tools.Tool;

public class ToolTipEx {

    public ToolTipEx (Display display) {

        initUI(display);
    }

    private void initUI(Display display){

        Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

        shell.setText("ToolTip");
        shell.setToolTipText("This is a window");
        shell.setSize(500,500);

        shell.open();



        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }


    @SuppressWarnings("unused")
    public static void main(String[] args) {

            Display display = new Display();
            ToolTipEx ex = new ToolTipEx(display);
            display.dispose();
    }
}
