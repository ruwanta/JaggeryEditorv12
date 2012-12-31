package org.wso2.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.wso2.fileType.JaggeryFileType;
import org.wso2.fileType.JaggeryLanguage;



public  class JaggeryFile extends PsiFileBase {


    protected JaggeryFile(@NotNull FileViewProvider viewProvider) {

        super(viewProvider, JaggeryLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JaggeryFileType.Jaggery_FILE_TYPE;
    }

    protected JaggeryFile(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, JaggeryLanguage.INSTANCE);
    }
}
