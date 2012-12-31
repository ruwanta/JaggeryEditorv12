package org.wso2.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.ILazyParseableElementType;


public class Ilazy extends ILazyParseableElementType {
    public Ilazy(@org.jetbrains.annotations.NotNull @org.jetbrains.annotations.NonNls String debugName, @org.jetbrains.annotations.Nullable Language language) {
        super(debugName, language);
    }
}
