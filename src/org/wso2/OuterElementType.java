package org.wso2;

import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.psi.tree.IElementType;


/*
This class reperesents the outer element type of the javascript text
 */

public class OuterElementType extends IElementType {
    public OuterElementType(@org.jetbrains.annotations.NotNull @org.jetbrains.annotations.NonNls String debugName) {
        super(debugName, StdFileTypes.HTML.getLanguage());
    }
}
