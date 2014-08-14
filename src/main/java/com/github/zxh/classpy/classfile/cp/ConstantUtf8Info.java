package com.github.zxh.classpy.classfile.cp;

import com.github.zxh.classpy.classfile.ClassComponent;
import com.github.zxh.classpy.classfile.ClassReader;
import com.github.zxh.classpy.classfile.U2;
import java.util.Arrays;
import java.util.List;

/*
CONSTANT_Utf8_info {
    u1 tag;
    u2 length;
    u1 bytes[length];
}
*/
public class ConstantUtf8Info extends ConstantInfo {

    private U2 length;
    private Utf8String bytes;
    
    public String getString() {
        return bytes.getValue();
    }
    
    @Override
    protected void readInfo(ClassReader reader) {
        length = reader.readU2();
        bytes = new Utf8String(length.getValue());
        bytes.read(reader);
    }
        
    @Override
    public List<ClassComponent> getSubComponents() {
        return Arrays.asList(getTag(), length, bytes);
    }
    
}