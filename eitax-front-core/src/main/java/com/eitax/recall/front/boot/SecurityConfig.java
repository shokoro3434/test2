package com.eitax.recall.front.boot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.ProfileService;
import com.eitax.recall.front.service.impl.LoginUserDetails;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// セキュリティの設定対象外設定
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/css/**","js/**");
	}

	// アクセス認証設定
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/loginForm").permitAll().anyRequest().authenticated();

		http.formLogin().loginProcessingUrl("/login").loginPage("/loginForm").failureUrl("/loginForm?error")
				.defaultSuccessUrl("/customers", true).usernameParameter("username").passwordParameter("password")
				.and();

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).logoutSuccessUrl("/loginForm");
	}

	// DB
	// @Configuration
	// static class AuthenticationConfiguration extends
	// GlobalAuthenticationConfigurerAdapter {
	// @Autowired
	// UserDetailsService userDetailsService;
	//
	// @Bean
	// PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }
	//
	// @Override
	// public void init(AuthenticationManagerBuilder auth) throws Exception {
	// auth.userDetailsService(userDetailsService)
	// .passwordEncoder(passwordEncoder());
	// }
	// }
	// AD
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		@Autowired
		private ProfileService profileService;

		@Bean
		PasswordEncoder passwordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
		}

		public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
			ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
					"mydomain.local", "ldap://192.168.0.61:389");
			provider.setConvertSubErrorCodesToExceptions(true);
			provider.setUseAuthenticationRequestCredentials(true);
			provider.setUserDetailsContextMapper(new LdapUserDetailsMapper(){

				@Override
				public UserDetails mapUserFromContext(DirContextOperations arg0, String username,
						Collection<? extends GrantedAuthority> arg2) {
					Profile p = profileService.findOne(username);
					List<GrantedAuthority> list = new ArrayList<>();
					list.add(new SimpleGrantedAuthority(p.getRole()));
					return new LoginUserDetails(username, list);
				}
				
			});
			return provider;
		}

	}

//	static class ADCustomUserDetailsContextMapper extends LdapUserDetailsMapper {
//
//		// @Override
//		public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
//				Collection<? extends GrantedAuthority> authorities) {
//			Profile p = profileService.findOne(username);
//			List<GrantedAuthority> list = new ArrayList<>();
//			list.add(new SimpleGrantedAuthority(p.getRole()));
//			return new LoginUserDetails(username, list);
//		}
//	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder authManagerBuilder)
	// throws Exception {
	// authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
	// }
	// @Autowired
	// protected void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception{
	// auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	// }
	// @Autowired
	// private UserDetailsService userDetailsService;
	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	// }
	// @Bean
	// public AuthenticationManager authenticationManager() {
	// return new
	// ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
	// }
	// @Bean
	// public AuthenticationProvider activeDirectoryLdapAuthenticationProvider()
	// {
	// ActiveDirectoryLdapAuthenticationProvider provider = new
	// ActiveDirectoryLdapAuthenticationProvider("mydomain.local",
	// "ldap://192.168.253.129:389");
	// provider.setConvertSubErrorCodesToExceptions(true);
	// provider.setUseAuthenticationRequestCredentials(true);
	//// provider.setUserDetailsContextMapper(new
	// ADCustomUserDetailsContextMapper());
	// return provider;
	// }

	/*
	 * @Configuration protected static class AuthenticationConfiguration extends
	 * GlobalAuthenticationConfigurerAdapter {
	 * 
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Override public void init(AuthenticationManagerBuilder auth) throws
	 * Exception { DefaultSpringSecurityContextSource contextSource = new
	 * DefaultSpringSecurityContextSource(
	 * "ldap://home.michinobu.jp:389/dc=home,dc=michinobu,dc=jp");
	 * contextSource.afterPropertiesSet();
	 * 
	 * 
	 * LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>
	 * configure = auth.ldapAuthentication();
	 * 
	 * configure.userDnPatterns("uid={0},ou=People") .groupRoleAttribute("cn")
	 * .rolePrefix("ROLE_") .contextSource(contextSource);
	 * 
	 * auth.userDetailsService(userDetailsService) .passwordEncoder(new
	 * PasswordEncoder(){
	 * 
	 * @Override public String encode(CharSequence arg0) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public boolean matches(CharSequence arg0, String arg1) { //
	 * TODO Auto-generated method stub return true; }
	 * 
	 * });
	 */

	// auth.userDetailsService(new UserDetailsService(){
	//
	// @Override
	// public UserDetails loadUserByUsername(String username) throws
	// UsernameNotFoundException {
	// // TODO Auto-generated method stub
	// User user = new User();
	// user.setUsername(username);
	// return new LoginUserDetails(user);
	// }
	// });

	// auth
	// .ldapAuthentication()
	// .userDnPatterns("uid={0},ou=People,dc=home,dc=michinobu,dc=jp")
	// .groupSearchBase("ou=groups")
	// .contextSource();//.ldif("classpath:test-server.ldif");
	// }
	// }
	// @Bean
	// public AuthenticationProvider activeDirectoryLdapAuthenticationProvider()
	// {
	// ActiveDirectoryLdapAuthenticationProvider provider = new
	// ActiveDirectoryLdapAuthenticationProvider("home.michinobu.jp",
	// "ldap://home.michinobu.jp:389/");
	// provider.setConvertSubErrorCodesToExceptions(true);
	// provider.setUseAuthenticationRequestCredentials(true);
	// provider.setSearchFilter("uid={0},ou=People,dc=home,dc=michinobu,dc=jp");
	// return provider;
	// }
	// public void configure(AuthenticationManagerBuilder auth) throws Exception
	// {
	// DefaultSpringSecurityContextSource contextSource = new
	// DefaultSpringSecurityContextSource("ldap://192.168.253.128:389/");
	// contextSource.afterPropertiesSet();
	// LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>
	// configure = auth.ldapAuthentication();
	// configure.contextSource(contextSource)
	// .userSearchFilter("uid=michinobu;ou=People,dc=home,dc=michinobu,dc=jp");
	//// .userSearchBase("ou=People")
	//// .groupSearchBase("ou=People")
	//// ;
	// }
	// configure.userDnPatterns("uid={0},ou=People,dc=home,dc=michinobu,dc=jp")
	// .groupSearchBase("ou=People")

	// ou=People,dc=home,dc=michinobu,dc=jp
	// .userDetailsContextMapper(userDetailsContextMapper)
	// ldapAuthoritiesPopulator(dbRoleLdapAuthoritiesPopulator);
	// }
	// @Autowired
	// public void configureGlobal(UserDetailsContextMapper
	// userDetailsContextMapper, LdapContextSource contextSource,
	// AuthenticationManagerBuilder builder) throws Exception {
	// DefaultSpringSecurityContextSource contextSource = new
	// DefaultSpringSecurityContextSource("ldap://192.168.253.128:389");
	// contextSource.afterPropertiesSet();
	//
	//
	// builder
	// .ldapAuthentication()
	// .userDetailsContextMapper(userDetailsContextMapper)
	// .contextSource(contextSource)
	// .userSearchFilter("uid={0}")
	// .userSearchBase("ou=People")
	// .groupSearchBase("ou=People");
	//
	//
	// }
	// AD
	/*
	 * @Configuration static class AuthenticationConfiguration extends
	 * GlobalAuthenticationConfigurerAdapter {
	 * 
	 * @Autowired UserDetailsService userDetailsService;
	 * 
	 * @Bean PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Override public void init(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userDetailsService)
	 * .passwordEncoder(passwordEncoder());
	 * auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	 * } public AuthenticationProvider
	 * activeDirectoryLdapAuthenticationProvider() {
	 * ActiveDirectoryLdapAuthenticationProvider provider = new
	 * ActiveDirectoryLdapAuthenticationProvider("mydomain.local",
	 * "ldap://192.168.253.129:389");
	 * provider.setConvertSubErrorCodesToExceptions(true);
	 * provider.setUseAuthenticationRequestCredentials(true); //
	 * provider.setUserDetailsContextMapper(new
	 * ADCustomUserDetailsContextMapper()); return provider; } }
	 */

}
