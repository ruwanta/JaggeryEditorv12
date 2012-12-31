package org.wso2.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;


public class JaggeryElementImpl extends ASTWrapperPsiElement implements JaggeryElement {

    private final ASTNode astNode;


    public JaggeryElementImpl(@NotNull ASTNode node) {
        super(node);

        this.astNode = node;
    }

    @NotNull
    @Override
    public ASTNode parse(IElementType iElementType, PsiBuilder psiBuilder) {




        return null;
    }

    public String toString(){
        return "Element type is "+ astNode.getElementType().toString();

    }


}
