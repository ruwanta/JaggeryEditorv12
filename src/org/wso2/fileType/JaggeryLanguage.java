package org.wso2.fileType;

import com.intellij.lang.Language;
import com.intellij.psi.templateLanguages.TemplateLanguage;

/*This is the language implementation of jaggery language
* Implemented TemplateLanguage interface.*/


public class JaggeryLanguage   extends Language implements TemplateLanguage {


    public static final JaggeryLanguage INSTANCE = new JaggeryLanguage();

    protected JaggeryLanguage() {
        super("jaggery","application/x-jaggery-template");


    }
}
