package org.wso2.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.wso2.JaggeryTokenTypes;
import org.wso2.fileType.JaggeryFileType;
import org.wso2.fileType.JaggeryLanguage;
import org.wso2.jaggeryFlexAdapter;

import java.io.FileNotFoundException;


public class JaggeryParserDefinition implements ParserDefinition {

    private static final IFileElementType LANGUAGE_FILE_TYPE = new IFileElementType(JaggeryLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {



        try {
            return new  jaggeryFlexAdapter();  //returns flex adapter inturn returns jaggery flex
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return null;
        }

    }

    @Override
    public PsiParser createParser(Project project) {

        return new JaggeryParser(); //returns parser
    }

    @Override
    public IFileElementType getFileNodeType() {


        return LANGUAGE_FILE_TYPE;  //get language filetype
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {

        return JaggeryTokenTypes.WHITE_SPACES;        //match if needed
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {


        return JaggeryTokenTypes.COMMENTS;       // match if needed
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {

        return JaggeryTokenTypes.STRINGS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {

       return new JaggeryElementImpl(astNode);  //return element implementation
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {             //returns the psifile created

        return new PsiFileBase(fileViewProvider, JaggeryLanguage.INSTANCE) {
            @NotNull
            public com.intellij.openapi.fileTypes.FileType getFileType() {
                return JaggeryFileType.Jaggery_FILE_TYPE;
            }
        };    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {

        return SpaceRequirements.MAY;
    }
}
