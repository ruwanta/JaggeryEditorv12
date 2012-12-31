package org.wso2;

import com.intellij.lexer.FlexAdapter;

import java.io.FileNotFoundException;
import java.io.Reader;
/*Returns
* the lexer*/


public class jaggeryFlexAdapter extends FlexAdapter {


    public jaggeryFlexAdapter() throws FileNotFoundException {


        super(new _jaggery2((Reader) null));

    }

}
