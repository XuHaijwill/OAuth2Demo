package cn.xhjc.mapper;

import cn.xhjc.model.SsoRefreshToken;
import org.apache.ibatis.annotations.Param;

public interface SsoRefreshTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SsoRefreshToken record);

    int insertSelective(SsoRefreshToken record);

    SsoRefreshToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SsoRefreshToken record);

    int updateByPrimaryKey(SsoRefreshToken record);

    /**
     * 通过tokenId查询记录
     * @author xhjc
     * @date 2018/8/30 14:27
     * @since 1.0.0
     * @param tokenId tokenId
     * @return cn.xhjc.model.SsoRefreshToken
     */
    SsoRefreshToken selectByTokenId(@Param("tokenId") Integer tokenId);

    /**
     * 通过Refresh Token查询记录
     * @author xhjc
     * @date 2018/8/32 14:27
     * @since 1.0.0
     * @param refreshToken Refresh Token
     * @return cn.xhjc.model.SsoRefreshToken
     */
    SsoRefreshToken selectByRefreshToken(@Param("refreshToken") String refreshToken);
}