package org.wso2.highlighting;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/*Generates the Highlighter .*/

public class HighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {


    @NotNull
    @Override
    protected SyntaxHighlighter createHighlighter() {


        try {


            return new SyntaxHighlightHandler();


        } catch (Exception e) {

            System.out.println("message is " + e.getMessage());
            return null;

        }


    }
}
