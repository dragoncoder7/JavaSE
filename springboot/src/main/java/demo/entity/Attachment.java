package demo.entity;

import lombok.Data;

@Data
public class Attachment {
    private int imageFileID;
    private String filename;
    private String filepath;
    //是否是压缩文件 0：不是 1：是
    private int isZip;
    //汇联易唯一标识
    private String attachmentOID = "";
}
