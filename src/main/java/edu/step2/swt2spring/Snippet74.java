package edu.step2.swt2spring;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Snippet74 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Caret caret = new Caret (shell, SWT.NONE);
	caret.setBounds (10, 10, 2, 32);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 