package org.wso2.fileType;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wso2.highlighting.JaggeryLayeredHighlighter;

import javax.swing.*;

/*
* This class contains all the information about the .jag file created and
* can be verified through the display of icon. JaggeryFileTypeFactory which is
*registered at fileTypeFactory extension point creates an instance
* of this.
*
* */
public class JaggeryFileType extends LanguageFileType {


    public static final JaggeryFileType Jaggery_FILE_TYPE = new JaggeryFileType();


    public static final Icon FILE_ICON = IconLoader.getIcon("favicon.png");

    @NonNls
    public static final String DEFAULT_EXTENSION = "jag";

    private String path;
    private String jarUrl;
    private VirtualFile jarVirtualFile;
    private ModifiableModuleModel modifiableModel;
    private Module theModule;
    private ModuleRootManager rootManager;
    private ModifiableRootModel rootModel;
    private Module module;
    private Module module0;
    private String pathvirtualfile;
    private VirtualFile virtualFile2;
    private Project p;


    protected JaggeryFileType() {

        super(JaggeryLanguage.INSTANCE);

        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider() {
            public EditorHighlighter getEditorHighlighter(@Nullable Project project,
                                                          @NotNull FileType fileType,
                                                          @Nullable VirtualFile virtualFile,
                                                          @NotNull EditorColorsScheme editorColorsScheme) {


                return new JaggeryLayeredHighlighter(project, virtualFile, editorColorsScheme);


            }
        });


    }

    @NotNull
    @Override
    public String getName() {
        return "jaggery";
    }


    @NotNull
    @Override
    public String getDescription() {
        return "jaggery";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public Icon getIcon() {

        return FILE_ICON;


    }


}
