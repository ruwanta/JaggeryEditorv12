package org.wso2.highlighting;

import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wso2.JaggeryTokenTypes;

/*Layered highlighter is added for highlighting purposes.
* Two layeres are registered. One for html and othr one is for
 * javascript*/



public class JaggeryLayeredHighlighter extends LayeredLexerEditorHighlighter {

    private Language language;
    private SyntaxHighlighter outerHighlighterHtml;
    private SyntaxHighlighter outerHighlighterJavaScript;

    public JaggeryLayeredHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme editorColorsScheme) {
        super(new SyntaxHighlightHandler(), editorColorsScheme);

        FileType type = null;

        if(project == null || virtualFile == null) {
            type = StdFileTypes.PLAIN_TEXT;

        } else {

            language = TemplateDataLanguageMappings.getInstance(project).getMapping(virtualFile);

            if(language != null) type = language.getAssociatedFileType();

            if(type == null) type = StdFileTypes.HTML;          // background language should be html

        }

        //get syntax highlighters for relevant file types.

        outerHighlighterHtml = SyntaxHighlighter.PROVIDER.create(type, project, virtualFile);
        outerHighlighterJavaScript =  SyntaxHighlighter.PROVIDER.create(StdFileTypes.JS, project, virtualFile);


        //register two layers
        registerLayer(JaggeryTokenTypes.HTML_TEXT, new LayerDescriptor(outerHighlighterHtml, ""));
        registerLayer(JaggeryTokenTypes.JAVASCRIPT_TEXT, new LayerDescriptor(outerHighlighterJavaScript, ""));




    }

}
