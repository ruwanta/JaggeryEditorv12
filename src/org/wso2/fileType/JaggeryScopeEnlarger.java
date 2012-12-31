package org.wso2.fileType;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.ResolveScopeEnlarger;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class JaggeryScopeEnlarger extends ResolveScopeEnlarger {

    public SearchScope getAdditionalResolveScope(@NotNull VirtualFile virtualFile, Project project) {
        if (virtualFile.getFileType() instanceof JaggeryFileType) {
            JagPredefinedLibrary provider = new JagPredefinedLibrary();
            Iterator<VirtualFile> iterator = provider.getPredefinedLibraryFiles().iterator();
            Set<PsiFile> psiFiles = new HashSet<PsiFile>();
            while (iterator.hasNext()) {
                PsiFile psiFile = PsiManager.getInstance(project).findFile(iterator.next());
                if (psiFile != null) {
                    psiFiles.add(psiFile);
                }
            }
            if (psiFiles.size() > 0) {
                return new LocalSearchScope(psiFiles.toArray(new PsiFile[psiFiles.size()]));
            }
        }
        return null;
    }

}
