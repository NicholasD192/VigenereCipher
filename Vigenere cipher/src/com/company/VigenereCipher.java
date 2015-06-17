package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * Created by Nick Davies on 17/06/2015.
 */
public class VigenereCipher {

    public VigenereCipher(Display display){
        initUI(display);
    }

    private void initUI(Display display){
        Shell shell = new Shell (display, SWT.SHELL_TRIM | SWT.CENTER);

        RowLayout layout = new RowLayout();
        layout.marginLeft = 50;
        layout.marginTop = 50;
        shell.setLayout(layout);


        Button quitBtn = new Button(shell,SWT.PUSH);
        Button newBtn = new Button(shell,SWT.PUSH);
        quitBtn.setText("Quit");
        newBtn.setText("New");
        quitBtn.setLayoutData(new RowData(80,30));
        newBtn.setLayoutData(new RowData(80,30));

        quitBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                shell.getDisplay().dispose();
                System.exit((0));
            }
        });

        shell.setText("Quit Button!!!!");
        shell.setSize(500,500);
        shell.open();

        while (!shell.isDisposed()){
            if(!display.readAndDispatch())
                display.sleep();
        }


    }

    @SuppressWarnings("unused")
    public static void main(String[] args){
        Display display = new Display();
        VigenereCipher ex = new VigenereCipher(display);
        display.dispose();
    }

}
