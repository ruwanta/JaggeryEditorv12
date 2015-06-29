package org.wso2.psi;

import com.intellij.lang.*;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.wso2.JaggeryElementType;
import org.wso2.JaggeryTokenTypes;
import org.wso2.JavascriptElementType;

/*Basic parsing is done for the base language*/


public class JaggeryParser implements PsiParser {


    public JaggeryParser() {

    }

    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {

        final PsiBuilder.Marker rootMarker = builder.mark();
        final PsiBuilder.Marker jaggeryMarker = builder.mark();

        // Process all tokens
        while (!builder.eof()) {

            IElementType type = builder.getTokenType();

            if (type == JaggeryTokenTypes.JAVASCRIPT_TEXT) {


            }

            builder.advanceLexer(); // move to next token
        }

        jaggeryMarker.done(JaggeryTokenTypes.TEMPLATE_HTML_TEXT);
        rootMarker.done(root);
        return builder.getTreeBuilt();

    }
}
