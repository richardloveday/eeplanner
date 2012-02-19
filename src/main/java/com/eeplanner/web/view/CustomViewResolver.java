package com.eeplanner.web.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class CustomViewResolver implements ViewResolver {

	private ViewResolver tilesResolver;
	private ViewResolver jspResolver;

	public void setJspResolver(ViewResolver jspResolver) {
		this.jspResolver = jspResolver;
	}

	public void setTilesResolver(ViewResolver tilesResolver) {
		this.tilesResolver = tilesResolver;
	}

	public View resolveViewName(String viewName, Locale locale) throws Exception {
		if (isTilesView(viewName)) {
			return tilesResolver.resolveViewName(viewName, locale);
		} else {
			return jspResolver.resolveViewName(viewName, locale);
		}
	}

	private boolean isTilesView(String viewName) {
		if (viewName.startsWith("staffMemberExternal")) {
			return true;
		}
		
		if (viewName.startsWith("error")) {
			return true;
		}

		return false;
	}
}
