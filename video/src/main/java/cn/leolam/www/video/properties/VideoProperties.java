package cn.leolam.www.video.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: leolam
 */
@Component // 不要少了
@ConfigurationProperties(prefix = "video")
@Data
public class VideoProperties {

    private String itemDir;

    //加密盐
    private String tokenString="leolam";

    //home page
    private Integer pageSizeOnHomePage=10;

    //网关地址
    private String gateWayUrl;

    //轮播图
    private Integer lunBoPic;

    //search page
    private Integer pageSizeOnSearchPage;

    //collection page
    private Integer pageSizeOnCollectionPage;
    //显示多少条推荐视频
    private Integer pageSizeOnDetailPage;
    private String emailAddress;
    //邮箱stmp码
    private String emailPassWord;
}
