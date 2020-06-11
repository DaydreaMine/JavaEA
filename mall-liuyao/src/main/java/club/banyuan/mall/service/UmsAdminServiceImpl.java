package club.banyuan.mall.service;

import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.common.model.UmsAdminExample;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminListParam;
import club.banyuan.mall.dto.UmsAdminListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UmsAdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }

    @Override
    public void createUser(UmsAdminCreateParam param) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(param,umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(true);

        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
//        if (umsAdminList.size()>0){
//            throw new CommonException(e);
//        }
        String encodePassword  = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
    }

    public UmsAdminListResponse list()
}
