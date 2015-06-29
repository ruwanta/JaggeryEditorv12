package org.wso2;

import com.intellij.psi.tree.ILazyParseableElementType;
import org.wso2.fileType.JaggeryLanguage;

/**
 * Generic element type for Jaggery sepecific elements
 *
 */
public class JaggeryElementType extends ILazyParseableElementType {

    public JaggeryElementType(
            @org.jetbrains.annotations.NotNull @org.jetbrains.annotations.NonNls String debugName) {
        super(debugName, JaggeryLanguage.INSTANCE);
    }

}
