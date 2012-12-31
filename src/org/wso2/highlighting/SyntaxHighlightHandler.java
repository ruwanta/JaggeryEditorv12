package org.wso2.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;
import org.wso2.JaggeryTokenTypes;
import org.wso2.jaggeryFlexAdapter;

import java.io.FileNotFoundException;


public class SyntaxHighlightHandler extends SyntaxHighlighterBase {


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        try {

            return new jaggeryFlexAdapter();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return null;

        }
    }


    public static final TextAttributesKey OUTERBRACKETS = TextAttributesKey.createTextAttributesKey(
            "JAGGERY.OUTERBRACKETS",
            SyntaxHighlighterColors.BRACKETS.getDefaultAttributes()
    );


    private static THashMap<IElementType, TextAttributesKey> keys1;

    static {

        keys1 = new THashMap<IElementType, TextAttributesKey>();
        keys1.put(JaggeryTokenTypes.OUTERBRACKETS, OUTERBRACKETS);
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {


        return pack(keys1.get(iElementType));


    }


}
