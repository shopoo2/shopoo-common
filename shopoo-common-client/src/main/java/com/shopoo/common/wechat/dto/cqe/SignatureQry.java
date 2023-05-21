package com.shopoo.common.wechat.dto.cqe;

import com.szmengran.cola.dto.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author Joe
 * @Date 2022/3/14 6:23 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignatureQry extends Query {
	private String appId;
	private String appSecret;
	private String url;
}
