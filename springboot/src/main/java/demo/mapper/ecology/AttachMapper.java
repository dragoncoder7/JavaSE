package demo.mapper.ecology;

import demo.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AttachMapper {
    @Select("select a.imagefileid,a.imagefilename as filename,a.filerealpath as filepath,a.iszip from imagefile a, docimagefile b where b.docid = #{id} and a.imagefileid = b.imagefileid")
    Attachment getAttachmentsID(@Param("id") String id);
}
