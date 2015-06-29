package org.wso2.fileType;

//import com.intellij.lang.javascript.index.IndexedFileTypeProvider;
import com.intellij.openapi.fileTypes.FileType;


public class indexedFileType
//        implements IndexedFileTypeProvider
{
//    @Override
    public FileType[] getFileTypesToIndex() {
        return new FileType[]{JaggeryFileType.Jaggery_FILE_TYPE};  //To change body of implemented methods use File | Settings | File Templates.
    }
}
