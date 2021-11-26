package jp.co.internous.nova.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.nova.model.domain.MstDestination;

@Mapper
public interface MstDestinationMapper {

	@Select("SELECT * FROM mst_destination WHERE user_id = #{userId} AND status = 1 ORDER BY id asc")
	List<MstDestination> findByUserId(@Param("userId") int userId);

	@Update("UPDATE mst_destination SET status = 0, updated_at = now() WHERE id = #{id}")
	int logicalDeleteById(@Param("id") int id);

	@Insert("INSERT INTO mst_destination(user_id,family_name,first_name,address,tel_number) " + 
			"VALUES (#{userId},#{familyName},#{firstName},#{address},#{telNumber})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert(MstDestination mstDestination);
}