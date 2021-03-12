package org.edwith.webbe.calculator;

import org.edwith.webbe.calculator.config.ApplicationConfig;
import org.edwith.webbe.calculator.config.MvcConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Spring 기본 설정파일 클래스를 지정
	// ApplicationConfig.class 작성 필요
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class};
	}

	// Spring MVC 설정 파일 클래스를 지정
	// MvcSongif.class 작성 필요
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {MvcConfig.class};
	}

	/*
	 DispatcherServlet이 동작할 맵핑정보를 설정
	 "/"를 설정한다는 것은 모든 요청을 DispatcherServlet이 처리한다는 것을 의미
	 */
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	/*
	 필터를 설정. 여기에서는 인코딩 필터를 설정
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}

}
