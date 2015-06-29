package org.wso2;


import com.intellij.psi.TokenType;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;

import com.intellij.psi.tree.TokenSet;

import org.wso2.fileType.JaggeryLanguage;
import org.wso2.fileType.JavascriptLanguage;

public interface JaggeryTokenTypes {

    /**
     * predefined token types
     */


    public static final IElementType TEMPLATE_HTML_TEXT = new JaggeryElementType("TEMPLATE_HTML_TEXT");   // This is the element type for html

    public static final IElementType OUTER_ELEMENT_TYPE = new JaggeryElementType("OUTER_ELEMENT_TYPE");    //outer element type that is under html

    public static final IElementType JAVASCRIPT_TEXT =  new JavascriptElementType("JavascriptContent",
            JavascriptLanguage.INSTANCE);

    public static TemplateDataElementType TEMPLATE_DATA =

            new TemplateDataElementType("JAGGERY_TEMPLATE_DATA", JaggeryLanguage.INSTANCE, JAVASCRIPT_TEXT, OUTER_ELEMENT_TYPE);


    public static final IElementType WHITE_SPACE = TokenType.WHITE_SPACE;


    public static final IElementType HTML_TEXT = TEMPLATE_HTML_TEXT;

    TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE);

    public static final IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

    /**
     * jaggery specific token types
     */


    public static final IElementType OUTERBRACKETS = new JaggeryElementType("OUTERBRACKETS");


    public static final IElementType STRING = new JaggeryElementType("STRING");
    public static final IElementType LINECOMMENT = new JaggeryElementType("LINECOMMENT");

    public static final IElementType LINE_TERMINATOR = new JaggeryElementType("LINE_TERMINATOR");

    public static TokenSet STRINGS = TokenSet.create(STRING);

    public static TokenSet COMMENTS = TokenSet.create(

            LINECOMMENT

    );


}
