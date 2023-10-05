package com.example.smallsecurityappdemo.security;

import com.example.smallsecurityappdemo.dao.SupplierDao;
import com.example.smallsecurityappdemo.entity.Supplier;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final SupplierDao supplierDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return supplierDao.findSupplierByName(username)
                .map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException(username + "Not Found!"));
    }
}
