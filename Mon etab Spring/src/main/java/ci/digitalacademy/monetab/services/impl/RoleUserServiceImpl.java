package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.repositories.RoleUserRepository;
import ci.digitalacademy.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.services.mapper.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class RoleUserServiceImpl implements RoleUserService {

    private final RoleUserRepository roleUserRepository;
    private final RoleUserMapper roleUserMapper;

    @Override
    public RoleUserDTO save(RoleUserDTO roleUserDTO) {
        log.debug("Request to save : {}",roleUserDTO);
        RoleUser roleUser = roleUserMapper.toEntity(roleUserDTO);
         roleUser= roleUserRepository.save(roleUser);

        return  roleUserMapper.toDto(roleUser);
    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUserDTO) {
        return null;
    }

    @Override
    public Optional<RoleUserDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUsers) {
        log.debug("Request to init roles {}", roleUsers);
        List<RoleUserDTO> roles = findAll();
        if (roles.isEmpty()){
            roleUsers.forEach(role->{
                save(role);
            });
        }
        return findAll();

    }

    @Override
    public List<RoleUserDTO> findAll() {
        return roleUserRepository.findAll().stream().map(school -> {
            return roleUserMapper.toDto(school);
        }).toList();

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Object findByRole(String roleUser) {
        return roleUserRepository.findByRole(roleUser).stream().map( role->{
            return roleUserMapper.toDto(role);
        }).collect(Collectors.toSet());

    }
}
