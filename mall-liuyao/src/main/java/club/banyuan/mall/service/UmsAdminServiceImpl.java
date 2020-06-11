package club.banyuan.mall.service;

import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.common.model.UmsAdmin;
import club.banyuan.mall.common.model.UmsAdminExample;
import club.banyuan.mall.dao.UmsAdminDao;
import club.banyuan.mall.dao.param.AdminQueryParam;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminListResponse;
import club.banyuan.mall.dto.UmsAdminUpdatePasswordParam;
import club.banyuan.mall.exception.CommonException;
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

    //分页方法实现
    @Autowired
    private UmsAdminDao adminDao;
    @Override
    public UmsAdminListResponse list(AdminQueryParam adminQueryParam){
        int offset = (adminQueryParam.getPageNum()-1)*adminQueryParam.getPageSize();
        adminQueryParam.setOffset(offset);

        UmsAdminListResponse response = new UmsAdminListResponse();
        response.setPageSize(adminQueryParam.getPageSize());
        response.setPageNum(adminQueryParam.getPageNum());
        int total = adminDao.count(adminQueryParam);
        int totalPage = (total%adminQueryParam.getPageSize()>0)?
                total/adminQueryParam.getPageSize()+1:total/adminQueryParam.getPageSize();
        response.setTotal(total);
        response.setTotalPage(totalPage);
        List<UmsAdmin> admins = adminDao.findManyByParam(adminQueryParam);
        response.setList(admins);
        return response;
    }

    //修改密码
    @Override
    public void updatePassword(UmsAdminUpdatePasswordParam param) throws CommonException{
        String username = param.getUsername();
        UmsAdmin umsAdmin = adminDao.findOneByParam(username);
        if (umsAdmin==null){
            throw new CommonException("用户不存在");
        }
        if (passwordEncoder.matches(param.getNewPassword(),umsAdmin.getPassword())){
            throw new CommonException("新密码与旧密码不能一样");
        }
        String newPassWordEncode =passwordEncoder.encode(param.getNewPassword());
        adminDao.updatePassword(umsAdmin.getId(),newPassWordEncode);
    }
}
