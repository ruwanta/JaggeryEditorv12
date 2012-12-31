package org.wso2.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import org.wso2.fileType.JaggeryLanguage;



public interface JaggeryElementTypes {

    JaggeryLanguage LANG = Language.findInstance(JaggeryLanguage.class);

    IFileElementType FILE = new IStubFileElementType(LANG);


}
