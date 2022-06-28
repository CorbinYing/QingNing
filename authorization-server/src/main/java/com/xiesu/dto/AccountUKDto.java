package com.xiesu.dto;

import com.xiesu.entity.SysAccount;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * {@link SysAccount}中具有唯一性的字段，可以作为
 * 查找账户的依据
 *
 * @author xiesu
 */
@Getter
@Setter
@Builder
public class AccountUKDto implements Serializable {

    private Integer id;

    private String tel;

    private String mail;

    private String accountId;

}
