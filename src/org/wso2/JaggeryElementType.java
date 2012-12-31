package org.wso2;

import com.intellij.psi.tree.IElementType;
import org.wso2.fileType.JaggeryLanguage;


public class JaggeryElementType extends IElementType {



    public JaggeryElementType(@org.jetbrains.annotations.NotNull @org.jetbrains.annotations.NonNls String debugName) {
        super(debugName, JaggeryLanguage.INSTANCE);
    }

}
