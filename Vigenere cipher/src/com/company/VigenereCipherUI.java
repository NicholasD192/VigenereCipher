package com.company;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


/**
 * Created by Nick Davies on 17/06/2015.
 */
public class VigenereCipherUI  {

    private VingenereCipher cipher = new VingenereCipher();
    public Display display = new Display();
    public Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

    public VigenereCipherUI() {

        shell.setText("Vigenere Cipher");

        GridLayout gridlayout = new GridLayout(4, true);
        gridlayout.verticalSpacing = 10;
        shell.setLayout(gridlayout);


        //Input Text

        Label label = new Label(shell, SWT.NULL);
        label.setText("PlainText: ");

        Text txtPlain = new Text(shell, SWT.SINGLE | SWT.BORDER);
        GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtPlain.setLayoutData(gridData);

        //Cipher Key

        label = new Label(shell, SWT.NULL);
        label.setText("Key: ");

        Text txtKey = new Text(shell, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtKey.setLayoutData(gridData);

        //CipherText
        label = new Label(shell, SWT.NULL);
        label.setText("CipherText: ");

        Text txtEncrypted = new Text(shell, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtEncrypted.setLayoutData(gridData);

        //Encrypt Button and Clear Button
        Button btnEncrypt = new Button(shell, SWT.PUSH);
        Button btnClear = new Button(shell, SWT.PUSH);
        btnEncrypt.setText("Encrypt");
        btnClear.setText("Clear");
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        btnEncrypt.setLayoutData(gridData);
        btnClear.setLayoutData(gridData);

        //Encrypt Button Functionality
        btnEncrypt.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {

                txtEncrypted.setText(cipher.generateCipherText(txtPlain.getText(), txtKey.getText()));

            }
        });

        //Clear Button Functionality
        btnClear.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                txtPlain.setText("");
                txtEncrypted.setText("");
                txtKey.setText("");
            }
        });

        //********************Decryption*************************

        //CipherText (Decryption
        label = new Label(shell, SWT.NULL);
        label.setText("CipherText: ");

        Text txtDecryptCipher = new Text(shell, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtDecryptCipher.setLayoutData(gridData);


        //Key (Decryption)
        label = new Label(shell, SWT.NULL);
        label.setText("Key");

        Text txtDecryptKey = new Text(shell, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtDecryptKey.setLayoutData(gridData);


        //Plain (Decryption)
        label = new Label(shell, SWT.NULL);
        label.setText("PlainText");

        Text txtDecryptPlain = new Text(shell, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 3;
        txtDecryptPlain.setLayoutData(gridData);

        //Decrypt Button and Clear Button
        Button btnDecrypt = new Button(shell, SWT.PUSH);
        btnClear = new Button(shell, SWT.PUSH);
        btnDecrypt.setText("Decrypt");
        btnClear.setText("Clear");
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        btnDecrypt.setLayoutData(gridData);
        btnClear.setLayoutData(gridData);

        //Decrypt button Funtionality
        btnDecrypt.addSelectionListener((new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                txtDecryptPlain.setText(cipher.generatePlainText(txtDecryptCipher.getText(), txtDecryptKey.getText()));
            }
        }));

        //Clear Button Functionality
        btnClear.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                txtDecryptCipher.setText("");
                txtDecryptKey.setText("");
                txtDecryptPlain.setText("");
            }
        });


        shell.setSize(310, 300);
        shell.open();

    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        VigenereCipherUI ui = new VigenereCipherUI();

        while (!ui.shell.isDisposed()) {
            if (!ui.display.readAndDispatch())
                ui.display.sleep();
        }
        ui.display.dispose();
    }

}
